package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsAttributeValueDTO数据传输对象类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsAttributeValueDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035594998765L;

    // 商品属性值编号
	private Long id;
	// SKU编号
	private Long goodsSkuId;
	// 属性编号
	private Long attrId;
	// 属性值
	private String attrValue;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsAttributeValueDTO () {}

    public GoodsAttributeValueDTO (Long id, Long goodsSkuId, Long attrId, String attrValue, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.goodsSkuId = goodsSkuId;
		this.attrId = attrId;
		this.attrValue = attrValue;
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

	public Long getGoodsSkuId() {
		return goodsSkuId;
	}

	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
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
        return "GoodsAttributeValueDTO {" +
                "id = " + id + 
				", goodsSkuId = " + goodsSkuId + 
				", attrId = " + attrId + 
				", attrValue = " + attrValue + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
