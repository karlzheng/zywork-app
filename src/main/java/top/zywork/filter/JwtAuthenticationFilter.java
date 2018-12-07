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
import top.zywork.enums.ContentTypeEnum;
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

    private JwtUserDetailsService jwtUserDetailsService;

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(tokenHeader);
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (!StringUtils.isEmpty(token) && token.startsWith(headerPrefix)) {
            token = token.substring(headerPrefix.length());
            JwtClaims jwtClaims = jwtUtils.getTokenJwtClaims(token);
            if (jwtClaims != null) {
                // 如果解析到正确的token
                Long userId = jwtClaims.getUserId();
                String jwtTokenInRedis = jwtTokenRedisUtils.getToken(userId + "");
                if (token.equals(jwtTokenInRedis)) {
                    // 如果redis中存在此token
                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        // springsecurity上下文中不存在认证信息
                        JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(jwtClaims.getUsername());
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        // 将认证状态存入SpringSecurity上下文
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                } else {
                    response.setContentType(ContentTypeEnum.JSON.getValue());
                    PrintWriter writer = response.getWriter();
                    statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_TOKEN_ERROR.getCode(), "Token不存在，或已失效", null);
                    writer.write(JSON.toJSONString(statusVO));
                    return;
                }
            } else {
                // token解析错误
                response.setContentType(ContentTypeEnum.JSON.getValue());
                PrintWriter writer = response.getWriter();
                statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_TOKEN_ERROR.getCode(), "Token错误", null);
                writer.write(JSON.toJSONString(statusVO));
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setJwtUserDetailsService(JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }
}