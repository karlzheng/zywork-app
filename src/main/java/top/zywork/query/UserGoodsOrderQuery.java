package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserGoodsOrderQuery查询对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsOrderQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036096048535L;

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
	// 版本号
	private Integer goodsOrderVersion;
	// 版本号（最小值）
	private Integer goodsOrderVersionMin;
	// 版本号（最大值）
	private Integer goodsOrderVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderUpdateTimeMax;
	
    public UserGoodsOrderQuery () {}

    public UserGoodsOrderQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, String userDetailNickname, String userDetailHeadicon, Long goodsOrderId, Long goodsOrderIdMin, Long goodsOrderIdMax, String goodsOrderOrderNo, Long goodsOrderTotalAmount, Long goodsOrderTotalAmountMin, Long goodsOrderTotalAmountMax, Long goodsOrderPayAmount, Long goodsOrderPayAmountMin, Long goodsOrderPayAmountMax, Long goodsOrderDiscountAmount, Long goodsOrderDiscountAmountMin, Long goodsOrderDiscountAmountMax, Long goodsOrderIntegralAmount, Long goodsOrderIntegralAmountMin, Long goodsOrderIntegralAmountMax, Long goodsOrderExpressFee, Long goodsOrderExpressFeeMin, Long goodsOrderExpressFeeMax, Byte goodsOrderOrderStatus, Byte goodsOrderOrderStatusMin, Byte goodsOrderOrderStatusMax, Date goodsOrderPayTime, Date goodsOrderPayTimeMin, Date goodsOrderPayTimeMax, Byte goodsOrderPayType, Byte goodsOrderPayTypeMin, Byte goodsOrderPayTypeMax, String goodsOrderTransactionNo, Byte goodsOrderPaySuccess, Byte goodsOrderPaySuccessMin, Byte goodsOrderPaySuccessMax, Date goodsOrderDeliverTime, Date goodsOrderDeliverTimeMin, Date goodsOrderDeliverTimeMax, Date goodsOrderDealTime, Date goodsOrderDealTimeMin, Date goodsOrderDealTimeMax, Integer goodsOrderVersion, Integer goodsOrderVersionMin, Integer goodsOrderVersionMax, Date goodsOrderCreateTime, Date goodsOrderCreateTimeMin, Date goodsOrderCreateTimeMax, Date goodsOrderUpdateTime, Date goodsOrderUpdateTimeMin, Date goodsOrderUpdateTimeMax) {
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
		this.goodsOrderVersion = goodsOrderVersion;
		this.goodsOrderVersionMin = goodsOrderVersionMin;
		this.goodsOrderVersionMax = goodsOrderVersionMax;
		this.goodsOrderCreateTime = goodsOrderCreateTime;
		this.goodsOrderCreateTimeMin = goodsOrderCreateTimeMin;
		this.goodsOrderCreateTimeMax = goodsOrderCreateTimeMax;
		this.goodsOrderUpdateTime = goodsOrderUpdateTime;
		this.goodsOrderUpdateTimeMin = goodsOrderUpdateTimeMin;
		this.goodsOrderUpdateTimeMax = goodsOrderUpdateTimeMax;
		
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

	public Integer getGoodsOrderVersion() {
		return goodsOrderVersion;
	}

	public void setGoodsOrderVersion(Integer goodsOrderVersion) {
		this.goodsOrderVersion = goodsOrderVersion;
	}

	public Integer getGoodsOrderVersionMin() {
		return goodsOrderVersionMin;
	}

	public void setGoodsOrderVersionMin(Integer goodsOrderVersionMin) {
		this.goodsOrderVersionMin = goodsOrderVersionMin;
	}

	public Integer getGoodsOrderVersionMax() {
		return goodsOrderVersionMax;
	}

	public void setGoodsOrderVersionMax(Integer goodsOrderVersionMax) {
		this.goodsOrderVersionMax = goodsOrderVersionMax;
	}

	public Date getGoodsOrderCreateTime() {
		return goodsOrderCreateTime;
	}

	public void setGoodsOrderCreateTime(Date goodsOrderCreateTime) {
		this.goodsOrderCreateTime = goodsOrderCreateTime;
	}

	public Date getGoodsOrderCreateTimeMin() {
		return goodsOrderCreateTimeMin;
	}

	public void setGoodsOrderCreateTimeMin(Date goodsOrderCreateTimeMin) {
		this.goodsOrderCreateTimeMin = goodsOrderCreateTimeMin;
	}

	public Date getGoodsOrderCreateTimeMax() {
		return goodsOrderCreateTimeMax;
	}

	public void setGoodsOrderCreateTimeMax(Date goodsOrderCreateTimeMax) {
		this.goodsOrderCreateTimeMax = goodsOrderCreateTimeMax;
	}

	public Date getGoodsOrderUpdateTime() {
		return goodsOrderUpdateTime;
	}

	public void setGoodsOrderUpdateTime(Date goodsOrderUpdateTime) {
		this.goodsOrderUpdateTime = goodsOrderUpdateTime;
	}

	public Date getGoodsOrderUpdateTimeMin() {
		return goodsOrderUpdateTimeMin;
	}

	public void setGoodsOrderUpdateTimeMin(Date goodsOrderUpdateTimeMin) {
		this.goodsOrderUpdateTimeMin = goodsOrderUpdateTimeMin;
	}

	public Date getGoodsOrderUpdateTimeMax() {
		return goodsOrderUpdateTimeMax;
	}

	public void setGoodsOrderUpdateTimeMax(Date goodsOrderUpdateTimeMax) {
		this.goodsOrderUpdateTimeMax = goodsOrderUpdateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserGoodsOrderQuery {" +
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
				", goodsOrderVersion = " + goodsOrderVersion + 
				", goodsOrderVersionMin = " + goodsOrderVersionMin + 
				", goodsOrderVersionMax = " + goodsOrderVersionMax + 
				", goodsOrderCreateTime = " + goodsOrderCreateTime + 
				", goodsOrderCreateTimeMin = " + goodsOrderCreateTimeMin + 
				", goodsOrderCreateTimeMax = " + goodsOrderCreateTimeMax + 
				", goodsOrderUpdateTime = " + goodsOrderUpdateTime + 
				", goodsOrderUpdateTimeMin = " + goodsOrderUpdateTimeMin + 
				", goodsOrderUpdateTimeMax = " + goodsOrderUpdateTimeMax + 
				" }";
    }

}
