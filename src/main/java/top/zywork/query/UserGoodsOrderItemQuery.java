package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserGoodsOrderItemQuery查询对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsOrderItemQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035856050901L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
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
	// 订单编号（最小值）
	private Long goodsOrderIdMin;
	// 订单编号（最大值）
	private Long goodsOrderIdMax;
	// 订单号
	private String goodsOrderOrderNo;
	// 订单金额
	private Long goodsOrderTotalAmount;
	// 订单金额（最小值）
	private Long goodsOrderTotalAmountMin;
	// 订单金额（最大值）
	private Long goodsOrderTotalAmountMax;
	// 实付金额
	private Long goodsOrderPayAmount;
	// 实付金额（最小值）
	private Long goodsOrderPayAmountMin;
	// 实付金额（最大值）
	private Long goodsOrderPayAmountMax;
	// 优惠金额
	private Long goodsOrderDiscountAmount;
	// 优惠金额（最小值）
	private Long goodsOrderDiscountAmountMin;
	// 优惠金额（最大值）
	private Long goodsOrderDiscountAmountMax;
	// 赠送积分
	private Long goodsOrderIntegralAmount;
	// 赠送积分（最小值）
	private Long goodsOrderIntegralAmountMin;
	// 赠送积分（最大值）
	private Long goodsOrderIntegralAmountMax;
	// 运费
	private Long goodsOrderExpressFee;
	// 运费（最小值）
	private Long goodsOrderExpressFeeMin;
	// 运费（最大值）
	private Long goodsOrderExpressFeeMax;
	// 订单状态
	private Byte goodsOrderOrderStatus;
	// 订单状态（最小值）
	private Byte goodsOrderOrderStatusMin;
	// 订单状态（最大值）
	private Byte goodsOrderOrderStatusMax;
	// 支付时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderPayTime;
	// 支付时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderPayTimeMin;
	// 支付时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderPayTimeMax;
	// 支付方式
	private Byte goodsOrderPayType;
	// 支付方式（最小值）
	private Byte goodsOrderPayTypeMin;
	// 支付方式（最大值）
	private Byte goodsOrderPayTypeMax;
	// 支付订单号
	private String goodsOrderTransactionNo;
	// 是否支付成功
	private Byte goodsOrderPaySuccess;
	// 是否支付成功（最小值）
	private Byte goodsOrderPaySuccessMin;
	// 是否支付成功（最大值）
	private Byte goodsOrderPaySuccessMax;
	// 发货时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderDeliverTime;
	// 发货时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderDeliverTimeMin;
	// 发货时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderDeliverTimeMax;
	// 成交时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderDealTime;
	// 成交时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderDealTimeMin;
	// 成交时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderDealTimeMax;
	//t_goods_order_item表的字段对应的属性
	// 商品编号
	private Long goodsOrderItemGoodsId;
	// 商品编号（最小值）
	private Long goodsOrderItemGoodsIdMin;
	// 商品编号（最大值）
	private Long goodsOrderItemGoodsIdMax;
	// SKU编号
	private Long goodsOrderItemGoodsSkuId;
	// SKU编号（最小值）
	private Long goodsOrderItemGoodsSkuIdMin;
	// SKU编号（最大值）
	private Long goodsOrderItemGoodsSkuIdMax;
	// 售卖标题
	private String goodsOrderItemSkuTitle;
	// SKU属性JSON
	private String goodsOrderItemSkuInfo;
	// 购买数量
	private Integer goodsOrderItemQuantity;
	// 购买数量（最小值）
	private Integer goodsOrderItemQuantityMin;
	// 购买数量（最大值）
	private Integer goodsOrderItemQuantityMax;
	// 实付金额
	private Long goodsOrderItemPayAmount;
	// 实付金额（最小值）
	private Long goodsOrderItemPayAmountMin;
	// 实付金额（最大值）
	private Long goodsOrderItemPayAmountMax;
	// 优惠金额
	private Long goodsOrderItemDiscountAmount;
	// 优惠金额（最小值）
	private Long goodsOrderItemDiscountAmountMin;
	// 优惠金额（最大值）
	private Long goodsOrderItemDiscountAmountMax;
	// 赠送积分
	private Long goodsOrderItemIntegralAmount;
	// 赠送积分（最小值）
	private Long goodsOrderItemIntegralAmountMin;
	// 赠送积分（最大值）
	private Long goodsOrderItemIntegralAmountMax;
	//t_goods_pic表的字段对应的属性
	// 商品图片编号
	private Long goodsPicId;
	// 商品图片编号（最小值）
	private Long goodsPicIdMin;
	// 商品图片编号（最大值）
	private Long goodsPicIdMax;
	// 图片URL
	private String goodsPicPicUrl;
	
    public UserGoodsOrderItemQuery () {}

    public UserGoodsOrderItemQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, String userDetailNickname, String userDetailHeadicon, Long goodsOrderId, Long goodsOrderIdMin, Long goodsOrderIdMax, String goodsOrderOrderNo, Long goodsOrderTotalAmount, Long goodsOrderTotalAmountMin, Long goodsOrderTotalAmountMax, Long goodsOrderPayAmount, Long goodsOrderPayAmountMin, Long goodsOrderPayAmountMax, Long goodsOrderDiscountAmount, Long goodsOrderDiscountAmountMin, Long goodsOrderDiscountAmountMax, Long goodsOrderIntegralAmount, Long goodsOrderIntegralAmountMin, Long goodsOrderIntegralAmountMax, Long goodsOrderExpressFee, Long goodsOrderExpressFeeMin, Long goodsOrderExpressFeeMax, Byte goodsOrderOrderStatus, Byte goodsOrderOrderStatusMin, Byte goodsOrderOrderStatusMax, Date goodsOrderPayTime, Date goodsOrderPayTimeMin, Date goodsOrderPayTimeMax, Byte goodsOrderPayType, Byte goodsOrderPayTypeMin, Byte goodsOrderPayTypeMax, String goodsOrderTransactionNo, Byte goodsOrderPaySuccess, Byte goodsOrderPaySuccessMin, Byte goodsOrderPaySuccessMax, Date goodsOrderDeliverTime, Date goodsOrderDeliverTimeMin, Date goodsOrderDeliverTimeMax, Date goodsOrderDealTime, Date goodsOrderDealTimeMin, Date goodsOrderDealTimeMax, Long goodsOrderItemGoodsId, Long goodsOrderItemGoodsIdMin, Long goodsOrderItemGoodsIdMax, Long goodsOrderItemGoodsSkuId, Long goodsOrderItemGoodsSkuIdMin, Long goodsOrderItemGoodsSkuIdMax, String goodsOrderItemSkuTitle, String goodsOrderItemSkuInfo, Integer goodsOrderItemQuantity, Integer goodsOrderItemQuantityMin, Integer goodsOrderItemQuantityMax, Long goodsOrderItemPayAmount, Long goodsOrderItemPayAmountMin, Long goodsOrderItemPayAmountMax, Long goodsOrderItemDiscountAmount, Long goodsOrderItemDiscountAmountMin, Long goodsOrderItemDiscountAmountMax, Long goodsOrderItemIntegralAmount, Long goodsOrderItemIntegralAmountMin, Long goodsOrderItemIntegralAmountMax, Long goodsPicId, Long goodsPicIdMin, Long goodsPicIdMax, String goodsPicPicUrl) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.goodsOrderId = goodsOrderId;
		this.goodsOrderIdMin = goodsOrderIdMin;
		this.goodsOrderIdMax = goodsOrderIdMax;
		this.goodsOrderOrderNo = goodsOrderOrderNo;
		this.goodsOrderTotalAmount = goodsOrderTotalAmount;
		this.goodsOrderTotalAmountMin = goodsOrderTotalAmountMin;
		this.goodsOrderTotalAmountMax = goodsOrderTotalAmountMax;
		this.goodsOrderPayAmount = goodsOrderPayAmount;
		this.goodsOrderPayAmountMin = goodsOrderPayAmountMin;
		this.goodsOrderPayAmountMax = goodsOrderPayAmountMax;
		this.goodsOrderDiscountAmount = goodsOrderDiscountAmount;
		this.goodsOrderDiscountAmountMin = goodsOrderDiscountAmountMin;
		this.goodsOrderDiscountAmountMax = goodsOrderDiscountAmountMax;
		this.goodsOrderIntegralAmount = goodsOrderIntegralAmount;
		this.goodsOrderIntegralAmountMin = goodsOrderIntegralAmountMin;
		this.goodsOrderIntegralAmountMax = goodsOrderIntegralAmountMax;
		this.goodsOrderExpressFee = goodsOrderExpressFee;
		this.goodsOrderExpressFeeMin = goodsOrderExpressFeeMin;
		this.goodsOrderExpressFeeMax = goodsOrderExpressFeeMax;
		this.goodsOrderOrderStatus = goodsOrderOrderStatus;
		this.goodsOrderOrderStatusMin = goodsOrderOrderStatusMin;
		this.goodsOrderOrderStatusMax = goodsOrderOrderStatusMax;
		this.goodsOrderPayTime = goodsOrderPayTime;
		this.goodsOrderPayTimeMin = goodsOrderPayTimeMin;
		this.goodsOrderPayTimeMax = goodsOrderPayTimeMax;
		this.goodsOrderPayType = goodsOrderPayType;
		this.goodsOrderPayTypeMin = goodsOrderPayTypeMin;
		this.goodsOrderPayTypeMax = goodsOrderPayTypeMax;
		this.goodsOrderTransactionNo = goodsOrderTransactionNo;
		this.goodsOrderPaySuccess = goodsOrderPaySuccess;
		this.goodsOrderPaySuccessMin = goodsOrderPaySuccessMin;
		this.goodsOrderPaySuccessMax = goodsOrderPaySuccessMax;
		this.goodsOrderDeliverTime = goodsOrderDeliverTime;
		this.goodsOrderDeliverTimeMin = goodsOrderDeliverTimeMin;
		this.goodsOrderDeliverTimeMax = goodsOrderDeliverTimeMax;
		this.goodsOrderDealTime = goodsOrderDealTime;
		this.goodsOrderDealTimeMin = goodsOrderDealTimeMin;
		this.goodsOrderDealTimeMax = goodsOrderDealTimeMax;
		this.goodsOrderItemGoodsId = goodsOrderItemGoodsId;
		this.goodsOrderItemGoodsIdMin = goodsOrderItemGoodsIdMin;
		this.goodsOrderItemGoodsIdMax = goodsOrderItemGoodsIdMax;
		this.goodsOrderItemGoodsSkuId = goodsOrderItemGoodsSkuId;
		this.goodsOrderItemGoodsSkuIdMin = goodsOrderItemGoodsSkuIdMin;
		this.goodsOrderItemGoodsSkuIdMax = goodsOrderItemGoodsSkuIdMax;
		this.goodsOrderItemSkuTitle = goodsOrderItemSkuTitle;
		this.goodsOrderItemSkuInfo = goodsOrderItemSkuInfo;
		this.goodsOrderItemQuantity = goodsOrderItemQuantity;
		this.goodsOrderItemQuantityMin = goodsOrderItemQuantityMin;
		this.goodsOrderItemQuantityMax = goodsOrderItemQuantityMax;
		this.goodsOrderItemPayAmount = goodsOrderItemPayAmount;
		this.goodsOrderItemPayAmountMin = goodsOrderItemPayAmountMin;
		this.goodsOrderItemPayAmountMax = goodsOrderItemPayAmountMax;
		this.goodsOrderItemDiscountAmount = goodsOrderItemDiscountAmount;
		this.goodsOrderItemDiscountAmountMin = goodsOrderItemDiscountAmountMin;
		this.goodsOrderItemDiscountAmountMax = goodsOrderItemDiscountAmountMax;
		this.goodsOrderItemIntegralAmount = goodsOrderItemIntegralAmount;
		this.goodsOrderItemIntegralAmountMin = goodsOrderItemIntegralAmountMin;
		this.goodsOrderItemIntegralAmountMax = goodsOrderItemIntegralAmountMax;
		this.goodsPicId = goodsPicId;
		this.goodsPicIdMin = goodsPicIdMin;
		this.goodsPicIdMax = goodsPicIdMax;
		this.goodsPicPicUrl = goodsPicPicUrl;
		
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

	public Long getGoodsOrderIdMin() {
		return goodsOrderIdMin;
	}

	public void setGoodsOrderIdMin(Long goodsOrderIdMin) {
		this.goodsOrderIdMin = goodsOrderIdMin;
	}

	public Long getGoodsOrderIdMax() {
		return goodsOrderIdMax;
	}

	public void setGoodsOrderIdMax(Long goodsOrderIdMax) {
		this.goodsOrderIdMax = goodsOrderIdMax;
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

	public Long getGoodsOrderTotalAmountMin() {
		return goodsOrderTotalAmountMin;
	}

	public void setGoodsOrderTotalAmountMin(Long goodsOrderTotalAmountMin) {
		this.goodsOrderTotalAmountMin = goodsOrderTotalAmountMin;
	}

	public Long getGoodsOrderTotalAmountMax() {
		return goodsOrderTotalAmountMax;
	}

	public void setGoodsOrderTotalAmountMax(Long goodsOrderTotalAmountMax) {
		this.goodsOrderTotalAmountMax = goodsOrderTotalAmountMax;
	}

	public Long getGoodsOrderPayAmount() {
		return goodsOrderPayAmount;
	}

	public void setGoodsOrderPayAmount(Long goodsOrderPayAmount) {
		this.goodsOrderPayAmount = goodsOrderPayAmount;
	}

	public Long getGoodsOrderPayAmountMin() {
		return goodsOrderPayAmountMin;
	}

	public void setGoodsOrderPayAmountMin(Long goodsOrderPayAmountMin) {
		this.goodsOrderPayAmountMin = goodsOrderPayAmountMin;
	}

	public Long getGoodsOrderPayAmountMax() {
		return goodsOrderPayAmountMax;
	}

	public void setGoodsOrderPayAmountMax(Long goodsOrderPayAmountMax) {
		this.goodsOrderPayAmountMax = goodsOrderPayAmountMax;
	}

	public Long getGoodsOrderDiscountAmount() {
		return goodsOrderDiscountAmount;
	}

	public void setGoodsOrderDiscountAmount(Long goodsOrderDiscountAmount) {
		this.goodsOrderDiscountAmount = goodsOrderDiscountAmount;
	}

	public Long getGoodsOrderDiscountAmountMin() {
		return goodsOrderDiscountAmountMin;
	}

	public void setGoodsOrderDiscountAmountMin(Long goodsOrderDiscountAmountMin) {
		this.goodsOrderDiscountAmountMin = goodsOrderDiscountAmountMin;
	}

	public Long getGoodsOrderDiscountAmountMax() {
		return goodsOrderDiscountAmountMax;
	}

	public void setGoodsOrderDiscountAmountMax(Long goodsOrderDiscountAmountMax) {
		this.goodsOrderDiscountAmountMax = goodsOrderDiscountAmountMax;
	}

	public Long getGoodsOrderIntegralAmount() {
		return goodsOrderIntegralAmount;
	}

	public void setGoodsOrderIntegralAmount(Long goodsOrderIntegralAmount) {
		this.goodsOrderIntegralAmount = goodsOrderIntegralAmount;
	}

	public Long getGoodsOrderIntegralAmountMin() {
		return goodsOrderIntegralAmountMin;
	}

	public void setGoodsOrderIntegralAmountMin(Long goodsOrderIntegralAmountMin) {
		this.goodsOrderIntegralAmountMin = goodsOrderIntegralAmountMin;
	}

	public Long getGoodsOrderIntegralAmountMax() {
		return goodsOrderIntegralAmountMax;
	}

	public void setGoodsOrderIntegralAmountMax(Long goodsOrderIntegralAmountMax) {
		this.goodsOrderIntegralAmountMax = goodsOrderIntegralAmountMax;
	}

	public Long getGoodsOrderExpressFee() {
		return goodsOrderExpressFee;
	}

	public void setGoodsOrderExpressFee(Long goodsOrderExpressFee) {
		this.goodsOrderExpressFee = goodsOrderExpressFee;
	}

	public Long getGoodsOrderExpressFeeMin() {
		return goodsOrderExpressFeeMin;
	}

	public void setGoodsOrderExpressFeeMin(Long goodsOrderExpressFeeMin) {
		this.goodsOrderExpressFeeMin = goodsOrderExpressFeeMin;
	}

	public Long getGoodsOrderExpressFeeMax() {
		return goodsOrderExpressFeeMax;
	}

	public void setGoodsOrderExpressFeeMax(Long goodsOrderExpressFeeMax) {
		this.goodsOrderExpressFeeMax = goodsOrderExpressFeeMax;
	}

	public Byte getGoodsOrderOrderStatus() {
		return goodsOrderOrderStatus;
	}

	public void setGoodsOrderOrderStatus(Byte goodsOrderOrderStatus) {
		this.goodsOrderOrderStatus = goodsOrderOrderStatus;
	}

	public Byte getGoodsOrderOrderStatusMin() {
		return goodsOrderOrderStatusMin;
	}

	public void setGoodsOrderOrderStatusMin(Byte goodsOrderOrderStatusMin) {
		this.goodsOrderOrderStatusMin = goodsOrderOrderStatusMin;
	}

	public Byte getGoodsOrderOrderStatusMax() {
		return goodsOrderOrderStatusMax;
	}

	public void setGoodsOrderOrderStatusMax(Byte goodsOrderOrderStatusMax) {
		this.goodsOrderOrderStatusMax = goodsOrderOrderStatusMax;
	}

	public Date getGoodsOrderPayTime() {
		return goodsOrderPayTime;
	}

	public void setGoodsOrderPayTime(Date goodsOrderPayTime) {
		this.goodsOrderPayTime = goodsOrderPayTime;
	}

	public Date getGoodsOrderPayTimeMin() {
		return goodsOrderPayTimeMin;
	}

	public void setGoodsOrderPayTimeMin(Date goodsOrderPayTimeMin) {
		this.goodsOrderPayTimeMin = goodsOrderPayTimeMin;
	}

	public Date getGoodsOrderPayTimeMax() {
		return goodsOrderPayTimeMax;
	}

	public void setGoodsOrderPayTimeMax(Date goodsOrderPayTimeMax) {
		this.goodsOrderPayTimeMax = goodsOrderPayTimeMax;
	}

	public Byte getGoodsOrderPayType() {
		return goodsOrderPayType;
	}

	public void setGoodsOrderPayType(Byte goodsOrderPayType) {
		this.goodsOrderPayType = goodsOrderPayType;
	}

	public Byte getGoodsOrderPayTypeMin() {
		return goodsOrderPayTypeMin;
	}

	public void setGoodsOrderPayTypeMin(Byte goodsOrderPayTypeMin) {
		this.goodsOrderPayTypeMin = goodsOrderPayTypeMin;
	}

	public Byte getGoodsOrderPayTypeMax() {
		return goodsOrderPayTypeMax;
	}

	public void setGoodsOrderPayTypeMax(Byte goodsOrderPayTypeMax) {
		this.goodsOrderPayTypeMax = goodsOrderPayTypeMax;
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

	public Byte getGoodsOrderPaySuccessMin() {
		return goodsOrderPaySuccessMin;
	}

	public void setGoodsOrderPaySuccessMin(Byte goodsOrderPaySuccessMin) {
		this.goodsOrderPaySuccessMin = goodsOrderPaySuccessMin;
	}

	public Byte getGoodsOrderPaySuccessMax() {
		return goodsOrderPaySuccessMax;
	}

	public void setGoodsOrderPaySuccessMax(Byte goodsOrderPaySuccessMax) {
		this.goodsOrderPaySuccessMax = goodsOrderPaySuccessMax;
	}

	public Date getGoodsOrderDeliverTime() {
		return goodsOrderDeliverTime;
	}

	public void setGoodsOrderDeliverTime(Date goodsOrderDeliverTime) {
		this.goodsOrderDeliverTime = goodsOrderDeliverTime;
	}

	public Date getGoodsOrderDeliverTimeMin() {
		return goodsOrderDeliverTimeMin;
	}

	public void setGoodsOrderDeliverTimeMin(Date goodsOrderDeliverTimeMin) {
		this.goodsOrderDeliverTimeMin = goodsOrderDeliverTimeMin;
	}

	public Date getGoodsOrderDeliverTimeMax() {
		return goodsOrderDeliverTimeMax;
	}

	public void setGoodsOrderDeliverTimeMax(Date goodsOrderDeliverTimeMax) {
		this.goodsOrderDeliverTimeMax = goodsOrderDeliverTimeMax;
	}

	public Date getGoodsOrderDealTime() {
		return goodsOrderDealTime;
	}

	public void setGoodsOrderDealTime(Date goodsOrderDealTime) {
		this.goodsOrderDealTime = goodsOrderDealTime;
	}

	public Date getGoodsOrderDealTimeMin() {
		return goodsOrderDealTimeMin;
	}

	public void setGoodsOrderDealTimeMin(Date goodsOrderDealTimeMin) {
		this.goodsOrderDealTimeMin = goodsOrderDealTimeMin;
	}

	public Date getGoodsOrderDealTimeMax() {
		return goodsOrderDealTimeMax;
	}

	public void setGoodsOrderDealTimeMax(Date goodsOrderDealTimeMax) {
		this.goodsOrderDealTimeMax = goodsOrderDealTimeMax;
	}

	public Long getGoodsOrderItemGoodsId() {
		return goodsOrderItemGoodsId;
	}

	public void setGoodsOrderItemGoodsId(Long goodsOrderItemGoodsId) {
		this.goodsOrderItemGoodsId = goodsOrderItemGoodsId;
	}

	public Long getGoodsOrderItemGoodsIdMin() {
		return goodsOrderItemGoodsIdMin;
	}

	public void setGoodsOrderItemGoodsIdMin(Long goodsOrderItemGoodsIdMin) {
		this.goodsOrderItemGoodsIdMin = goodsOrderItemGoodsIdMin;
	}

	public Long getGoodsOrderItemGoodsIdMax() {
		return goodsOrderItemGoodsIdMax;
	}

	public void setGoodsOrderItemGoodsIdMax(Long goodsOrderItemGoodsIdMax) {
		this.goodsOrderItemGoodsIdMax = goodsOrderItemGoodsIdMax;
	}

	public Long getGoodsOrderItemGoodsSkuId() {
		return goodsOrderItemGoodsSkuId;
	}

	public void setGoodsOrderItemGoodsSkuId(Long goodsOrderItemGoodsSkuId) {
		this.goodsOrderItemGoodsSkuId = goodsOrderItemGoodsSkuId;
	}

	public Long getGoodsOrderItemGoodsSkuIdMin() {
		return goodsOrderItemGoodsSkuIdMin;
	}

	public void setGoodsOrderItemGoodsSkuIdMin(Long goodsOrderItemGoodsSkuIdMin) {
		this.goodsOrderItemGoodsSkuIdMin = goodsOrderItemGoodsSkuIdMin;
	}

	public Long getGoodsOrderItemGoodsSkuIdMax() {
		return goodsOrderItemGoodsSkuIdMax;
	}

	public void setGoodsOrderItemGoodsSkuIdMax(Long goodsOrderItemGoodsSkuIdMax) {
		this.goodsOrderItemGoodsSkuIdMax = goodsOrderItemGoodsSkuIdMax;
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

	public Integer getGoodsOrderItemQuantityMin() {
		return goodsOrderItemQuantityMin;
	}

	public void setGoodsOrderItemQuantityMin(Integer goodsOrderItemQuantityMin) {
		this.goodsOrderItemQuantityMin = goodsOrderItemQuantityMin;
	}

	public Integer getGoodsOrderItemQuantityMax() {
		return goodsOrderItemQuantityMax;
	}

	public void setGoodsOrderItemQuantityMax(Integer goodsOrderItemQuantityMax) {
		this.goodsOrderItemQuantityMax = goodsOrderItemQuantityMax;
	}

	public Long getGoodsOrderItemPayAmount() {
		return goodsOrderItemPayAmount;
	}

	public void setGoodsOrderItemPayAmount(Long goodsOrderItemPayAmount) {
		this.goodsOrderItemPayAmount = goodsOrderItemPayAmount;
	}

	public Long getGoodsOrderItemPayAmountMin() {
		return goodsOrderItemPayAmountMin;
	}

	public void setGoodsOrderItemPayAmountMin(Long goodsOrderItemPayAmountMin) {
		this.goodsOrderItemPayAmountMin = goodsOrderItemPayAmountMin;
	}

	public Long getGoodsOrderItemPayAmountMax() {
		return goodsOrderItemPayAmountMax;
	}

	public void setGoodsOrderItemPayAmountMax(Long goodsOrderItemPayAmountMax) {
		this.goodsOrderItemPayAmountMax = goodsOrderItemPayAmountMax;
	}

	public Long getGoodsOrderItemDiscountAmount() {
		return goodsOrderItemDiscountAmount;
	}

	public void setGoodsOrderItemDiscountAmount(Long goodsOrderItemDiscountAmount) {
		this.goodsOrderItemDiscountAmount = goodsOrderItemDiscountAmount;
	}

	public Long getGoodsOrderItemDiscountAmountMin() {
		return goodsOrderItemDiscountAmountMin;
	}

	public void setGoodsOrderItemDiscountAmountMin(Long goodsOrderItemDiscountAmountMin) {
		this.goodsOrderItemDiscountAmountMin = goodsOrderItemDiscountAmountMin;
	}

	public Long getGoodsOrderItemDiscountAmountMax() {
		return goodsOrderItemDiscountAmountMax;
	}

	public void setGoodsOrderItemDiscountAmountMax(Long goodsOrderItemDiscountAmountMax) {
		this.goodsOrderItemDiscountAmountMax = goodsOrderItemDiscountAmountMax;
	}

	public Long getGoodsOrderItemIntegralAmount() {
		return goodsOrderItemIntegralAmount;
	}

	public void setGoodsOrderItemIntegralAmount(Long goodsOrderItemIntegralAmount) {
		this.goodsOrderItemIntegralAmount = goodsOrderItemIntegralAmount;
	}

	public Long getGoodsOrderItemIntegralAmountMin() {
		return goodsOrderItemIntegralAmountMin;
	}

	public void setGoodsOrderItemIntegralAmountMin(Long goodsOrderItemIntegralAmountMin) {
		this.goodsOrderItemIntegralAmountMin = goodsOrderItemIntegralAmountMin;
	}

	public Long getGoodsOrderItemIntegralAmountMax() {
		return goodsOrderItemIntegralAmountMax;
	}

	public void setGoodsOrderItemIntegralAmountMax(Long goodsOrderItemIntegralAmountMax) {
		this.goodsOrderItemIntegralAmountMax = goodsOrderItemIntegralAmountMax;
	}

	public Long getGoodsPicId() {
		return goodsPicId;
	}

	public void setGoodsPicId(Long goodsPicId) {
		this.goodsPicId = goodsPicId;
	}

	public Long getGoodsPicIdMin() {
		return goodsPicIdMin;
	}

	public void setGoodsPicIdMin(Long goodsPicIdMin) {
		this.goodsPicIdMin = goodsPicIdMin;
	}

	public Long getGoodsPicIdMax() {
		return goodsPicIdMax;
	}

	public void setGoodsPicIdMax(Long goodsPicIdMax) {
		this.goodsPicIdMax = goodsPicIdMax;
	}

	public String getGoodsPicPicUrl() {
		return goodsPicPicUrl;
	}

	public void setGoodsPicPicUrl(String goodsPicPicUrl) {
		this.goodsPicPicUrl = goodsPicPicUrl;
	}

	
    @Override
    public String toString() {
        return "UserGoodsOrderItemQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", goodsOrderId = " + goodsOrderId + 
				", goodsOrderIdMin = " + goodsOrderIdMin + 
				", goodsOrderIdMax = " + goodsOrderIdMax + 
				", goodsOrderOrderNo = " + goodsOrderOrderNo + 
				", goodsOrderTotalAmount = " + goodsOrderTotalAmount + 
				", goodsOrderTotalAmountMin = " + goodsOrderTotalAmountMin + 
				", goodsOrderTotalAmountMax = " + goodsOrderTotalAmountMax + 
				", goodsOrderPayAmount = " + goodsOrderPayAmount + 
				", goodsOrderPayAmountMin = " + goodsOrderPayAmountMin + 
				", goodsOrderPayAmountMax = " + goodsOrderPayAmountMax + 
				", goodsOrderDiscountAmount = " + goodsOrderDiscountAmount + 
				", goodsOrderDiscountAmountMin = " + goodsOrderDiscountAmountMin + 
				", goodsOrderDiscountAmountMax = " + goodsOrderDiscountAmountMax + 
				", goodsOrderIntegralAmount = " + goodsOrderIntegralAmount + 
				", goodsOrderIntegralAmountMin = " + goodsOrderIntegralAmountMin + 
				", goodsOrderIntegralAmountMax = " + goodsOrderIntegralAmountMax + 
				", goodsOrderExpressFee = " + goodsOrderExpressFee + 
				", goodsOrderExpressFeeMin = " + goodsOrderExpressFeeMin + 
				", goodsOrderExpressFeeMax = " + goodsOrderExpressFeeMax + 
				", goodsOrderOrderStatus = " + goodsOrderOrderStatus + 
				", goodsOrderOrderStatusMin = " + goodsOrderOrderStatusMin + 
				", goodsOrderOrderStatusMax = " + goodsOrderOrderStatusMax + 
				", goodsOrderPayTime = " + goodsOrderPayTime + 
				", goodsOrderPayTimeMin = " + goodsOrderPayTimeMin + 
				", goodsOrderPayTimeMax = " + goodsOrderPayTimeMax + 
				", goodsOrderPayType = " + goodsOrderPayType + 
				", goodsOrderPayTypeMin = " + goodsOrderPayTypeMin + 
				", goodsOrderPayTypeMax = " + goodsOrderPayTypeMax + 
				", goodsOrderTransactionNo = " + goodsOrderTransactionNo + 
				", goodsOrderPaySuccess = " + goodsOrderPaySuccess + 
				", goodsOrderPaySuccessMin = " + goodsOrderPaySuccessMin + 
				", goodsOrderPaySuccessMax = " + goodsOrderPaySuccessMax + 
				", goodsOrderDeliverTime = " + goodsOrderDeliverTime + 
				", goodsOrderDeliverTimeMin = " + goodsOrderDeliverTimeMin + 
				", goodsOrderDeliverTimeMax = " + goodsOrderDeliverTimeMax + 
				", goodsOrderDealTime = " + goodsOrderDealTime + 
				", goodsOrderDealTimeMin = " + goodsOrderDealTimeMin + 
				", goodsOrderDealTimeMax = " + goodsOrderDealTimeMax + 
				", goodsOrderItemGoodsId = " + goodsOrderItemGoodsId + 
				", goodsOrderItemGoodsIdMin = " + goodsOrderItemGoodsIdMin + 
				", goodsOrderItemGoodsIdMax = " + goodsOrderItemGoodsIdMax + 
				", goodsOrderItemGoodsSkuId = " + goodsOrderItemGoodsSkuId + 
				", goodsOrderItemGoodsSkuIdMin = " + goodsOrderItemGoodsSkuIdMin + 
				", goodsOrderItemGoodsSkuIdMax = " + goodsOrderItemGoodsSkuIdMax + 
				", goodsOrderItemSkuTitle = " + goodsOrderItemSkuTitle + 
				", goodsOrderItemSkuInfo = " + goodsOrderItemSkuInfo + 
				", goodsOrderItemQuantity = " + goodsOrderItemQuantity + 
				", goodsOrderItemQuantityMin = " + goodsOrderItemQuantityMin + 
				", goodsOrderItemQuantityMax = " + goodsOrderItemQuantityMax + 
				", goodsOrderItemPayAmount = " + goodsOrderItemPayAmount + 
				", goodsOrderItemPayAmountMin = " + goodsOrderItemPayAmountMin + 
				", goodsOrderItemPayAmountMax = " + goodsOrderItemPayAmountMax + 
				", goodsOrderItemDiscountAmount = " + goodsOrderItemDiscountAmount + 
				", goodsOrderItemDiscountAmountMin = " + goodsOrderItemDiscountAmountMin + 
				", goodsOrderItemDiscountAmountMax = " + goodsOrderItemDiscountAmountMax + 
				", goodsOrderItemIntegralAmount = " + goodsOrderItemIntegralAmount + 
				", goodsOrderItemIntegralAmountMin = " + goodsOrderItemIntegralAmountMin + 
				", goodsOrderItemIntegralAmountMax = " + goodsOrderItemIntegralAmountMax + 
				", goodsPicId = " + goodsPicId + 
				", goodsPicIdMin = " + goodsPicIdMin + 
				", goodsPicIdMax = " + goodsPicIdMax + 
				", goodsPicPicUrl = " + goodsPicPicUrl + 
				" }";
    }

}
