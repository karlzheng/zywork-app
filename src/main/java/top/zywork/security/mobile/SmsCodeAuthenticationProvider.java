package top.zywork.security.mobile;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import top.zywork.security.JwtUser;
import top.zywork.security.MyUserDetailsService;

/**
 * 手机验证码验证器，先判断手机号是否正确，如果手机号正确则用户存在，
 * 再判断用户输入的手机验证码是否正确，如果不正确，则抛出自定义的异常信息，
 * 如果手机验证码也正确，则验证通过。
 * 验证通过，把JwtUser放入AuthenticationToken中，最终在AuthenticationSuccessHandler中获取此JwtUser，以后返回jwt token<br/>
 *
 * 创建于2018-12-10<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService jwtUserDetailsService;

    @Autowired
    private SmsCodeRedisUtils smsCodeRedisUtils;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
        String phone = (String) authenticationToken.getPrincipal();
        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(phone);

        if (jwtUser == null || StringUtils.isEmpty(jwtUser.getUsername())) {
            throw new UsernameNotFoundException("无法获取该手机号用户信息");
        }
        String smsCode = (String) authenticationToken.getCredentials();
        String codeInRedis = smsCodeRedisUtils.getCode(SmsCodeRedisUtils.SMS_CODE_LOGIN_PREFIX, phone);
        if (StringUtils.isEmpty(codeInRedis)) {
            throw new SmsCodeExpirationException("手机验证码不存在或已失效，请重新获取");
        }
        if (!codeInRedis.equals(smsCode)) {
            throw new SmsCodeErrorException("手机验证码错误");
        }
        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(jwtUser, jwtUser.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

}