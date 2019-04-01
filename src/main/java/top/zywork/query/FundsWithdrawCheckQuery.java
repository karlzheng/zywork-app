package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FundsWithdrawCheckQuery查询对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsWithdrawCheckQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036109280635L;

    // 提现审核编号
	private Long id;
	// 提现审核编号（最小值）
	private Long idMin;
	// 提现审核编号（最大值）
	private Long idMax;
	// 提现编号
	private Long withdrawId;
	// 提现编号（最小值）
	private Long withdrawIdMin;
	// 提现编号（最大值）
	private Long withdrawIdMax;
	// 交易编号
	private String transactionNo;
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
	
    public FundsWithdrawCheckQuery () {}

    public FundsWithdrawCheckQuery (Long id, Long idMin, Long idMax, Long withdrawId, Long withdrawIdMin, Long withdrawIdMax, String transactionNo, Byte withdrawStatus, Byte withdrawStatusMin, Byte withdrawStatusMax, String withdrawDescription, Long checkedUserId, Long checkedUserIdMin, Long checkedUserIdMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.withdrawId = withdrawId;
		this.withdrawIdMin = withdrawIdMin;
		this.withdrawIdMax = withdrawIdMax;
		this.transactionNo = transactionNo;
		this.withdrawStatus = withdrawStatus;
		this.withdrawStatusMin = withdrawStatusMin;
		this.withdrawStatusMax = withdrawStatusMax;
		this.withdrawDescription = withdrawDescription;
		this.checkedUserId = checkedUserId;
		this.checkedUserIdMin = checkedUserIdMin;
		this.checkedUserIdMax = checkedUserIdMax;
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

	public Long getWithdrawId() {
		return withdrawId;
	}

	public void setWithdrawId(Long withdrawId) {
		this.withdrawId = withdrawId;
	}

	public Long getWithdrawIdMin() {
		return withdrawIdMin;
	}

	public void setWithdrawIdMin(Long withdrawIdMin) {
		this.withdrawIdMin = withdrawIdMin;
	}

	public Long getWithdrawIdMax() {
		return withdrawIdMax;
	}

	public void setWithdrawIdMax(Long withdrawIdMax) {
		this.withdrawIdMax = withdrawIdMax;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
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
        return "FundsWithdrawCheckQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", withdrawId = " + withdrawId + 
				", withdrawIdMin = " + withdrawIdMin + 
				", withdrawIdMax = " + withdrawIdMax + 
				", transactionNo = " + transactionNo + 
				", withdrawStatus = " + withdrawStatus + 
				", withdrawStatusMin = " + withdrawStatusMin + 
				", withdrawStatusMax = " + withdrawStatusMax + 
				", withdrawDescription = " + withdrawDescription + 
				", checkedUserId = " + checkedUserId + 
				", checkedUserIdMin = " + checkedUserIdMin + 
				", checkedUserIdMax = " + checkedUserIdMax + 
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
