package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户注册时，给用户保存相应的角色<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserRoleRegDAO {

    /**
     * 把用户与角色关系保存起来
     * @param userId 用户编号
     * @param roleId 角色编号
     */
    void saveUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

}
