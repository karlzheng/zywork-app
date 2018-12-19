package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserRoleDO数据对象实体类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserRoleDO extends BaseDO {

    private static final long serialVersionUID = -9223372036362915987L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_role表的字段对应的属性
	// 角色标题
	private String roleTitle;
	// 角色描述
	private String roleDescription;
	//t_user_role表的字段对应的属性
	// 创建时间
	private Date userRoleCreateTime;
	
    public UserRoleDO () {}

    public UserRoleDO (Long userId, String userPhone, String userEmail, String roleTitle, String roleDescription, Date userRoleCreateTime) {
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
        return "UserRoleDO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", roleTitle = " + roleTitle + 
				", roleDescription = " + roleDescription + 
				", userRoleCreateTime = " + userRoleCreateTime + 
				" }";
    }

}
