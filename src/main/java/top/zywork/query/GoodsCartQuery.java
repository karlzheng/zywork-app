package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsCartQuery查询对象类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsCartQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036164254639L;

    // 购物编号
	private Long id;
	// 购物编号（最小值）
	private Long idMin;
	// 购物编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 商品编号
	private Long goodsId;
	// 商品编号（最小值）
	private Long goodsIdMin;
	// 商品编号（最大值）
	private Long goodsIdMax;
	// SKU编号
	private Long goodsSkuId;
	// SKU编号（最小值）
	private Long goodsSkuIdMin;
	// SKU编号（最大值）
	private Long goodsSkuIdMax;
	// 购买数量
	private Integer quantity;
	// 购买数量（最小值）
	private Integer quantityMin;
	// 购买数量（最大值）
	private Integer quantityMax;
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
	
    public GoodsCartQuery () {}

    public GoodsCartQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long goodsId, Long goodsIdMin, Long goodsIdMax, Long goodsSkuId, Long goodsSkuIdMin, Long goodsSkuIdMax, Integer quantity, Integer quantityMin, Integer quantityMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.goodsId = goodsId;
		this.goodsIdMin = goodsIdMin;
		this.goodsIdMax = goodsIdMax;
		this.goodsSkuId = goodsSkuId;
		this.goodsSkuIdMin = goodsSkuIdMin;
		this.goodsSkuIdMax = goodsSkuIdMax;
		this.quantity = quantity;
		this.quantityMin = quantityMin;
		this.quantityMax = quantityMax;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsIdMin() {
		return goodsIdMin;
	}

	public void setGoodsIdMin(Long goodsIdMin) {
		this.goodsIdMin = goodsIdMin;
	}

	public Long getGoodsIdMax() {
		return goodsIdMax;
	}

	public void setGoodsIdMax(Long goodsIdMax) {
		this.goodsIdMax = goodsIdMax;
	}

	public Long getGoodsSkuId() {
		return goodsSkuId;
	}

	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public Long getGoodsSkuIdMin() {
		return goodsSkuIdMin;
	}

	public void setGoodsSkuIdMin(Long goodsSkuIdMin) {
		this.goodsSkuIdMin = goodsSkuIdMin;
	}

	public Long getGoodsSkuIdMax() {
		return goodsSkuIdMax;
	}

	public void setGoodsSkuIdMax(Long goodsSkuIdMax) {
		this.goodsSkuIdMax = goodsSkuIdMax;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantityMin() {
		return quantityMin;
	}

	public void setQuantityMin(Integer quantityMin) {
		this.quantityMin = quantityMin;
	}

	public Integer getQuantityMax() {
		return quantityMax;
	}

	public void setQuantityMax(Integer quantityMax) {
		this.quantityMax = quantityMax;
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
        return "GoodsCartQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", goodsId = " + goodsId + 
				", goodsIdMin = " + goodsIdMin + 
				", goodsIdMax = " + goodsIdMax + 
				", goodsSkuId = " + goodsSkuId + 
				", goodsSkuIdMin = " + goodsSkuIdMin + 
				", goodsSkuIdMax = " + goodsSkuIdMax + 
				", quantity = " + quantity + 
				", quantityMin = " + quantityMin + 
				", quantityMax = " + quantityMax + 
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
