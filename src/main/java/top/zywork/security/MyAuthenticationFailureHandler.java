package top.zywork.security;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.ResponseStatusEnum;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.info("用户认证失败");
        response.setContentType(ContentTypeEnum.JSON.getValue());
        ResponseStatusVO statusVO = new ResponseStatusVO();
        statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_FAILURE.getCode(),
                ResponseStatusEnum.AUTHENTICATION_FAILURE.getMessage(), null);
        response.getWriter().write(JSON.toJSONString(statusVO));
    }
}
