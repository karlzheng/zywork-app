package top.zywork.controller;

import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.ali.AliyunMailConfig;
import top.zywork.ali.AliyunMailUtils;
import top.zywork.ali.AliyunSmsConfig;
import top.zywork.ali.AliyunSmsUtils;
import top.zywork.common.*;
import top.zywork.enums.*;
import top.zywork.security.*;
import top.zywork.security.mobile.SmsCodeRedisUtils;
import top.zywork.service.DefaultRoleQueryService;
import top.zywork.service.SysConfigQueryService;
import top.zywork.service.UserRegService;
import top.zywork.vo.ResponseStatusVO;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * SpringSecurity的用户认证控制器<br/>
 *
 * 创建于2018-12-03<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Value("${verify.code.cookie-name}")
    private String verifyCodeCookieName;

    @Value("${verify.code.expiration}")
    private Integer verifyCodeExpiration;

    @Value("${verify.sms-code.expiration}")
    private Integer smsCodeExpiration;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    private VerifyCodeRedisUtils verifyCodeRedisUtils;

    private SmsCodeRedisUtils smsCodeRedisUtils;

    private MyUserDetailsService jwtUserDetailsService;

    private UserRegService userRegService;

    private DefaultRoleQueryService defaultRoleQueryService;

    private SysConfigQueryService sysConfigQueryService;

    /**
     * 普通账号（手机号，邮箱），密码登录处理，可以配置是否开启验证码功能
     * @param username
     * @param password
     * @param verifyCode
     */
    @PostMapping("login")
    public void login(String username, String password, String verifyCode) {}

    /**
     * 手机验证码登录处理
     * @param phone
     * @param smsCode
     */
    @PostMapping("mobile")
    public void mobile(String phone, String smsCode) {}

    /**
     * 未认证处理
     * @return
     */
    @GetMapping("require")
    public ResponseStatusVO require() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(),
                ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        return statusVO;
    }

    /**
     * 退出登录处理，只有登录过的用户才需要退出
     * @return
     */
    @GetMapping("logout")
    public ResponseStatusVO logout() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            jwtTokenRedisUtils.removeToken(jwtUser.getUserId() + "");
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "已安全退出", null);
        } else {
            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "未登录，无需退出", null);
        }
        return statusVO;
    }

    /**
     * 生成验证码图片，把验证码保存到redis中，有效期参考application配置文件
     * @param response
     */
    @GetMapping("verify-code")
    public void generateVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = WebUtils.getCookieValue(request, verifyCodeCookieName);
        String verifyCode = VerifyCodeUtils.generateCode();
        BufferedImage bufferedImage = VerifyCodeUtils.generateImage(verifyCode);
        response.setContentType(ContentTypeEnum.PNG.getValue());
        try {
            if (sessionId == null) {
                sessionId = UUIDUtils.uuid();
                response.addCookie(new Cookie(verifyCodeCookieName, sessionId));
            }
            verifyCodeRedisUtils.storeCode(VerifyCodeRedisUtils.CODE_LOGIN_PREFIX, sessionId, verifyCode);
            ImageIO.write(bufferedImage, MIMETypeEnum.PNG.getValue(), response.getOutputStream());
        } catch (IOException e) {
            logger.error("返回验证码图片出错： {}", e.getMessage());
        }
    }

    /**
     * 发送手机验证码
     * @param phone
     */
    @PostMapping("sms-code")
    public ResponseStatusVO sendSmsCode(String phone) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            if (smsCodeRedisUtils.existsCode(SmsCodeRedisUtils.SMS_CODE_LOGIN_PREFIX, phone)) {
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "已获取过手机验证码，请稍候再获取", null);
            } else {
                JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
                if (StringUtils.isEmpty(jwtUser.getUsername())) {
                    // 此用户还未注册
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机号还未注册用户", null);
                } else {
                    // 是平台用户，准备发送手机验证码，此code用于发送短信
                    String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
                    try {
                        AliyunSmsConfig aliyunSmsConfig = sysConfigQueryService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
                        SendSmsResponse smsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phone, "templateCode", "templateParam", "outId");
                        if (smsResponse.getCode() != null && smsResponse.getCode().equals("OK")) {
                            smsCodeRedisUtils.storeCode(SmsCodeRedisUtils.SMS_CODE_LOGIN_PREFIX, phone, code);
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "短信发送成功", smsCodeExpiration);
                        } else {
                            logger.error("短信发送失败：{}", smsResponse.getMessage());
                            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "短信发送失败", null);
                        }
                    } catch (ClientException e) {
                        logger.error("短信发送失败：{}", e.getMessage());
                        statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "短信发送失败", null);
                    }
                }
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的手机号", null);
        }
        return statusVO;
    }

    /**
     * 邮箱注册
     * @param email
     * @param password
     * @param confirmPassword
     * @param regCode
     * @return
     */
    @PostMapping("reg")
    public ResponseStatusVO reg(String email, String password, String confirmPassword, String regCode) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(email) && RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
            if (StringUtils.isEmpty(jwtUser.getUsername())) {
                if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                    if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                        if (verifyCodeRedisUtils.existsCode(VerifyCodeRedisUtils.CODE_REG_PREFIX, email)
                                && verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_REG_PREFIX, email).equals(regCode)) {
                            userRegService.saveUser(email, password, defaultRoleQueryService.getDefaultRole());
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "注册成功", null);
                        } else {
                            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱验证码不正确", null);
                        }
                    } else {
                        statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码和确认密码不一致", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码不符合要求", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱已注册用户，请直接登录", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的邮箱地址", null);
        }
        return statusVO;
    }

    /**
     * 发送邮箱注册码到注册邮箱
     * @param email
     * @return
     */
    @PostMapping("reg-code")
    public ResponseStatusVO sendRegCode(String email) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(email) && RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            if (verifyCodeRedisUtils.existsCode(VerifyCodeRedisUtils.CODE_REG_PREFIX, email)) {
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "已获取过邮箱验证码，请稍候再获取", null);
            } else {
                JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
                if (StringUtils.isNotEmpty(jwtUser.getUsername())) {
                    // 此邮箱已注册
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱已注册用户，请直接登录", null);
                } else {
                    // 还不是平台用户，准备发送邮箱验证码，此code用于发送邮件
                    String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
                    try {
                        AliyunMailConfig aliyunMailConfig = sysConfigQueryService.getByName(SysConfigEnum.ALIYUN_MAIL_CONFIG.getValue(), AliyunMailConfig.class);
                        SingleSendMailResponse singleSendMailResponse = AliyunMailUtils.sendEmail(aliyunMailConfig, "service@mail.zywork.top", "赣州智悦科技",  email, false, "注册验证码", code, "verifyRegCode");
                        verifyCodeRedisUtils.storeCode(VerifyCodeRedisUtils.CODE_REG_PREFIX, email, code);
                        statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "邮件发送成功，请查收邮件", verifyCodeExpiration);
                    } catch (ClientException e) {
                        logger.error("邮件发送失败：{}", e.getMessage());
                        if (e.getErrCode().equals("InvalidToAddress.Spam")) {
                            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱地址无效，请重新填写", null);
                        } else {
                            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "邮件发送失败", null);
                        }
                    }
                }
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的邮箱", null);
        }
        return statusVO;
    }

    /**
     * 手机注册
     * @param phone
     * @param password
     * @param confirmPassword
     * @param regCode
     * @return
     */
    @PostMapping("reg-mobile")
    public ResponseStatusVO regMobile(String phone, String password, String confirmPassword, String regCode) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
            if (StringUtils.isEmpty(jwtUser.getUsername())) {
                if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                    if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                        if (verifyCodeRedisUtils.existsCode(VerifyCodeRedisUtils.CODE_REG_PREFIX, phone)
                                && verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_REG_PREFIX, phone).equals(regCode)) {
                            userRegService.saveUserMobile(phone, password, defaultRoleQueryService.getDefaultRole());
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "注册成功", null);
                        } else {
                            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机验证码不正确", null);
                        }
                    } else {
                        statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码和确认密码不一致", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码不符合要求", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机号已注册用户，请直接登录", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的手机号", null);
        }
        return statusVO;
    }

    /**
     * 发送手机注册验证码到注册手机号
     * @param phone
     * @return
     */
    @PostMapping("reg-sms-code")
    public ResponseStatusVO sendRegSmsCode(String phone) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            if (smsCodeRedisUtils.existsCode(SmsCodeRedisUtils.SMS_CODE_REG_PREFIX, phone)) {
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "已获取过手机验证码，请稍候再获取", null);
            } else {
                JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
                if (StringUtils.isNotEmpty(jwtUser.getUsername())) {
                    // 此手机号已注册
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机号已注册用户，请直接登录", null);
                } else {
                    // 还不是平台用户，准备发送手机验证码，此code用于发送短信
                    String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
                    try {
                        AliyunSmsConfig aliyunSmsConfig = sysConfigQueryService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
                        SendSmsResponse smsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phone, "templateCode", "templateParam", "outId");
                        if (smsResponse.getCode() != null && smsResponse.getCode().equals("OK")) {
                            smsCodeRedisUtils.storeCode(SmsCodeRedisUtils.SMS_CODE_REG_PREFIX, phone, code);
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "短信发送成功", smsCodeExpiration);
                        } else {
                            logger.error("短信发送失败：{}", smsResponse.getMessage());
                            statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "短信发送失败", null);
                        }
                    } catch (ClientException e) {
                        logger.error("短信发送失败：{}", e.getMessage());
                        statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "短信发送失败", null);
                    }
                }
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的手机号", null);
        }
        return statusVO;
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }

    @Autowired
    public void setVerifyCodeRedisUtils(VerifyCodeRedisUtils verifyCodeRedisUtils) {
        this.verifyCodeRedisUtils = verifyCodeRedisUtils;
    }

    @Autowired
    public void setSmsCodeRedisUtils(SmsCodeRedisUtils smsCodeRedisUtils) {
        this.smsCodeRedisUtils = smsCodeRedisUtils;
    }

    @Autowired
    public void setJwtUserDetailsService(MyUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
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
    public void setSysConfigQueryService(SysConfigQueryService sysConfigQueryService) {
        this.sysConfigQueryService = sysConfigQueryService;
    }
}
