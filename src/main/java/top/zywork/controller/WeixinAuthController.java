package top.zywork.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.RandomUtils;
import top.zywork.common.WebUtils;
import top.zywork.enums.RandomCodeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.security.JwtUser;
import top.zywork.security.JwtUtils;
import top.zywork.service.SysConfigQueryService;
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

    private UserDetailsService jwtUserDetailsService;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    private UserRegService userRegService;

    private SysConfigQueryService sysConfigQueryService;

    /**
     * <p>从cookies中读取用户信息，如果没有用户信息，则需要微信授权登录，登录成功后，把用户信息cookie写出到客户端。</p>
     * <p>如果cookies中有用户信息，则不需要授权登录。</p>
     * @param request
     * @param code
     */
    @GetMapping("gzh")
    public ResponseStatusVO gzhAuth(HttpServletRequest request, HttpServletResponse response,  String code) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        String openid = WebUtils.getCookieValue(request, gzhCookieName);
        if (StringUtils.isEmpty(openid)) {
            if (StringUtils.isNotEmpty(code)) {
                // 没有授权登录，则开始微信授权登录并写出cookie到客户端，返回jwt token
                WeixinGzhConfig weixinGzhConfig = sysConfigQueryService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
                GzhAuth gzhAuth = WeixinUtils.authGzh(weixinGzhConfig.getAppId(), weixinGzhConfig.getAppSecret(), code);
                WeixinUser weixinUser = WeixinUtils.userInfo(gzhAuth);
                if (weixinUser != null) {
                    // 判断用户是否已经保存，如未保存，则保存微信用户信息到数据库
                    JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(weixinUser.getOpenid());
                    if (StringUtils.isEmpty(jwtUser.getUsername())) {
                        userRegService.saveGzhUser(weixinUser.getOpenid(), new BCryptPasswordEncoder().encode(RandomUtils.randomCode(RandomCodeEnum.MIX_CODE, 8)),
                                weixinUser.getNickname(), weixinUser.getHeadimgurl(), Byte.valueOf(weixinUser.getSex()));
                        // 重新根据openid获取JwtUser，生成jwt token并返回客户端
                        jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(weixinUser.getOpenid());
                    }
                    // 写出用户cookie到客户端
                    writeCookie(response, gzhCookieName, weixinUser.getOpenid());
                    String token = jwtUtils.generateToken(jwtUser);
                    jwtTokenRedisUtils.storeToken(jwtUser.getUserId() + "", token);
                    statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "微信用户授权登录成功，并返回Token", token);
                } else {
                    statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "微信授权登录失败，请检查参数", null);
                }
            } else {
                // 没有登录，且也没有code
                statusVO.errorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "微信授权登录缺少code", null);
            }
        } else {
            // 已经有登录，则什么事都不用做，直接返回已经登录的消息
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "已授权登录的用户", null);
        }
        return statusVO;
    }

    /**
     *
     * @param request
     * @param code
     */
    @GetMapping("xcx")
    public void xcxAuth(HttpServletRequest request, String code) {
        WeixinXcxConfig weixinXcxConfig = sysConfigQueryService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinXcxConfig.class);
        XcxAuth xcxAuth = WeixinUtils.authXcx(weixinXcxConfig.getAppId(), weixinXcxConfig.getAppSecret(), code);
        // TODO 判断用户是否已经保存，如未保存，则保存微信用户信息到数据库
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
    public void setJwtUserDetailsService(UserDetailsService jwtUserDetailsService) {
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
    public void setSysConfigQueryService(SysConfigQueryService sysConfigQueryService) {
        this.sysConfigQueryService = sysConfigQueryService;
    }
}
