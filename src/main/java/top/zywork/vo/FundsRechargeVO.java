package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * FundsRechargeVO值对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class FundsRechargeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035442339562L;

    // 充值编号
	private Long id;
	// 交易编号
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 32, message = "必须是1-32个字符")
	private String transactionNo;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 充值金额
	@NotNull(message = "此项是必须项")
	private Long amount;
	// 充值类型
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String rechargeType;
	// 是否成功
	private Byte isSuccess;
	// 商户订单号
	@Size(min = 0, max = 64, message = "必须小于64个字符")
	private String outTradeNo;
	// 支付系统订单号
	@Size(min = 0, max = 64, message = "必须小于64个字符")
	private String tradeNo;
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
	
    public FundsRechargeVO () {}

    public FundsRechargeVO (Long id, String transactionNo, Long userId, Long amount, String rechargeType, Byte isSuccess, String outTradeNo, String tradeNo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.transactionNo = transactionNo;
		this.userId = userId;
		this.amount = amount;
		this.rechargeType = rechargeType;
		this.isSuccess = isSuccess;
		this.outTradeNo = outTradeNo;
		this.tradeNo = tradeNo;
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

	public String getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	public Byte getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Byte isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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
        return "FundsRechargeVO {" +
                "id = " + id + 
				", transactionNo = " + transactionNo + 
				", userId = " + userId + 
				", amount = " + amount + 
				", rechargeType = " + rechargeType + 
				", isSuccess = " + isSuccess + 
				", outTradeNo = " + outTradeNo + 
				", tradeNo = " + tradeNo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
