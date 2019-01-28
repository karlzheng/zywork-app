package top.zywork.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;
import top.zywork.filter.JwtAuthenticationFilter;
import top.zywork.filter.SmsCodeAuthenticationFilter;
import top.zywork.filter.VerifyCodeAuthenticationFilter;
import top.zywork.security.*;
import top.zywork.security.mobile.SmsCodeAuthenticationProvider;

/**
 * 创建于2018-10-26<br/>
 *
 * 核心流程：<br/>
 * 1）用户登录，此时与UserDetailsService返回的用户进行对比，UserDetailsService只根据用户名查找用户的密码和对应的权限<br/>
 * 2）如果用户密码对比相同，则用户登录成功，否则用户登录失败<br/>
 * 3）当用户访问指定的url时，InvocationSecurityMetadataSource去获取所有用户角色和能够访问此url的用户角色<br/>
 * 4）再把能够访问此url的用户角色交给AccessDecisionManager的decide方法进行判断，如果登录用户的角色与能访问此url的基本一个角色匹配，则意味着有权限，否则无权限<br/>
 *
 *  在SpringSecurity中，authority即为用户角色，而access list即为url<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${verify.code.enable}")
    private Boolean enableVerifyCode;

    @Autowired
    private MyUserDetailsService jwtUserDetailsService;

    @Autowired
    private MyInvocationSecurityMetadataSource myInvocationSecurityMetadataSource;

    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private VerifyCodeAuthenticationFilter verifyCodeAuthenticationFilter;

    @Autowired
    private SmsCodeAuthenticationProvider smsCodeAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/");
        web.ignoring().antMatchers("/wx-auth/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 不能直接使用@Autowired注解，否则authenticationManager未设置会报错
        SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
        smsCodeAuthenticationFilter.setAuthenticationManager(super.authenticationManagerBean());
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        http.authenticationProvider(smsCodeAuthenticationProvider);
        if (enableVerifyCode) {
            http.addFilterBefore(verifyCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(jwtAuthenticationFilter, VerifyCodeAuthenticationFilter.class);
        } else {
            http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        }
        http.addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors()
                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .anyRequest()
                .authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin()
                // 未认证则转入此url
                .loginPage("/auth/require")
                // 使用此url进行用户登录
                .loginProcessingUrl("/auth/login")
                .permitAll()
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);
    }
}
