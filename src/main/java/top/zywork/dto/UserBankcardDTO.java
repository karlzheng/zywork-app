package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserBankcardDTO数据传输对象类<br/>
 *
 * 创建于2018-12-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserBankcardDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035128316978L;

    // 银行卡编号
	private Long id;
	// 用户编号
	private Long userId;
	// 持卡人姓名
	private String accountName;
	// 银行代码
	private String bankCode;
	// 银行名称
	private String bankName;
	// 银行卡号
	private String bankcardNo;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserBankcardDTO () {}

    public UserBankcardDTO (Long id, Long userId, String accountName, String bankCode, String bankName, String bankcardNo, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.accountName = accountName;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankcardNo = bankcardNo;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankcardNo() {
		return bankcardNo;
	}

	public void setBankcardNo(String bankcardNo) {
		this.bankcardNo = bankcardNo;
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
        return "UserBankcardDTO {" +
                "id = " + id + 
				", userId = " + userId + 
				", accountName = " + accountName + 
				", bankCode = " + bankCode + 
				", bankName = " + bankName + 
				", bankcardNo = " + bankcardNo + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
