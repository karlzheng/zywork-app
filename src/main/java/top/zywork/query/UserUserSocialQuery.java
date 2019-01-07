package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserSocialQuery查询对象类<br/>
 *
 * 创建于2019-01-07<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserSocialQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035332036999L;

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
	// 第三方登录编号
	private Long userSocialId;
	// 第三方登录编号（最小值）
	private Long userSocialIdMin;
	// 第三方登录编号（最大值）
	private Long userSocialIdMax;
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
	// 版本号（最小值）
	private Integer userSocialVersionMin;
	// 版本号（最大值）
	private Integer userSocialVersionMax;
	// 第三方登录绑定时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTime;
	// 第三方登录绑定时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTimeMin;
	// 第三方登录绑定时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialUpdateTimeMax;
	
    public UserUserSocialQuery () {}

    public UserUserSocialQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, Long userSocialId, Long userSocialIdMin, Long userSocialIdMax, String userSocialOpenid, String userSocialUnionId, String userSocialAccessToken, String userSocialSessionKey, String userSocialRefreshToken, String userSocialSocialType, Integer userSocialVersion, Integer userSocialVersionMin, Integer userSocialVersionMax, Date userSocialCreateTime, Date userSocialCreateTimeMin, Date userSocialCreateTimeMax, Date userSocialUpdateTime, Date userSocialUpdateTimeMin, Date userSocialUpdateTimeMax) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userSocialId = userSocialId;
		this.userSocialIdMin = userSocialIdMin;
		this.userSocialIdMax = userSocialIdMax;
		this.userSocialOpenid = userSocialOpenid;
		this.userSocialUnionId = userSocialUnionId;
		this.userSocialAccessToken = userSocialAccessToken;
		this.userSocialSessionKey = userSocialSessionKey;
		this.userSocialRefreshToken = userSocialRefreshToken;
		this.userSocialSocialType = userSocialSocialType;
		this.userSocialVersion = userSocialVersion;
		this.userSocialVersionMin = userSocialVersionMin;
		this.userSocialVersionMax = userSocialVersionMax;
		this.userSocialCreateTime = userSocialCreateTime;
		this.userSocialCreateTimeMin = userSocialCreateTimeMin;
		this.userSocialCreateTimeMax = userSocialCreateTimeMax;
		this.userSocialUpdateTime = userSocialUpdateTime;
		this.userSocialUpdateTimeMin = userSocialUpdateTimeMin;
		this.userSocialUpdateTimeMax = userSocialUpdateTimeMax;
		
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

	public Long getUserSocialId() {
		return userSocialId;
	}

	public void setUserSocialId(Long userSocialId) {
		this.userSocialId = userSocialId;
	}

	public Long getUserSocialIdMin() {
		return userSocialIdMin;
	}

	public void setUserSocialIdMin(Long userSocialIdMin) {
		this.userSocialIdMin = userSocialIdMin;
	}

	public Long getUserSocialIdMax() {
		return userSocialIdMax;
	}

	public void setUserSocialIdMax(Long userSocialIdMax) {
		this.userSocialIdMax = userSocialIdMax;
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

	public Integer getUserSocialVersionMin() {
		return userSocialVersionMin;
	}

	public void setUserSocialVersionMin(Integer userSocialVersionMin) {
		this.userSocialVersionMin = userSocialVersionMin;
	}

	public Integer getUserSocialVersionMax() {
		return userSocialVersionMax;
	}

	public void setUserSocialVersionMax(Integer userSocialVersionMax) {
		this.userSocialVersionMax = userSocialVersionMax;
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

	public Date getUserSocialUpdateTime() {
		return userSocialUpdateTime;
	}

	public void setUserSocialUpdateTime(Date userSocialUpdateTime) {
		this.userSocialUpdateTime = userSocialUpdateTime;
	}

	public Date getUserSocialUpdateTimeMin() {
		return userSocialUpdateTimeMin;
	}

	public void setUserSocialUpdateTimeMin(Date userSocialUpdateTimeMin) {
		this.userSocialUpdateTimeMin = userSocialUpdateTimeMin;
	}

	public Date getUserSocialUpdateTimeMax() {
		return userSocialUpdateTimeMax;
	}

	public void setUserSocialUpdateTimeMax(Date userSocialUpdateTimeMax) {
		this.userSocialUpdateTimeMax = userSocialUpdateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserUserSocialQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userSocialId = " + userSocialId + 
				", userSocialIdMin = " + userSocialIdMin + 
				", userSocialIdMax = " + userSocialIdMax + 
				", userSocialOpenid = " + userSocialOpenid + 
				", userSocialUnionId = " + userSocialUnionId + 
				", userSocialAccessToken = " + userSocialAccessToken + 
				", userSocialSessionKey = " + userSocialSessionKey + 
				", userSocialRefreshToken = " + userSocialRefreshToken + 
				", userSocialSocialType = " + userSocialSocialType + 
				", userSocialVersion = " + userSocialVersion + 
				", userSocialVersionMin = " + userSocialVersionMin + 
				", userSocialVersionMax = " + userSocialVersionMax + 
				", userSocialCreateTime = " + userSocialCreateTime + 
				", userSocialCreateTimeMin = " + userSocialCreateTimeMin + 
				", userSocialCreateTimeMax = " + userSocialCreateTimeMax + 
				", userSocialUpdateTime = " + userSocialUpdateTime + 
				", userSocialUpdateTimeMin = " + userSocialUpdateTimeMin + 
				", userSocialUpdateTimeMax = " + userSocialUpdateTimeMax + 
				" }";
    }

}
