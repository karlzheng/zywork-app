package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserSocialQuery查询对象类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserSocialQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035074690324L;

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
	//t_user_social表的字段对应的属性
	// 第三方登录OAuth openid
	private String userSocialOpenid;
	// 第三方登录OAuth unionid
	private String userSocialUnionId;
	// 刷新Token
	private String userSocialRefreshToken;
	// 第三方登录类型
	private String userSocialSocialType;
	// 第三方登录绑定时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTime;
	// 第三方登录绑定时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTimeMin;
	// 第三方登录绑定时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTimeMax;
	
    public UserUserSocialQuery () {}

    public UserUserSocialQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, String userSocialOpenid, String userSocialUnionId, String userSocialRefreshToken, String userSocialSocialType, Date userSocialCreateTime, Date userSocialCreateTimeMin, Date userSocialCreateTimeMax) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userSocialOpenid = userSocialOpenid;
		this.userSocialUnionId = userSocialUnionId;
		this.userSocialRefreshToken = userSocialRefreshToken;
		this.userSocialSocialType = userSocialSocialType;
		this.userSocialCreateTime = userSocialCreateTime;
		this.userSocialCreateTimeMin = userSocialCreateTimeMin;
		this.userSocialCreateTimeMax = userSocialCreateTimeMax;
		
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

	public String getUserSocialOpenid() {
		return userSocialOpenid;
	}

	public void setUserSocialOpenid(String userSocialOpenid) {
		this.userSocialOpenid = userSocialOpenid;
	}

	public String getUserSocialUnionId() {
		return userSocialUnionId;
	}

	public void setUserSocialUnionId(String userSocialUnionId) {
		this.userSocialUnionId = userSocialUnionId;
	}

	public String getUserSocialRefreshToken() {
		return userSocialRefreshToken;
	}

	public void setUserSocialRefreshToken(String userSocialRefreshToken) {
		this.userSocialRefreshToken = userSocialRefreshToken;
	}

	public String getUserSocialSocialType() {
		return userSocialSocialType;
	}

	public void setUserSocialSocialType(String userSocialSocialType) {
		this.userSocialSocialType = userSocialSocialType;
	}

	public Date getUserSocialCreateTime() {
		return userSocialCreateTime;
	}

	public void setUserSocialCreateTime(Date userSocialCreateTime) {
		this.userSocialCreateTime = userSocialCreateTime;
	}

	public Date getUserSocialCreateTimeMin() {
		return userSocialCreateTimeMin;
	}

	public void setUserSocialCreateTimeMin(Date userSocialCreateTimeMin) {
		this.userSocialCreateTimeMin = userSocialCreateTimeMin;
	}

	public Date getUserSocialCreateTimeMax() {
		return userSocialCreateTimeMax;
	}

	public void setUserSocialCreateTimeMax(Date userSocialCreateTimeMax) {
		this.userSocialCreateTimeMax = userSocialCreateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserUserSocialQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userSocialOpenid = " + userSocialOpenid + 
				", userSocialUnionId = " + userSocialUnionId + 
				", userSocialRefreshToken = " + userSocialRefreshToken + 
				", userSocialSocialType = " + userSocialSocialType + 
				", userSocialCreateTime = " + userSocialCreateTime + 
				", userSocialCreateTimeMin = " + userSocialCreateTimeMin + 
				", userSocialCreateTimeMax = " + userSocialCreateTimeMax + 
				" }";
    }

}
