package top.zywork.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * SpringSecurity用于获取用户信息的工具类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class SecurityUtils {

    /**
     * 获取当前登录的JwtUser，如果返为null，表示没有用户登录
     * @return
     */
    public static JwtUser getJwtUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof JwtUser) {
            return (JwtUser) principal;
        }
        return null;
    }
}
