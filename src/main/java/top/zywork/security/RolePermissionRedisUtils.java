package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.zywork.common.RedisUtils;

import java.util.List;

/**
 * 用于操作角色权限的redis类<br/>
 *
 * 创建于2018-12-13<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class RolePermissionRedisUtils {

    private static final String ROLE_PERMISSION_LIST = "spring_security::role_permission_list";

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储所有角色权限
     * @param rolePermissionDOList
     */
    public void store(List<RolePermissionDO> rolePermissionDOList) {
        RedisUtils.save(redisTemplate, ROLE_PERMISSION_LIST, rolePermissionDOList);
    }

    /**
     * 判断是否缓存了角色权限
     * @return
     */
    public Boolean exists() {
        return RedisUtils.exists(redisTemplate, ROLE_PERMISSION_LIST);
    }

    /**
     * 从缓存获取角色权限
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public List<RolePermissionDO> get() {
        return (List<RolePermissionDO>) RedisUtils.get(redisTemplate, ROLE_PERMISSION_LIST);
    }

    /**
     * 删除缓存的角色权限
     */
    public void del() {
        RedisUtils.delete(redisTemplate, ROLE_PERMISSION_LIST);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
