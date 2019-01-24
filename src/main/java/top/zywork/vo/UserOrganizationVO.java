package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserOrganizationVO值对象类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserOrganizationVO extends BaseVO {

    private static final long serialVersionUID = -9223372035044578376L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String userPhone;
	// 用户邮箱
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userEmail;
	//t_organization表的字段对应的属性
	// 组织编号
	@NotNull(message = "此项是必须项")
	private Long organizationId;
	// 组织名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String organizationTitle;
	// 组织描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String organizationDescription;
	//t_user_organization表的字段对应的属性
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationCreateTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationUpdateTime;
	
    public UserOrganizationVO () {}

    public UserOrganizationVO (Long userId, String userPhone, String userEmail, Long organizationId, String organizationTitle, String organizationDescription, Date userOrganizationCreateTime, Date userOrganizationUpdateTime) {
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
        return "UserOrganizationVO {" +
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
