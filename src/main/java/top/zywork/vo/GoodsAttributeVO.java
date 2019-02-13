package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsAttributeVO值对象类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsAttributeVO extends BaseVO {

    private static final long serialVersionUID = -9223372034928431744L;

    // 商品属性编号
	private Long id;
	// 属性名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String attrName;
	// 属性代码
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String attrCode;
	// 数据类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String attrType;
	// 数据长度
	@NotNull(message = "此项是必须项")
	private Integer attrLength;
	// 是否前端显示
	@NotNull(message = "此项是必须项")
	private Byte attrDisplay;
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
	
    public GoodsAttributeVO () {}

    public GoodsAttributeVO (Long id, String attrName, String attrCode, String attrType, Integer attrLength, Byte attrDisplay, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.attrName = attrName;
		this.attrCode = attrCode;
		this.attrType = attrType;
		this.attrLength = attrLength;
		this.attrDisplay = attrDisplay;
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

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrCode() {
		return attrCode;
	}

	public void setAttrCode(String attrCode) {
		this.attrCode = attrCode;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public Integer getAttrLength() {
		return attrLength;
	}

	public void setAttrLength(Integer attrLength) {
		this.attrLength = attrLength;
	}

	public Byte getAttrDisplay() {
		return attrDisplay;
	}

	public void setAttrDisplay(Byte attrDisplay) {
		this.attrDisplay = attrDisplay;
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
        return "GoodsAttributeVO {" +
                "id = " + id + 
				", attrName = " + attrName + 
				", attrCode = " + attrCode + 
				", attrType = " + attrType + 
				", attrLength = " + attrLength + 
				", attrDisplay = " + attrDisplay + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
