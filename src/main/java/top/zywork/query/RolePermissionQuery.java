package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * RolePermissionQuery查询对象类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class RolePermissionQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036216713138L;

    //t_role表的字段对应的属性
	// 角色编号
	private Long roleId;
	// 角色编号（最小值）
	private Long roleIdMin;
	// 角色编号（最大值）
	private Long roleIdMax;
	// 角色标题
	private String roleTitle;
	//t_permission表的字段对应的属性
	// 权限编号
	private Long permissionId;
	// 权限编号（最小值）
	private Long permissionIdMin;
	// 权限编号（最大值）
	private Long permissionIdMax;
	// 权限标题
	private String permissionTitle;
	// 权限字符串
	private String permissionPermission;
	
    public RolePermissionQuery () {}

    public RolePermissionQuery (Long roleId, Long roleIdMin, Long roleIdMax, String roleTitle, Long permissionId, Long permissionIdMin, Long permissionIdMax, String permissionTitle, String permissionPermission) {
        this.roleId = roleId;
		this.roleIdMin = roleIdMin;
		this.roleIdMax = roleIdMax;
		this.roleTitle = roleTitle;
		this.permissionId = permissionId;
		this.permissionIdMin = permissionIdMin;
		this.permissionIdMax = permissionIdMax;
		this.permissionTitle = permissionTitle;
		this.permissionPermission = permissionPermission;
		
    }

    public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRoleIdMin() {
		return roleIdMin;
	}

	public void setRoleIdMin(Long roleIdMin) {
		this.roleIdMin = roleIdMin;
	}

	public Long getRoleIdMax() {
		return roleIdMax;
	}

	public void setRoleIdMax(Long roleIdMax) {
		this.roleIdMax = roleIdMax;
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

	public Long getPermissionIdMin() {
		return permissionIdMin;
	}

	public void setPermissionIdMin(Long permissionIdMin) {
		this.permissionIdMin = permissionIdMin;
	}

	public Long getPermissionIdMax() {
		return permissionIdMax;
	}

	public void setPermissionIdMax(Long permissionIdMax) {
		this.permissionIdMax = permissionIdMax;
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
        return "RolePermissionQuery {" +
                "roleId = " + roleId + 
				", roleIdMin = " + roleIdMin + 
				", roleIdMax = " + roleIdMax + 
				", roleTitle = " + roleTitle + 
				", permissionId = " + permissionId + 
				", permissionIdMin = " + permissionIdMin + 
				", permissionIdMax = " + permissionIdMax + 
				", permissionTitle = " + permissionTitle + 
				", permissionPermission = " + permissionPermission + 
				" }";
    }

}
