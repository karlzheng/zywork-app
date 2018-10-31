package top.zywork.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }
        Collection<? extends GrantedAuthority> authorityList = authentication.getAuthorities();
        for (GrantedAuthority authority : authorityList) {
            for (ConfigAttribute configAttribute : configAttributes) {
                if (authority.getAuthority().equals(configAttribute.getAttribute())) {
                    return; // 如果用户的权限与配置的权限有匹配项，表示有权限，直接返回
                }
            }
        }
        throw new AccessDeniedException("No permission!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
