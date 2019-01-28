package top.zywork.filter;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.zywork.common.WebUtils;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.VerifyCodeRedisUtils;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证码认证过滤器<br/>
 *
 * 创建于2018-12-10<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class VerifyCodeAuthenticationFilter extends OncePerRequestFilter {

    private static final String LOGIN_URL = "/auth/login";
    private static final String POST = "post";

    @Value("${verify.code.cookie-name}")
    private String verifyCodeCookieName;

    private VerifyCodeRedisUtils verifyCodeRedisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals(LOGIN_URL, request.getRequestURI()) && StringUtils.equalsIgnoreCase(request.getMethod(),  POST)) {
            String sessionId = WebUtils.getCookieValue(request, verifyCodeCookieName);
            String verifyCode = ServletRequestUtils.getStringParameter(request, "verifyCode");
            String codeInRedis = verifyCodeRedisUtils.getCode(VerifyCodeRedisUtils.CODE_LOGIN_PREFIX, sessionId);
            if (StringUtils.isNotEmpty(codeInRedis)) {
                if (!codeInRedis.equalsIgnoreCase(verifyCode)) {
                    outResponse(response, ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), "验证码错误", null);
                    return;
                }
            } else {
                outResponse(response, ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), "验证码不存在，请刷新 ", null);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void outResponse(HttpServletResponse response, int responseCode, String responseMsg, Object responseData) throws IOException {
        response.setContentType(ContentTypeEnum.JSON.getValue());
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(ResponseStatusVO.error(responseCode, responseMsg, responseData)));
    }

    @Autowired
    public void setVerifyCodeRedisUtils(VerifyCodeRedisUtils verifyCodeRedisUtils) {
        this.verifyCodeRedisUtils = verifyCodeRedisUtils;
    }
}
