package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserWithdrawCheckQuery查询对象类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserWithdrawCheckQuery extends PageQuery {

    private static final long serialVersionUID = -9223372034885106975L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_funds_withdraw表的字段对应的属性
	// 交易编号
	private String fundsWithdrawTransactionNo;
	// 提现金额
	private Long fundsWithdrawAmount;
	// 提现金额（最小值）
	private Long fundsWithdrawAmountMin;
	// 提现金额（最大值）
	private Long fundsWithdrawAmountMax;
	// 提现银行卡
	private Long fundsWithdrawBankcardId;
	// 提现银行卡（最小值）
	private Long fundsWithdrawBankcardIdMin;
	// 提现银行卡（最大值）
	private Long fundsWithdrawBankcardIdMax;
	// 完成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCompleteTime;
	// 完成时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCompleteTimeMin;
	// 完成时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCompleteTimeMax;
	//t_funds_withdraw_check表的字段对应的属性
	// 提现状态
	private Byte fundsWithdrawCheckWithdrawStatus;
	// 提现状态（最小值）
	private Byte fundsWithdrawCheckWithdrawStatusMin;
	// 提现状态（最大值）
	private Byte fundsWithdrawCheckWithdrawStatusMax;
	// 提现描述
	private String fundsWithdrawCheckWithdrawDescription;
	// 审核人编号
	private Long fundsWithdrawCheckCheckedUserId;
	// 审核人编号（最小值）
	private Long fundsWithdrawCheckCheckedUserIdMin;
	// 审核人编号（最大值）
	private Long fundsWithdrawCheckCheckedUserIdMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCheckCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCheckCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fundsWithdrawCheckCreateTimeMax;
	
    public UserWithdrawCheckQuery () {}

    public UserWithdrawCheckQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, String fundsWithdrawTransactionNo, Long fundsWithdrawAmount, Long fundsWithdrawAmountMin, Long fundsWithdrawAmountMax, Long fundsWithdrawBankcardId, Long fundsWithdrawBankcardIdMin, Long fundsWithdrawBankcardIdMax, Date fundsWithdrawCompleteTime, Date fundsWithdrawCompleteTimeMin, Date fundsWithdrawCompleteTimeMax, Byte fundsWithdrawCheckWithdrawStatus, Byte fundsWithdrawCheckWithdrawStatusMin, Byte fundsWithdrawCheckWithdrawStatusMax, String fundsWithdrawCheckWithdrawDescription, Long fundsWithdrawCheckCheckedUserId, Long fundsWithdrawCheckCheckedUserIdMin, Long fundsWithdrawCheckCheckedUserIdMax, Date fundsWithdrawCheckCreateTime, Date fundsWithdrawCheckCreateTimeMin, Date fundsWithdrawCheckCreateTimeMax) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.fundsWithdrawTransactionNo = fundsWithdrawTransactionNo;
		this.fundsWithdrawAmount = fundsWithdrawAmount;
		this.fundsWithdrawAmountMin = fundsWithdrawAmountMin;
		this.fundsWithdrawAmountMax = fundsWithdrawAmountMax;
		this.fundsWithdrawBankcardId = fundsWithdrawBankcardId;
		this.fundsWithdrawBankcardIdMin = fundsWithdrawBankcardIdMin;
		this.fundsWithdrawBankcardIdMax = fundsWithdrawBankcardIdMax;
		this.fundsWithdrawCompleteTime = fundsWithdrawCompleteTime;
		this.fundsWithdrawCompleteTimeMin = fundsWithdrawCompleteTimeMin;
		this.fundsWithdrawCompleteTimeMax = fundsWithdrawCompleteTimeMax;
		this.fundsWithdrawCheckWithdrawStatus = fundsWithdrawCheckWithdrawStatus;
		this.fundsWithdrawCheckWithdrawStatusMin = fundsWithdrawCheckWithdrawStatusMin;
		this.fundsWithdrawCheckWithdrawStatusMax = fundsWithdrawCheckWithdrawStatusMax;
		this.fundsWithdrawCheckWithdrawDescription = fundsWithdrawCheckWithdrawDescription;
		this.fundsWithdrawCheckCheckedUserId = fundsWithdrawCheckCheckedUserId;
		this.fundsWithdrawCheckCheckedUserIdMin = fundsWithdrawCheckCheckedUserIdMin;
		this.fundsWithdrawCheckCheckedUserIdMax = fundsWithdrawCheckCheckedUserIdMax;
		this.fundsWithdrawCheckCreateTime = fundsWithdrawCheckCreateTime;
		this.fundsWithdrawCheckCreateTimeMin = fundsWithdrawCheckCreateTimeMin;
		this.fundsWithdrawCheckCreateTimeMax = fundsWithdrawCheckCreateTimeMax;
		
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
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

	public Long getFundsWithdrawAmountMin() {
		return fundsWithdrawAmountMin;
	}

	public void setFundsWithdrawAmountMin(Long fundsWithdrawAmountMin) {
		this.fundsWithdrawAmountMin = fundsWithdrawAmountMin;
	}

	public Long getFundsWithdrawAmountMax() {
		return fundsWithdrawAmountMax;
	}

	public void setFundsWithdrawAmountMax(Long fundsWithdrawAmountMax) {
		this.fundsWithdrawAmountMax = fundsWithdrawAmountMax;
	}

	public Long getFundsWithdrawBankcardId() {
		return fundsWithdrawBankcardId;
	}

	public void setFundsWithdrawBankcardId(Long fundsWithdrawBankcardId) {
		this.fundsWithdrawBankcardId = fundsWithdrawBankcardId;
	}

	public Long getFundsWithdrawBankcardIdMin() {
		return fundsWithdrawBankcardIdMin;
	}

	public void setFundsWithdrawBankcardIdMin(Long fundsWithdrawBankcardIdMin) {
		this.fundsWithdrawBankcardIdMin = fundsWithdrawBankcardIdMin;
	}

	public Long getFundsWithdrawBankcardIdMax() {
		return fundsWithdrawBankcardIdMax;
	}

	public void setFundsWithdrawBankcardIdMax(Long fundsWithdrawBankcardIdMax) {
		this.fundsWithdrawBankcardIdMax = fundsWithdrawBankcardIdMax;
	}

	public Date getFundsWithdrawCompleteTime() {
		return fundsWithdrawCompleteTime;
	}

	public void setFundsWithdrawCompleteTime(Date fundsWithdrawCompleteTime) {
		this.fundsWithdrawCompleteTime = fundsWithdrawCompleteTime;
	}

	public Date getFundsWithdrawCompleteTimeMin() {
		return fundsWithdrawCompleteTimeMin;
	}

	public void setFundsWithdrawCompleteTimeMin(Date fundsWithdrawCompleteTimeMin) {
		this.fundsWithdrawCompleteTimeMin = fundsWithdrawCompleteTimeMin;
	}

	public Date getFundsWithdrawCompleteTimeMax() {
		return fundsWithdrawCompleteTimeMax;
	}

	public void setFundsWithdrawCompleteTimeMax(Date fundsWithdrawCompleteTimeMax) {
		this.fundsWithdrawCompleteTimeMax = fundsWithdrawCompleteTimeMax;
	}

	public Byte getFundsWithdrawCheckWithdrawStatus() {
		return fundsWithdrawCheckWithdrawStatus;
	}

	public void setFundsWithdrawCheckWithdrawStatus(Byte fundsWithdrawCheckWithdrawStatus) {
		this.fundsWithdrawCheckWithdrawStatus = fundsWithdrawCheckWithdrawStatus;
	}

	public Byte getFundsWithdrawCheckWithdrawStatusMin() {
		return fundsWithdrawCheckWithdrawStatusMin;
	}

	public void setFundsWithdrawCheckWithdrawStatusMin(Byte fundsWithdrawCheckWithdrawStatusMin) {
		this.fundsWithdrawCheckWithdrawStatusMin = fundsWithdrawCheckWithdrawStatusMin;
	}

	public Byte getFundsWithdrawCheckWithdrawStatusMax() {
		return fundsWithdrawCheckWithdrawStatusMax;
	}

	public void setFundsWithdrawCheckWithdrawStatusMax(Byte fundsWithdrawCheckWithdrawStatusMax) {
		this.fundsWithdrawCheckWithdrawStatusMax = fundsWithdrawCheckWithdrawStatusMax;
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

	public Long getFundsWithdrawCheckCheckedUserIdMin() {
		return fundsWithdrawCheckCheckedUserIdMin;
	}

	public void setFundsWithdrawCheckCheckedUserIdMin(Long fundsWithdrawCheckCheckedUserIdMin) {
		this.fundsWithdrawCheckCheckedUserIdMin = fundsWithdrawCheckCheckedUserIdMin;
	}

	public Long getFundsWithdrawCheckCheckedUserIdMax() {
		return fundsWithdrawCheckCheckedUserIdMax;
	}

	public void setFundsWithdrawCheckCheckedUserIdMax(Long fundsWithdrawCheckCheckedUserIdMax) {
		this.fundsWithdrawCheckCheckedUserIdMax = fundsWithdrawCheckCheckedUserIdMax;
	}

	public Date getFundsWithdrawCheckCreateTime() {
		return fundsWithdrawCheckCreateTime;
	}

	public void setFundsWithdrawCheckCreateTime(Date fundsWithdrawCheckCreateTime) {
		this.fundsWithdrawCheckCreateTime = fundsWithdrawCheckCreateTime;
	}

	public Date getFundsWithdrawCheckCreateTimeMin() {
		return fundsWithdrawCheckCreateTimeMin;
	}

	public void setFundsWithdrawCheckCreateTimeMin(Date fundsWithdrawCheckCreateTimeMin) {
		this.fundsWithdrawCheckCreateTimeMin = fundsWithdrawCheckCreateTimeMin;
	}

	public Date getFundsWithdrawCheckCreateTimeMax() {
		return fundsWithdrawCheckCreateTimeMax;
	}

	public void setFundsWithdrawCheckCreateTimeMax(Date fundsWithdrawCheckCreateTimeMax) {
		this.fundsWithdrawCheckCreateTimeMax = fundsWithdrawCheckCreateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserWithdrawCheckQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", fundsWithdrawTransactionNo = " + fundsWithdrawTransactionNo + 
				", fundsWithdrawAmount = " + fundsWithdrawAmount + 
				", fundsWithdrawAmountMin = " + fundsWithdrawAmountMin + 
				", fundsWithdrawAmountMax = " + fundsWithdrawAmountMax + 
				", fundsWithdrawBankcardId = " + fundsWithdrawBankcardId + 
				", fundsWithdrawBankcardIdMin = " + fundsWithdrawBankcardIdMin + 
				", fundsWithdrawBankcardIdMax = " + fundsWithdrawBankcardIdMax + 
				", fundsWithdrawCompleteTime = " + fundsWithdrawCompleteTime + 
				", fundsWithdrawCompleteTimeMin = " + fundsWithdrawCompleteTimeMin + 
				", fundsWithdrawCompleteTimeMax = " + fundsWithdrawCompleteTimeMax + 
				", fundsWithdrawCheckWithdrawStatus = " + fundsWithdrawCheckWithdrawStatus + 
				", fundsWithdrawCheckWithdrawStatusMin = " + fundsWithdrawCheckWithdrawStatusMin + 
				", fundsWithdrawCheckWithdrawStatusMax = " + fundsWithdrawCheckWithdrawStatusMax + 
				", fundsWithdrawCheckWithdrawDescription = " + fundsWithdrawCheckWithdrawDescription + 
				", fundsWithdrawCheckCheckedUserId = " + fundsWithdrawCheckCheckedUserId + 
				", fundsWithdrawCheckCheckedUserIdMin = " + fundsWithdrawCheckCheckedUserIdMin + 
				", fundsWithdrawCheckCheckedUserIdMax = " + fundsWithdrawCheckCheckedUserIdMax + 
				", fundsWithdrawCheckCreateTime = " + fundsWithdrawCheckCreateTime + 
				", fundsWithdrawCheckCreateTimeMin = " + fundsWithdrawCheckCreateTimeMin + 
				", fundsWithdrawCheckCreateTimeMax = " + fundsWithdrawCheckCreateTimeMax + 
				" }";
    }

}
