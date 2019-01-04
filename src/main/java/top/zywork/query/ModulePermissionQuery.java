package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ModulePermissionQuery查询对象类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ModulePermissionQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036027793785L;

    //t_module表的字段对应的属性
	// 模块标题
	private String moduleTitle;
	// 模块描述
	private String moduleDescription;
	//t_permission表的字段对应的属性
	// 权限编号
	private Long permissionId;
	// 权限编号（最小值）
	private Long permissionIdMin;
	// 权限编号（最大值）
	private Long permissionIdMax;
	// 所属模块
	private Long permissionModuleId;
	// 所属模块（最小值）
	private Long permissionModuleIdMin;
	// 所属模块（最大值）
	private Long permissionModuleIdMax;
	// 权限标题
	private String permissionTitle;
	// 权限字符串
	private String permissionPermission;
	// 权限描述
	private String permissionDescription;
	// 版本号
	private Integer permissionVersion;
	// 版本号（最小值）
	private Integer permissionVersionMin;
	// 版本号（最大值）
	private Integer permissionVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date permissionUpdateTimeMax;
	// 是否激活
	private Byte permissionIsActive;
	// 是否激活（最小值）
	private Byte permissionIsActiveMin;
	// 是否激活（最大值）
	private Byte permissionIsActiveMax;
	
    public ModulePermissionQuery () {}

    public ModulePermissionQuery (String moduleTitle, String moduleDescription, Long permissionId, Long permissionIdMin, Long permissionIdMax, Long permissionModuleId, Long permissionModuleIdMin, Long permissionModuleIdMax, String permissionTitle, String permissionPermission, String permissionDescription, Integer permissionVersion, Integer permissionVersionMin, Integer permissionVersionMax, Date permissionCreateTime, Date permissionCreateTimeMin, Date permissionCreateTimeMax, Date permissionUpdateTime, Date permissionUpdateTimeMin, Date permissionUpdateTimeMax, Byte permissionIsActive, Byte permissionIsActiveMin, Byte permissionIsActiveMax) {
        this.moduleTitle = moduleTitle;
		this.moduleDescription = moduleDescription;
		this.permissionId = permissionId;
		this.permissionIdMin = permissionIdMin;
		this.permissionIdMax = permissionIdMax;
		this.permissionModuleId = permissionModuleId;
		this.permissionModuleIdMin = permissionModuleIdMin;
		this.permissionModuleIdMax = permissionModuleIdMax;
		this.permissionTitle = permissionTitle;
		this.permissionPermission = permissionPermission;
		this.permissionDescription = permissionDescription;
		this.permissionVersion = permissionVersion;
		this.permissionVersionMin = permissionVersionMin;
		this.permissionVersionMax = permissionVersionMax;
		this.permissionCreateTime = permissionCreateTime;
		this.permissionCreateTimeMin = permissionCreateTimeMin;
		this.permissionCreateTimeMax = permissionCreateTimeMax;
		this.permissionUpdateTime = permissionUpdateTime;
		this.permissionUpdateTimeMin = permissionUpdateTimeMin;
		this.permissionUpdateTimeMax = permissionUpdateTimeMax;
		this.permissionIsActive = permissionIsActive;
		this.permissionIsActiveMin = permissionIsActiveMin;
		this.permissionIsActiveMax = permissionIsActiveMax;
		
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

	public Long getPermissionModuleId() {
		return permissionModuleId;
	}

	public void setPermissionModuleId(Long permissionModuleId) {
		this.permissionModuleId = permissionModuleId;
	}

	public Long getPermissionModuleIdMin() {
		return permissionModuleIdMin;
	}

	public void setPermissionModuleIdMin(Long permissionModuleIdMin) {
		this.permissionModuleIdMin = permissionModuleIdMin;
	}

	public Long getPermissionModuleIdMax() {
		return permissionModuleIdMax;
	}

	public void setPermissionModuleIdMax(Long permissionModuleIdMax) {
		this.permissionModuleIdMax = permissionModuleIdMax;
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

	public Integer getPermissionVersionMin() {
		return permissionVersionMin;
	}

	public void setPermissionVersionMin(Integer permissionVersionMin) {
		this.permissionVersionMin = permissionVersionMin;
	}

	public Integer getPermissionVersionMax() {
		return permissionVersionMax;
	}

	public void setPermissionVersionMax(Integer permissionVersionMax) {
		this.permissionVersionMax = permissionVersionMax;
	}

	public Date getPermissionCreateTime() {
		return permissionCreateTime;
	}

	public void setPermissionCreateTime(Date permissionCreateTime) {
		this.permissionCreateTime = permissionCreateTime;
	}

	public Date getPermissionCreateTimeMin() {
		return permissionCreateTimeMin;
	}

	public void setPermissionCreateTimeMin(Date permissionCreateTimeMin) {
		this.permissionCreateTimeMin = permissionCreateTimeMin;
	}

	public Date getPermissionCreateTimeMax() {
		return permissionCreateTimeMax;
	}

	public void setPermissionCreateTimeMax(Date permissionCreateTimeMax) {
		this.permissionCreateTimeMax = permissionCreateTimeMax;
	}

	public Date getPermissionUpdateTime() {
		return permissionUpdateTime;
	}

	public void setPermissionUpdateTime(Date permissionUpdateTime) {
		this.permissionUpdateTime = permissionUpdateTime;
	}

	public Date getPermissionUpdateTimeMin() {
		return permissionUpdateTimeMin;
	}

	public void setPermissionUpdateTimeMin(Date permissionUpdateTimeMin) {
		this.permissionUpdateTimeMin = permissionUpdateTimeMin;
	}

	public Date getPermissionUpdateTimeMax() {
		return permissionUpdateTimeMax;
	}

	public void setPermissionUpdateTimeMax(Date permissionUpdateTimeMax) {
		this.permissionUpdateTimeMax = permissionUpdateTimeMax;
	}

	public Byte getPermissionIsActive() {
		return permissionIsActive;
	}

	public void setPermissionIsActive(Byte permissionIsActive) {
		this.permissionIsActive = permissionIsActive;
	}

	public Byte getPermissionIsActiveMin() {
		return permissionIsActiveMin;
	}

	public void setPermissionIsActiveMin(Byte permissionIsActiveMin) {
		this.permissionIsActiveMin = permissionIsActiveMin;
	}

	public Byte getPermissionIsActiveMax() {
		return permissionIsActiveMax;
	}

	public void setPermissionIsActiveMax(Byte permissionIsActiveMax) {
		this.permissionIsActiveMax = permissionIsActiveMax;
	}

	
    @Override
    public String toString() {
        return "ModulePermissionQuery {" +
                "moduleTitle = " + moduleTitle + 
				", moduleDescription = " + moduleDescription + 
				", permissionId = " + permissionId + 
				", permissionIdMin = " + permissionIdMin + 
				", permissionIdMax = " + permissionIdMax + 
				", permissionModuleId = " + permissionModuleId + 
				", permissionModuleIdMin = " + permissionModuleIdMin + 
				", permissionModuleIdMax = " + permissionModuleIdMax + 
				", permissionTitle = " + permissionTitle + 
				", permissionPermission = " + permissionPermission + 
				", permissionDescription = " + permissionDescription + 
				", permissionVersion = " + permissionVersion + 
				", permissionVersionMin = " + permissionVersionMin + 
				", permissionVersionMax = " + permissionVersionMax + 
				", permissionCreateTime = " + permissionCreateTime + 
				", permissionCreateTimeMin = " + permissionCreateTimeMin + 
				", permissionCreateTimeMax = " + permissionCreateTimeMax + 
				", permissionUpdateTime = " + permissionUpdateTime + 
				", permissionUpdateTimeMin = " + permissionUpdateTimeMin + 
				", permissionUpdateTimeMax = " + permissionUpdateTimeMax + 
				", permissionIsActive = " + permissionIsActive + 
				", permissionIsActiveMin = " + permissionIsActiveMin + 
				", permissionIsActiveMax = " + permissionIsActiveMax + 
				" }";
    }

}
