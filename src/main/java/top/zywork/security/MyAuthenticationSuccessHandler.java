package top.zywork.security;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import top.zywork.common.DateFormatUtils;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.DatePatternEnum;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

    private JwtUtils jwtUtils;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("用户认证成功");
        response.setContentType(ContentTypeEnum.JSON.getValue());
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        Map<String, Object> claims = jwtUtils.generateClaims(jwtUser);
        String token = jwtUtils.generateToken(jwtUser.getUsername(), claims);
        // 支持用户多平台同时登录，一次平台登录产生一个jwt token
        JwtClaims jwtClaims = JSON.parseObject((String) claims.get(JwtUtils.JWT_CLAIMS), JwtClaims.class);
        String jwtTokenKey = jwtUser.getUserId() + "_" + jwtClaims.getCreateDate().getTime();
        jwtTokenRedisUtils.storeToken(jwtTokenKey, new JwtToken(token, DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATE.getValue())));
        jwtTokenRedisUtils.countDau();
        response.getWriter().write(JSON.toJSONString(ResponseStatusVO.ok("用户认证成功", token)));
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }
}