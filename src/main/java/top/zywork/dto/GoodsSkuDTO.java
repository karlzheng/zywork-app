package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsSkuDTO数据传输对象类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsSkuDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035136652969L;

    // SKU编号
	private Long id;
	// 商品编号
	private Long goodsId;
	// 商品图片编号
	private Long picId;
	// 上架状态
	private Byte shelfStatus;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsSkuDTO () {}

    public GoodsSkuDTO (Long id, Long goodsId, Long picId, Byte shelfStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.goodsId = goodsId;
		this.picId = picId;
		this.shelfStatus = shelfStatus;
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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public Byte getShelfStatus() {
		return shelfStatus;
	}

	public void setShelfStatus(Byte shelfStatus) {
		this.shelfStatus = shelfStatus;
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
        return "GoodsSkuDTO {" +
                "id = " + id + 
				", goodsId = " + goodsId + 
				", picId = " + picId + 
				", shelfStatus = " + shelfStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
