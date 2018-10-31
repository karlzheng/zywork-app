package top.zywork.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, Collection<ConfigAttribute>> rolePermissionMap;

    static {
        // 查询出系统中所有的权限url，及可以访问此url的所有角色
        rolePermissionMap = new HashMap<>();
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        configAttributes.add(new SecurityConfig("admin"));
        configAttributes.add(new SecurityConfig("user"));
        rolePermissionMap.put("/user/edit", configAttributes);
        rolePermissionMap.put("/user/remove/*", configAttributes);
        List<ConfigAttribute> configAttributes1 = new ArrayList<>();
        configAttributes1.add(new SecurityConfig("user"));
        rolePermissionMap.put("/user/add", configAttributes1);
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        List<ConfigAttribute> configAttributes = null;
        FilterInvocation filterInvocation = (FilterInvocation) o;
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : rolePermissionMap.entrySet()) {
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(entry.getKey());
            if (matcher.matches(((FilterInvocation) o).getRequest())) {
                if (configAttributes == null) {
                    configAttributes = new ArrayList<>();
                }
                configAttributes.addAll(entry.getValue());
                break;
            }
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // 返回系统中配置的角色
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        configAttributes.add(new SecurityConfig("admin"));
        configAttributes.add(new SecurityConfig("user"));
        return configAttributes;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
