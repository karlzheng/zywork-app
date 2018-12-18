package top.zywork.dao;

import org.springframework.stereotype.Repository;

/**
 * 默认角色查询DAO<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface DefaultRoleQueryDAO {

    /**
     * 获取配置的默认角色
     * @return
     */
    Long getDefaultRole();

}
