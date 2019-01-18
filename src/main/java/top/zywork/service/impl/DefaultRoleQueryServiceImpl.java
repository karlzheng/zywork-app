package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.zywork.common.RedisUtils;
import top.zywork.dao.DefaultRoleQueryDAO;
import top.zywork.service.DefaultRoleQueryService;

/**
 * 默认角色查询Service接口实现类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class DefaultRoleQueryServiceImpl implements DefaultRoleQueryService {

    private static final String DEFAULT_ROLE_KEY = "default_role";

    private DefaultRoleQueryDAO defaultRoleQueryDAO;

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Long getDefaultRole() {
        Object roleId = RedisUtils.get(redisTemplate, DEFAULT_ROLE_KEY);
        if (roleId == null) {
            roleId = defaultRoleQueryDAO.getDefaultRole();
            if (roleId != null) {
                RedisUtils.save(redisTemplate, DEFAULT_ROLE_KEY, roleId);
            }
        }
        if (roleId instanceof Long) {
            return (Long) roleId;
        } else if (roleId instanceof Integer) {
            return Long.valueOf((Integer) roleId);
        }
        return null;
    }

    @Autowired
    public void setDefaultRoleQueryDAO(DefaultRoleQueryDAO defaultRoleQueryDAO) {
        this.defaultRoleQueryDAO = defaultRoleQueryDAO;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
