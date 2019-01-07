package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserSocialDO数据对象实体类<br/>
 *
 * 创建于2019-01-07<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserSocialDO extends BaseDO {

    private static final long serialVersionUID = -9223372035276694181L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_user_social表的字段对应的属性
	// 第三方登录编号
	private Long userSocialId;
	// openid
	private String userSocialOpenid;
	// unionid
	private String userSocialUnionId;
	// AccessToken
	private String userSocialAccessToken;
	// SessionKey
	private String userSocialSessionKey;
	// 刷新Token
	private String userSocialRefreshToken;
	// 第三方登录类型
	private String userSocialSocialType;
	// 版本号
	private Integer userSocialVersion;
	// 第三方登录绑定时间
	private Date userSocialCreateTime;
	// 更新时间
	private Date userSocialUpdateTime;
	
    public UserUserSocialDO () {}

    public UserUserSocialDO (Long userId, String userPhone, String userEmail, Long userSocialId, String userSocialOpenid, String userSocialUnionId, String userSocialAccessToken, String userSocialSessionKey, String userSocialRefreshToken, String userSocialSocialType, Integer userSocialVersion, Date userSocialCreateTime, Date userSocialUpdateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userSocialId = userSocialId;
		this.userSocialOpenid = userSocialOpenid;
		this.userSocialUnionId = userSocialUnionId;
		this.userSocialAccessToken = userSocialAccessToken;
		this.userSocialSessionKey = userSocialSessionKey;
		this.userSocialRefreshToken = userSocialRefreshToken;
		this.userSocialSocialType = userSocialSocialType;
		this.userSocialVersion = userSocialVersion;
		this.userSocialCreateTime = userSocialCreateTime;
		this.userSocialUpdateTime = userSocialUpdateTime;
		
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

	public Long getUserSocialId() {
		return userSocialId;
	}

	public void setUserSocialId(Long userSocialId) {
		this.userSocialId = userSocialId;
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

	public String getUserSocialAccessToken() {
		return userSocialAccessToken;
	}

	public void setUserSocialAccessToken(String userSocialAccessToken) {
		this.userSocialAccessToken = userSocialAccessToken;
	}

	public String getUserSocialSessionKey() {
		return userSocialSessionKey;
	}

	public void setUserSocialSessionKey(String userSocialSessionKey) {
		this.userSocialSessionKey = userSocialSessionKey;
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

	public Integer getUserSocialVersion() {
		return userSocialVersion;
	}

	public void setUserSocialVersion(Integer userSocialVersion) {
		this.userSocialVersion = userSocialVersion;
	}

	public Date getUserSocialCreateTime() {
		return userSocialCreateTime;
	}

	public void setUserSocialCreateTime(Date userSocialCreateTime) {
		this.userSocialCreateTime = userSocialCreateTime;
	}

	public Date getUserSocialUpdateTime() {
		return userSocialUpdateTime;
	}

	public void setUserSocialUpdateTime(Date userSocialUpdateTime) {
		this.userSocialUpdateTime = userSocialUpdateTime;
	}

	
    @Override
    public String toString() {
        return "UserUserSocialDO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userSocialId = " + userSocialId + 
				", userSocialOpenid = " + userSocialOpenid + 
				", userSocialUnionId = " + userSocialUnionId + 
				", userSocialAccessToken = " + userSocialAccessToken + 
				", userSocialSessionKey = " + userSocialSessionKey + 
				", userSocialRefreshToken = " + userSocialRefreshToken + 
				", userSocialSocialType = " + userSocialSocialType + 
				", userSocialVersion = " + userSocialVersion + 
				", userSocialCreateTime = " + userSocialCreateTime + 
				", userSocialUpdateTime = " + userSocialUpdateTime + 
				" }";
    }

}
