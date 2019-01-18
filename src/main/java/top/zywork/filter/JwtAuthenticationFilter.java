package top.zywork.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.zywork.common.DateFormatUtils;
import top.zywork.enums.ContentTypeEnum;
import top.zywork.enums.DatePatternEnum;
import top.zywork.enums.ResponseStatusEnum;
import top.zywork.security.*;
import top.zywork.vo.ResponseStatusVO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Jwt认证过滤器<br/>
 * 在UsernamePasswordAuthenticationFilter用户认证过滤器前先判断是否有jwt token传入，如果有，
 * 则从token中获取用户信息，并且检验此token是否有效，如果有效则表示此用户认证通过
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.header-prefix}")
    private String headerPrefix;

    private JwtUtils jwtUtils;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(tokenHeader);
        if (!StringUtils.isEmpty(token) && token.startsWith(headerPrefix)) {
            token = token.substring(headerPrefix.length());
            JwtClaims jwtClaims = jwtUtils.getTokenJwtClaims(token);
            if (jwtClaims != null) {
                // 如果解析到正确的token
                String jwtTokenKey = jwtClaims.getUserId() + "_" + jwtClaims.getCreateDate().getTime();
                JwtToken jwtTokenInRedis = jwtTokenRedisUtils.getToken(jwtTokenKey);
                if (jwtTokenInRedis != null &&token.equals(jwtTokenInRedis.getToken())) {
                    // 如果redis中存在此token
                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        // springsecurity上下文中不存在认证信息，则存储新的authentication到上下文
                        storeAuthentication(request, jwtClaims);
                    }
                    jwtTokenRedisUtils.countDau(jwtTokenKey, jwtTokenInRedis);
                    // 只要jwt token正常使用了，就刷新失效时间
                    jwtTokenRedisUtils.refreshTokenExpiration(jwtTokenKey);
                } else {
                    outResponse(response, ResponseStatusEnum.AUTHENTICATION_TOKEN_ERROR.getCode(), "Token不存在，或已失效", null);
                    return;
                }
            } else {
                // token解析错误
                outResponse(response, ResponseStatusEnum.AUTHENTICATION_TOKEN_ERROR.getCode(), "Token错误", null);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void storeAuthentication(HttpServletRequest request, JwtClaims jwtClaims) {
        JwtUser jwtUser = jwtUtils.getTokenJwtUser(jwtClaims);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 将认证状态存入SpringSecurity上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private void outResponse(HttpServletResponse response, int responseCode, String responseMsg, Object responseData) throws IOException {
        response.setContentType(ContentTypeEnum.JSON.getValue());
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(ResponseStatusVO.error(responseCode, responseMsg, responseData)));
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