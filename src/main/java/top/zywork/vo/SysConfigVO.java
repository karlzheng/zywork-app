package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * SysConfigVO值对象类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SysConfigVO extends BaseVO {

    private static final long serialVersionUID = -9223372035949245858L;

    // 配置编号
	private Long id;
	// 配置名称
	@Size(min = 0, max = 50, message = "必须小于50个字符")
	private String name;
	// 配置内容(JSON)
	@Size(min = 0, max = 5000, message = "必须小于5000个字符")
	private String value;
	// 中文说明
	@Size(min = 0, max = 50, message = "必须小于50个字符")
	private String description;
	// 配置注释
	@Size(min = 0, max = 5000, message = "必须小于5000个字符")
	private String comment;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public SysConfigVO () {}

    public SysConfigVO (Long id, String name, String value, String description, String comment, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.name = name;
		this.value = value;
		this.description = description;
		this.comment = comment;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
        return "SysConfigVO {" +
                "id = " + id + 
				", name = " + name + 
				", value = " + value + 
				", description = " + description + 
				", comment = " + comment + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
