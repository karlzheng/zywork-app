package top.zywork.controller;

import com.alibaba.fastjson.JSON;
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
import top.zywork.common.DateFormatUtils;
import top.zywork.common.WebUtils;
import top.zywork.enums.DatePatternEnum;
import top.zywork.enums.SocialTypeEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.*;
import top.zywork.service.DefaultRoleQueryService;
import top.zywork.service.SysConfigService;
import top.zywork.service.UserRegService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.weixin.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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

    private static final String SHARE_CODE = "shareCode";

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
     * @param extraParams
     * @return
     */
    @GetMapping("to-gzh")
    public ModelAndView toGzhAuth(HttpServletRequest request, String extraParams) {
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        logger.info("openid: {}", openid);
        if (StringUtils.isEmpty(openid)) {
            WeixinGzhConfig weixinGzhConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
            return new ModelAndView("redirect:" + WeixinUtils.gzhAuthorizeUrl(weixinGzhConfig.getAppId(), weixinGzhConfig.getLoginRedirectUrl(), extraParams));
        } else {
            return new ModelAndView("redirect:" + extraParams.split(WeixinUtils.EXTRA_PARAMS_SEPERATOR)[0]);
        }
    }

    /**
     * <p>从cookies中读取用户信息，如果没有用户信息，则需要微信授权登录，登录成功后，把用户信息cookie写出到客户端。</p>
     * <p>如果cookies中有用户信息，则不需要授权登录。</p>
     *
     * @param request
     * @param response
     * @param code
     * @param extraParams 包含三个部分，fromUrl表示从哪个网页发起的授权，notAuthUrl表示如果未授权成功跳转到的网页，
     *                    shareCode表示分享码，三个部分都需要指定，每个部分使用__分割
     */
    @GetMapping("gzh")
    @SysLog(description = "微信公众号登录", requestParams = false)
    public ModelAndView gzhAuth(HttpServletRequest request, HttpServletResponse response, String code, String extraParams) {
        logger.info("extraParams: {}, code: {}", extraParams, code);
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        logger.info("openid: {}", openid);
        String[] extraParamAry = extraParams.split(WeixinUtils.EXTRA_PARAMS_SEPERATOR);
        String fromUrl = extraParamAry[0];
        String notAuthUrl = extraParamAry[1];
        String shareCode = extraParamAry[2];
        if (StringUtils.isNotEmpty(openid)) {
            // 已经有登录，则什么事都不用做，直接返回已经登录的消息
            return new ModelAndView("redirect:" + fromUrl);
        }
        if (StringUtils.isEmpty(code)) {
            // 没有登录，且也没有code
            return new ModelAndView("redirect:" + notAuthUrl);
        }
        WeixinGzhConfig weixinGzhConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
        GzhAuth gzhAuth = WeixinUtils.authGzh(weixinGzhConfig.getAppId(), weixinGzhConfig.getAppSecret(), code);
        if (gzhAuth == null) {
            return new ModelAndView("redirect:" + notAuthUrl);
        }
        // 判断用户是否已经保存，如未保存，则保存微信用户信息到数据库
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(gzhAuth.getOpenid());
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            // 还未保存用户信息
            WeixinUser weixinUser = WeixinUtils.userInfo(gzhAuth);
            if (weixinUser != null) {
                Long inviteUserId = null;
                if (StringUtils.isNotEmpty(shareCode) && !SHARE_CODE.equals(shareCode)) {
                    inviteUserId = userRegService.getUserIdByShareCode(shareCode);
                }
                userRegService.saveWeixinUser(weixinUser.getOpenid(), weixinUser.getUnionid(), gzhAuth.getAccessToken(), null,
                        SocialTypeEnum.WEIXIN_GZH.getValue(), null, weixinUser.getNickname(), weixinUser.getHeadimgurl(),
                        Byte.valueOf(weixinUser.getSex()), defaultRoleQueryService.getDefaultRole(), inviteUserId);
                WebUtils.setCookie(response, gzhCookieName, gzhAuth.getOpenid(), cookieExpiration);
                return new ModelAndView("redirect:" + fromUrl);
            } else {
                return new ModelAndView("redirect:" + notAuthUrl);
            }
        } else {
            // 已保存用户信息，更新access token
            userRegService.updateWeixinUserSocial(gzhAuth.getOpenid(), gzhAuth.getAccessToken(), null);
            WebUtils.setCookie(response, gzhCookieName, gzhAuth.getOpenid(), cookieExpiration);
            return new ModelAndView("redirect:" + fromUrl);
        }
    }

    private String generateAndSaveToken(String openid) {
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(openid);
        Map<String, Object> claims = jwtUtils.generateClaims(jwtUser);
        String token = jwtUtils.generateToken(jwtUser.getUsername(), claims);
        // 支持用户多平台同时登录，一次平台登录产生一个jwt token
        JwtClaims jwtClaims = JSON.parseObject((String) claims.get(JwtUtils.JWT_CLAIMS), JwtClaims.class);
        jwtTokenRedisUtils.storeToken(jwtUser.getUserId() + "_" + jwtClaims.getCreateDate().getTime(),
                new JwtToken(token, DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATE.getValue())));
        return token;
    }

    /**
     * 通过公众号cookie中的openid获取jwt token并返回
     * @param request
     * @return
     */
    @GetMapping("token")
    public ResponseStatusVO getJwtToken(HttpServletRequest request) {
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        if (StringUtils.isNotEmpty(openid)) {
            // 重新根据openid获取JwtUser，生成jwt token并返回客户端
            String token = generateAndSaveToken(openid);
            return ResponseStatusVO.ok("成功获取jwt token", token);
        } else {
            return ResponseStatusVO.dataError("公众号Cookie中不存在openid", null);
        }
    }

    /**
     * 清除公众号cookie中的openid
     * @param request
     * @return
     */
    @GetMapping("clear-openid")
    public ResponseStatusVO clearOpenidInCookie(HttpServletRequest request, HttpServletResponse response) {
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        if (StringUtils.isNotEmpty(openid)) {
            WebUtils.setCookie(response, gzhCookieName, "", 0);
            return ResponseStatusVO.ok("成功清除公众号cookie中的openid", null);
        } else {
            return ResponseStatusVO.dataError("公众号Cookie中不存在openid，无需清除", null);
        }
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
        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_XCX_CONFIG.getValue(), WeixinXcxConfig.class);
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
        String token = generateAndSaveToken(openid);
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
    @PostMapping("xcx-phone")
    public ResponseStatusVO xcxUserPhone(String openid, String encryptedData, String iv) {
        XcxPhone xcxPhone = WeixinUtils.decryptPhoneData(userRegService.getSessionKeyByOpenid(openid), encryptedData, iv);
        userRegService.updateUserPhone(openid, xcxPhone.getPhoneNumber());
        return ResponseStatusVO.ok("成功获取微信用户手机号", xcxPhone);
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
