package top.zywork.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.zywork.annotation.SysLog;
import top.zywork.common.WebUtils;
import top.zywork.enums.SocialTypeEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.security.JwtUser;
import top.zywork.security.JwtUtils;
import top.zywork.security.MyUserDetailsService;
import top.zywork.service.DefaultRoleQueryService;
import top.zywork.service.SysConfigService;
import top.zywork.service.UserRegService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.weixin.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>微信控制器</p>
 * <p>此控制器不需要被SpringSecurity拦截，不参与SpringSecurity的用户认证</p>
 * 创建于2018-12-06<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/wx-auth")
public class WeixinAuthController {

    private static final Logger logger = LoggerFactory.getLogger(WeixinAuthController.class);

    @Value("${weixin.cookie.expiration}")
    private Integer cookieExpiration;

    @Value("${weixin.cookie.gzh-cookie-name}")
    private String gzhCookieName;

    private JwtUtils jwtUtils;

    private MyUserDetailsService jwtUserDetailsService;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    private UserRegService userRegService;

    private DefaultRoleQueryService defaultRoleQueryService;

    private SysConfigService sysConfigService;

    /**
     * 开始微信授权，可指定微信授权后跳转回的url，也可指定分享码
     *
     * @param request
     * @param modelAndView
     * @param fromUrl      从哪个url发起微信授权，授权成功后跳转回此url
     * @param shareCode    分享码
     * @return
     */
    @GetMapping("to-gzh")
    public ModelAndView toGzhAuth(HttpServletRequest request, ModelAndView modelAndView, String fromUrl, String shareCode) {
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        if (StringUtils.isEmpty(openid)) {
            WeixinGzhConfig weixinGzhConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
            modelAndView.setViewName("redirect:" + WeixinUtils.gzhAuthorizeUrl(weixinGzhConfig.getAppId(), weixinGzhConfig.getLoginRedirectUrl(), fromUrl, shareCode));
        } else {
            modelAndView.setViewName("redirect:" + fromUrl);
        }
        return modelAndView;
    }

    /**
     * <p>从cookies中读取用户信息，如果没有用户信息，则需要微信授权登录，登录成功后，把用户信息cookie写出到客户端。</p>
     * <p>如果cookies中有用户信息，则不需要授权登录。</p>
     *
     * @param request
     * @param code
     */
    @GetMapping("gzh")
    @SysLog(description = "微信公众号登录", requestParams = false)
    public ResponseStatusVO gzhAuth(HttpServletRequest request, HttpServletResponse response, String code, String fromUrl, String shareCode) {
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        if (StringUtils.isNotEmpty(openid)) {
            // 已经有登录，则什么事都不用做，直接返回已经登录的消息
            return ResponseStatusVO.ok("已授权登录的用户", null);
        }
        if (StringUtils.isEmpty(code)) {
            // 没有登录，且也没有code
            return ResponseStatusVO.dataError("微信授权登录缺少code", null);
        }
        WeixinGzhConfig weixinGzhConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
        GzhAuth gzhAuth = WeixinUtils.authGzh(weixinGzhConfig.getAppId(), weixinGzhConfig.getAppSecret(), code);
        if (gzhAuth == null) {
            return ResponseStatusVO.error("微信授权登录失败，请检查参数", null);
        }
        // 判断用户是否已经保存，如未保存，则保存微信用户信息到数据库
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(gzhAuth.getOpenid());
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            // 还未保存用户信息
            WeixinUser weixinUser = WeixinUtils.userInfo(gzhAuth);
            if (weixinUser != null) {
                Long inviteUserId = null;
                if (StringUtils.isNotEmpty(shareCode)) {
                    inviteUserId = userRegService.getUserIdByShareCode(shareCode);
                }
                userRegService.saveWeixinUser(weixinUser.getOpenid(), weixinUser.getUnionid(), gzhAuth.getAccessToken(), null,
                        SocialTypeEnum.WEIXIN_GZH.getValue(), null, weixinUser.getNickname(), weixinUser.getHeadimgurl(),
                        Byte.valueOf(weixinUser.getSex()), defaultRoleQueryService.getDefaultRole(), inviteUserId);
                return outInfoToGzh(response, gzhAuth.getOpenid(), fromUrl);
            } else {
                return ResponseStatusVO.error("微信授权登录失败，无法获取用户信息", null);
            }
        } else {
            // 已保存用户信息，更新access token
            userRegService.updateWeixinUserSocial(gzhAuth.getOpenid(), gzhAuth.getAccessToken(), null);
            return outInfoToGzh(response, gzhAuth.getOpenid(), fromUrl);
        }
    }

    private ResponseStatusVO outInfoToGzh(HttpServletResponse response, String openid, String fromUrl) {
        // 重新根据openid获取JwtUser，生成jwt token并返回客户端
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(openid);
        // 写出用户cookie到客户端
        writeCookie(response, gzhCookieName, openid);
        String token = jwtUtils.generateToken(jwtUser);
        jwtTokenRedisUtils.storeToken(jwtUser.getUserId() + "", token);
        // 微信授权登录成功，返回openid, jwt token和开启微信授权的页面url，此url可用于微信登录成功后指定要跳转到的页面
        return ResponseStatusVO.ok("微信用户授权登录成功", new String[]{openid, token, fromUrl});
    }

    /**
     * 通过微信小程序端wx.login函数获取的code授权登录，可获取到openid, session_key和unionid
     *
     * @param code 此code由小程序端调用api获得
     */
    @GetMapping("xcx")
    public ResponseStatusVO xcxAuth(String code) {
        if (StringUtils.isEmpty(code)) {
            return ResponseStatusVO.dataError("微信授权登录缺少code", null);
        }
        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinXcxConfig.class);
        XcxAuth xcxAuth = WeixinUtils.authXcx(weixinXcxConfig.getAppId(), weixinXcxConfig.getAppSecret(), code);
        if (xcxAuth == null) {
            return ResponseStatusVO.error("微信授权登录失败，请检查参数", null);
        }
        // 判断用户是否已经保存，如未保存，则保存微信用户信息到数据库
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(xcxAuth.getOpenid());
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            // 还未保存用户信息，不包括用户详情
            userRegService.saveWeixinUser(xcxAuth.getOpenid(), xcxAuth.getUnionid(), null, xcxAuth.getSessionKey(),
                    SocialTypeEnum.WEIXIN_XCX.getValue(), null, null, null, null,
                    defaultRoleQueryService.getDefaultRole(), null);
            return outInfoToXcx(xcxAuth.getOpenid());
        } else {
            // 已保存用户信息，更新session key
            userRegService.updateWeixinUserSocial(xcxAuth.getOpenid(), null, xcxAuth.getSessionKey());
            return outInfoToXcx(xcxAuth.getOpenid());
        }
    }

    private ResponseStatusVO outInfoToXcx(String openid) {
        // 重新根据openid获取JwtUser，生成jwt token并返回客户端
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(openid);
        String token = jwtUtils.generateToken(jwtUser);
        jwtTokenRedisUtils.storeToken(jwtUser.getUserId() + "", token);
        // 微信授权登录成功，返回openid, jwt token
        return ResponseStatusVO.ok("微信用户授权登录成功", new String[]{openid, token});
    }

    /**
     * 微信小程序端调用getUserInfo接口后，获取的用户信息保存到服务器
     *
     * @param openid
     * @param nickname
     * @param headicon
     * @param gender
     * @return
     */
    @PostMapping("xcx-userdetail")
    public ResponseStatusVO xcxUserDetail(String openid, String nickname, String headicon, Byte gender) {
        userRegService.updateWeixinUserDetail(openid, nickname, headicon, gender);
        return ResponseStatusVO.ok("已更新微信用户信息", null);
    }

    /**
     * 微信小程序获取登录用户手机号
     *
     * @param openid
     * @param encryptedData 加密数据
     * @param iv            iv向量
     * @return
     */
    public ResponseStatusVO xcxUserPhone(String openid, String encryptedData, String iv) {
        XcxPhone xcxPhone = WeixinUtils.decryptPhoneData(userRegService.getSessionKeyByOpenid(openid), encryptedData, iv);
        userRegService.updateUserPhone(openid, xcxPhone.getPhoneNumber());
        return ResponseStatusVO.ok("成功获取微信用户手机号", xcxPhone);
    }

    private void writeCookie(HttpServletResponse response, String name, String openid) {
        Cookie cookie = new Cookie(name, openid);
        cookie.setMaxAge(cookieExpiration);
        response.addCookie(cookie);
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setJwtUserDetailsService(MyUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }

    @Autowired
    public void setUserRegService(UserRegService userRegService) {
        this.userRegService = userRegService;
    }

    @Autowired
    public void setDefaultRoleQueryService(DefaultRoleQueryService defaultRoleQueryService) {
        this.defaultRoleQueryService = defaultRoleQueryService;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }
}
