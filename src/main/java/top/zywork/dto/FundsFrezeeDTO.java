package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * FundsFrezeeDTO数据传输对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsFrezeeDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035158324646L;

    // 冻结编号
	private Long id;
	// 交易编号
	private String transactionNo;
	// 用户编号
	private Long userId;
	// 金额
	private Long amount;
	// 类型
	private String frezeeType;
	// 描述
	private String frezeeDescription;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public FundsFrezeeDTO () {}

    public FundsFrezeeDTO (Long id, String transactionNo, Long userId, Long amount, String frezeeType, String frezeeDescription, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.transactionNo = transactionNo;
		this.userId = userId;
		this.amount = amount;
		this.frezeeType = frezeeType;
		this.frezeeDescription = frezeeDescription;
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

	public String getFrezeeType() {
		return frezeeType;
	}

	public void setFrezeeType(String frezeeType) {
		this.frezeeType = frezeeType;
	}

	public String getFrezeeDescription() {
		return frezeeDescription;
	}

	public void setFrezeeDescription(String frezeeDescription) {
		this.frezeeDescription = frezeeDescription;
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
        return "FundsFrezeeDTO {" +
                "id = " + id + 
				", transactionNo = " + transactionNo + 
				", userId = " + userId + 
				", amount = " + amount + 
				", frezeeType = " + frezeeType + 
				", frezeeDescription = " + frezeeDescription + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
