package top.zywork.security.mobile;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义手机验证码登录时，手机验证码不存在或已失效异常类<br/>
 *
 * 创建于2018-12-10<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class SmsCodeExpirationException extends AuthenticationException {

    public SmsCodeExpirationException(String msg, Throwable t) {
        super(msg, t);
    }

    public SmsCodeExpirationException(String msg) {
        super(msg);
    }

}
