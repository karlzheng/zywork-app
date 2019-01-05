package top.zywork.service;

import top.zywork.dto.PagerDTO;

/**
 * PermissionService服务接口<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface PermissionService extends BaseService {

    /**
     * 根据用户编号获取用户所有权限
     * @param userId
     * @return
     */
    PagerDTO listByUserId(Long userId);

}
