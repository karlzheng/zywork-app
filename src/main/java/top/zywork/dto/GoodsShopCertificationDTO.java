package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsShopCertificationDTO数据传输对象类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopCertificationDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372034999387837L;

    // 店铺认证编号
	private Long id;
	// 店铺编号
	private Long shopId;
	// 认证详情JSON
	private String detail;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsShopCertificationDTO () {}

    public GoodsShopCertificationDTO (Long id, Long shopId, String detail, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.shopId = shopId;
		this.detail = detail;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
        return "GoodsShopCertificationDTO {" +
                "id = " + id + 
				", shopId = " + shopId + 
				", detail = " + detail + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
