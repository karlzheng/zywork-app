package top.zywork.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.zywork.security.JwtClaims;
import top.zywork.security.JwtUser;
import top.zywork.security.JwtUserDetailsService;
import top.zywork.security.JwtUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.header-prefix}")
    private String headerPrefix;

    private JwtUtils jwtUtils;

    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(tokenHeader);
        if (!StringUtils.isEmpty(token) && token.startsWith(headerPrefix)) {
            token = token.substring(headerPrefix.length());
            JwtClaims jwtClaims = jwtUtils.getTokenJwtClaims(token);
            if (jwtClaims != null) {
                String username = jwtClaims.getUsername();
                if (!StringUtils.isEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                    JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(username);
                    if (jwtUtils.validateToken(jwtUser, jwtClaims)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
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
}