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
import top.zywork.enums.SysConfigEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.MyUserDetailsService;
import top.zywork.security.SecurityUtils;
import top.zywork.security.VerifyCodeRedisUtils;
import top.zywork.security.mobile.SmsCodeRedisUtils;
import top.zywork.service.SysConfigService;
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

    private static final String ALIYUN_SMS_OK = "OK";

    private static final String ALIYUN_MAIL_INVALID = "InvalidToAddress.Spam";

    @Value("${verify.code.expiration}")
    private Integer verifyCodeExpiration;

    @Value("${verify.sms-code.expiration}")
    private Integer smsCodeExpiration;

    private UserPasswordService userPasswordService;

    private MyUserDetailsService jwtUserDetailsService;

    private SysConfigService sysConfigService;

    private VerifyCodeRedisUtils verifyCodeRedisUtils;

    private SmsCodeRedisUtils smsCodeRedisUtils;

    /**
     * 邮箱重置登录密码
     *
     * @param email
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-login/email")
    @SysLog(description = "邮箱重置登录密码", requestParams = false)
    public ResponseStatusVO resetLoginPwdByEmail(String email, String password, String confirmPassword, String verifyCode) {
        if (StringUtils.isEmpty(email) || !RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            return ResponseStatusVO.dataError("错误的邮箱地址", null);
        }
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            return ResponseStatusVO.dataError("邮箱未注册用户", null);
        }
        if (StringUtils.isEmpty(password) || !RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
            return ResponseStatusVO.dataError("密码不符合要求", null);
        }
        if (StringUtils.isEmpty(confirmPassword) || !password.trim().equals(confirmPassword.trim())) {
            return ResponseStatusVO.dataError("密码和确认密码不一致", null);
        }
        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_RESET_LOGIN_PWD_PREFIX, email))) {
            return ResponseStatusVO.dataError("邮箱验证码不正确", null);
        }
        userPasswordService.resetLoginPwdByEmail(email, password);
        return ResponseStatusVO.ok("重置登录密码成功", null);
    }

    /**
     * 手机重置登录密码
     *
     * @param phone
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-login/sms")
    @SysLog(description = "手机重置登录密码", requestParams = false)
    public ResponseStatusVO resetLoginPwdByPhone(String phone, String password, String confirmPassword, String verifyCode) {
        if (StringUtils.isEmpty(phone) || !RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            return ResponseStatusVO.dataError("错误的手机号", null);
        }
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            return ResponseStatusVO.dataError("手机号未注册用户", null);
        }
        if (StringUtils.isEmpty(password) || !RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
            return ResponseStatusVO.dataError("密码不符合要求", null);
        }
        if (StringUtils.isEmpty(confirmPassword) || !password.trim().equals(confirmPassword.trim())) {
            return ResponseStatusVO.dataError("密码和确认密码不一致", null);
        }
        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(smsCodeRedisUtils.getCode(SmsCodeRedisUtils.SMS_CODE_RESET_LOGIN_PWD_PREFIX, phone))) {
            return ResponseStatusVO.dataError("手机验证码不正确", null);
        }
        userPasswordService.resetLoginPwdByPhone(phone, password);
        return ResponseStatusVO.ok("重置登录密码成功", null);
    }

    /**
     * 重置登录密码发送邮箱验证码
     *
     * @param email
     * @return
     */
    @PostMapping("reset-login/email-code")
    public ResponseStatusVO resetLoginPwdEmailCode(String email) {
        return sendEmailCode(VerifyCodeRedisUtils.CODE_RESET_LOGIN_PWD_PREFIX, email);
    }

    /**
     * 重置登录密码发送手机验证码
     *
     * @param phone
     * @return
     */
    @PostMapping("reset-login/sms-code")
    public ResponseStatusVO resetLoginPwdPhoneCode(String phone) {
        return sendSmsCode(SmsCodeRedisUtils.SMS_CODE_RESET_LOGIN_PWD_PREFIX, phone);
    }

    /**
     * 更新登录密码
     *
     * @param oldPassword
     * @param password
     * @param confirmPassword
     * @return
     */
    @PostMapping("update-login")
    @SysLog(description = "更新登录密码", requestParams = false)
    public ResponseStatusVO updateLoginPwd(String oldPassword, String password, String confirmPassword) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (StringUtils.isEmpty(password) || !RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
            return ResponseStatusVO.dataError("密码不符合要求", null);
        }
        if (StringUtils.isEmpty(confirmPassword) || !password.trim().equals(confirmPassword.trim())) {
            return ResponseStatusVO.dataError("密码和确认密码不一致", null);
        }
        if (userPasswordService.updateLoginPwd(jwtUser.getUserId(), oldPassword, password)) {
            return ResponseStatusVO.ok("登录密码更新成功", null);
        } else {
            return ResponseStatusVO.dataError("原密码错误", null);
        }
    }

    /**
     * 邮箱重置支付密码
     *
     * @param email
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-pay/email")
    @SysLog(description = "邮箱重置支付密码", requestParams = false)
    public ResponseStatusVO resetPayPwdByEmail(String email, String password, String confirmPassword, String verifyCode) {
        if (StringUtils.isEmpty(email) || !RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            return ResponseStatusVO.dataError("错误的邮箱地址", null);
        }
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            return ResponseStatusVO.dataError("邮箱未注册用户", null);
        }
        if (StringUtils.isEmpty(password) || !RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
            return ResponseStatusVO.dataError("密码不符合要求", null);
        }
        if (StringUtils.isEmpty(confirmPassword) || !password.trim().equals(confirmPassword.trim())) {
            return ResponseStatusVO.dataError("密码和确认密码不一致", null);
        }
        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_RESET_PAY_PWD_PREFIX, email))) {
            return ResponseStatusVO.dataError("邮箱验证码不正确", null);
        }
        userPasswordService.resetPayPwdByEmail(email, password);
        return ResponseStatusVO.ok("重置支付密码成功", null);
    }

    /**
     * 手机重置支付密码
     *
     * @param phone
     * @param password
     * @param confirmPassword
     * @param verifyCode
     * @return
     */
    @PostMapping("reset-pay/sms")
    @SysLog(description = "手机重置支付密码", requestParams = false)
    public ResponseStatusVO resetPayPwdByPhone(String phone, String password, String confirmPassword, String verifyCode) {
        if (StringUtils.isEmpty(phone) || !RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            return ResponseStatusVO.dataError("错误的手机号", null);
        }
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            return ResponseStatusVO.dataError("手机号未注册用户", null);
        }
        if (StringUtils.isEmpty(password) || !RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
            return ResponseStatusVO.dataError("密码不符合要求", null);
        }
        if (StringUtils.isEmpty(confirmPassword) || !password.trim().equals(confirmPassword.trim())) {
            return ResponseStatusVO.dataError("密码和确认密码不一致", null);
        }
        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(smsCodeRedisUtils.getCode(SmsCodeRedisUtils.SMS_CODE_RESET_PAY_PWD_PREFIX, phone))) {
            return ResponseStatusVO.dataError("手机验证码不正确", null);
        }
        userPasswordService.resetPayPwdByPhone(phone, password);
        return ResponseStatusVO.ok("重置支付密码成功", null);
    }

    /**
     * 重置支付密码发送邮箱验证码
     *
     * @param email
     * @return
     */
    @PostMapping("reset-pay/email-code")
    public ResponseStatusVO resetPayPwdEmailCode(String email) {
        return sendEmailCode(VerifyCodeRedisUtils.CODE_RESET_PAY_PWD_PREFIX, email);
    }

    /**
     * 重置支付密码发送手机验证码
     *
     * @param phone
     * @return
     */
    @PostMapping("reset-pay/sms-code")
    public ResponseStatusVO resetPayPwdPhoneCode(String phone) {
        return sendSmsCode(SmsCodeRedisUtils.SMS_CODE_RESET_PAY_PWD_PREFIX, phone);
    }

    /**
     * 更新支付密码
     *
     * @param oldPassword
     * @param password
     * @param confirmPassword
     * @return
     */
    @PostMapping("update-pay")
    @SysLog(description = "更新支付密码", requestParams = false)
    public ResponseStatusVO updatePayPwd(String oldPassword, String password, String confirmPassword) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (StringUtils.isEmpty(password) || !RegexUtils.match(RegexUtils.REGEX_PASSWORD, password.trim())) {
            return ResponseStatusVO.dataError("密码不符合要求", null);
        }
        if (StringUtils.isEmpty(confirmPassword) || !password.trim().equals(confirmPassword.trim())) {
            return ResponseStatusVO.dataError("密码和确认密码不一致", null);
        }
        if (userPasswordService.updatePayPwd(jwtUser.getUserId(), oldPassword, password)) {
            return ResponseStatusVO.ok("支付密码更新成功", null);
        } else {
            return ResponseStatusVO.dataError("原密码错误", null);
        }
    }

    /**
     * 发送邮箱验证码
     *
     * @param prefix
     * @param email
     * @return
     */
    private ResponseStatusVO sendEmailCode(String prefix, String email) {
        if (StringUtils.isEmpty(email) || !RegexUtils.match(RegexUtils.REGEX_EMAIL, email)) {
            return ResponseStatusVO.dataError("错误的邮箱", null);
        }
        if (verifyCodeRedisUtils.existsCode(prefix, email)) {
            return ResponseStatusVO.error("已获取过邮箱验证码，请稍候再获取", null);
        }
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(email);
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            // 此邮箱未注册用户
            return ResponseStatusVO.dataError("邮箱未注册用户", null);
        }
        // 是注册用户，准备发送邮箱验证码，此code用于发送邮件
        String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
        try {
            AliyunMailConfig aliyunMailConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_MAIL_CONFIG.getValue(), AliyunMailConfig.class);
            SingleSendMailResponse singleSendMailResponse = AliyunMailUtils.sendEmail(aliyunMailConfig, "service@mail.zywork.top", "赣州智悦科技", email, false, "注册验证码", code, "verifyRegCode");
            verifyCodeRedisUtils.storeCode(prefix, email, code);
            return ResponseStatusVO.ok("邮件发送成功，请查收邮件", verifyCodeExpiration);
        } catch (ClientException e) {
            logger.error("邮件发送失败：{}", e.getMessage());
            if (ALIYUN_MAIL_INVALID.equals(e.getErrCode())) {
                return ResponseStatusVO.dataError("邮箱地址无效，请重新填写", null);
            } else {
                return ResponseStatusVO.error("邮件发送失败", null);
            }
        }
    }

    /**
     * 发送手机验证码
     *
     * @param prefix
     * @param phone
     * @return
     */
    private ResponseStatusVO sendSmsCode(String prefix, String phone) {
        if (StringUtils.isEmpty(phone) || !RegexUtils.match(RegexUtils.REGEX_PHONE, phone)) {
            return ResponseStatusVO.dataError("错误的手机号", null);
        }
        if (smsCodeRedisUtils.existsCode(prefix, phone)) {
            return ResponseStatusVO.error("已获取过手机验证码，请稍候再获取", null);
        }
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);
        if (StringUtils.isEmpty(jwtUser.getUsername())) {
            // 此手机号未注册
            return ResponseStatusVO.dataError("手机号未注册用户", null);
        }
        // 是平台用户，准备发送手机验证码，此code用于发送短信
        String code = RandomUtils.randomCode(RandomCodeEnum.NUMBER_CODE, 6);
        try {
            AliyunSmsConfig aliyunSmsConfig = sysConfigService.getByName(SysConfigEnum.ALIYUN_SMS_CONFIG.getValue(), AliyunSmsConfig.class);
            SendSmsResponse smsResponse = AliyunSmsUtils.sendSms(aliyunSmsConfig, phone, "templateCode", "templateParam", "outId");
            if (smsResponse.getCode() != null && ALIYUN_SMS_OK.equals(smsResponse.getCode())) {
                smsCodeRedisUtils.storeCode(prefix, phone, code);
                return ResponseStatusVO.ok("短信发送成功", smsCodeExpiration);
            } else {
                logger.error("短信发送失败：{}", smsResponse.getMessage());
                return ResponseStatusVO.error("短信发送失败", null);
            }
        } catch (ClientException e) {
            logger.error("短信发送失败：{}", e.getMessage());
            return ResponseStatusVO.error("短信发送失败", null);
        }
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
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
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
