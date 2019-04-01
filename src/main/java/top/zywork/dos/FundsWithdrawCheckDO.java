package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * FundsWithdrawCheckDO数据对象实体类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsWithdrawCheckDO extends BaseDO {

    private static final long serialVersionUID = -9223372035001911705L;

    // 提现审核编号
	private Long id;
	// 提现编号
	private Long withdrawId;
	// 交易编号
	private String transactionNo;
	// 提现状态
	private Byte withdrawStatus;
	// 提现描述
	private String withdrawDescription;
	// 审核人编号
	private Long checkedUserId;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public FundsWithdrawCheckDO () {}

    public FundsWithdrawCheckDO (Long id, Long withdrawId, String transactionNo, Byte withdrawStatus, String withdrawDescription, Long checkedUserId, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.withdrawId = withdrawId;
		this.transactionNo = transactionNo;
		this.withdrawStatus = withdrawStatus;
		this.withdrawDescription = withdrawDescription;
		this.checkedUserId = checkedUserId;
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

	public Long getWithdrawId() {
		return withdrawId;
	}

	public void setWithdrawId(Long withdrawId) {
		this.withdrawId = withdrawId;
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
        return "FundsWithdrawCheckDO {" +
                "id = " + id + 
				", withdrawId = " + withdrawId + 
				", transactionNo = " + transactionNo + 
				", withdrawStatus = " + withdrawStatus + 
				", withdrawDescription = " + withdrawDescription + 
				", checkedUserId = " + checkedUserId + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
