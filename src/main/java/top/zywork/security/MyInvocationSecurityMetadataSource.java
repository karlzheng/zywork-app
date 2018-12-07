package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import top.zywork.dao.SpringSecurityDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户资源与角色元数据<br/>
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final String ROLE_PERMISSION_LIST = "spring_security::role_permission_list";

    private SpringSecurityDAO springSecurityDAO;

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        List<RolePermissionDO> rolePermissionDOList = listAllRolePermission();
        List<ConfigAttribute> configAttributes = null;
        FilterInvocation filterInvocation = (FilterInvocation) o;
        for (RolePermissionDO rolePermissionDO : rolePermissionDOList) {
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(rolePermissionDO.getPermission());
            if (matcher.matches(filterInvocation.getRequest())) {
                if (configAttributes == null) {
                    configAttributes = new ArrayList<>();
                }
                configAttributes.add(new SecurityConfig(rolePermissionDO.getRole()));
            }
        }
        return configAttributes;
    }

    private List<RolePermissionDO> listAllRolePermission() {
        List<RolePermissionDO> rolePermissionDOList = (List<RolePermissionDO>) redisTemplate.opsForValue().get(ROLE_PERMISSION_LIST);
        if (rolePermissionDOList == null || rolePermissionDOList.size() == 0) {
            rolePermissionDOList = springSecurityDAO.listAllRolePermission();
            redisTemplate.opsForValue().set(ROLE_PERMISSION_LIST, rolePermissionDOList);
        }
        return rolePermissionDOList;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Autowired
    public void setSpringSecurityDAO(SpringSecurityDAO springSecurityDAO) {
        this.springSecurityDAO = springSecurityDAO;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
