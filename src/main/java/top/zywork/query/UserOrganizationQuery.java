package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserOrganizationQuery查询对象类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserOrganizationQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035957908492L;

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
	//t_organization表的字段对应的属性
	// 组织编号
	private Long organizationId;
	// 组织编号（最小值）
	private Long organizationIdMin;
	// 组织编号（最大值）
	private Long organizationIdMax;
	// 组织名称
	private String organizationTitle;
	// 组织描述
	private String organizationDescription;
	//t_user_organization表的字段对应的属性
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userOrganizationUpdateTimeMax;
	
    public UserOrganizationQuery () {}

    public UserOrganizationQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, Long organizationId, Long organizationIdMin, Long organizationIdMax, String organizationTitle, String organizationDescription, Date userOrganizationCreateTime, Date userOrganizationCreateTimeMin, Date userOrganizationCreateTimeMax, Date userOrganizationUpdateTime, Date userOrganizationUpdateTimeMin, Date userOrganizationUpdateTimeMax) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.organizationId = organizationId;
		this.organizationIdMin = organizationIdMin;
		this.organizationIdMax = organizationIdMax;
		this.organizationTitle = organizationTitle;
		this.organizationDescription = organizationDescription;
		this.userOrganizationCreateTime = userOrganizationCreateTime;
		this.userOrganizationCreateTimeMin = userOrganizationCreateTimeMin;
		this.userOrganizationCreateTimeMax = userOrganizationCreateTimeMax;
		this.userOrganizationUpdateTime = userOrganizationUpdateTime;
		this.userOrganizationUpdateTimeMin = userOrganizationUpdateTimeMin;
		this.userOrganizationUpdateTimeMax = userOrganizationUpdateTimeMax;
		
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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getOrganizationIdMin() {
		return organizationIdMin;
	}

	public void setOrganizationIdMin(Long organizationIdMin) {
		this.organizationIdMin = organizationIdMin;
	}

	public Long getOrganizationIdMax() {
		return organizationIdMax;
	}

	public void setOrganizationIdMax(Long organizationIdMax) {
		this.organizationIdMax = organizationIdMax;
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

	public Date getUserOrganizationCreateTimeMin() {
		return userOrganizationCreateTimeMin;
	}

	public void setUserOrganizationCreateTimeMin(Date userOrganizationCreateTimeMin) {
		this.userOrganizationCreateTimeMin = userOrganizationCreateTimeMin;
	}

	public Date getUserOrganizationCreateTimeMax() {
		return userOrganizationCreateTimeMax;
	}

	public void setUserOrganizationCreateTimeMax(Date userOrganizationCreateTimeMax) {
		this.userOrganizationCreateTimeMax = userOrganizationCreateTimeMax;
	}

	public Date getUserOrganizationUpdateTime() {
		return userOrganizationUpdateTime;
	}

	public void setUserOrganizationUpdateTime(Date userOrganizationUpdateTime) {
		this.userOrganizationUpdateTime = userOrganizationUpdateTime;
	}

	public Date getUserOrganizationUpdateTimeMin() {
		return userOrganizationUpdateTimeMin;
	}

	public void setUserOrganizationUpdateTimeMin(Date userOrganizationUpdateTimeMin) {
		this.userOrganizationUpdateTimeMin = userOrganizationUpdateTimeMin;
	}

	public Date getUserOrganizationUpdateTimeMax() {
		return userOrganizationUpdateTimeMax;
	}

	public void setUserOrganizationUpdateTimeMax(Date userOrganizationUpdateTimeMax) {
		this.userOrganizationUpdateTimeMax = userOrganizationUpdateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserOrganizationQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", organizationId = " + organizationId + 
				", organizationIdMin = " + organizationIdMin + 
				", organizationIdMax = " + organizationIdMax + 
				", organizationTitle = " + organizationTitle + 
				", organizationDescription = " + organizationDescription + 
				", userOrganizationCreateTime = " + userOrganizationCreateTime + 
				", userOrganizationCreateTimeMin = " + userOrganizationCreateTimeMin + 
				", userOrganizationCreateTimeMax = " + userOrganizationCreateTimeMax + 
				", userOrganizationUpdateTime = " + userOrganizationUpdateTime + 
				", userOrganizationUpdateTimeMin = " + userOrganizationUpdateTimeMin + 
				", userOrganizationUpdateTimeMax = " + userOrganizationUpdateTimeMax + 
				" }";
    }

}
