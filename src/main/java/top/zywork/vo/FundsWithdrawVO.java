package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FundsWithdrawVO值对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsWithdrawVO extends BaseVO {

    private static final long serialVersionUID = -9223372036731875872L;

    // 提现编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 交易编号
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 32, message = "必须是1-32个字符")
	private String transactionNo;
	// 提现金额
	@NotNull(message = "此项是必须项")
	private Long amount;
	// 提现银行卡
	@NotNull(message = "此项是必须项")
	private Long bankcardId;
	// 提现状态
	private Byte withdrawStatus;
	// 提现描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String withdrawDescription;
	// 审核人编号
	private Long checkedUserId;
	// 审核时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTime;
	// 完成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date completeTime;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public FundsWithdrawVO () {}

    public FundsWithdrawVO (Long id, Long userId, String transactionNo, Long amount, Long bankcardId, Byte withdrawStatus, String withdrawDescription, Long checkedUserId, Date checkedTime, Date completeTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.transactionNo = transactionNo;
		this.amount = amount;
		this.bankcardId = bankcardId;
		this.withdrawStatus = withdrawStatus;
		this.withdrawDescription = withdrawDescription;
		this.checkedUserId = checkedUserId;
		this.checkedTime = checkedTime;
		this.completeTime = completeTime;
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

	public Long getBankcardId() {
		return bankcardId;
	}

	public void setBankcardId(Long bankcardId) {
		this.bankcardId = bankcardId;
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

	public Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
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
        return "FundsWithdrawVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", transactionNo = " + transactionNo + 
				", amount = " + amount + 
				", bankcardId = " + bankcardId + 
				", withdrawStatus = " + withdrawStatus + 
				", withdrawDescription = " + withdrawDescription + 
				", checkedUserId = " + checkedUserId + 
				", checkedTime = " + checkedTime + 
				", completeTime = " + completeTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
