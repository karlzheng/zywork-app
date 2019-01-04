package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PermissionDTO数据传输对象类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class PermissionDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036131346075L;

    // 权限编号
	private Long id;
	// 所属模块
	private Long moduleId;
	// 权限标题
	private String title;
	// 权限字符串
	private String permission;
	// 权限描述
	private String description;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public PermissionDTO () {}

    public PermissionDTO (Long id, Long moduleId, String title, String permission, String description, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.moduleId = moduleId;
		this.title = title;
		this.permission = permission;
		this.description = description;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "PermissionDTO {" +
                "id = " + id + 
				", moduleId = " + moduleId + 
				", title = " + title + 
				", permission = " + permission + 
				", description = " + description + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
