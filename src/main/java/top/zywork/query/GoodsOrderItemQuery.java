package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsOrderItemQuery查询对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsOrderItemQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035135899243L;

    // 订单项编号
	private Long id;
	// 订单项编号（最小值）
	private Long idMin;
	// 订单项编号（最大值）
	private Long idMax;
	// 订单编号
	private Long orderId;
	// 订单编号（最小值）
	private Long orderIdMin;
	// 订单编号（最大值）
	private Long orderIdMax;
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
	// SKU图片编号
	private Long skuPicId;
	// SKU图片编号（最小值）
	private Long skuPicIdMin;
	// SKU图片编号（最大值）
	private Long skuPicIdMax;
	// 售卖标题
	private String skuTitle;
	// SKU属性JSON
	private String skuInfo;
	// 购买数量
	private Integer quantity;
	// 购买数量（最小值）
	private Integer quantityMin;
	// 购买数量（最大值）
	private Integer quantityMax;
	// 实付金额
	private Long payAmount;
	// 实付金额（最小值）
	private Long payAmountMin;
	// 实付金额（最大值）
	private Long payAmountMax;
	// 优惠金额
	private Long discountAmount;
	// 优惠金额（最小值）
	private Long discountAmountMin;
	// 优惠金额（最大值）
	private Long discountAmountMax;
	// 赠送积分
	private Long integralAmount;
	// 赠送积分（最小值）
	private Long integralAmountMin;
	// 赠送积分（最大值）
	private Long integralAmountMax;
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
	
    public GoodsOrderItemQuery () {}

    public GoodsOrderItemQuery (Long id, Long idMin, Long idMax, Long orderId, Long orderIdMin, Long orderIdMax, Long goodsId, Long goodsIdMin, Long goodsIdMax, Long goodsSkuId, Long goodsSkuIdMin, Long goodsSkuIdMax, Long skuPicId, Long skuPicIdMin, Long skuPicIdMax, String skuTitle, String skuInfo, Integer quantity, Integer quantityMin, Integer quantityMax, Long payAmount, Long payAmountMin, Long payAmountMax, Long discountAmount, Long discountAmountMin, Long discountAmountMax, Long integralAmount, Long integralAmountMin, Long integralAmountMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.orderId = orderId;
		this.orderIdMin = orderIdMin;
		this.orderIdMax = orderIdMax;
		this.goodsId = goodsId;
		this.goodsIdMin = goodsIdMin;
		this.goodsIdMax = goodsIdMax;
		this.goodsSkuId = goodsSkuId;
		this.goodsSkuIdMin = goodsSkuIdMin;
		this.goodsSkuIdMax = goodsSkuIdMax;
		this.skuPicId = skuPicId;
		this.skuPicIdMin = skuPicIdMin;
		this.skuPicIdMax = skuPicIdMax;
		this.skuTitle = skuTitle;
		this.skuInfo = skuInfo;
		this.quantity = quantity;
		this.quantityMin = quantityMin;
		this.quantityMax = quantityMax;
		this.payAmount = payAmount;
		this.payAmountMin = payAmountMin;
		this.payAmountMax = payAmountMax;
		this.discountAmount = discountAmount;
		this.discountAmountMin = discountAmountMin;
		this.discountAmountMax = discountAmountMax;
		this.integralAmount = integralAmount;
		this.integralAmountMin = integralAmountMin;
		this.integralAmountMax = integralAmountMax;
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderIdMin() {
		return orderIdMin;
	}

	public void setOrderIdMin(Long orderIdMin) {
		this.orderIdMin = orderIdMin;
	}

	public Long getOrderIdMax() {
		return orderIdMax;
	}

	public void setOrderIdMax(Long orderIdMax) {
		this.orderIdMax = orderIdMax;
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

	public Long getSkuPicId() {
		return skuPicId;
	}

	public void setSkuPicId(Long skuPicId) {
		this.skuPicId = skuPicId;
	}

	public Long getSkuPicIdMin() {
		return skuPicIdMin;
	}

	public void setSkuPicIdMin(Long skuPicIdMin) {
		this.skuPicIdMin = skuPicIdMin;
	}

	public Long getSkuPicIdMax() {
		return skuPicIdMax;
	}

	public void setSkuPicIdMax(Long skuPicIdMax) {
		this.skuPicIdMax = skuPicIdMax;
	}

	public String getSkuTitle() {
		return skuTitle;
	}

	public void setSkuTitle(String skuTitle) {
		this.skuTitle = skuTitle;
	}

	public String getSkuInfo() {
		return skuInfo;
	}

	public void setSkuInfo(String skuInfo) {
		this.skuInfo = skuInfo;
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

	public Long getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}

	public Long getPayAmountMin() {
		return payAmountMin;
	}

	public void setPayAmountMin(Long payAmountMin) {
		this.payAmountMin = payAmountMin;
	}

	public Long getPayAmountMax() {
		return payAmountMax;
	}

	public void setPayAmountMax(Long payAmountMax) {
		this.payAmountMax = payAmountMax;
	}

	public Long getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Long discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Long getDiscountAmountMin() {
		return discountAmountMin;
	}

	public void setDiscountAmountMin(Long discountAmountMin) {
		this.discountAmountMin = discountAmountMin;
	}

	public Long getDiscountAmountMax() {
		return discountAmountMax;
	}

	public void setDiscountAmountMax(Long discountAmountMax) {
		this.discountAmountMax = discountAmountMax;
	}

	public Long getIntegralAmount() {
		return integralAmount;
	}

	public void setIntegralAmount(Long integralAmount) {
		this.integralAmount = integralAmount;
	}

	public Long getIntegralAmountMin() {
		return integralAmountMin;
	}

	public void setIntegralAmountMin(Long integralAmountMin) {
		this.integralAmountMin = integralAmountMin;
	}

	public Long getIntegralAmountMax() {
		return integralAmountMax;
	}

	public void setIntegralAmountMax(Long integralAmountMax) {
		this.integralAmountMax = integralAmountMax;
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
        return "GoodsOrderItemQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", orderId = " + orderId + 
				", orderIdMin = " + orderIdMin + 
				", orderIdMax = " + orderIdMax + 
				", goodsId = " + goodsId + 
				", goodsIdMin = " + goodsIdMin + 
				", goodsIdMax = " + goodsIdMax + 
				", goodsSkuId = " + goodsSkuId + 
				", goodsSkuIdMin = " + goodsSkuIdMin + 
				", goodsSkuIdMax = " + goodsSkuIdMax + 
				", skuPicId = " + skuPicId + 
				", skuPicIdMin = " + skuPicIdMin + 
				", skuPicIdMax = " + skuPicIdMax + 
				", skuTitle = " + skuTitle + 
				", skuInfo = " + skuInfo + 
				", quantity = " + quantity + 
				", quantityMin = " + quantityMin + 
				", quantityMax = " + quantityMax + 
				", payAmount = " + payAmount + 
				", payAmountMin = " + payAmountMin + 
				", payAmountMax = " + payAmountMax + 
				", discountAmount = " + discountAmount + 
				", discountAmountMin = " + discountAmountMin + 
				", discountAmountMax = " + discountAmountMax + 
				", integralAmount = " + integralAmount + 
				", integralAmountMin = " + integralAmountMin + 
				", integralAmountMax = " + integralAmountMax + 
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
