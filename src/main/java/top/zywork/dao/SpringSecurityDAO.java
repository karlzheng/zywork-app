package top.zywork.dao;

import org.springframework.stereotype.Repository;
import top.zywork.security.RolePermissionDO;
import top.zywork.security.UserDO;

import java.util.List;

/**
 * <p>SpringSecurity数据访问接口，获取用户及权限相关信息信息</p>
 * 创建于2018-12-06<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface SpringSecurityDAO {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名，可以是phone或email，或用户social中的openid
     * @return
     */
    UserDO loadUserByUsername(String username);

    /**
     * 根据用户名获取用户的角色
     * @param username 用户名，可以是phone或email，或用户social中的openid
     * @return
     */
    List<String> loadRolesByUsername(String username);

    /**
     * 获取所有角色
     * @return
     */
    List<RolePermissionDO> listAllRolePermission();

    /**
     * 根据用户编号查询用户信息
     * @param userId
     * @return
     */
    UserDO loadUserByUserId(Long userId);
}
