package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserWalletDO数据对象实体类<br/>
 *
 * 创建于2019-01-14<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserWalletDO extends BaseDO {

    private static final long serialVersionUID = -9223372035270560793L;

    // 钱包编号
	private Long id;
	// 支付密码
	private String payPassword;
	// 人民币余额
	private Long rmbBalance;
	// 可用余额
	private Long usableRmbBalance;
	// 冻结余额
	private Long frozenRmbBalance;
	// 总积分
	private Long integral;
	// 可用积分
	private Long usableIntegral;
	// 冻结积分
	private Long frozenIntegral;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserWalletDO () {}

    public UserWalletDO (Long id, String payPassword, Long rmbBalance, Long usableRmbBalance, Long frozenRmbBalance, Long integral, Long usableIntegral, Long frozenIntegral, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.payPassword = payPassword;
		this.rmbBalance = rmbBalance;
		this.usableRmbBalance = usableRmbBalance;
		this.frozenRmbBalance = frozenRmbBalance;
		this.integral = integral;
		this.usableIntegral = usableIntegral;
		this.frozenIntegral = frozenIntegral;
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

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public Long getRmbBalance() {
		return rmbBalance;
	}

	public void setRmbBalance(Long rmbBalance) {
		this.rmbBalance = rmbBalance;
	}

	public Long getUsableRmbBalance() {
		return usableRmbBalance;
	}

	public void setUsableRmbBalance(Long usableRmbBalance) {
		this.usableRmbBalance = usableRmbBalance;
	}

	public Long getFrozenRmbBalance() {
		return frozenRmbBalance;
	}

	public void setFrozenRmbBalance(Long frozenRmbBalance) {
		this.frozenRmbBalance = frozenRmbBalance;
	}

	public Long getIntegral() {
		return integral;
	}

	public void setIntegral(Long integral) {
		this.integral = integral;
	}

	public Long getUsableIntegral() {
		return usableIntegral;
	}

	public void setUsableIntegral(Long usableIntegral) {
		this.usableIntegral = usableIntegral;
	}

	public Long getFrozenIntegral() {
		return frozenIntegral;
	}

	public void setFrozenIntegral(Long frozenIntegral) {
		this.frozenIntegral = frozenIntegral;
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
        return "UserWalletDO {" +
                "id = " + id + 
				", payPassword = " + payPassword + 
				", rmbBalance = " + rmbBalance + 
				", usableRmbBalance = " + usableRmbBalance + 
				", frozenRmbBalance = " + frozenRmbBalance + 
				", integral = " + integral + 
				", usableIntegral = " + usableIntegral + 
				", frozenIntegral = " + frozenIntegral + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
