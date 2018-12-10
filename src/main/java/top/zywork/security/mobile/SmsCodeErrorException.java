package top.zywork.security.mobile;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义手机验证码登录时，手机验证码错误异常类<br/>
 *
 * 创建于2018-12-10<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class SmsCodeErrorException extends AuthenticationException {

    public SmsCodeErrorException(String msg, Throwable t) {
        super(msg, t);
    }

    public SmsCodeErrorException(String msg) {
        super(msg);
    }

}
