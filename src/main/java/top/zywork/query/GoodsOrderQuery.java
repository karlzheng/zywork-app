package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsOrderQuery查询对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsOrderQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035581835026L;

    // 订单编号
	private Long id;
	// 订单编号（最小值）
	private Long idMin;
	// 订单编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 订单号
	private String orderNo;
	// 订单金额
	private Long totalAmount;
	// 订单金额（最小值）
	private Long totalAmountMin;
	// 订单金额（最大值）
	private Long totalAmountMax;
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
	// 运费
	private Long expressFee;
	// 运费（最小值）
	private Long expressFeeMin;
	// 运费（最大值）
	private Long expressFeeMax;
	// 订单状态
	private Byte orderStatus;
	// 订单状态（最小值）
	private Byte orderStatusMin;
	// 订单状态（最大值）
	private Byte orderStatusMax;
	// 支付时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date payTime;
	// 支付时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date payTimeMin;
	// 支付时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date payTimeMax;
	// 支付方式
	private Byte payType;
	// 支付方式（最小值）
	private Byte payTypeMin;
	// 支付方式（最大值）
	private Byte payTypeMax;
	// 支付订单号
	private String transactionNo;
	// 是否支付成功
	private Byte paySuccess;
	// 是否支付成功（最小值）
	private Byte paySuccessMin;
	// 是否支付成功（最大值）
	private Byte paySuccessMax;
	// 发货时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deliverTime;
	// 发货时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deliverTimeMin;
	// 发货时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deliverTimeMax;
	// 成交时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date dealTime;
	// 成交时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date dealTimeMin;
	// 成交时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date dealTimeMax;
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
	
    public GoodsOrderQuery () {}

    public GoodsOrderQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String orderNo, Long totalAmount, Long totalAmountMin, Long totalAmountMax, Long payAmount, Long payAmountMin, Long payAmountMax, Long discountAmount, Long discountAmountMin, Long discountAmountMax, Long integralAmount, Long integralAmountMin, Long integralAmountMax, Long expressFee, Long expressFeeMin, Long expressFeeMax, Byte orderStatus, Byte orderStatusMin, Byte orderStatusMax, Date payTime, Date payTimeMin, Date payTimeMax, Byte payType, Byte payTypeMin, Byte payTypeMax, String transactionNo, Byte paySuccess, Byte paySuccessMin, Byte paySuccessMax, Date deliverTime, Date deliverTimeMin, Date deliverTimeMax, Date dealTime, Date dealTimeMin, Date dealTimeMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.orderNo = orderNo;
		this.totalAmount = totalAmount;
		this.totalAmountMin = totalAmountMin;
		this.totalAmountMax = totalAmountMax;
		this.payAmount = payAmount;
		this.payAmountMin = payAmountMin;
		this.payAmountMax = payAmountMax;
		this.discountAmount = discountAmount;
		this.discountAmountMin = discountAmountMin;
		this.discountAmountMax = discountAmountMax;
		this.integralAmount = integralAmount;
		this.integralAmountMin = integralAmountMin;
		this.integralAmountMax = integralAmountMax;
		this.expressFee = expressFee;
		this.expressFeeMin = expressFeeMin;
		this.expressFeeMax = expressFeeMax;
		this.orderStatus = orderStatus;
		this.orderStatusMin = orderStatusMin;
		this.orderStatusMax = orderStatusMax;
		this.payTime = payTime;
		this.payTimeMin = payTimeMin;
		this.payTimeMax = payTimeMax;
		this.payType = payType;
		this.payTypeMin = payTypeMin;
		this.payTypeMax = payTypeMax;
		this.transactionNo = transactionNo;
		this.paySuccess = paySuccess;
		this.paySuccessMin = paySuccessMin;
		this.paySuccessMax = paySuccessMax;
		this.deliverTime = deliverTime;
		this.deliverTimeMin = deliverTimeMin;
		this.deliverTimeMax = deliverTimeMax;
		this.dealTime = dealTime;
		this.dealTimeMin = dealTimeMin;
		this.dealTimeMax = dealTimeMax;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getTotalAmountMin() {
		return totalAmountMin;
	}

	public void setTotalAmountMin(Long totalAmountMin) {
		this.totalAmountMin = totalAmountMin;
	}

	public Long getTotalAmountMax() {
		return totalAmountMax;
	}

	public void setTotalAmountMax(Long totalAmountMax) {
		this.totalAmountMax = totalAmountMax;
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

	public Long getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Long expressFee) {
		this.expressFee = expressFee;
	}

	public Long getExpressFeeMin() {
		return expressFeeMin;
	}

	public void setExpressFeeMin(Long expressFeeMin) {
		this.expressFeeMin = expressFeeMin;
	}

	public Long getExpressFeeMax() {
		return expressFeeMax;
	}

	public void setExpressFeeMax(Long expressFeeMax) {
		this.expressFeeMax = expressFeeMax;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Byte getOrderStatusMin() {
		return orderStatusMin;
	}

	public void setOrderStatusMin(Byte orderStatusMin) {
		this.orderStatusMin = orderStatusMin;
	}

	public Byte getOrderStatusMax() {
		return orderStatusMax;
	}

	public void setOrderStatusMax(Byte orderStatusMax) {
		this.orderStatusMax = orderStatusMax;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getPayTimeMin() {
		return payTimeMin;
	}

	public void setPayTimeMin(Date payTimeMin) {
		this.payTimeMin = payTimeMin;
	}

	public Date getPayTimeMax() {
		return payTimeMax;
	}

	public void setPayTimeMax(Date payTimeMax) {
		this.payTimeMax = payTimeMax;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	public Byte getPayTypeMin() {
		return payTypeMin;
	}

	public void setPayTypeMin(Byte payTypeMin) {
		this.payTypeMin = payTypeMin;
	}

	public Byte getPayTypeMax() {
		return payTypeMax;
	}

	public void setPayTypeMax(Byte payTypeMax) {
		this.payTypeMax = payTypeMax;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Byte getPaySuccess() {
		return paySuccess;
	}

	public void setPaySuccess(Byte paySuccess) {
		this.paySuccess = paySuccess;
	}

	public Byte getPaySuccessMin() {
		return paySuccessMin;
	}

	public void setPaySuccessMin(Byte paySuccessMin) {
		this.paySuccessMin = paySuccessMin;
	}

	public Byte getPaySuccessMax() {
		return paySuccessMax;
	}

	public void setPaySuccessMax(Byte paySuccessMax) {
		this.paySuccessMax = paySuccessMax;
	}

	public Date getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public Date getDeliverTimeMin() {
		return deliverTimeMin;
	}

	public void setDeliverTimeMin(Date deliverTimeMin) {
		this.deliverTimeMin = deliverTimeMin;
	}

	public Date getDeliverTimeMax() {
		return deliverTimeMax;
	}

	public void setDeliverTimeMax(Date deliverTimeMax) {
		this.deliverTimeMax = deliverTimeMax;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public Date getDealTimeMin() {
		return dealTimeMin;
	}

	public void setDealTimeMin(Date dealTimeMin) {
		this.dealTimeMin = dealTimeMin;
	}

	public Date getDealTimeMax() {
		return dealTimeMax;
	}

	public void setDealTimeMax(Date dealTimeMax) {
		this.dealTimeMax = dealTimeMax;
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
        return "GoodsOrderQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", orderNo = " + orderNo + 
				", totalAmount = " + totalAmount + 
				", totalAmountMin = " + totalAmountMin + 
				", totalAmountMax = " + totalAmountMax + 
				", payAmount = " + payAmount + 
				", payAmountMin = " + payAmountMin + 
				", payAmountMax = " + payAmountMax + 
				", discountAmount = " + discountAmount + 
				", discountAmountMin = " + discountAmountMin + 
				", discountAmountMax = " + discountAmountMax + 
				", integralAmount = " + integralAmount + 
				", integralAmountMin = " + integralAmountMin + 
				", integralAmountMax = " + integralAmountMax + 
				", expressFee = " + expressFee + 
				", expressFeeMin = " + expressFeeMin + 
				", expressFeeMax = " + expressFeeMax + 
				", orderStatus = " + orderStatus + 
				", orderStatusMin = " + orderStatusMin + 
				", orderStatusMax = " + orderStatusMax + 
				", payTime = " + payTime + 
				", payTimeMin = " + payTimeMin + 
				", payTimeMax = " + payTimeMax + 
				", payType = " + payType + 
				", payTypeMin = " + payTypeMin + 
				", payTypeMax = " + payTypeMax + 
				", transactionNo = " + transactionNo + 
				", paySuccess = " + paySuccess + 
				", paySuccessMin = " + paySuccessMin + 
				", paySuccessMax = " + paySuccessMax + 
				", deliverTime = " + deliverTime + 
				", deliverTimeMin = " + deliverTimeMin + 
				", deliverTimeMax = " + deliverTimeMax + 
				", dealTime = " + dealTime + 
				", dealTimeMin = " + dealTimeMin + 
				", dealTimeMax = " + dealTimeMax + 
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
