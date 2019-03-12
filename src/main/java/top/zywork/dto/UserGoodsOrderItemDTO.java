package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserGoodsOrderItemDTO数据传输对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsOrderItemDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036042229192L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	//t_goods_order表的字段对应的属性
	// 订单编号
	private Long goodsOrderId;
	// 订单号
	private String goodsOrderOrderNo;
	// 订单金额
	private Long goodsOrderTotalAmount;
	// 实付金额
	private Long goodsOrderPayAmount;
	// 优惠金额
	private Long goodsOrderDiscountAmount;
	// 赠送积分
	private Long goodsOrderIntegralAmount;
	// 运费
	private Long goodsOrderExpressFee;
	// 订单状态
	private Byte goodsOrderOrderStatus;
	// 支付时间
	private Date goodsOrderPayTime;
	// 支付方式
	private Byte goodsOrderPayType;
	// 支付订单号
	private String goodsOrderTransactionNo;
	// 是否支付成功
	private Byte goodsOrderPaySuccess;
	// 发货时间
	private Date goodsOrderDeliverTime;
	// 成交时间
	private Date goodsOrderDealTime;
	//t_goods_order_item表的字段对应的属性
	// 商品编号
	private Long goodsOrderItemGoodsId;
	// SKU编号
	private Long goodsOrderItemGoodsSkuId;
	// 售卖标题
	private String goodsOrderItemSkuTitle;
	// SKU属性JSON
	private String goodsOrderItemSkuInfo;
	// 购买数量
	private Integer goodsOrderItemQuantity;
	// 实付金额
	private Long goodsOrderItemPayAmount;
	// 优惠金额
	private Long goodsOrderItemDiscountAmount;
	// 赠送积分
	private Long goodsOrderItemIntegralAmount;
	//t_goods_pic表的字段对应的属性
	// 商品图片编号
	private Long goodsPicId;
	// 图片URL
	private String goodsPicPicUrl;
	
    public UserGoodsOrderItemDTO () {}

    public UserGoodsOrderItemDTO (Long userId, String userPhone, String userEmail, String userDetailNickname, String userDetailHeadicon, Long goodsOrderId, String goodsOrderOrderNo, Long goodsOrderTotalAmount, Long goodsOrderPayAmount, Long goodsOrderDiscountAmount, Long goodsOrderIntegralAmount, Long goodsOrderExpressFee, Byte goodsOrderOrderStatus, Date goodsOrderPayTime, Byte goodsOrderPayType, String goodsOrderTransactionNo, Byte goodsOrderPaySuccess, Date goodsOrderDeliverTime, Date goodsOrderDealTime, Long goodsOrderItemGoodsId, Long goodsOrderItemGoodsSkuId, String goodsOrderItemSkuTitle, String goodsOrderItemSkuInfo, Integer goodsOrderItemQuantity, Long goodsOrderItemPayAmount, Long goodsOrderItemDiscountAmount, Long goodsOrderItemIntegralAmount, Long goodsPicId, String goodsPicPicUrl) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.goodsOrderId = goodsOrderId;
		this.goodsOrderOrderNo = goodsOrderOrderNo;
		this.goodsOrderTotalAmount = goodsOrderTotalAmount;
		this.goodsOrderPayAmount = goodsOrderPayAmount;
		this.goodsOrderDiscountAmount = goodsOrderDiscountAmount;
		this.goodsOrderIntegralAmount = goodsOrderIntegralAmount;
		this.goodsOrderExpressFee = goodsOrderExpressFee;
		this.goodsOrderOrderStatus = goodsOrderOrderStatus;
		this.goodsOrderPayTime = goodsOrderPayTime;
		this.goodsOrderPayType = goodsOrderPayType;
		this.goodsOrderTransactionNo = goodsOrderTransactionNo;
		this.goodsOrderPaySuccess = goodsOrderPaySuccess;
		this.goodsOrderDeliverTime = goodsOrderDeliverTime;
		this.goodsOrderDealTime = goodsOrderDealTime;
		this.goodsOrderItemGoodsId = goodsOrderItemGoodsId;
		this.goodsOrderItemGoodsSkuId = goodsOrderItemGoodsSkuId;
		this.goodsOrderItemSkuTitle = goodsOrderItemSkuTitle;
		this.goodsOrderItemSkuInfo = goodsOrderItemSkuInfo;
		this.goodsOrderItemQuantity = goodsOrderItemQuantity;
		this.goodsOrderItemPayAmount = goodsOrderItemPayAmount;
		this.goodsOrderItemDiscountAmount = goodsOrderItemDiscountAmount;
		this.goodsOrderItemIntegralAmount = goodsOrderItemIntegralAmount;
		this.goodsPicId = goodsPicId;
		this.goodsPicPicUrl = goodsPicPicUrl;
		
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDetailNickname() {
		return userDetailNickname;
	}

	public void setUserDetailNickname(String userDetailNickname) {
		this.userDetailNickname = userDetailNickname;
	}

	public String getUserDetailHeadicon() {
		return userDetailHeadicon;
	}

	public void setUserDetailHeadicon(String userDetailHeadicon) {
		this.userDetailHeadicon = userDetailHeadicon;
	}

	public Long getGoodsOrderId() {
		return goodsOrderId;
	}

	public void setGoodsOrderId(Long goodsOrderId) {
		this.goodsOrderId = goodsOrderId;
	}

	public String getGoodsOrderOrderNo() {
		return goodsOrderOrderNo;
	}

	public void setGoodsOrderOrderNo(String goodsOrderOrderNo) {
		this.goodsOrderOrderNo = goodsOrderOrderNo;
	}

	public Long getGoodsOrderTotalAmount() {
		return goodsOrderTotalAmount;
	}

	public void setGoodsOrderTotalAmount(Long goodsOrderTotalAmount) {
		this.goodsOrderTotalAmount = goodsOrderTotalAmount;
	}

	public Long getGoodsOrderPayAmount() {
		return goodsOrderPayAmount;
	}

	public void setGoodsOrderPayAmount(Long goodsOrderPayAmount) {
		this.goodsOrderPayAmount = goodsOrderPayAmount;
	}

	public Long getGoodsOrderDiscountAmount() {
		return goodsOrderDiscountAmount;
	}

	public void setGoodsOrderDiscountAmount(Long goodsOrderDiscountAmount) {
		this.goodsOrderDiscountAmount = goodsOrderDiscountAmount;
	}

	public Long getGoodsOrderIntegralAmount() {
		return goodsOrderIntegralAmount;
	}

	public void setGoodsOrderIntegralAmount(Long goodsOrderIntegralAmount) {
		this.goodsOrderIntegralAmount = goodsOrderIntegralAmount;
	}

	public Long getGoodsOrderExpressFee() {
		return goodsOrderExpressFee;
	}

	public void setGoodsOrderExpressFee(Long goodsOrderExpressFee) {
		this.goodsOrderExpressFee = goodsOrderExpressFee;
	}

	public Byte getGoodsOrderOrderStatus() {
		return goodsOrderOrderStatus;
	}

	public void setGoodsOrderOrderStatus(Byte goodsOrderOrderStatus) {
		this.goodsOrderOrderStatus = goodsOrderOrderStatus;
	}

	public Date getGoodsOrderPayTime() {
		return goodsOrderPayTime;
	}

	public void setGoodsOrderPayTime(Date goodsOrderPayTime) {
		this.goodsOrderPayTime = goodsOrderPayTime;
	}

	public Byte getGoodsOrderPayType() {
		return goodsOrderPayType;
	}

	public void setGoodsOrderPayType(Byte goodsOrderPayType) {
		this.goodsOrderPayType = goodsOrderPayType;
	}

	public String getGoodsOrderTransactionNo() {
		return goodsOrderTransactionNo;
	}

	public void setGoodsOrderTransactionNo(String goodsOrderTransactionNo) {
		this.goodsOrderTransactionNo = goodsOrderTransactionNo;
	}

	public Byte getGoodsOrderPaySuccess() {
		return goodsOrderPaySuccess;
	}

	public void setGoodsOrderPaySuccess(Byte goodsOrderPaySuccess) {
		this.goodsOrderPaySuccess = goodsOrderPaySuccess;
	}

	public Date getGoodsOrderDeliverTime() {
		return goodsOrderDeliverTime;
	}

	public void setGoodsOrderDeliverTime(Date goodsOrderDeliverTime) {
		this.goodsOrderDeliverTime = goodsOrderDeliverTime;
	}

	public Date getGoodsOrderDealTime() {
		return goodsOrderDealTime;
	}

	public void setGoodsOrderDealTime(Date goodsOrderDealTime) {
		this.goodsOrderDealTime = goodsOrderDealTime;
	}

	public Long getGoodsOrderItemGoodsId() {
		return goodsOrderItemGoodsId;
	}

	public void setGoodsOrderItemGoodsId(Long goodsOrderItemGoodsId) {
		this.goodsOrderItemGoodsId = goodsOrderItemGoodsId;
	}

	public Long getGoodsOrderItemGoodsSkuId() {
		return goodsOrderItemGoodsSkuId;
	}

	public void setGoodsOrderItemGoodsSkuId(Long goodsOrderItemGoodsSkuId) {
		this.goodsOrderItemGoodsSkuId = goodsOrderItemGoodsSkuId;
	}

	public String getGoodsOrderItemSkuTitle() {
		return goodsOrderItemSkuTitle;
	}

	public void setGoodsOrderItemSkuTitle(String goodsOrderItemSkuTitle) {
		this.goodsOrderItemSkuTitle = goodsOrderItemSkuTitle;
	}

	public String getGoodsOrderItemSkuInfo() {
		return goodsOrderItemSkuInfo;
	}

	public void setGoodsOrderItemSkuInfo(String goodsOrderItemSkuInfo) {
		this.goodsOrderItemSkuInfo = goodsOrderItemSkuInfo;
	}

	public Integer getGoodsOrderItemQuantity() {
		return goodsOrderItemQuantity;
	}

	public void setGoodsOrderItemQuantity(Integer goodsOrderItemQuantity) {
		this.goodsOrderItemQuantity = goodsOrderItemQuantity;
	}

	public Long getGoodsOrderItemPayAmount() {
		return goodsOrderItemPayAmount;
	}

	public void setGoodsOrderItemPayAmount(Long goodsOrderItemPayAmount) {
		this.goodsOrderItemPayAmount = goodsOrderItemPayAmount;
	}

	public Long getGoodsOrderItemDiscountAmount() {
		return goodsOrderItemDiscountAmount;
	}

	public void setGoodsOrderItemDiscountAmount(Long goodsOrderItemDiscountAmount) {
		this.goodsOrderItemDiscountAmount = goodsOrderItemDiscountAmount;
	}

	public Long getGoodsOrderItemIntegralAmount() {
		return goodsOrderItemIntegralAmount;
	}

	public void setGoodsOrderItemIntegralAmount(Long goodsOrderItemIntegralAmount) {
		this.goodsOrderItemIntegralAmount = goodsOrderItemIntegralAmount;
	}

	public Long getGoodsPicId() {
		return goodsPicId;
	}

	public void setGoodsPicId(Long goodsPicId) {
		this.goodsPicId = goodsPicId;
	}

	public String getGoodsPicPicUrl() {
		return goodsPicPicUrl;
	}

	public void setGoodsPicPicUrl(String goodsPicPicUrl) {
		this.goodsPicPicUrl = goodsPicPicUrl;
	}

	
    @Override
    public String toString() {
        return "UserGoodsOrderItemDTO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", goodsOrderId = " + goodsOrderId + 
				", goodsOrderOrderNo = " + goodsOrderOrderNo + 
				", goodsOrderTotalAmount = " + goodsOrderTotalAmount + 
				", goodsOrderPayAmount = " + goodsOrderPayAmount + 
				", goodsOrderDiscountAmount = " + goodsOrderDiscountAmount + 
				", goodsOrderIntegralAmount = " + goodsOrderIntegralAmount + 
				", goodsOrderExpressFee = " + goodsOrderExpressFee + 
				", goodsOrderOrderStatus = " + goodsOrderOrderStatus + 
				", goodsOrderPayTime = " + goodsOrderPayTime + 
				", goodsOrderPayType = " + goodsOrderPayType + 
				", goodsOrderTransactionNo = " + goodsOrderTransactionNo + 
				", goodsOrderPaySuccess = " + goodsOrderPaySuccess + 
				", goodsOrderDeliverTime = " + goodsOrderDeliverTime + 
				", goodsOrderDealTime = " + goodsOrderDealTime + 
				", goodsOrderItemGoodsId = " + goodsOrderItemGoodsId + 
				", goodsOrderItemGoodsSkuId = " + goodsOrderItemGoodsSkuId + 
				", goodsOrderItemSkuTitle = " + goodsOrderItemSkuTitle + 
				", goodsOrderItemSkuInfo = " + goodsOrderItemSkuInfo + 
				", goodsOrderItemQuantity = " + goodsOrderItemQuantity + 
				", goodsOrderItemPayAmount = " + goodsOrderItemPayAmount + 
				", goodsOrderItemDiscountAmount = " + goodsOrderItemDiscountAmount + 
				", goodsOrderItemIntegralAmount = " + goodsOrderItemIntegralAmount + 
				", goodsPicId = " + goodsPicId + 
				", goodsPicPicUrl = " + goodsPicPicUrl + 
				" }";
    }

}
