package top.zywork.vo;

import java.util.List;

/**
 * 权限导入导出值对象类，与JSON配置对<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class PermissionImportExportVO {

    private String moduleTitle;
    private List<PermissionInnerVO> permissions;

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public List<PermissionInnerVO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionInnerVO> permissions) {
        this.permissions = permissions;
    }
}


