package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * RolePermissionVO值对象类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class RolePermissionVO extends BaseVO {

    private static final long serialVersionUID = -9223372036609551047L;

    //t_role表的字段对应的属性
	// 角色编号
	private Long roleId;
	// 角色标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String roleTitle;
	//t_permission表的字段对应的属性
	// 权限编号
	@NotNull(message = "此项是必须项")
	private Long permissionId;
	// 权限标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String permissionTitle;
	// 权限字符串
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 200, message = "必须是1-200个字符")
	private String permissionPermission;
	
    public RolePermissionVO () {}

    public RolePermissionVO (Long roleId, String roleTitle, Long permissionId, String permissionTitle, String permissionPermission) {
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
        return "RolePermissionVO {" +
                "roleId = " + roleId + 
				", roleTitle = " + roleTitle + 
				", permissionId = " + permissionId + 
				", permissionTitle = " + permissionTitle + 
				", permissionPermission = " + permissionPermission + 
				" }";
    }

}
