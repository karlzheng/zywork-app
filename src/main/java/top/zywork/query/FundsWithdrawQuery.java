package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FundsWithdrawQuery查询对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsWithdrawQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034998141979L;

    // 提现编号
	private Long id;
	// 提现编号（最小值）
	private Long idMin;
	// 提现编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 交易编号
	private String transactionNo;
	// 提现金额
	private Long amount;
	// 提现金额（最小值）
	private Long amountMin;
	// 提现金额（最大值）
	private Long amountMax;
	// 提现银行卡
	private Long bankcardId;
	// 提现银行卡（最小值）
	private Long bankcardIdMin;
	// 提现银行卡（最大值）
	private Long bankcardIdMax;
	// 提现状态
	private Byte withdrawStatus;
	// 提现状态（最小值）
	private Byte withdrawStatusMin;
	// 提现状态（最大值）
	private Byte withdrawStatusMax;
	// 提现描述
	private String withdrawDescription;
	// 审核人编号
	private Long checkedUserId;
	// 审核人编号（最小值）
	private Long checkedUserIdMin;
	// 审核人编号（最大值）
	private Long checkedUserIdMax;
	// 审核时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTime;
	// 审核时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTimeMin;
	// 审核时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTimeMax;
	// 完成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date completeTime;
	// 完成时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date completeTimeMin;
	// 完成时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date completeTimeMax;
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
	
    public FundsWithdrawQuery () {}

    public FundsWithdrawQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, String transactionNo, Long amount, Long amountMin, Long amountMax, Long bankcardId, Long bankcardIdMin, Long bankcardIdMax, Byte withdrawStatus, Byte withdrawStatusMin, Byte withdrawStatusMax, String withdrawDescription, Long checkedUserId, Long checkedUserIdMin, Long checkedUserIdMax, Date checkedTime, Date checkedTimeMin, Date checkedTimeMax, Date completeTime, Date completeTimeMin, Date completeTimeMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.transactionNo = transactionNo;
		this.amount = amount;
		this.amountMin = amountMin;
		this.amountMax = amountMax;
		this.bankcardId = bankcardId;
		this.bankcardIdMin = bankcardIdMin;
		this.bankcardIdMax = bankcardIdMax;
		this.withdrawStatus = withdrawStatus;
		this.withdrawStatusMin = withdrawStatusMin;
		this.withdrawStatusMax = withdrawStatusMax;
		this.withdrawDescription = withdrawDescription;
		this.checkedUserId = checkedUserId;
		this.checkedUserIdMin = checkedUserIdMin;
		this.checkedUserIdMax = checkedUserIdMax;
		this.checkedTime = checkedTime;
		this.checkedTimeMin = checkedTimeMin;
		this.checkedTimeMax = checkedTimeMax;
		this.completeTime = completeTime;
		this.completeTimeMin = completeTimeMin;
		this.completeTimeMax = completeTimeMax;
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

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
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

	public Long getBankcardId() {
		return bankcardId;
	}

	public void setBankcardId(Long bankcardId) {
		this.bankcardId = bankcardId;
	}

	public Long getBankcardIdMin() {
		return bankcardIdMin;
	}

	public void setBankcardIdMin(Long bankcardIdMin) {
		this.bankcardIdMin = bankcardIdMin;
	}

	public Long getBankcardIdMax() {
		return bankcardIdMax;
	}

	public void setBankcardIdMax(Long bankcardIdMax) {
		this.bankcardIdMax = bankcardIdMax;
	}

	public Byte getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(Byte withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public Byte getWithdrawStatusMin() {
		return withdrawStatusMin;
	}

	public void setWithdrawStatusMin(Byte withdrawStatusMin) {
		this.withdrawStatusMin = withdrawStatusMin;
	}

	public Byte getWithdrawStatusMax() {
		return withdrawStatusMax;
	}

	public void setWithdrawStatusMax(Byte withdrawStatusMax) {
		this.withdrawStatusMax = withdrawStatusMax;
	}

	public String getWithdrawDescription() {
		return withdrawDescription;
	}

	public void setWithdrawDescription(String withdrawDescription) {
		this.withdrawDescription = withdrawDescription;
	}

	public Long getCheckedUserId() {
		return checkedUserId;
	}

	public void setCheckedUserId(Long checkedUserId) {
		this.checkedUserId = checkedUserId;
	}

	public Long getCheckedUserIdMin() {
		return checkedUserIdMin;
	}

	public void setCheckedUserIdMin(Long checkedUserIdMin) {
		this.checkedUserIdMin = checkedUserIdMin;
	}

	public Long getCheckedUserIdMax() {
		return checkedUserIdMax;
	}

	public void setCheckedUserIdMax(Long checkedUserIdMax) {
		this.checkedUserIdMax = checkedUserIdMax;
	}

	public Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Date getCheckedTimeMin() {
		return checkedTimeMin;
	}

	public void setCheckedTimeMin(Date checkedTimeMin) {
		this.checkedTimeMin = checkedTimeMin;
	}

	public Date getCheckedTimeMax() {
		return checkedTimeMax;
	}

	public void setCheckedTimeMax(Date checkedTimeMax) {
		this.checkedTimeMax = checkedTimeMax;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Date getCompleteTimeMin() {
		return completeTimeMin;
	}

	public void setCompleteTimeMin(Date completeTimeMin) {
		this.completeTimeMin = completeTimeMin;
	}

	public Date getCompleteTimeMax() {
		return completeTimeMax;
	}

	public void setCompleteTimeMax(Date completeTimeMax) {
		this.completeTimeMax = completeTimeMax;
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
        return "FundsWithdrawQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", transactionNo = " + transactionNo + 
				", amount = " + amount + 
				", amountMin = " + amountMin + 
				", amountMax = " + amountMax + 
				", bankcardId = " + bankcardId + 
				", bankcardIdMin = " + bankcardIdMin + 
				", bankcardIdMax = " + bankcardIdMax + 
				", withdrawStatus = " + withdrawStatus + 
				", withdrawStatusMin = " + withdrawStatusMin + 
				", withdrawStatusMax = " + withdrawStatusMax + 
				", withdrawDescription = " + withdrawDescription + 
				", checkedUserId = " + checkedUserId + 
				", checkedUserIdMin = " + checkedUserIdMin + 
				", checkedUserIdMax = " + checkedUserIdMax + 
				", checkedTime = " + checkedTime + 
				", checkedTimeMin = " + checkedTimeMin + 
				", checkedTimeMax = " + checkedTimeMax + 
				", completeTime = " + completeTime + 
				", completeTimeMin = " + completeTimeMin + 
				", completeTimeMax = " + completeTimeMax + 
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
