package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserRoleVO值对象类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserRoleVO extends BaseVO {

    private static final long serialVersionUID = -9223372034922732841L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String userPhone;
	// 用户邮箱
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userEmail;
	//t_role表的字段对应的属性
	// 角色标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String roleTitle;
	// 角色描述
	@Size(min = 0, max = 200, message = "必须小于200个字符")
	private String roleDescription;
	//t_user_role表的字段对应的属性
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userRoleCreateTime;
	
    public UserRoleVO () {}

    public UserRoleVO (Long userId, String userPhone, String userEmail, String roleTitle, String roleDescription, Date userRoleCreateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.roleTitle = roleTitle;
		this.roleDescription = roleDescription;
		this.userRoleCreateTime = userRoleCreateTime;
		
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

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Date getUserRoleCreateTime() {
		return userRoleCreateTime;
	}

	public void setUserRoleCreateTime(Date userRoleCreateTime) {
		this.userRoleCreateTime = userRoleCreateTime;
	}

	
    @Override
    public String toString() {
        return "UserRoleVO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", roleTitle = " + roleTitle + 
				", roleDescription = " + roleDescription + 
				", userRoleCreateTime = " + userRoleCreateTime + 
				" }";
    }

}