package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FundsFrezeeVO值对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsFrezeeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035005688187L;

    // 冻结编号
	private Long id;
	// 交易编号
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 32, message = "必须是1-32个字符")
	private String transactionNo;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 金额
	@NotNull(message = "此项是必须项")
	private Long amount;
	// 类型
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String frezeeType;
	// 描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String frezeeDescription;
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
	
    public FundsFrezeeVO () {}

    public FundsFrezeeVO (Long id, String transactionNo, Long userId, Long amount, String frezeeType, String frezeeDescription, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
        return "FundsFrezeeVO {" +
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
