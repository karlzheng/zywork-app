package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsAttributeQuery查询对象类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsAttributeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036317563343L;

    // 商品属性编号
	private Long id;
	// 商品属性编号（最小值）
	private Long idMin;
	// 商品属性编号（最大值）
	private Long idMax;
	// 属性名称
	private String attrName;
	// 属性代码
	private String attrCode;
	// 数据类型
	private String attrType;
	// 数据长度
	private Integer attrLength;
	// 数据长度（最小值）
	private Integer attrLengthMin;
	// 数据长度（最大值）
	private Integer attrLengthMax;
	// 是否前端显示
	private Byte attrDisplay;
	// 是否前端显示（最小值）
	private Byte attrDisplayMin;
	// 是否前端显示（最大值）
	private Byte attrDisplayMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public GoodsAttributeQuery () {}

    public GoodsAttributeQuery (Long id, Long idMin, Long idMax, String attrName, String attrCode, String attrType, Integer attrLength, Integer attrLengthMin, Integer attrLengthMax, Byte attrDisplay, Byte attrDisplayMin, Byte attrDisplayMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.attrName = attrName;
		this.attrCode = attrCode;
		this.attrType = attrType;
		this.attrLength = attrLength;
		this.attrLengthMin = attrLengthMin;
		this.attrLengthMax = attrLengthMax;
		this.attrDisplay = attrDisplay;
		this.attrDisplayMin = attrDisplayMin;
		this.attrDisplayMax = attrDisplayMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
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

	public Integer getAttrLengthMin() {
		return attrLengthMin;
	}

	public void setAttrLengthMin(Integer attrLengthMin) {
		this.attrLengthMin = attrLengthMin;
	}

	public Integer getAttrLengthMax() {
		return attrLengthMax;
	}

	public void setAttrLengthMax(Integer attrLengthMax) {
		this.attrLengthMax = attrLengthMax;
	}

	public Byte getAttrDisplay() {
		return attrDisplay;
	}

	public void setAttrDisplay(Byte attrDisplay) {
		this.attrDisplay = attrDisplay;
	}

	public Byte getAttrDisplayMin() {
		return attrDisplayMin;
	}

	public void setAttrDisplayMin(Byte attrDisplayMin) {
		this.attrDisplayMin = attrDisplayMin;
	}

	public Byte getAttrDisplayMax() {
		return attrDisplayMax;
	}

	public void setAttrDisplayMax(Byte attrDisplayMax) {
		this.attrDisplayMax = attrDisplayMax;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "GoodsAttributeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", attrName = " + attrName + 
				", attrCode = " + attrCode + 
				", attrType = " + attrType + 
				", attrLength = " + attrLength + 
				", attrLengthMin = " + attrLengthMin + 
				", attrLengthMax = " + attrLengthMax + 
				", attrDisplay = " + attrDisplay + 
				", attrDisplayMin = " + attrDisplayMin + 
				", attrDisplayMax = " + attrDisplayMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
