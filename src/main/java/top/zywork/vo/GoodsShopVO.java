package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsShopVO值对象类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopVO extends BaseVO {

    private static final long serialVersionUID = -9223372035055839364L;

    // 店铺编号
	private Long id;
	// 用户编号
	@NotNull(message = "此项是必须项")
	private Long userId;
	// 类目编号
	@NotNull(message = "此项是必须项")
	private Long categoryId;
	// 主体类型
	@NotNull(message = "此项是必须项")
	private Byte subjectType;
	// 店铺Logo
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String logo;
	// 店铺标题
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String title;
	// 店铺简介
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String intro;
	// 店铺等级
	private Byte level;
	// 审核状态
	private Byte checkStatus;
	// 审核描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String checkDescription;
	// 审核人编号
	private Byte checkedUserId;
	// 审核时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTime;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsShopVO () {}

    public GoodsShopVO (Long id, Long userId, Long categoryId, Byte subjectType, String logo, String title, String intro, Byte level, Byte checkStatus, String checkDescription, Byte checkedUserId, Date checkedTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.categoryId = categoryId;
		this.subjectType = subjectType;
		this.logo = logo;
		this.title = title;
		this.intro = intro;
		this.level = level;
		this.checkStatus = checkStatus;
		this.checkDescription = checkDescription;
		this.checkedUserId = checkedUserId;
		this.checkedTime = checkedTime;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Byte getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Byte subjectType) {
		this.subjectType = subjectType;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Byte getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Byte checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckDescription() {
		return checkDescription;
	}

	public void setCheckDescription(String checkDescription) {
		this.checkDescription = checkDescription;
	}

	public Byte getCheckedUserId() {
		return checkedUserId;
	}

	public void setCheckedUserId(Byte checkedUserId) {
		this.checkedUserId = checkedUserId;
	}

	public Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "GoodsShopVO {" +
                "id = " + id + 
				", userId = " + userId + 
				", categoryId = " + categoryId + 
				", subjectType = " + subjectType + 
				", logo = " + logo + 
				", title = " + title + 
				", intro = " + intro + 
				", level = " + level + 
				", checkStatus = " + checkStatus + 
				", checkDescription = " + checkDescription + 
				", checkedUserId = " + checkedUserId + 
				", checkedTime = " + checkedTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
