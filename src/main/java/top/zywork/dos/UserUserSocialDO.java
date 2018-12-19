package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserSocialDO数据对象实体类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserSocialDO extends BaseDO {

    private static final long serialVersionUID = -9223372035572483324L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
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
	private Date userSocialCreateTime;
	
    public UserUserSocialDO () {}

    public UserUserSocialDO (Long userId, String userPhone, String userEmail, String userSocialOpenid, String userSocialUnionId, String userSocialRefreshToken, String userSocialSocialType, Date userSocialCreateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userSocialOpenid = userSocialOpenid;
		this.userSocialUnionId = userSocialUnionId;
		this.userSocialRefreshToken = userSocialRefreshToken;
		this.userSocialSocialType = userSocialSocialType;
		this.userSocialCreateTime = userSocialCreateTime;
		
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

	
    @Override
    public String toString() {
        return "UserUserSocialDO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userSocialOpenid = " + userSocialOpenid + 
				", userSocialUnionId = " + userSocialUnionId + 
				", userSocialRefreshToken = " + userSocialRefreshToken + 
				", userSocialSocialType = " + userSocialSocialType + 
				", userSocialCreateTime = " + userSocialCreateTime + 
				" }";
    }

}
