package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsPicDO数据对象实体类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsPicDO extends BaseDO {

    private static final long serialVersionUID = -9223372035825436698L;

    // 商品图片编号
	private Long id;
	// 商品编号
	private Long goodsId;
	// 图片URL
	private String picUrl;
	// 图片顺序
	private Integer picOrder;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsPicDO () {}

    public GoodsPicDO (Long id, Long goodsId, String picUrl, Integer picOrder, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.goodsId = goodsId;
		this.picUrl = picUrl;
		this.picOrder = picOrder;
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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getPicOrder() {
		return picOrder;
	}

	public void setPicOrder(Integer picOrder) {
		this.picOrder = picOrder;
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
        return "GoodsPicDO {" +
                "id = " + id + 
				", goodsId = " + goodsId + 
				", picUrl = " + picUrl + 
				", picOrder = " + picOrder + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
