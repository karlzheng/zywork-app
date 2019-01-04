package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ModulePermissionVO值对象类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ModulePermissionVO extends BaseVO {

    private static final long serialVersionUID = -9223372036636167944L;

    //t_module表的字段对应的属性
	// 模块标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String moduleTitle;
	// 模块描述
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String moduleDescription;
	//t_permission表的字段对应的属性
	// 权限编号
	@NotNull(message = "此项是必须项")
	private Long permissionId;
	// 所属模块
	@NotNull(message = "此项是必须项")
	private Long permissionModuleId;
	// 权限标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String permissionTitle;
	// 权限字符串
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 200, message = "必须是1-200个字符")
	private String permissionPermission;
	// 权限描述
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String permissionDescription;
	// 版本号
	private Integer permissionVersion;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionUpdateTime;
	// 是否激活
	private Byte permissionIsActive;
	
    public ModulePermissionVO () {}

    public ModulePermissionVO (String moduleTitle, String moduleDescription, Long permissionId, Long permissionModuleId, String permissionTitle, String permissionPermission, String permissionDescription, Integer permissionVersion, Date permissionCreateTime, Date permissionUpdateTime, Byte permissionIsActive) {
        this.moduleTitle = moduleTitle;
		this.moduleDescription = moduleDescription;
		this.permissionId = permissionId;
		this.permissionModuleId = permissionModuleId;
		this.permissionTitle = permissionTitle;
		this.permissionPermission = permissionPermission;
		this.permissionDescription = permissionDescription;
		this.permissionVersion = permissionVersion;
		this.permissionCreateTime = permissionCreateTime;
		this.permissionUpdateTime = permissionUpdateTime;
		this.permissionIsActive = permissionIsActive;
		
    }

    public String getModuleTitle() {
		return moduleTitle;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getPermissionModuleId() {
		return permissionModuleId;
	}

	public void setPermissionModuleId(Long permissionModuleId) {
		this.permissionModuleId = permissionModuleId;
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

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public Integer getPermissionVersion() {
		return permissionVersion;
	}

	public void setPermissionVersion(Integer permissionVersion) {
		this.permissionVersion = permissionVersion;
	}

	public Date getPermissionCreateTime() {
		return permissionCreateTime;
	}

	public void setPermissionCreateTime(Date permissionCreateTime) {
		this.permissionCreateTime = permissionCreateTime;
	}

	public Date getPermissionUpdateTime() {
		return permissionUpdateTime;
	}

	public void setPermissionUpdateTime(Date permissionUpdateTime) {
		this.permissionUpdateTime = permissionUpdateTime;
	}

	public Byte getPermissionIsActive() {
		return permissionIsActive;
	}

	public void setPermissionIsActive(Byte permissionIsActive) {
		this.permissionIsActive = permissionIsActive;
	}

	
    @Override
    public String toString() {
        return "ModulePermissionVO {" +
                "moduleTitle = " + moduleTitle + 
				", moduleDescription = " + moduleDescription + 
				", permissionId = " + permissionId + 
				", permissionModuleId = " + permissionModuleId + 
				", permissionTitle = " + permissionTitle + 
				", permissionPermission = " + permissionPermission + 
				", permissionDescription = " + permissionDescription + 
				", permissionVersion = " + permissionVersion + 
				", permissionCreateTime = " + permissionCreateTime + 
				", permissionUpdateTime = " + permissionUpdateTime + 
				", permissionIsActive = " + permissionIsActive + 
				" }";
    }

}
