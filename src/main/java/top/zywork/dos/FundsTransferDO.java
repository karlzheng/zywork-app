package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * FundsTransferDO数据对象实体类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsTransferDO extends BaseDO {

    private static final long serialVersionUID = -9223372036067478505L;

    // 转账编号
	private Long id;
	// 交易编号
	private String transactionNo;
	// 用户编号
	private Long userId;
	// 金额
	private Long amount;
	// FROM
	private Long fromUserId;
	// TO
	private Long toUserId;
	// 类型
	private String transferType;
	// 描述
	private String transferDescription;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public FundsTransferDO () {}

    public FundsTransferDO (Long id, String transactionNo, Long userId, Long amount, Long fromUserId, Long toUserId, String transferType, String transferDescription, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.transactionNo = transactionNo;
		this.userId = userId;
		this.amount = amount;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.transferType = transferType;
		this.transferDescription = transferDescription;
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

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransferDescription() {
		return transferDescription;
	}

	public void setTransferDescription(String transferDescription) {
		this.transferDescription = transferDescription;
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
        return "FundsTransferDO {" +
                "id = " + id + 
				", transactionNo = " + transactionNo + 
				", userId = " + userId + 
				", amount = " + amount + 
				", fromUserId = " + fromUserId + 
				", toUserId = " + toUserId + 
				", transferType = " + transferType + 
				", transferDescription = " + transferDescription + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
