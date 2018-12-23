package top.zywork.controller;

import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.ali.AliyunMailConfig;
import top.zywork.ali.AliyunMailUtils;
import top.zywork.ali.AliyunSmsConfig;
import top.zywork.ali.AliyunSmsUtils;
import top.zywork.annotation.SysLog;
import top.zywork.common.RandomUtils;
import top.zywork.common.RegexUtils;
import top.zywork.enums.RandomCodeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.MyUserDetailsService;
import top.zywork.security.SecurityUtils;
import top.zywork.security.VerifyCodeRedisUtils;
import top.zywork.security.mobile.SmsCodeRedisUtils;
import top.zywork.service.SysConfigQueryService;
import top.zywork.service.UserPasswordService;
import top.zywork.vo.ResponseStatusVO;

/**
 * 密码操作控制器，用于重置登录密码，重置支付密码，修改登录密码和修改支付密码<br/>
 * 重置密码操作需要手机验证码或邮箱验证码，而更新密码操作需要原密码<br/>
 *
 * 创建于2018-12-21<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/pwd")
public class PasswordController {

    private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);

    @Value("${verify.code.expiration}")
    private Integer verifyCodeExpiration;

    @Value("${verify.sms-code.expiration}")
    private Integer smsCodeExpiration;

    private UserPasswordService userPasswordService;

    private MyUserDetailsService jwtUserDetailsService;

    private SysConfigQueryService sysConfigQueryService;

    private VerifyCodeRedisUtils verifyCodeRedisUtils;

    private SmsCodeRedisUtils smsCodeRedisUtils;

    /**
     * 邮箱重置登录密码
     * @param email
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-login/email")
    @SysLog(description = "邮箱重置登录密码")
    public ResponseStatusVO resetLoginPwdByEmail(String email, String password, String confirmPassword, String verifyCode) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(email) && RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
            if (StringUtils.isNotEmpty(jwtUser.getUsername())) {
                if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                    if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                        if (verifyCodeRedisUtils.existsCode(VerifyCodeRedisUtils.CODE_RESET_LOGIN_PWD_PREFIX, email)
                                && verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_RESET_LOGIN_PWD_PREFIX, email).equals(verifyCode)) {
                            userPasswordService.resetLoginPwdByEmail(email, password);
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "重置登录密码成功", null);
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
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱未注册用户", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的邮箱地址", null);
        }
        return statusVO;
    }

    /**
     * 手机重置登录密码
     * @param phone
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-login/sms")
    @SysLog(description = "手机重置登录密码")
    public ResponseStatusVO resetLoginPwdByPhone(String phone, String password, String confirmPassword, String verifyCode) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
            if (StringUtils.isNotEmpty(jwtUser.getUsername())) {
                if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                    if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                        if (smsCodeRedisUtils.existsCode(SmsCodeRedisUtils.SMS_CODE_RESET_LOGIN_PWD_PREFIX, phone)
                                && smsCodeRedisUtils.getCode(SmsCodeRedisUtils.SMS_CODE_RESET_LOGIN_PWD_PREFIX, phone).equals(verifyCode)) {
                            userPasswordService.resetLoginPwdByPhone(phone, password);
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "重置登录密码成功", null);
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
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机号未注册用户", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的手机号", null);
        }
        return statusVO;
    }

    /**
     * 重置登录密码发送邮箱验证码
     * @param email
     * @return
     */
    @PostMapping("reset-login/email-code")
    public ResponseStatusVO resetLoginPwdEmailCode(String email) {
        return sendEmailCode(VerifyCodeRedisUtils.CODE_RESET_LOGIN_PWD_PREFIX, email);
    }

    /**
     * 重置登录密码发送手机验证码
     * @param phone
     * @return
     */
    @PostMapping("reset-login/sms-code")
    public ResponseStatusVO resetLoginPwdPhoneCode(String phone) {
        return sendSmsCode(SmsCodeRedisUtils.SMS_CODE_RESET_LOGIN_PWD_PREFIX, phone);
    }

    /**
     * 更新登录密码
     * @param oldPassword
     * @param password
     * @param confirmPassword
     * @return
     */
    @PostMapping("update-login")
    @SysLog(description = "更新登录密码")
    public ResponseStatusVO updateLoginPwd(String oldPassword, String password, String confirmPassword) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                    if (userPasswordService.updateLoginPwd(jwtUser.getUserId(), oldPassword, password)) {
                        statusVO.dataErrorStatus(ResponseStatusEnum.OK.getCode(), "登录密码更新成功", null);
                    } else {
                        statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "原密码错误", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码和确认密码不一致", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码不符合要求", null);
            }
        } else {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 邮箱重置支付密码
     * @param email
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-pay/email")
    @SysLog(description = "邮箱重置支付密码")
    public ResponseStatusVO resetPayPwdByEmail(String email, String password, String confirmPassword, String verifyCode) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(email) && RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
            if (StringUtils.isNotEmpty(jwtUser.getUsername())) {
                if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                    if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                        if (verifyCodeRedisUtils.existsCode(VerifyCodeRedisUtils.CODE_RESET_PAY_PWD_PREFIX, email)
                                && verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_RESET_PAY_PWD_PREFIX, email).equals(verifyCode)) {
                            userPasswordService.resetPayPwdByEmail(email, password);
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "重置支付密码成功", null);
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
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱未注册用户", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的邮箱地址", null);
        }
        return statusVO;
    }

    /**
     * 手机重置支付密码
     * @param phone
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-pay/sms")
    @SysLog(description = "手机重置支付密码")
    public ResponseStatusVO resetPayPwdByPhone(String phone, String password, String confirmPassword, String verifyCode) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
            if (StringUtils.isNotEmpty(jwtUser.getUsername())) {
                if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                    if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                        if (smsCodeRedisUtils.existsCode(SmsCodeRedisUtils.SMS_CODE_RESET_PAY_PWD_PREFIX, phone)
                                && smsCodeRedisUtils.getCode(SmsCodeRedisUtils.SMS_CODE_RESET_PAY_PWD_PREFIX, phone).equals(verifyCode)) {
                            userPasswordService.resetPayPwdByPhone(phone, password);
                            statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "重置支付密码成功", null);
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
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机号未注册用户", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "错误的手机号", null);
        }
        return statusVO;
    }

    /**
     * 重置支付密码发送邮箱验证码
     * @param email
     * @return
     */
    @PostMapping("reset-pay/email-code")
    public ResponseStatusVO resetPayPwdEmailCode(String email) {
        return sendEmailCode(VerifyCodeRedisUtils.CODE_RESET_PAY_PWD_PREFIX, email);
    }

    /**
     * 重置支付密码发送手机验证码
     * @param phone
     * @return
     */
    @PostMapping("reset-pay/sms-code")
    public ResponseStatusVO resetPayPwdPhoneCode(String phone) {
        return sendSmsCode(SmsCodeRedisUtils.SMS_CODE_RESET_PAY_PWD_PREFIX, phone);
    }

    /**
     * 更新支付密码
     * @param oldPassword
     * @param password
     * @param confirmPassword
     * @return
     */
    @PostMapping("update-pay")
    @SysLog(description = "更新支付密码")
    public ResponseStatusVO updatePayPwd(String oldPassword, String password, String confirmPassword) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            if (StringUtils.isNotEmpty(password) && RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
                if (StringUtils.isNotEmpty(confirmPassword) && password.trim().equals(confirmPassword.trim())) {
                    if (userPasswordService.updatePayPwd(jwtUser.getUserId(), oldPassword, password)) {
                        statusVO.dataErrorStatus(ResponseStatusEnum.OK.getCode(), "支付密码更新成功", null);
                    } else {
                        statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "原密码错误", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码和确认密码不一致", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "密码不符合要求", null);
            }
        } else {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 发送邮箱验证码
     * @param prefix
     * @param email
     * @return
     */
    private ResponseStatusVO sendEmailCode(String prefix, String email) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(email) && RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            if (verifyCodeRedisUtils.existsCode(prefix, email)) {
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "已获取过邮箱验证码，请稍候再获取", null);
            } else {
                JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
                if (StringUtils.isEmpty(jwtUser.getUsername())) {
                    // 此邮箱未注册用户
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "邮箱未注册用户", null);
                } else {
                    // 是注册用户，准备发送邮箱验证码，此code用于发送邮件
                    String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
                    try {
                        AliyunMailConfig aliyunMailConfig = sysConfigQueryService.getByName(SysConfigEnum.ALIYUN_MAIL_CONFIG.getValue(), AliyunMailConfig.class);
                        SingleSendMailResponse singleSendMailResponse = AliyunMailUtils.sendEmail(aliyunMailConfig, "service@mail.zywork.top", "赣州智悦科技",  email, false, "注册验证码", code, "verifyRegCode");
                        verifyCodeRedisUtils.storeCode(prefix, email, code);
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
     * 发送手机验证码
     * @param prefix
     * @param phone
     * @return
     */
    private ResponseStatusVO sendSmsCode(String prefix, String phone) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(phone) && RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            if (smsCodeRedisUtils.existsCode(prefix, phone)) {
                statusVO.errorStatus(ResponseStatusEnum.ERROR.getCode(), "已获取过手机验证码，请稍候再获取", null);
            } else {
                JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
                if (StringUtils.isEmpty(jwtUser.getUsername())) {
                    // 此手机号未注册
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "手机号未注册用户", null);
                } else {
                    // 是平台用户，准备发送手机验证码，此code用于发送短信
                    String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
                    try {
                        AliyunSmsConfig aliyunSmsConfig = sysConfigQueryService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
                        SendSmsResponse smsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phone, "templateCode", "templateParam", "outId");
                        if (smsResponse.getCode() != null && smsResponse.getCode().equals("OK")) {
                            smsCodeRedisUtils.storeCode(prefix, phone, code);
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
    public void setUserPasswordService(UserPasswordService userPasswordService) {
        this.userPasswordService = userPasswordService;
    }

    @Autowired
    public void setJwtUserDetailsService(MyUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Autowired
    public void setSysConfigQueryService(SysConfigQueryService sysConfigQueryService) {
        this.sysConfigQueryService = sysConfigQueryService;
    }

    @Autowired
    public void setVerifyCodeRedisUtils(VerifyCodeRedisUtils verifyCodeRedisUtils) {
        this.verifyCodeRedisUtils = verifyCodeRedisUtils;
    }

    @Autowired
    public void setSmsCodeRedisUtils(SmsCodeRedisUtils smsCodeRedisUtils) {
        this.smsCodeRedisUtils = smsCodeRedisUtils;
    }
}
