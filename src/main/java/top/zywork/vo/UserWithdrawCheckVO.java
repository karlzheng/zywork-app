package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserWithdrawCheckVO值对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserWithdrawCheckVO extends BaseVO {

    private static final long serialVersionUID = -9223372036469178047L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String userPhone;
	// 用户邮箱
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userEmail;
	//t_funds_withdraw表的字段对应的属性
	// 交易编号
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 32, message = "必须是1-32个字符")
	private String fundsWithdrawTransactionNo;
	// 提现金额
	@NotNull(message = "此项是必须项")
	private Long fundsWithdrawAmount;
	// 提现银行卡
	@NotNull(message = "此项是必须项")
	private Long fundsWithdrawBankcardId;
	// 完成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCompleteTime;
	//t_funds_withdraw_check表的字段对应的属性
	// 提现状态
	@NotNull(message = "此项是必须项")
	private Byte fundsWithdrawCheckWithdrawStatus;
	// 提现描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String fundsWithdrawCheckWithdrawDescription;
	// 审核人编号
	@NotNull(message = "此项是必须项")
	private Long fundsWithdrawCheckCheckedUserId;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCheckCreateTime;
	
    public UserWithdrawCheckVO () {}

    public UserWithdrawCheckVO (Long userId, String userPhone, String userEmail, String fundsWithdrawTransactionNo, Long fundsWithdrawAmount, Long fundsWithdrawBankcardId, Date fundsWithdrawCompleteTime, Byte fundsWithdrawCheckWithdrawStatus, String fundsWithdrawCheckWithdrawDescription, Long fundsWithdrawCheckCheckedUserId, Date fundsWithdrawCheckCreateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.fundsWithdrawTransactionNo = fundsWithdrawTransactionNo;
		this.fundsWithdrawAmount = fundsWithdrawAmount;
		this.fundsWithdrawBankcardId = fundsWithdrawBankcardId;
		this.fundsWithdrawCompleteTime = fundsWithdrawCompleteTime;
		this.fundsWithdrawCheckWithdrawStatus = fundsWithdrawCheckWithdrawStatus;
		this.fundsWithdrawCheckWithdrawDescription = fundsWithdrawCheckWithdrawDescription;
		this.fundsWithdrawCheckCheckedUserId = fundsWithdrawCheckCheckedUserId;
		this.fundsWithdrawCheckCreateTime = fundsWithdrawCheckCreateTime;
		
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFundsWithdrawTransactionNo() {
		return fundsWithdrawTransactionNo;
	}

	public void setFundsWithdrawTransactionNo(String fundsWithdrawTransactionNo) {
		this.fundsWithdrawTransactionNo = fundsWithdrawTransactionNo;
	}

	public Long getFundsWithdrawAmount() {
		return fundsWithdrawAmount;
	}

	public void setFundsWithdrawAmount(Long fundsWithdrawAmount) {
		this.fundsWithdrawAmount = fundsWithdrawAmount;
	}

	public Long getFundsWithdrawBankcardId() {
		return fundsWithdrawBankcardId;
	}

	public void setFundsWithdrawBankcardId(Long fundsWithdrawBankcardId) {
		this.fundsWithdrawBankcardId = fundsWithdrawBankcardId;
	}

	public Date getFundsWithdrawCompleteTime() {
		return fundsWithdrawCompleteTime;
	}

	public void setFundsWithdrawCompleteTime(Date fundsWithdrawCompleteTime) {
		this.fundsWithdrawCompleteTime = fundsWithdrawCompleteTime;
	}

	public Byte getFundsWithdrawCheckWithdrawStatus() {
		return fundsWithdrawCheckWithdrawStatus;
	}

	public void setFundsWithdrawCheckWithdrawStatus(Byte fundsWithdrawCheckWithdrawStatus) {
		this.fundsWithdrawCheckWithdrawStatus = fundsWithdrawCheckWithdrawStatus;
	}

	public String getFundsWithdrawCheckWithdrawDescription() {
		return fundsWithdrawCheckWithdrawDescription;
	}

	public void setFundsWithdrawCheckWithdrawDescription(String fundsWithdrawCheckWithdrawDescription) {
		this.fundsWithdrawCheckWithdrawDescription = fundsWithdrawCheckWithdrawDescription;
	}

	public Long getFundsWithdrawCheckCheckedUserId() {
		return fundsWithdrawCheckCheckedUserId;
	}

	public void setFundsWithdrawCheckCheckedUserId(Long fundsWithdrawCheckCheckedUserId) {
		this.fundsWithdrawCheckCheckedUserId = fundsWithdrawCheckCheckedUserId;
	}

	public Date getFundsWithdrawCheckCreateTime() {
		return fundsWithdrawCheckCreateTime;
	}

	public void setFundsWithdrawCheckCreateTime(Date fundsWithdrawCheckCreateTime) {
		this.fundsWithdrawCheckCreateTime = fundsWithdrawCheckCreateTime;
	}

	
    @Override
    public String toString() {
        return "UserWithdrawCheckVO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", fundsWithdrawTransactionNo = " + fundsWithdrawTransactionNo + 
				", fundsWithdrawAmount = " + fundsWithdrawAmount + 
				", fundsWithdrawBankcardId = " + fundsWithdrawBankcardId + 
				", fundsWithdrawCompleteTime = " + fundsWithdrawCompleteTime + 
				", fundsWithdrawCheckWithdrawStatus = " + fundsWithdrawCheckWithdrawStatus + 
				", fundsWithdrawCheckWithdrawDescription = " + fundsWithdrawCheckWithdrawDescription + 
				", fundsWithdrawCheckCheckedUserId = " + fundsWithdrawCheckCheckedUserId + 
				", fundsWithdrawCheckCreateTime = " + fundsWithdrawCheckCreateTime + 
				" }";
    }

}
