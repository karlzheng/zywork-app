package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * FundsRechargeDO数据对象实体类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsRechargeDO extends BaseDO {

    private static final long serialVersionUID = -9223372035536983955L;

    // 充值编号
	private Long id;
	// 交易编号
	private String transactionNo;
	// 用户编号
	private Long userId;
	// 充值金额
	private Long amount;
	// 充值类型
	private String rechargeType;
	// 是否成功
	private Byte isSuccess;
	// 商户订单号
	private String outTradeNo;
	// 支付系统订单号
	private String tradeNo;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public FundsRechargeDO () {}

    public FundsRechargeDO (Long id, String transactionNo, Long userId, Long amount, String rechargeType, Byte isSuccess, String outTradeNo, String tradeNo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.transactionNo = transactionNo;
		this.userId = userId;
		this.amount = amount;
		this.rechargeType = rechargeType;
		this.isSuccess = isSuccess;
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
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

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public Byte getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Byte isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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
        return "FundsRechargeDO {" +
                "id = " + id + 
				", transactionNo = " + transactionNo + 
				", userId = " + userId + 
				", amount = " + amount + 
				", rechargeType = " + rechargeType + 
				", isSuccess = " + isSuccess + 
				", outTradeNo = " + outTradeNo + 
				", tradeNo = " + tradeNo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
