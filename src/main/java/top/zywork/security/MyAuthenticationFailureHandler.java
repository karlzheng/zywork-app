package top.zywork.security;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.mobile.SmsCodeErrorException;
import top.zywork.security.mobile.SmsCodeExpirationException;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户认证失败处理器<br/>
 * 用户认证失败，需要返回认证错误消息给客户端（JSON）
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.info("用户认证失败");
        response.setContentType(ContentTypeEnum.JSON.getValue());
        String msg = ResponseStatusEnum.AUTHENTICATION_FAILURE.getMessage();
        if (exception instanceof DisabledException) {
            msg = "用户未启用";
        } else if (exception instanceof UsernameNotFoundException) {
            msg = "用户不存在";
        } else if (exception instanceof BadCredentialsException) {
            msg = "错误的凭证，用户名或密码错误";
        } else if (exception instanceof SmsCodeExpirationException) {
            msg = exception.getMessage();
        } else if (exception instanceof SmsCodeErrorException) {
            msg = exception.getMessage();
        }
        response.getWriter().write(JSON.toJSONString(ResponseStatusVO.error(ResponseStatusEnum.AUTHENTICATION_FAILURE.getCode(), msg, null)));
    }
}
