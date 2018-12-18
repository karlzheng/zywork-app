package top.zywork.service;

/**
 * 默认角色查询Service接口<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface DefaultRoleQueryService {

    /**
     * 获取配置的默认角色，并缓存
     * @return
     */
    Long getDefaultRole();

}
