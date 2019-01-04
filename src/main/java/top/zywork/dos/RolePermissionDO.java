package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * RolePermissionDO数据对象实体类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class RolePermissionDO extends BaseDO {

    private static final long serialVersionUID = -9223372035415845800L;

    //t_role表的字段对应的属性
	// 角色编号
	private Long roleId;
	// 角色标题
	private String roleTitle;
	//t_permission表的字段对应的属性
	// 权限编号
	private Long permissionId;
	// 权限标题
	private String permissionTitle;
	// 权限字符串
	private String permissionPermission;
	
    public RolePermissionDO () {}

    public RolePermissionDO (Long roleId, String roleTitle, Long permissionId, String permissionTitle, String permissionPermission) {
        this.roleId = roleId;
		this.roleTitle = roleTitle;
		this.permissionId = permissionId;
		this.permissionTitle = permissionTitle;
		this.permissionPermission = permissionPermission;
		
    }

    public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionTitle() {
		return permissionTitle;
	}

	public void setPermissionTitle(String permissionTitle) {
		this.permissionTitle = permissionTitle;
	}

	public String getPermissionPermission() {
		return permissionPermission;
	}

	public void setPermissionPermission(String permissionPermission) {
		this.permissionPermission = permissionPermission;
	}

	
    @Override
    public String toString() {
        return "RolePermissionDO {" +
                "roleId = " + roleId + 
				", roleTitle = " + roleTitle + 
				", permissionId = " + permissionId + 
				", permissionTitle = " + permissionTitle + 
				", permissionPermission = " + permissionPermission + 
				" }";
    }

}
