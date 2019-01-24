package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserOrganizationDTO数据传输对象类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserOrganizationDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036215747690L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_organization表的字段对应的属性
	// 组织编号
	private Long organizationId;
	// 组织名称
	private String organizationTitle;
	// 组织描述
	private String organizationDescription;
	//t_user_organization表的字段对应的属性
	// 创建时间
	private Date userOrganizationCreateTime;
	// 更新时间
	private Date userOrganizationUpdateTime;
	
    public UserOrganizationDTO () {}

    public UserOrganizationDTO (Long userId, String userPhone, String userEmail, Long organizationId, String organizationTitle, String organizationDescription, Date userOrganizationCreateTime, Date userOrganizationUpdateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.organizationId = organizationId;
		this.organizationTitle = organizationTitle;
		this.organizationDescription = organizationDescription;
		this.userOrganizationCreateTime = userOrganizationCreateTime;
		this.userOrganizationUpdateTime = userOrganizationUpdateTime;
		
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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationTitle() {
		return organizationTitle;
	}

	public void setOrganizationTitle(String organizationTitle) {
		this.organizationTitle = organizationTitle;
	}

	public String getOrganizationDescription() {
		return organizationDescription;
	}

	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}

	public Date getUserOrganizationCreateTime() {
		return userOrganizationCreateTime;
	}

	public void setUserOrganizationCreateTime(Date userOrganizationCreateTime) {
		this.userOrganizationCreateTime = userOrganizationCreateTime;
	}

	public Date getUserOrganizationUpdateTime() {
		return userOrganizationUpdateTime;
	}

	public void setUserOrganizationUpdateTime(Date userOrganizationUpdateTime) {
		this.userOrganizationUpdateTime = userOrganizationUpdateTime;
	}

	
    @Override
    public String toString() {
        return "UserOrganizationDTO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", organizationId = " + organizationId + 
				", organizationTitle = " + organizationTitle + 
				", organizationDescription = " + organizationDescription + 
				", userOrganizationCreateTime = " + userOrganizationCreateTime + 
				", userOrganizationUpdateTime = " + userOrganizationUpdateTime + 
				" }";
    }

}
