package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsCartDO数据对象实体类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsCartDO extends BaseDO {

    private static final long serialVersionUID = -9223372034889715652L;

    // 购物编号
	private Long id;
	// 用户编号
	private Long userId;
	// 商品编号
	private Long goodsId;
	// SKU编号
	private Long goodsSkuId;
	// 购买数量
	private Integer quantity;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsCartDO () {}

    public GoodsCartDO (Long id, Long userId, Long goodsId, Long goodsSkuId, Integer quantity, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.goodsSkuId = goodsSkuId;
		this.quantity = quantity;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsSkuId() {
		return goodsSkuId;
	}

	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
        return "GoodsCartDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", goodsId = " + goodsId + 
				", goodsSkuId = " + goodsSkuId + 
				", quantity = " + quantity + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
