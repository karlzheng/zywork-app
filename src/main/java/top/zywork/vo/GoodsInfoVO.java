package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsInfoVO值对象类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsInfoVO extends BaseVO {

    private static final long serialVersionUID = -9223372035380074106L;

    // 商品编号
	private Long id;
	// 店铺编号
	@NotNull(message = "此项是必须项")
	private Long shopId;
	// 类目编号
	@NotNull(message = "此项是必须项")
	private Long categoryId;
	// 图文详情
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 65535, message = "必须是1-65535个字符")
	private String intro;
	// 上架状态
	private Byte shelfStatus;
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
	
    public GoodsInfoVO () {}

    public GoodsInfoVO (Long id, Long shopId, Long categoryId, String intro, Byte shelfStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
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
        return "GoodsInfoVO {" +
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
