package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * OrganizationDTO数据传输对象类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class OrganizationDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036355305666L;

    // 组织编号
	private Long id;
	// 父编号
	private Long parentId;
	// 组织名称
	private String title;
	// 组织描述
	private String description;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public OrganizationDTO () {}

    public OrganizationDTO (Long id, Long parentId, String title, String description, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.parentId = parentId;
		this.title = title;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
        return "OrganizationDTO {" +
                "id = " + id + 
				", parentId = " + parentId + 
				", title = " + title + 
				", description = " + description + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
