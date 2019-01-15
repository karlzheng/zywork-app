package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * AccountDetailDO数据对象实体类<br/>
 *
 * 创建于2019-01-15<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class AccountDetailDO extends BaseDO {

    private static final long serialVersionUID = -9223372036046372540L;

    // 账目编号
	private Long id;
	// 用户编号
	private Long userId;
	// 金额
	private Long amount;
	// 积分
	private Long integral;
	// 收入或支出
	private Byte type;
	// 收支类型
	private String subType;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public AccountDetailDO () {}

    public AccountDetailDO (Long id, Long userId, Long amount, Long integral, Byte type, String subType, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.integral = integral;
		this.type = type;
		this.subType = subType;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getIntegral() {
		return integral;
	}

	public void setIntegral(Long integral) {
		this.integral = integral;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
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
        return "AccountDetailDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", amount = " + amount + 
				", integral = " + integral + 
				", type = " + type + 
				", subType = " + subType + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
