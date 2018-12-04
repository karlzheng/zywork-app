package top.zywork.security;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户认证成功处理器<br/>
 * 用户认证成功，需要为此用户生成一个token，此token返回给客户端(JSON)
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("用户认证成功");
        response.setContentType(ContentTypeEnum.JSON.getValue());
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        String token = jwtUtils.generateToken(jwtUser);
        ResponseStatusVO statusVO = new ResponseStatusVO();
        statusVO.okStatus(ResponseStatusEnum.OK.getCode(), "用户认证成功", token);
        response.getWriter().write(JSON.toJSONString(statusVO));
    }
}