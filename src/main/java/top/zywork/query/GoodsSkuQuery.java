package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsSkuQuery查询对象类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsSkuQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036078726166L;

    // SKU编号
	private Long id;
	// SKU编号（最小值）
	private Long idMin;
	// SKU编号（最大值）
	private Long idMax;
	// 商品编号
	private Long goodsId;
	// 商品编号（最小值）
	private Long goodsIdMin;
	// 商品编号（最大值）
	private Long goodsIdMax;
	// 商品图片编号
	private Long picId;
	// 商品图片编号（最小值）
	private Long picIdMin;
	// 商品图片编号（最大值）
	private Long picIdMax;
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
	
    public GoodsSkuQuery () {}

    public GoodsSkuQuery (Long id, Long idMin, Long idMax, Long goodsId, Long goodsIdMin, Long goodsIdMax, Long picId, Long picIdMin, Long picIdMax, Byte shelfStatus, Byte shelfStatusMin, Byte shelfStatusMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.goodsId = goodsId;
		this.goodsIdMin = goodsIdMin;
		this.goodsIdMax = goodsIdMax;
		this.picId = picId;
		this.picIdMin = picIdMin;
		this.picIdMax = picIdMax;
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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsIdMin() {
		return goodsIdMin;
	}

	public void setGoodsIdMin(Long goodsIdMin) {
		this.goodsIdMin = goodsIdMin;
	}

	public Long getGoodsIdMax() {
		return goodsIdMax;
	}

	public void setGoodsIdMax(Long goodsIdMax) {
		this.goodsIdMax = goodsIdMax;
	}

	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public Long getPicIdMin() {
		return picIdMin;
	}

	public void setPicIdMin(Long picIdMin) {
		this.picIdMin = picIdMin;
	}

	public Long getPicIdMax() {
		return picIdMax;
	}

	public void setPicIdMax(Long picIdMax) {
		this.picIdMax = picIdMax;
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
        return "GoodsSkuQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", goodsId = " + goodsId + 
				", goodsIdMin = " + goodsIdMin + 
				", goodsIdMax = " + goodsIdMax + 
				", picId = " + picId + 
				", picIdMin = " + picIdMin + 
				", picIdMax = " + picIdMax + 
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
