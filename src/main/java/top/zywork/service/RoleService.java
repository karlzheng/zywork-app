package top.zywork.service;

import top.zywork.vo.RoleExportVO;
import top.zywork.vo.RoleVO;

import java.util.List;

/**
 * RoleService服务接口<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface RoleService extends BaseService {

    /**
     * 导入角色
     * @param roleVOList
     */
    void importRoles(List<RoleVO> roleVOList);

    /**
     * 导出角色
     * @return
     */
    List<RoleExportVO> exportRoles();
}
