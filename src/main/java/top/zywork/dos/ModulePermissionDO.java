package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ModulePermissionDO数据对象实体类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ModulePermissionDO extends BaseDO {

    private static final long serialVersionUID = -9223372035745767915L;

    //t_module表的字段对应的属性
	// 模块标题
	private String moduleTitle;
	// 模块描述
	private String moduleDescription;
	//t_permission表的字段对应的属性
	// 权限编号
	private Long permissionId;
	// 所属模块
	private Long permissionModuleId;
	// 权限标题
	private String permissionTitle;
	// 权限字符串
	private String permissionPermission;
	// 权限描述
	private String permissionDescription;
	// 版本号
	private Integer permissionVersion;
	// 创建时间
	private Date permissionCreateTime;
	// 更新时间
	private Date permissionUpdateTime;
	// 是否激活
	private Byte permissionIsActive;
	
    public ModulePermissionDO () {}

    public ModulePermissionDO (String moduleTitle, String moduleDescription, Long permissionId, Long permissionModuleId, String permissionTitle, String permissionPermission, String permissionDescription, Integer permissionVersion, Date permissionCreateTime, Date permissionUpdateTime, Byte permissionIsActive) {
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
        return "ModulePermissionDO {" +
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
