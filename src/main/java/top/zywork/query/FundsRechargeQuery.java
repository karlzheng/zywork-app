package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FundsRechargeQuery查询对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsRechargeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036533426455L;

    // 充值编号
	private Long id;
	// 充值编号（最小值）
	private Long idMin;
	// 充值编号（最大值）
	private Long idMax;
	// 交易编号
	private String transactionNo;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 充值金额
	private Long amount;
	// 充值金额（最小值）
	private Long amountMin;
	// 充值金额（最大值）
	private Long amountMax;
	// 充值类型
	private String rechargeType;
	// 是否成功
	private Byte isSuccess;
	// 是否成功（最小值）
	private Byte isSuccessMin;
	// 是否成功（最大值）
	private Byte isSuccessMax;
	// 商户订单号
	private String outTradeNo;
	// 支付系统订单号
	private String tradeNo;
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
	
    public FundsRechargeQuery () {}

    public FundsRechargeQuery (Long id, Long idMin, Long idMax, String transactionNo, Long userId, Long userIdMin, Long userIdMax, Long amount, Long amountMin, Long amountMax, String rechargeType, Byte isSuccess, Byte isSuccessMin, Byte isSuccessMax, String outTradeNo, String tradeNo, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.transactionNo = transactionNo;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.amount = amount;
		this.amountMin = amountMin;
		this.amountMax = amountMax;
		this.rechargeType = rechargeType;
		this.isSuccess = isSuccess;
		this.isSuccessMin = isSuccessMin;
		this.isSuccessMax = isSuccessMax;
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getAmountMin() {
		return amountMin;
	}

	public void setAmountMin(Long amountMin) {
		this.amountMin = amountMin;
	}

	public Long getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(Long amountMax) {
		this.amountMax = amountMax;
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

	public Byte getIsSuccessMin() {
		return isSuccessMin;
	}

	public void setIsSuccessMin(Byte isSuccessMin) {
		this.isSuccessMin = isSuccessMin;
	}

	public Byte getIsSuccessMax() {
		return isSuccessMax;
	}

	public void setIsSuccessMax(Byte isSuccessMax) {
		this.isSuccessMax = isSuccessMax;
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
        return "FundsRechargeQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", transactionNo = " + transactionNo + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", amount = " + amount + 
				", amountMin = " + amountMin + 
				", amountMax = " + amountMax + 
				", rechargeType = " + rechargeType + 
				", isSuccess = " + isSuccess + 
				", isSuccessMin = " + isSuccessMin + 
				", isSuccessMax = " + isSuccessMax + 
				", outTradeNo = " + outTradeNo + 
				", tradeNo = " + tradeNo + 
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
