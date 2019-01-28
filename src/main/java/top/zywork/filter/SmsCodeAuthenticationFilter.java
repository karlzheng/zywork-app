package top.zywork.filter;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;
import top.zywork.security.mobile.SmsCodeAuthenticationToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 手机登录过滤器，包含有手机号和手机验证码。依照UsernamePasswordAuthenticationFilter编写<br/>
 *
 * 创建于2018-12-10<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String MOBILE_URL = "/auth/mobile";

    private static final String POST = "POST";

    public static final String PHONE_KEY = "phone";
    public static final String SMS_CODE = "smsCode";
    private String phoneParameter = PHONE_KEY;
    private String smsCodeParameter = SMS_CODE;
    private boolean postOnly = true;

    public SmsCodeAuthenticationFilter() {
        // 设置短信登录url，必须是post请求
        super(new AntPathRequestMatcher(MOBILE_URL, POST));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (postOnly && !POST.equals(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String phone = obtainPhone(request);
        if (phone == null) {
            phone = "";
        }
        phone = phone.trim();
        String smsCode = obtainSmsCode(request);
        if (smsCode == null) {
            smsCode = "";
        }
        // 将包含有手机号和验证码的token交给AuthenticationProvider进行验证
        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(phone, smsCode);

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected String obtainPhone(HttpServletRequest request) {
        return request.getParameter(phoneParameter);
    }

    protected String obtainSmsCode(HttpServletRequest request) {
        return request.getParameter(smsCodeParameter);
    }

    protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public void setPhoneParameter(String phoneParameter) {
        Assert.hasText(phoneParameter, "Phone parameter must not be empty or null");
        this.phoneParameter = phoneParameter;
    }

    public final String getPhoneParameter() {
        return phoneParameter;
    }

    public void setSmsCodeParameter(String smsCodeParameter) {
        Assert.hasText(smsCodeParameter, "Sms code parameter must not be empty or null");
        this.smsCodeParameter = smsCodeParameter;
    }

    public String getSmsCodeParameter() {
        return smsCodeParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

}