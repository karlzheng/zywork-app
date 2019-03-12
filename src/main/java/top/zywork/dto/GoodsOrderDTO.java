package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsOrderDTO数据传输对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsOrderDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036716497446L;

    // 订单编号
	private Long id;
	// 用户编号
	private Long userId;
	// 订单号
	private String orderNo;
	// 订单金额
	private Long totalAmount;
	// 实付金额
	private Long payAmount;
	// 优惠金额
	private Long discountAmount;
	// 赠送积分
	private Long integralAmount;
	// 运费
	private Long expressFee;
	// 订单状态
	private Byte orderStatus;
	// 支付时间
	private Date payTime;
	// 支付方式
	private Byte payType;
	// 支付订单号
	private String transactionNo;
	// 是否支付成功
	private Byte paySuccess;
	// 发货时间
	private Date deliverTime;
	// 成交时间
	private Date dealTime;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsOrderDTO () {}

    public GoodsOrderDTO (Long id, Long userId, String orderNo, Long totalAmount, Long payAmount, Long discountAmount, Long integralAmount, Long expressFee, Byte orderStatus, Date payTime, Byte payType, String transactionNo, Byte paySuccess, Date deliverTime, Date dealTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.totalAmount = totalAmount;
		this.payAmount = payAmount;
		this.discountAmount = discountAmount;
		this.integralAmount = integralAmount;
		this.expressFee = expressFee;
		this.orderStatus = orderStatus;
		this.payTime = payTime;
		this.payType = payType;
		this.transactionNo = transactionNo;
		this.paySuccess = paySuccess;
		this.deliverTime = deliverTime;
		this.dealTime = dealTime;
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

	public Long getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(Long expressFee) {
		this.expressFee = expressFee;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
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

	public Date getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
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
        return "GoodsOrderDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", orderNo = " + orderNo + 
				", totalAmount = " + totalAmount + 
				", payAmount = " + payAmount + 
				", discountAmount = " + discountAmount + 
				", integralAmount = " + integralAmount + 
				", expressFee = " + expressFee + 
				", orderStatus = " + orderStatus + 
				", payTime = " + payTime + 
				", payType = " + payType + 
				", transactionNo = " + transactionNo + 
				", paySuccess = " + paySuccess + 
				", deliverTime = " + deliverTime + 
				", dealTime = " + dealTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
