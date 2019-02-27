package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsShopCertificationCheckQuery查询对象类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopCertificationCheckQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035303731930L;

    //t_goods_shop_check表的字段对应的属性
	// 店铺审核编号
	private Long goodsShopCheckId;
	// 店铺审核编号（最小值）
	private Long goodsShopCheckIdMin;
	// 店铺审核编号（最大值）
	private Long goodsShopCheckIdMax;
	// 审核状态
	private Byte goodsShopCheckCheckStatus;
	// 审核状态（最小值）
	private Byte goodsShopCheckCheckStatusMin;
	// 审核状态（最大值）
	private Byte goodsShopCheckCheckStatusMax;
	// 审核描述
	private String goodsShopCheckCheckDescription;
	// 审核人编号
	private Byte goodsShopCheckCheckedUserId;
	// 审核人编号（最小值）
	private Byte goodsShopCheckCheckedUserIdMin;
	// 审核人编号（最大值）
	private Byte goodsShopCheckCheckedUserIdMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsShopCheckCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsShopCheckCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsShopCheckCreateTimeMax;
	//t_goods_shop表的字段对应的属性
	// 店铺编号
	private Long goodsShopId;
	// 店铺编号（最小值）
	private Long goodsShopIdMin;
	// 店铺编号（最大值）
	private Long goodsShopIdMax;
	// 类目编号
	private Long goodsShopCategoryId;
	// 类目编号（最小值）
	private Long goodsShopCategoryIdMin;
	// 类目编号（最大值）
	private Long goodsShopCategoryIdMax;
	// 主体类型
	private Byte goodsShopSubjectType;
	// 主体类型（最小值）
	private Byte goodsShopSubjectTypeMin;
	// 主体类型（最大值）
	private Byte goodsShopSubjectTypeMax;
	// 店铺Logo
	private String goodsShopLogo;
	// 店铺标题
	private String goodsShopTitle;
	//t_goods_shop_certification表的字段对应的属性
	// 认证详情JSON
	private String goodsShopCertificationDetail;
	
    public GoodsShopCertificationCheckQuery () {}

    public GoodsShopCertificationCheckQuery (Long goodsShopCheckId, Long goodsShopCheckIdMin, Long goodsShopCheckIdMax, Byte goodsShopCheckCheckStatus, Byte goodsShopCheckCheckStatusMin, Byte goodsShopCheckCheckStatusMax, String goodsShopCheckCheckDescription, Byte goodsShopCheckCheckedUserId, Byte goodsShopCheckCheckedUserIdMin, Byte goodsShopCheckCheckedUserIdMax, Date goodsShopCheckCreateTime, Date goodsShopCheckCreateTimeMin, Date goodsShopCheckCreateTimeMax, Long goodsShopId, Long goodsShopIdMin, Long goodsShopIdMax, Long goodsShopCategoryId, Long goodsShopCategoryIdMin, Long goodsShopCategoryIdMax, Byte goodsShopSubjectType, Byte goodsShopSubjectTypeMin, Byte goodsShopSubjectTypeMax, String goodsShopLogo, String goodsShopTitle, String goodsShopCertificationDetail) {
        this.goodsShopCheckId = goodsShopCheckId;
		this.goodsShopCheckIdMin = goodsShopCheckIdMin;
		this.goodsShopCheckIdMax = goodsShopCheckIdMax;
		this.goodsShopCheckCheckStatus = goodsShopCheckCheckStatus;
		this.goodsShopCheckCheckStatusMin = goodsShopCheckCheckStatusMin;
		this.goodsShopCheckCheckStatusMax = goodsShopCheckCheckStatusMax;
		this.goodsShopCheckCheckDescription = goodsShopCheckCheckDescription;
		this.goodsShopCheckCheckedUserId = goodsShopCheckCheckedUserId;
		this.goodsShopCheckCheckedUserIdMin = goodsShopCheckCheckedUserIdMin;
		this.goodsShopCheckCheckedUserIdMax = goodsShopCheckCheckedUserIdMax;
		this.goodsShopCheckCreateTime = goodsShopCheckCreateTime;
		this.goodsShopCheckCreateTimeMin = goodsShopCheckCreateTimeMin;
		this.goodsShopCheckCreateTimeMax = goodsShopCheckCreateTimeMax;
		this.goodsShopId = goodsShopId;
		this.goodsShopIdMin = goodsShopIdMin;
		this.goodsShopIdMax = goodsShopIdMax;
		this.goodsShopCategoryId = goodsShopCategoryId;
		this.goodsShopCategoryIdMin = goodsShopCategoryIdMin;
		this.goodsShopCategoryIdMax = goodsShopCategoryIdMax;
		this.goodsShopSubjectType = goodsShopSubjectType;
		this.goodsShopSubjectTypeMin = goodsShopSubjectTypeMin;
		this.goodsShopSubjectTypeMax = goodsShopSubjectTypeMax;
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

	public Long getGoodsShopCheckIdMin() {
		return goodsShopCheckIdMin;
	}

	public void setGoodsShopCheckIdMin(Long goodsShopCheckIdMin) {
		this.goodsShopCheckIdMin = goodsShopCheckIdMin;
	}

	public Long getGoodsShopCheckIdMax() {
		return goodsShopCheckIdMax;
	}

	public void setGoodsShopCheckIdMax(Long goodsShopCheckIdMax) {
		this.goodsShopCheckIdMax = goodsShopCheckIdMax;
	}

	public Byte getGoodsShopCheckCheckStatus() {
		return goodsShopCheckCheckStatus;
	}

	public void setGoodsShopCheckCheckStatus(Byte goodsShopCheckCheckStatus) {
		this.goodsShopCheckCheckStatus = goodsShopCheckCheckStatus;
	}

	public Byte getGoodsShopCheckCheckStatusMin() {
		return goodsShopCheckCheckStatusMin;
	}

	public void setGoodsShopCheckCheckStatusMin(Byte goodsShopCheckCheckStatusMin) {
		this.goodsShopCheckCheckStatusMin = goodsShopCheckCheckStatusMin;
	}

	public Byte getGoodsShopCheckCheckStatusMax() {
		return goodsShopCheckCheckStatusMax;
	}

	public void setGoodsShopCheckCheckStatusMax(Byte goodsShopCheckCheckStatusMax) {
		this.goodsShopCheckCheckStatusMax = goodsShopCheckCheckStatusMax;
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

	public Byte getGoodsShopCheckCheckedUserIdMin() {
		return goodsShopCheckCheckedUserIdMin;
	}

	public void setGoodsShopCheckCheckedUserIdMin(Byte goodsShopCheckCheckedUserIdMin) {
		this.goodsShopCheckCheckedUserIdMin = goodsShopCheckCheckedUserIdMin;
	}

	public Byte getGoodsShopCheckCheckedUserIdMax() {
		return goodsShopCheckCheckedUserIdMax;
	}

	public void setGoodsShopCheckCheckedUserIdMax(Byte goodsShopCheckCheckedUserIdMax) {
		this.goodsShopCheckCheckedUserIdMax = goodsShopCheckCheckedUserIdMax;
	}

	public Date getGoodsShopCheckCreateTime() {
		return goodsShopCheckCreateTime;
	}

	public void setGoodsShopCheckCreateTime(Date goodsShopCheckCreateTime) {
		this.goodsShopCheckCreateTime = goodsShopCheckCreateTime;
	}

	public Date getGoodsShopCheckCreateTimeMin() {
		return goodsShopCheckCreateTimeMin;
	}

	public void setGoodsShopCheckCreateTimeMin(Date goodsShopCheckCreateTimeMin) {
		this.goodsShopCheckCreateTimeMin = goodsShopCheckCreateTimeMin;
	}

	public Date getGoodsShopCheckCreateTimeMax() {
		return goodsShopCheckCreateTimeMax;
	}

	public void setGoodsShopCheckCreateTimeMax(Date goodsShopCheckCreateTimeMax) {
		this.goodsShopCheckCreateTimeMax = goodsShopCheckCreateTimeMax;
	}

	public Long getGoodsShopId() {
		return goodsShopId;
	}

	public void setGoodsShopId(Long goodsShopId) {
		this.goodsShopId = goodsShopId;
	}

	public Long getGoodsShopIdMin() {
		return goodsShopIdMin;
	}

	public void setGoodsShopIdMin(Long goodsShopIdMin) {
		this.goodsShopIdMin = goodsShopIdMin;
	}

	public Long getGoodsShopIdMax() {
		return goodsShopIdMax;
	}

	public void setGoodsShopIdMax(Long goodsShopIdMax) {
		this.goodsShopIdMax = goodsShopIdMax;
	}

	public Long getGoodsShopCategoryId() {
		return goodsShopCategoryId;
	}

	public void setGoodsShopCategoryId(Long goodsShopCategoryId) {
		this.goodsShopCategoryId = goodsShopCategoryId;
	}

	public Long getGoodsShopCategoryIdMin() {
		return goodsShopCategoryIdMin;
	}

	public void setGoodsShopCategoryIdMin(Long goodsShopCategoryIdMin) {
		this.goodsShopCategoryIdMin = goodsShopCategoryIdMin;
	}

	public Long getGoodsShopCategoryIdMax() {
		return goodsShopCategoryIdMax;
	}

	public void setGoodsShopCategoryIdMax(Long goodsShopCategoryIdMax) {
		this.goodsShopCategoryIdMax = goodsShopCategoryIdMax;
	}

	public Byte getGoodsShopSubjectType() {
		return goodsShopSubjectType;
	}

	public void setGoodsShopSubjectType(Byte goodsShopSubjectType) {
		this.goodsShopSubjectType = goodsShopSubjectType;
	}

	public Byte getGoodsShopSubjectTypeMin() {
		return goodsShopSubjectTypeMin;
	}

	public void setGoodsShopSubjectTypeMin(Byte goodsShopSubjectTypeMin) {
		this.goodsShopSubjectTypeMin = goodsShopSubjectTypeMin;
	}

	public Byte getGoodsShopSubjectTypeMax() {
		return goodsShopSubjectTypeMax;
	}

	public void setGoodsShopSubjectTypeMax(Byte goodsShopSubjectTypeMax) {
		this.goodsShopSubjectTypeMax = goodsShopSubjectTypeMax;
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
        return "GoodsShopCertificationCheckQuery {" +
                "goodsShopCheckId = " + goodsShopCheckId + 
				", goodsShopCheckIdMin = " + goodsShopCheckIdMin + 
				", goodsShopCheckIdMax = " + goodsShopCheckIdMax + 
				", goodsShopCheckCheckStatus = " + goodsShopCheckCheckStatus + 
				", goodsShopCheckCheckStatusMin = " + goodsShopCheckCheckStatusMin + 
				", goodsShopCheckCheckStatusMax = " + goodsShopCheckCheckStatusMax + 
				", goodsShopCheckCheckDescription = " + goodsShopCheckCheckDescription + 
				", goodsShopCheckCheckedUserId = " + goodsShopCheckCheckedUserId + 
				", goodsShopCheckCheckedUserIdMin = " + goodsShopCheckCheckedUserIdMin + 
				", goodsShopCheckCheckedUserIdMax = " + goodsShopCheckCheckedUserIdMax + 
				", goodsShopCheckCreateTime = " + goodsShopCheckCreateTime + 
				", goodsShopCheckCreateTimeMin = " + goodsShopCheckCreateTimeMin + 
				", goodsShopCheckCreateTimeMax = " + goodsShopCheckCreateTimeMax + 
				", goodsShopId = " + goodsShopId + 
				", goodsShopIdMin = " + goodsShopIdMin + 
				", goodsShopIdMax = " + goodsShopIdMax + 
				", goodsShopCategoryId = " + goodsShopCategoryId + 
				", goodsShopCategoryIdMin = " + goodsShopCategoryIdMin + 
				", goodsShopCategoryIdMax = " + goodsShopCategoryIdMax + 
				", goodsShopSubjectType = " + goodsShopSubjectType + 
				", goodsShopSubjectTypeMin = " + goodsShopSubjectTypeMin + 
				", goodsShopSubjectTypeMax = " + goodsShopSubjectTypeMax + 
				", goodsShopLogo = " + goodsShopLogo + 
				", goodsShopTitle = " + goodsShopTitle + 
				", goodsShopCertificationDetail = " + goodsShopCertificationDetail + 
				" }";
    }

}
