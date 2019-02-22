package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsShopQuery查询对象类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036069442949L;

    // 店铺编号
	private Long id;
	// 店铺编号（最小值）
	private Long idMin;
	// 店铺编号（最大值）
	private Long idMax;
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 类目编号
	private Long categoryId;
	// 类目编号（最小值）
	private Long categoryIdMin;
	// 类目编号（最大值）
	private Long categoryIdMax;
	// 主体类型
	private Byte subjectType;
	// 主体类型（最小值）
	private Byte subjectTypeMin;
	// 主体类型（最大值）
	private Byte subjectTypeMax;
	// 店铺Logo
	private String logo;
	// 店铺标题
	private String title;
	// 店铺简介
	private String intro;
	// 店铺等级
	private Byte level;
	// 店铺等级（最小值）
	private Byte levelMin;
	// 店铺等级（最大值）
	private Byte levelMax;
	// 审核状态
	private Byte checkStatus;
	// 审核状态（最小值）
	private Byte checkStatusMin;
	// 审核状态（最大值）
	private Byte checkStatusMax;
	// 审核描述
	private String checkDescription;
	// 审核人编号
	private Byte checkedUserId;
	// 审核人编号（最小值）
	private Byte checkedUserIdMin;
	// 审核人编号（最大值）
	private Byte checkedUserIdMax;
	// 审核时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTime;
	// 审核时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTimeMin;
	// 审核时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checkedTimeMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public GoodsShopQuery () {}

    public GoodsShopQuery (Long id, Long idMin, Long idMax, Long userId, Long userIdMin, Long userIdMax, Long categoryId, Long categoryIdMin, Long categoryIdMax, Byte subjectType, Byte subjectTypeMin, Byte subjectTypeMax, String logo, String title, String intro, Byte level, Byte levelMin, Byte levelMax, Byte checkStatus, Byte checkStatusMin, Byte checkStatusMax, String checkDescription, Byte checkedUserId, Byte checkedUserIdMin, Byte checkedUserIdMax, Date checkedTime, Date checkedTimeMin, Date checkedTimeMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.categoryId = categoryId;
		this.categoryIdMin = categoryIdMin;
		this.categoryIdMax = categoryIdMax;
		this.subjectType = subjectType;
		this.subjectTypeMin = subjectTypeMin;
		this.subjectTypeMax = subjectTypeMax;
		this.logo = logo;
		this.title = title;
		this.intro = intro;
		this.level = level;
		this.levelMin = levelMin;
		this.levelMax = levelMax;
		this.checkStatus = checkStatus;
		this.checkStatusMin = checkStatusMin;
		this.checkStatusMax = checkStatusMax;
		this.checkDescription = checkDescription;
		this.checkedUserId = checkedUserId;
		this.checkedUserIdMin = checkedUserIdMin;
		this.checkedUserIdMax = checkedUserIdMax;
		this.checkedTime = checkedTime;
		this.checkedTimeMin = checkedTimeMin;
		this.checkedTimeMax = checkedTimeMax;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategoryIdMin() {
		return categoryIdMin;
	}

	public void setCategoryIdMin(Long categoryIdMin) {
		this.categoryIdMin = categoryIdMin;
	}

	public Long getCategoryIdMax() {
		return categoryIdMax;
	}

	public void setCategoryIdMax(Long categoryIdMax) {
		this.categoryIdMax = categoryIdMax;
	}

	public Byte getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Byte subjectType) {
		this.subjectType = subjectType;
	}

	public Byte getSubjectTypeMin() {
		return subjectTypeMin;
	}

	public void setSubjectTypeMin(Byte subjectTypeMin) {
		this.subjectTypeMin = subjectTypeMin;
	}

	public Byte getSubjectTypeMax() {
		return subjectTypeMax;
	}

	public void setSubjectTypeMax(Byte subjectTypeMax) {
		this.subjectTypeMax = subjectTypeMax;
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

	public Byte getLevelMin() {
		return levelMin;
	}

	public void setLevelMin(Byte levelMin) {
		this.levelMin = levelMin;
	}

	public Byte getLevelMax() {
		return levelMax;
	}

	public void setLevelMax(Byte levelMax) {
		this.levelMax = levelMax;
	}

	public Byte getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Byte checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Byte getCheckStatusMin() {
		return checkStatusMin;
	}

	public void setCheckStatusMin(Byte checkStatusMin) {
		this.checkStatusMin = checkStatusMin;
	}

	public Byte getCheckStatusMax() {
		return checkStatusMax;
	}

	public void setCheckStatusMax(Byte checkStatusMax) {
		this.checkStatusMax = checkStatusMax;
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

	public Byte getCheckedUserIdMin() {
		return checkedUserIdMin;
	}

	public void setCheckedUserIdMin(Byte checkedUserIdMin) {
		this.checkedUserIdMin = checkedUserIdMin;
	}

	public Byte getCheckedUserIdMax() {
		return checkedUserIdMax;
	}

	public void setCheckedUserIdMax(Byte checkedUserIdMax) {
		this.checkedUserIdMax = checkedUserIdMax;
	}

	public Date getCheckedTime() {
		return checkedTime;
	}

	public void setCheckedTime(Date checkedTime) {
		this.checkedTime = checkedTime;
	}

	public Date getCheckedTimeMin() {
		return checkedTimeMin;
	}

	public void setCheckedTimeMin(Date checkedTimeMin) {
		this.checkedTimeMin = checkedTimeMin;
	}

	public Date getCheckedTimeMax() {
		return checkedTimeMax;
	}

	public void setCheckedTimeMax(Date checkedTimeMax) {
		this.checkedTimeMax = checkedTimeMax;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "GoodsShopQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", categoryId = " + categoryId + 
				", categoryIdMin = " + categoryIdMin + 
				", categoryIdMax = " + categoryIdMax + 
				", subjectType = " + subjectType + 
				", subjectTypeMin = " + subjectTypeMin + 
				", subjectTypeMax = " + subjectTypeMax + 
				", logo = " + logo + 
				", title = " + title + 
				", intro = " + intro + 
				", level = " + level + 
				", levelMin = " + levelMin + 
				", levelMax = " + levelMax + 
				", checkStatus = " + checkStatus + 
				", checkStatusMin = " + checkStatusMin + 
				", checkStatusMax = " + checkStatusMax + 
				", checkDescription = " + checkDescription + 
				", checkedUserId = " + checkedUserId + 
				", checkedUserIdMin = " + checkedUserIdMin + 
				", checkedUserIdMax = " + checkedUserIdMax + 
				", checkedTime = " + checkedTime + 
				", checkedTimeMin = " + checkedTimeMin + 
				", checkedTimeMax = " + checkedTimeMax + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
