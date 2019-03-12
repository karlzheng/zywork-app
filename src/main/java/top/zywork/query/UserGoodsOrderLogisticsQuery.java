package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserGoodsOrderLogisticsQuery查询对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsOrderLogisticsQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035874447181L;

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
	//t_goods_order_logistics表的字段对应的属性
	// 收货人
	private String goodsOrderLogisticsRealName;
	// 手机号
	private String goodsOrderLogisticsPhone;
	// 省
	private String goodsOrderLogisticsProvince;
	// 市
	private String goodsOrderLogisticsCity;
	// 区/县
	private String goodsOrderLogisticsDistrict;
	// 详细地址
	private String goodsOrderLogisticsAddress;
	// 是否已发货
	private Byte goodsOrderLogisticsIsDeliver;
	// 是否已发货（最小值）
	private Byte goodsOrderLogisticsIsDeliverMin;
	// 是否已发货（最大值）
	private Byte goodsOrderLogisticsIsDeliverMax;
	// 物流公司名称
	private String goodsOrderLogisticsLogisticsCompany;
	// 物流公司编码
	private String goodsOrderLogisticsLogisticsCode;
	// 物流单号
	private String goodsOrderLogisticsLogisticsNo;
	// 版本号
	private Integer goodsOrderLogisticsVersion;
	// 版本号（最小值）
	private Integer goodsOrderLogisticsVersionMin;
	// 版本号（最大值）
	private Integer goodsOrderLogisticsVersionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderLogisticsCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderLogisticsCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderLogisticsCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderLogisticsUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderLogisticsUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsOrderLogisticsUpdateTimeMax;
	
    public UserGoodsOrderLogisticsQuery () {}

    public UserGoodsOrderLogisticsQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, String userDetailNickname, String userDetailHeadicon, Long goodsOrderId, Long goodsOrderIdMin, Long goodsOrderIdMax, String goodsOrderOrderNo, Long goodsOrderTotalAmount, Long goodsOrderTotalAmountMin, Long goodsOrderTotalAmountMax, Long goodsOrderPayAmount, Long goodsOrderPayAmountMin, Long goodsOrderPayAmountMax, Long goodsOrderDiscountAmount, Long goodsOrderDiscountAmountMin, Long goodsOrderDiscountAmountMax, Long goodsOrderIntegralAmount, Long goodsOrderIntegralAmountMin, Long goodsOrderIntegralAmountMax, Long goodsOrderExpressFee, Long goodsOrderExpressFeeMin, Long goodsOrderExpressFeeMax, Byte goodsOrderOrderStatus, Byte goodsOrderOrderStatusMin, Byte goodsOrderOrderStatusMax, Date goodsOrderPayTime, Date goodsOrderPayTimeMin, Date goodsOrderPayTimeMax, Byte goodsOrderPayType, Byte goodsOrderPayTypeMin, Byte goodsOrderPayTypeMax, String goodsOrderTransactionNo, Byte goodsOrderPaySuccess, Byte goodsOrderPaySuccessMin, Byte goodsOrderPaySuccessMax, Date goodsOrderDeliverTime, Date goodsOrderDeliverTimeMin, Date goodsOrderDeliverTimeMax, Date goodsOrderDealTime, Date goodsOrderDealTimeMin, Date goodsOrderDealTimeMax, String goodsOrderLogisticsRealName, String goodsOrderLogisticsPhone, String goodsOrderLogisticsProvince, String goodsOrderLogisticsCity, String goodsOrderLogisticsDistrict, String goodsOrderLogisticsAddress, Byte goodsOrderLogisticsIsDeliver, Byte goodsOrderLogisticsIsDeliverMin, Byte goodsOrderLogisticsIsDeliverMax, String goodsOrderLogisticsLogisticsCompany, String goodsOrderLogisticsLogisticsCode, String goodsOrderLogisticsLogisticsNo, Integer goodsOrderLogisticsVersion, Integer goodsOrderLogisticsVersionMin, Integer goodsOrderLogisticsVersionMax, Date goodsOrderLogisticsCreateTime, Date goodsOrderLogisticsCreateTimeMin, Date goodsOrderLogisticsCreateTimeMax, Date goodsOrderLogisticsUpdateTime, Date goodsOrderLogisticsUpdateTimeMin, Date goodsOrderLogisticsUpdateTimeMax) {
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
		this.goodsOrderLogisticsRealName = goodsOrderLogisticsRealName;
		this.goodsOrderLogisticsPhone = goodsOrderLogisticsPhone;
		this.goodsOrderLogisticsProvince = goodsOrderLogisticsProvince;
		this.goodsOrderLogisticsCity = goodsOrderLogisticsCity;
		this.goodsOrderLogisticsDistrict = goodsOrderLogisticsDistrict;
		this.goodsOrderLogisticsAddress = goodsOrderLogisticsAddress;
		this.goodsOrderLogisticsIsDeliver = goodsOrderLogisticsIsDeliver;
		this.goodsOrderLogisticsIsDeliverMin = goodsOrderLogisticsIsDeliverMin;
		this.goodsOrderLogisticsIsDeliverMax = goodsOrderLogisticsIsDeliverMax;
		this.goodsOrderLogisticsLogisticsCompany = goodsOrderLogisticsLogisticsCompany;
		this.goodsOrderLogisticsLogisticsCode = goodsOrderLogisticsLogisticsCode;
		this.goodsOrderLogisticsLogisticsNo = goodsOrderLogisticsLogisticsNo;
		this.goodsOrderLogisticsVersion = goodsOrderLogisticsVersion;
		this.goodsOrderLogisticsVersionMin = goodsOrderLogisticsVersionMin;
		this.goodsOrderLogisticsVersionMax = goodsOrderLogisticsVersionMax;
		this.goodsOrderLogisticsCreateTime = goodsOrderLogisticsCreateTime;
		this.goodsOrderLogisticsCreateTimeMin = goodsOrderLogisticsCreateTimeMin;
		this.goodsOrderLogisticsCreateTimeMax = goodsOrderLogisticsCreateTimeMax;
		this.goodsOrderLogisticsUpdateTime = goodsOrderLogisticsUpdateTime;
		this.goodsOrderLogisticsUpdateTimeMin = goodsOrderLogisticsUpdateTimeMin;
		this.goodsOrderLogisticsUpdateTimeMax = goodsOrderLogisticsUpdateTimeMax;
		
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

	public String getGoodsOrderLogisticsRealName() {
		return goodsOrderLogisticsRealName;
	}

	public void setGoodsOrderLogisticsRealName(String goodsOrderLogisticsRealName) {
		this.goodsOrderLogisticsRealName = goodsOrderLogisticsRealName;
	}

	public String getGoodsOrderLogisticsPhone() {
		return goodsOrderLogisticsPhone;
	}

	public void setGoodsOrderLogisticsPhone(String goodsOrderLogisticsPhone) {
		this.goodsOrderLogisticsPhone = goodsOrderLogisticsPhone;
	}

	public String getGoodsOrderLogisticsProvince() {
		return goodsOrderLogisticsProvince;
	}

	public void setGoodsOrderLogisticsProvince(String goodsOrderLogisticsProvince) {
		this.goodsOrderLogisticsProvince = goodsOrderLogisticsProvince;
	}

	public String getGoodsOrderLogisticsCity() {
		return goodsOrderLogisticsCity;
	}

	public void setGoodsOrderLogisticsCity(String goodsOrderLogisticsCity) {
		this.goodsOrderLogisticsCity = goodsOrderLogisticsCity;
	}

	public String getGoodsOrderLogisticsDistrict() {
		return goodsOrderLogisticsDistrict;
	}

	public void setGoodsOrderLogisticsDistrict(String goodsOrderLogisticsDistrict) {
		this.goodsOrderLogisticsDistrict = goodsOrderLogisticsDistrict;
	}

	public String getGoodsOrderLogisticsAddress() {
		return goodsOrderLogisticsAddress;
	}

	public void setGoodsOrderLogisticsAddress(String goodsOrderLogisticsAddress) {
		this.goodsOrderLogisticsAddress = goodsOrderLogisticsAddress;
	}

	public Byte getGoodsOrderLogisticsIsDeliver() {
		return goodsOrderLogisticsIsDeliver;
	}

	public void setGoodsOrderLogisticsIsDeliver(Byte goodsOrderLogisticsIsDeliver) {
		this.goodsOrderLogisticsIsDeliver = goodsOrderLogisticsIsDeliver;
	}

	public Byte getGoodsOrderLogisticsIsDeliverMin() {
		return goodsOrderLogisticsIsDeliverMin;
	}

	public void setGoodsOrderLogisticsIsDeliverMin(Byte goodsOrderLogisticsIsDeliverMin) {
		this.goodsOrderLogisticsIsDeliverMin = goodsOrderLogisticsIsDeliverMin;
	}

	public Byte getGoodsOrderLogisticsIsDeliverMax() {
		return goodsOrderLogisticsIsDeliverMax;
	}

	public void setGoodsOrderLogisticsIsDeliverMax(Byte goodsOrderLogisticsIsDeliverMax) {
		this.goodsOrderLogisticsIsDeliverMax = goodsOrderLogisticsIsDeliverMax;
	}

	public String getGoodsOrderLogisticsLogisticsCompany() {
		return goodsOrderLogisticsLogisticsCompany;
	}

	public void setGoodsOrderLogisticsLogisticsCompany(String goodsOrderLogisticsLogisticsCompany) {
		this.goodsOrderLogisticsLogisticsCompany = goodsOrderLogisticsLogisticsCompany;
	}

	public String getGoodsOrderLogisticsLogisticsCode() {
		return goodsOrderLogisticsLogisticsCode;
	}

	public void setGoodsOrderLogisticsLogisticsCode(String goodsOrderLogisticsLogisticsCode) {
		this.goodsOrderLogisticsLogisticsCode = goodsOrderLogisticsLogisticsCode;
	}

	public String getGoodsOrderLogisticsLogisticsNo() {
		return goodsOrderLogisticsLogisticsNo;
	}

	public void setGoodsOrderLogisticsLogisticsNo(String goodsOrderLogisticsLogisticsNo) {
		this.goodsOrderLogisticsLogisticsNo = goodsOrderLogisticsLogisticsNo;
	}

	public Integer getGoodsOrderLogisticsVersion() {
		return goodsOrderLogisticsVersion;
	}

	public void setGoodsOrderLogisticsVersion(Integer goodsOrderLogisticsVersion) {
		this.goodsOrderLogisticsVersion = goodsOrderLogisticsVersion;
	}

	public Integer getGoodsOrderLogisticsVersionMin() {
		return goodsOrderLogisticsVersionMin;
	}

	public void setGoodsOrderLogisticsVersionMin(Integer goodsOrderLogisticsVersionMin) {
		this.goodsOrderLogisticsVersionMin = goodsOrderLogisticsVersionMin;
	}

	public Integer getGoodsOrderLogisticsVersionMax() {
		return goodsOrderLogisticsVersionMax;
	}

	public void setGoodsOrderLogisticsVersionMax(Integer goodsOrderLogisticsVersionMax) {
		this.goodsOrderLogisticsVersionMax = goodsOrderLogisticsVersionMax;
	}

	public Date getGoodsOrderLogisticsCreateTime() {
		return goodsOrderLogisticsCreateTime;
	}

	public void setGoodsOrderLogisticsCreateTime(Date goodsOrderLogisticsCreateTime) {
		this.goodsOrderLogisticsCreateTime = goodsOrderLogisticsCreateTime;
	}

	public Date getGoodsOrderLogisticsCreateTimeMin() {
		return goodsOrderLogisticsCreateTimeMin;
	}

	public void setGoodsOrderLogisticsCreateTimeMin(Date goodsOrderLogisticsCreateTimeMin) {
		this.goodsOrderLogisticsCreateTimeMin = goodsOrderLogisticsCreateTimeMin;
	}

	public Date getGoodsOrderLogisticsCreateTimeMax() {
		return goodsOrderLogisticsCreateTimeMax;
	}

	public void setGoodsOrderLogisticsCreateTimeMax(Date goodsOrderLogisticsCreateTimeMax) {
		this.goodsOrderLogisticsCreateTimeMax = goodsOrderLogisticsCreateTimeMax;
	}

	public Date getGoodsOrderLogisticsUpdateTime() {
		return goodsOrderLogisticsUpdateTime;
	}

	public void setGoodsOrderLogisticsUpdateTime(Date goodsOrderLogisticsUpdateTime) {
		this.goodsOrderLogisticsUpdateTime = goodsOrderLogisticsUpdateTime;
	}

	public Date getGoodsOrderLogisticsUpdateTimeMin() {
		return goodsOrderLogisticsUpdateTimeMin;
	}

	public void setGoodsOrderLogisticsUpdateTimeMin(Date goodsOrderLogisticsUpdateTimeMin) {
		this.goodsOrderLogisticsUpdateTimeMin = goodsOrderLogisticsUpdateTimeMin;
	}

	public Date getGoodsOrderLogisticsUpdateTimeMax() {
		return goodsOrderLogisticsUpdateTimeMax;
	}

	public void setGoodsOrderLogisticsUpdateTimeMax(Date goodsOrderLogisticsUpdateTimeMax) {
		this.goodsOrderLogisticsUpdateTimeMax = goodsOrderLogisticsUpdateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserGoodsOrderLogisticsQuery {" +
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
				", goodsOrderLogisticsRealName = " + goodsOrderLogisticsRealName + 
				", goodsOrderLogisticsPhone = " + goodsOrderLogisticsPhone + 
				", goodsOrderLogisticsProvince = " + goodsOrderLogisticsProvince + 
				", goodsOrderLogisticsCity = " + goodsOrderLogisticsCity + 
				", goodsOrderLogisticsDistrict = " + goodsOrderLogisticsDistrict + 
				", goodsOrderLogisticsAddress = " + goodsOrderLogisticsAddress + 
				", goodsOrderLogisticsIsDeliver = " + goodsOrderLogisticsIsDeliver + 
				", goodsOrderLogisticsIsDeliverMin = " + goodsOrderLogisticsIsDeliverMin + 
				", goodsOrderLogisticsIsDeliverMax = " + goodsOrderLogisticsIsDeliverMax + 
				", goodsOrderLogisticsLogisticsCompany = " + goodsOrderLogisticsLogisticsCompany + 
				", goodsOrderLogisticsLogisticsCode = " + goodsOrderLogisticsLogisticsCode + 
				", goodsOrderLogisticsLogisticsNo = " + goodsOrderLogisticsLogisticsNo + 
				", goodsOrderLogisticsVersion = " + goodsOrderLogisticsVersion + 
				", goodsOrderLogisticsVersionMin = " + goodsOrderLogisticsVersionMin + 
				", goodsOrderLogisticsVersionMax = " + goodsOrderLogisticsVersionMax + 
				", goodsOrderLogisticsCreateTime = " + goodsOrderLogisticsCreateTime + 
				", goodsOrderLogisticsCreateTimeMin = " + goodsOrderLogisticsCreateTimeMin + 
				", goodsOrderLogisticsCreateTimeMax = " + goodsOrderLogisticsCreateTimeMax + 
				", goodsOrderLogisticsUpdateTime = " + goodsOrderLogisticsUpdateTime + 
				", goodsOrderLogisticsUpdateTimeMin = " + goodsOrderLogisticsUpdateTimeMin + 
				", goodsOrderLogisticsUpdateTimeMax = " + goodsOrderLogisticsUpdateTimeMax + 
				" }";
    }

}
