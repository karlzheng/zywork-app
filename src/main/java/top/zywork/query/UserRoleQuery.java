package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserRoleQuery查询对象类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserRoleQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036025832235L;

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
	//t_role表的字段对应的属性
	// 角色编号
	private Long roleId;
	// 角色编号（最小值）
	private Long roleIdMin;
	// 角色编号（最大值）
	private Long roleIdMax;
	// 角色标题
	private String roleTitle;
	// 角色描述
	private String roleDescription;
	//t_user_role表的字段对应的属性
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userRoleCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userRoleCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userRoleCreateTimeMax;
	
    public UserRoleQuery () {}

    public UserRoleQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, Long roleId, Long roleIdMin, Long roleIdMax, String roleTitle, String roleDescription, Date userRoleCreateTime, Date userRoleCreateTimeMin, Date userRoleCreateTimeMax) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.roleId = roleId;
		this.roleIdMin = roleIdMin;
		this.roleIdMax = roleIdMax;
		this.roleTitle = roleTitle;
		this.roleDescription = roleDescription;
		this.userRoleCreateTime = userRoleCreateTime;
		this.userRoleCreateTimeMin = userRoleCreateTimeMin;
		this.userRoleCreateTimeMax = userRoleCreateTimeMax;
		
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRoleIdMin() {
		return roleIdMin;
	}

	public void setRoleIdMin(Long roleIdMin) {
		this.roleIdMin = roleIdMin;
	}

	public Long getRoleIdMax() {
		return roleIdMax;
	}

	public void setRoleIdMax(Long roleIdMax) {
		this.roleIdMax = roleIdMax;
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

	public Date getUserRoleCreateTimeMin() {
		return userRoleCreateTimeMin;
	}

	public void setUserRoleCreateTimeMin(Date userRoleCreateTimeMin) {
		this.userRoleCreateTimeMin = userRoleCreateTimeMin;
	}

	public Date getUserRoleCreateTimeMax() {
		return userRoleCreateTimeMax;
	}

	public void setUserRoleCreateTimeMax(Date userRoleCreateTimeMax) {
		this.userRoleCreateTimeMax = userRoleCreateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserRoleQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", roleId = " + roleId + 
				", roleIdMin = " + roleIdMin + 
				", roleIdMax = " + roleIdMax + 
				", roleTitle = " + roleTitle + 
				", roleDescription = " + roleDescription + 
				", userRoleCreateTime = " + userRoleCreateTime + 
				", userRoleCreateTimeMin = " + userRoleCreateTimeMin + 
				", userRoleCreateTimeMax = " + userRoleCreateTimeMax + 
				" }";
    }

}
