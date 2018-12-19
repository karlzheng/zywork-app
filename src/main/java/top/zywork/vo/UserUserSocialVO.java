package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserSocialVO值对象类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserSocialVO extends BaseVO {

    private static final long serialVersionUID = -9223372036154611898L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String userPhone;
	// 用户邮箱
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userEmail;
	//t_user_social表的字段对应的属性
	// 第三方登录OAuth openid
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String userSocialOpenid;
	// 第三方登录OAuth unionid
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String userSocialUnionId;
	// 刷新Token
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String userSocialRefreshToken;
	// 第三方登录类型
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userSocialSocialType;
	// 第三方登录绑定时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userSocialCreateTime;
	
    public UserUserSocialVO () {}

    public UserUserSocialVO (Long userId, String userPhone, String userEmail, String userSocialOpenid, String userSocialUnionId, String userSocialRefreshToken, String userSocialSocialType, Date userSocialCreateTime) {
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
        return "UserUserSocialVO {" +
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
