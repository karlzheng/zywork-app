package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsInfoDO数据对象实体类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsInfoDO extends BaseDO {

    private static final long serialVersionUID = -9223372035854765249L;

    // 商品编号
	private Long id;
	// 店铺编号
	private Long shopId;
	// 类目编号
	private Long categoryId;
	// 图文详情
	private String intro;
	// 上架状态
	private Byte shelfStatus;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsInfoDO () {}

    public GoodsInfoDO (Long id, Long shopId, Long categoryId, String intro, Byte shelfStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.shopId = shopId;
		this.categoryId = categoryId;
		this.intro = intro;
		this.shelfStatus = shelfStatus;
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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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
        return "GoodsInfoDO {" +
                "id = " + id + 
				", shopId = " + shopId + 
				", categoryId = " + categoryId + 
				", intro = " + intro + 
				", shelfStatus = " + shelfStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
