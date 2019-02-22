package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsShopCertificationCheckDO数据对象实体类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopCertificationCheckDO extends BaseDO {

    private static final long serialVersionUID = -9223372035722262330L;

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
	//t_goods_shop_certification表的字段对应的属性
	// 店铺认证编号
	private Long goodsShopCertificationId;
	// 认证详情JSON
	private String goodsShopCertificationDetail;
	
    public GoodsShopCertificationCheckDO () {}

    public GoodsShopCertificationCheckDO (Long goodsShopCheckId, Byte goodsShopCheckCheckStatus, String goodsShopCheckCheckDescription, Byte goodsShopCheckCheckedUserId, Date goodsShopCheckCreateTime, Long goodsShopId, Long goodsShopCategoryId, Byte goodsShopSubjectType, Long goodsShopCertificationId, String goodsShopCertificationDetail) {
        this.goodsShopCheckId = goodsShopCheckId;
		this.goodsShopCheckCheckStatus = goodsShopCheckCheckStatus;
		this.goodsShopCheckCheckDescription = goodsShopCheckCheckDescription;
		this.goodsShopCheckCheckedUserId = goodsShopCheckCheckedUserId;
		this.goodsShopCheckCreateTime = goodsShopCheckCreateTime;
		this.goodsShopId = goodsShopId;
		this.goodsShopCategoryId = goodsShopCategoryId;
		this.goodsShopSubjectType = goodsShopSubjectType;
		this.goodsShopCertificationId = goodsShopCertificationId;
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

	public Long getGoodsShopCertificationId() {
		return goodsShopCertificationId;
	}

	public void setGoodsShopCertificationId(Long goodsShopCertificationId) {
		this.goodsShopCertificationId = goodsShopCertificationId;
	}

	public String getGoodsShopCertificationDetail() {
		return goodsShopCertificationDetail;
	}

	public void setGoodsShopCertificationDetail(String goodsShopCertificationDetail) {
		this.goodsShopCertificationDetail = goodsShopCertificationDetail;
	}

	
    @Override
    public String toString() {
        return "GoodsShopCertificationCheckDO {" +
                "goodsShopCheckId = " + goodsShopCheckId + 
				", goodsShopCheckCheckStatus = " + goodsShopCheckCheckStatus + 
				", goodsShopCheckCheckDescription = " + goodsShopCheckCheckDescription + 
				", goodsShopCheckCheckedUserId = " + goodsShopCheckCheckedUserId + 
				", goodsShopCheckCreateTime = " + goodsShopCheckCreateTime + 
				", goodsShopId = " + goodsShopId + 
				", goodsShopCategoryId = " + goodsShopCategoryId + 
				", goodsShopSubjectType = " + goodsShopSubjectType + 
				", goodsShopCertificationId = " + goodsShopCertificationId + 
				", goodsShopCertificationDetail = " + goodsShopCertificationDetail + 
				" }";
    }

}
