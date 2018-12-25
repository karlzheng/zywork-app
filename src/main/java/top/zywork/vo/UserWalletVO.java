package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserWalletVO值对象类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserWalletVO extends BaseVO {

    private static final long serialVersionUID = -9223372035363664156L;

    // 钱包编号
	private Long id;
	// 支付密码
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String payPassword;
	// 人民币余额
	private Long rmbBalance;
	// 可用余额
	private Long usableRmbBalance;
	// 冻结余额
	private Long frozenRmbBalance;
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
	
    public UserWalletVO () {}

    public UserWalletVO (Long id, String payPassword, Long rmbBalance, Long usableRmbBalance, Long frozenRmbBalance, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.payPassword = payPassword;
		this.rmbBalance = rmbBalance;
		this.usableRmbBalance = usableRmbBalance;
		this.frozenRmbBalance = frozenRmbBalance;
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
        return "UserWalletVO {" +
                "id = " + id + 
				", payPassword = " + payPassword + 
				", rmbBalance = " + rmbBalance + 
				", usableRmbBalance = " + usableRmbBalance + 
				", frozenRmbBalance = " + frozenRmbBalance + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
