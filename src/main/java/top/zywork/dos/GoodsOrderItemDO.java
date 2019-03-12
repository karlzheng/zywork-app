package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsOrderItemDO数据对象实体类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsOrderItemDO extends BaseDO {

    private static final long serialVersionUID = -9223372036836582256L;

    // 订单项编号
	private Long id;
	// 订单编号
	private Long orderId;
	// 商品编号
	private Long goodsId;
	// SKU编号
	private Long goodsSkuId;
	// SKU图片编号
	private Long skuPicId;
	// 售卖标题
	private String skuTitle;
	// SKU属性JSON
	private String skuInfo;
	// 购买数量
	private Integer quantity;
	// 实付金额
	private Long payAmount;
	// 优惠金额
	private Long discountAmount;
	// 赠送积分
	private Long integralAmount;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsOrderItemDO () {}

    public GoodsOrderItemDO (Long id, Long orderId, Long goodsId, Long goodsSkuId, Long skuPicId, String skuTitle, String skuInfo, Integer quantity, Long payAmount, Long discountAmount, Long integralAmount, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsSkuId = goodsSkuId;
		this.skuPicId = skuPicId;
		this.skuTitle = skuTitle;
		this.skuInfo = skuInfo;
		this.quantity = quantity;
		this.payAmount = payAmount;
		this.discountAmount = discountAmount;
		this.integralAmount = integralAmount;
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Long getSkuPicId() {
		return skuPicId;
	}

	public void setSkuPicId(Long skuPicId) {
		this.skuPicId = skuPicId;
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

	public Long getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}

	public Long getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Long discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Long getIntegralAmount() {
		return integralAmount;
	}

	public void setIntegralAmount(Long integralAmount) {
		this.integralAmount = integralAmount;
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
        return "GoodsOrderItemDO {" +
                "id = " + id + 
				", orderId = " + orderId + 
				", goodsId = " + goodsId + 
				", goodsSkuId = " + goodsSkuId + 
				", skuPicId = " + skuPicId + 
				", skuTitle = " + skuTitle + 
				", skuInfo = " + skuInfo + 
				", quantity = " + quantity + 
				", payAmount = " + payAmount + 
				", discountAmount = " + discountAmount + 
				", integralAmount = " + integralAmount + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
