package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsShopCertificationCheckDTO数据传输对象类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopCertificationCheckDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372034972395405L;

    //t_goods_shop_check表的字段对应的属性
	// 店铺审核编号
	private Long goodsShopCheckId;
	// 审核状态
	private Byte goodsShopCheckCheckStatus;
	// 审核描述
	private String goodsShopCheckCheckDescription;
	// 审核人编号
	private Byte goodsShopCheckCheckedUserId;
	// 创建时间
	private Date goodsShopCheckCreateTime;
	//t_goods_shop表的字段对应的属性
	// 店铺编号
	private Long goodsShopId;
	// 类目编号
	private Long goodsShopCategoryId;
	// 主体类型
	private Byte goodsShopSubjectType;
	// 店铺Logo
	private String goodsShopLogo;
	// 店铺标题
	private String goodsShopTitle;
	//t_goods_shop_certification表的字段对应的属性
	// 认证详情JSON
	private String goodsShopCertificationDetail;
	
    public GoodsShopCertificationCheckDTO () {}

    public GoodsShopCertificationCheckDTO (Long goodsShopCheckId, Byte goodsShopCheckCheckStatus, String goodsShopCheckCheckDescription, Byte goodsShopCheckCheckedUserId, Date goodsShopCheckCreateTime, Long goodsShopId, Long goodsShopCategoryId, Byte goodsShopSubjectType, String goodsShopLogo, String goodsShopTitle, String goodsShopCertificationDetail) {
        this.goodsShopCheckId = goodsShopCheckId;
		this.goodsShopCheckCheckStatus = goodsShopCheckCheckStatus;
		this.goodsShopCheckCheckDescription = goodsShopCheckCheckDescription;
		this.goodsShopCheckCheckedUserId = goodsShopCheckCheckedUserId;
		this.goodsShopCheckCreateTime = goodsShopCheckCreateTime;
		this.goodsShopId = goodsShopId;
		this.goodsShopCategoryId = goodsShopCategoryId;
		this.goodsShopSubjectType = goodsShopSubjectType;
		this.goodsShopLogo = goodsShopLogo;
		this.goodsShopTitle = goodsShopTitle;
		this.goodsShopCertificationDetail = goodsShopCertificationDetail;
		
    }

    public Long getGoodsShopCheckId() {
		return goodsShopCheckId;
	}

	public void setGoodsShopCheckId(Long goodsShopCheckId) {
		this.goodsShopCheckId = goodsShopCheckId;
	}

	public Byte getGoodsShopCheckCheckStatus() {
		return goodsShopCheckCheckStatus;
	}

	public void setGoodsShopCheckCheckStatus(Byte goodsShopCheckCheckStatus) {
		this.goodsShopCheckCheckStatus = goodsShopCheckCheckStatus;
	}

	public String getGoodsShopCheckCheckDescription() {
		return goodsShopCheckCheckDescription;
	}

	public void setGoodsShopCheckCheckDescription(String goodsShopCheckCheckDescription) {
		this.goodsShopCheckCheckDescription = goodsShopCheckCheckDescription;
	}

	public Byte getGoodsShopCheckCheckedUserId() {
		return goodsShopCheckCheckedUserId;
	}

	public void setGoodsShopCheckCheckedUserId(Byte goodsShopCheckCheckedUserId) {
		this.goodsShopCheckCheckedUserId = goodsShopCheckCheckedUserId;
	}

	public Date getGoodsShopCheckCreateTime() {
		return goodsShopCheckCreateTime;
	}

	public void setGoodsShopCheckCreateTime(Date goodsShopCheckCreateTime) {
		this.goodsShopCheckCreateTime = goodsShopCheckCreateTime;
	}

	public Long getGoodsShopId() {
		return goodsShopId;
	}

	public void setGoodsShopId(Long goodsShopId) {
		this.goodsShopId = goodsShopId;
	}

	public Long getGoodsShopCategoryId() {
		return goodsShopCategoryId;
	}

	public void setGoodsShopCategoryId(Long goodsShopCategoryId) {
		this.goodsShopCategoryId = goodsShopCategoryId;
	}

	public Byte getGoodsShopSubjectType() {
		return goodsShopSubjectType;
	}

	public void setGoodsShopSubjectType(Byte goodsShopSubjectType) {
		this.goodsShopSubjectType = goodsShopSubjectType;
	}

	public String getGoodsShopLogo() {
		return goodsShopLogo;
	}

	public void setGoodsShopLogo(String goodsShopLogo) {
		this.goodsShopLogo = goodsShopLogo;
	}

	public String getGoodsShopTitle() {
		return goodsShopTitle;
	}

	public void setGoodsShopTitle(String goodsShopTitle) {
		this.goodsShopTitle = goodsShopTitle;
	}

	public String getGoodsShopCertificationDetail() {
		return goodsShopCertificationDetail;
	}

	public void setGoodsShopCertificationDetail(String goodsShopCertificationDetail) {
		this.goodsShopCertificationDetail = goodsShopCertificationDetail;
	}

	
    @Override
    public String toString() {
        return "GoodsShopCertificationCheckDTO {" +
                "goodsShopCheckId = " + goodsShopCheckId + 
				", goodsShopCheckCheckStatus = " + goodsShopCheckCheckStatus + 
				", goodsShopCheckCheckDescription = " + goodsShopCheckCheckDescription + 
				", goodsShopCheckCheckedUserId = " + goodsShopCheckCheckedUserId + 
				", goodsShopCheckCreateTime = " + goodsShopCheckCreateTime + 
				", goodsShopId = " + goodsShopId + 
				", goodsShopCategoryId = " + goodsShopCategoryId + 
				", goodsShopSubjectType = " + goodsShopSubjectType + 
				", goodsShopLogo = " + goodsShopLogo + 
				", goodsShopTitle = " + goodsShopTitle + 
				", goodsShopCertificationDetail = " + goodsShopCertificationDetail + 
				" }";
    }

}
