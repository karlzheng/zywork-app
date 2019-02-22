package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsShopCertificationCheckVO值对象类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsShopCertificationCheckVO extends BaseVO {

    private static final long serialVersionUID = -9223372035829657941L;

    //t_goods_shop_check表的字段对应的属性
	// 店铺审核编号
	@NotNull(message = "此项是必须项")
	private Long goodsShopCheckId;
	// 审核状态
	private Byte goodsShopCheckCheckStatus;
	// 审核描述
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String goodsShopCheckCheckDescription;
	// 审核人编号
	private Byte goodsShopCheckCheckedUserId;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsShopCheckCreateTime;
	//t_goods_shop表的字段对应的属性
	// 店铺编号
	private Long goodsShopId;
	// 类目编号
	@NotNull(message = "此项是必须项")
	private Long goodsShopCategoryId;
	// 主体类型
	@NotNull(message = "此项是必须项")
	private Byte goodsShopSubjectType;
	//t_goods_shop_certification表的字段对应的属性
	// 店铺认证编号
	@NotNull(message = "此项是必须项")
	private Long goodsShopCertificationId;
	// 认证详情JSON
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 1000, message = "必须是1-1000个字符")
	private String goodsShopCertificationDetail;
	
    public GoodsShopCertificationCheckVO () {}

    public GoodsShopCertificationCheckVO (Long goodsShopCheckId, Byte goodsShopCheckCheckStatus, String goodsShopCheckCheckDescription, Byte goodsShopCheckCheckedUserId, Date goodsShopCheckCreateTime, Long goodsShopId, Long goodsShopCategoryId, Byte goodsShopSubjectType, Long goodsShopCertificationId, String goodsShopCertificationDetail) {
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
        return "GoodsShopCertificationCheckVO {" +
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
