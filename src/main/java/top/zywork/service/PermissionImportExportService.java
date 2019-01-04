package top.zywork.service;

import top.zywork.vo.PermissionImportExportVO;

import java.util.List;

/**
 * 权限导入导出服务接口<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface PermissionImportExportService {

    /**
     * 导入权限信息
     * @param permissionImportExportVOList
     */
    void importPermissions(List<PermissionImportExportVO> permissionImportExportVOList);

    /**
     * 导出权限信息
     * @return
     */
    List<PermissionImportExportVO> exportPermissions();

}
