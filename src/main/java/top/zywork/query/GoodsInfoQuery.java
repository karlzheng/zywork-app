package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsInfoQuery查询对象类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsInfoQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035790645271L;

    // 商品编号
	private Long id;
	// 商品编号（最小值）
	private Long idMin;
	// 商品编号（最大值）
	private Long idMax;
	// 店铺编号
	private Long shopId;
	// 店铺编号（最小值）
	private Long shopIdMin;
	// 店铺编号（最大值）
	private Long shopIdMax;
	// 类目编号
	private Long categoryId;
	// 类目编号（最小值）
	private Long categoryIdMin;
	// 类目编号（最大值）
	private Long categoryIdMax;
	// 图文详情
	private String intro;
	// 上架状态
	private Byte shelfStatus;
	// 上架状态（最小值）
	private Byte shelfStatusMin;
	// 上架状态（最大值）
	private Byte shelfStatusMax;
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
	
    public GoodsInfoQuery () {}

    public GoodsInfoQuery (Long id, Long idMin, Long idMax, Long shopId, Long shopIdMin, Long shopIdMax, Long categoryId, Long categoryIdMin, Long categoryIdMax, String intro, Byte shelfStatus, Byte shelfStatusMin, Byte shelfStatusMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.shopId = shopId;
		this.shopIdMin = shopIdMin;
		this.shopIdMax = shopIdMax;
		this.categoryId = categoryId;
		this.categoryIdMin = categoryIdMin;
		this.categoryIdMax = categoryIdMax;
		this.intro = intro;
		this.shelfStatus = shelfStatus;
		this.shelfStatusMin = shelfStatusMin;
		this.shelfStatusMax = shelfStatusMax;
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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopIdMin() {
		return shopIdMin;
	}

	public void setShopIdMin(Long shopIdMin) {
		this.shopIdMin = shopIdMin;
	}

	public Long getShopIdMax() {
		return shopIdMax;
	}

	public void setShopIdMax(Long shopIdMax) {
		this.shopIdMax = shopIdMax;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Byte getShelfStatus() {
		return shelfStatus;
	}

	public void setShelfStatus(Byte shelfStatus) {
		this.shelfStatus = shelfStatus;
	}

	public Byte getShelfStatusMin() {
		return shelfStatusMin;
	}

	public void setShelfStatusMin(Byte shelfStatusMin) {
		this.shelfStatusMin = shelfStatusMin;
	}

	public Byte getShelfStatusMax() {
		return shelfStatusMax;
	}

	public void setShelfStatusMax(Byte shelfStatusMax) {
		this.shelfStatusMax = shelfStatusMax;
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
        return "GoodsInfoQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", shopId = " + shopId + 
				", shopIdMin = " + shopIdMin + 
				", shopIdMax = " + shopIdMax + 
				", categoryId = " + categoryId + 
				", categoryIdMin = " + categoryIdMin + 
				", categoryIdMax = " + categoryIdMax + 
				", intro = " + intro + 
				", shelfStatus = " + shelfStatus + 
				", shelfStatusMin = " + shelfStatusMin + 
				", shelfStatusMax = " + shelfStatusMax + 
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
