package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserGoodsCartQuery查询对象类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsCartQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036554524228L;

    //t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	//t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 用户编号（最小值）
	private Long userIdMin;
	// 用户编号（最大值）
	private Long userIdMax;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_goods_sku表的字段对应的属性
	// SKU编号
	private Long goodsSkuId;
	// SKU编号（最小值）
	private Long goodsSkuIdMin;
	// SKU编号（最大值）
	private Long goodsSkuIdMax;
	// 商品编号
	private Long goodsSkuGoodsId;
	// 商品编号（最小值）
	private Long goodsSkuGoodsIdMin;
	// 商品编号（最大值）
	private Long goodsSkuGoodsIdMax;
	//t_goods_pic表的字段对应的属性
	// 图片URL
	private String goodsPicPicUrl;
	//t_goods_cart表的字段对应的属性
	// 购买数量
	private Integer goodsCartQuantity;
	// 购买数量（最小值）
	private Integer goodsCartQuantityMin;
	// 购买数量（最大值）
	private Integer goodsCartQuantityMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCartCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCartCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCartCreateTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCartUpdateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCartUpdateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCartUpdateTimeMax;
	
    public UserGoodsCartQuery () {}

    public UserGoodsCartQuery (String userDetailNickname, String userDetailHeadicon, Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, Long goodsSkuId, Long goodsSkuIdMin, Long goodsSkuIdMax, Long goodsSkuGoodsId, Long goodsSkuGoodsIdMin, Long goodsSkuGoodsIdMax, String goodsPicPicUrl, Integer goodsCartQuantity, Integer goodsCartQuantityMin, Integer goodsCartQuantityMax, Date goodsCartCreateTime, Date goodsCartCreateTimeMin, Date goodsCartCreateTimeMax, Date goodsCartUpdateTime, Date goodsCartUpdateTimeMin, Date goodsCartUpdateTimeMax) {
        this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.goodsSkuId = goodsSkuId;
		this.goodsSkuIdMin = goodsSkuIdMin;
		this.goodsSkuIdMax = goodsSkuIdMax;
		this.goodsSkuGoodsId = goodsSkuGoodsId;
		this.goodsSkuGoodsIdMin = goodsSkuGoodsIdMin;
		this.goodsSkuGoodsIdMax = goodsSkuGoodsIdMax;
		this.goodsPicPicUrl = goodsPicPicUrl;
		this.goodsCartQuantity = goodsCartQuantity;
		this.goodsCartQuantityMin = goodsCartQuantityMin;
		this.goodsCartQuantityMax = goodsCartQuantityMax;
		this.goodsCartCreateTime = goodsCartCreateTime;
		this.goodsCartCreateTimeMin = goodsCartCreateTimeMin;
		this.goodsCartCreateTimeMax = goodsCartCreateTimeMax;
		this.goodsCartUpdateTime = goodsCartUpdateTime;
		this.goodsCartUpdateTimeMin = goodsCartUpdateTimeMin;
		this.goodsCartUpdateTimeMax = goodsCartUpdateTimeMax;
		
    }

    public String getUserDetailNickname() {
		return userDetailNickname;
	}

	public void setUserDetailNickname(String userDetailNickname) {
		this.userDetailNickname = userDetailNickname;
	}

	public String getUserDetailHeadicon() {
		return userDetailHeadicon;
	}

	public void setUserDetailHeadicon(String userDetailHeadicon) {
		this.userDetailHeadicon = userDetailHeadicon;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdMin() {
		return userIdMin;
	}

	public void setUserIdMin(Long userIdMin) {
		this.userIdMin = userIdMin;
	}

	public Long getUserIdMax() {
		return userIdMax;
	}

	public void setUserIdMax(Long userIdMax) {
		this.userIdMax = userIdMax;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getGoodsSkuId() {
		return goodsSkuId;
	}

	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public Long getGoodsSkuIdMin() {
		return goodsSkuIdMin;
	}

	public void setGoodsSkuIdMin(Long goodsSkuIdMin) {
		this.goodsSkuIdMin = goodsSkuIdMin;
	}

	public Long getGoodsSkuIdMax() {
		return goodsSkuIdMax;
	}

	public void setGoodsSkuIdMax(Long goodsSkuIdMax) {
		this.goodsSkuIdMax = goodsSkuIdMax;
	}

	public Long getGoodsSkuGoodsId() {
		return goodsSkuGoodsId;
	}

	public void setGoodsSkuGoodsId(Long goodsSkuGoodsId) {
		this.goodsSkuGoodsId = goodsSkuGoodsId;
	}

	public Long getGoodsSkuGoodsIdMin() {
		return goodsSkuGoodsIdMin;
	}

	public void setGoodsSkuGoodsIdMin(Long goodsSkuGoodsIdMin) {
		this.goodsSkuGoodsIdMin = goodsSkuGoodsIdMin;
	}

	public Long getGoodsSkuGoodsIdMax() {
		return goodsSkuGoodsIdMax;
	}

	public void setGoodsSkuGoodsIdMax(Long goodsSkuGoodsIdMax) {
		this.goodsSkuGoodsIdMax = goodsSkuGoodsIdMax;
	}

	public String getGoodsPicPicUrl() {
		return goodsPicPicUrl;
	}

	public void setGoodsPicPicUrl(String goodsPicPicUrl) {
		this.goodsPicPicUrl = goodsPicPicUrl;
	}

	public Integer getGoodsCartQuantity() {
		return goodsCartQuantity;
	}

	public void setGoodsCartQuantity(Integer goodsCartQuantity) {
		this.goodsCartQuantity = goodsCartQuantity;
	}

	public Integer getGoodsCartQuantityMin() {
		return goodsCartQuantityMin;
	}

	public void setGoodsCartQuantityMin(Integer goodsCartQuantityMin) {
		this.goodsCartQuantityMin = goodsCartQuantityMin;
	}

	public Integer getGoodsCartQuantityMax() {
		return goodsCartQuantityMax;
	}

	public void setGoodsCartQuantityMax(Integer goodsCartQuantityMax) {
		this.goodsCartQuantityMax = goodsCartQuantityMax;
	}

	public Date getGoodsCartCreateTime() {
		return goodsCartCreateTime;
	}

	public void setGoodsCartCreateTime(Date goodsCartCreateTime) {
		this.goodsCartCreateTime = goodsCartCreateTime;
	}

	public Date getGoodsCartCreateTimeMin() {
		return goodsCartCreateTimeMin;
	}

	public void setGoodsCartCreateTimeMin(Date goodsCartCreateTimeMin) {
		this.goodsCartCreateTimeMin = goodsCartCreateTimeMin;
	}

	public Date getGoodsCartCreateTimeMax() {
		return goodsCartCreateTimeMax;
	}

	public void setGoodsCartCreateTimeMax(Date goodsCartCreateTimeMax) {
		this.goodsCartCreateTimeMax = goodsCartCreateTimeMax;
	}

	public Date getGoodsCartUpdateTime() {
		return goodsCartUpdateTime;
	}

	public void setGoodsCartUpdateTime(Date goodsCartUpdateTime) {
		this.goodsCartUpdateTime = goodsCartUpdateTime;
	}

	public Date getGoodsCartUpdateTimeMin() {
		return goodsCartUpdateTimeMin;
	}

	public void setGoodsCartUpdateTimeMin(Date goodsCartUpdateTimeMin) {
		this.goodsCartUpdateTimeMin = goodsCartUpdateTimeMin;
	}

	public Date getGoodsCartUpdateTimeMax() {
		return goodsCartUpdateTimeMax;
	}

	public void setGoodsCartUpdateTimeMax(Date goodsCartUpdateTimeMax) {
		this.goodsCartUpdateTimeMax = goodsCartUpdateTimeMax;
	}

	
    @Override
    public String toString() {
        return "UserGoodsCartQuery {" +
                "userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", goodsSkuId = " + goodsSkuId + 
				", goodsSkuIdMin = " + goodsSkuIdMin + 
				", goodsSkuIdMax = " + goodsSkuIdMax + 
				", goodsSkuGoodsId = " + goodsSkuGoodsId + 
				", goodsSkuGoodsIdMin = " + goodsSkuGoodsIdMin + 
				", goodsSkuGoodsIdMax = " + goodsSkuGoodsIdMax + 
				", goodsPicPicUrl = " + goodsPicPicUrl + 
				", goodsCartQuantity = " + goodsCartQuantity + 
				", goodsCartQuantityMin = " + goodsCartQuantityMin + 
				", goodsCartQuantityMax = " + goodsCartQuantityMax + 
				", goodsCartCreateTime = " + goodsCartCreateTime + 
				", goodsCartCreateTimeMin = " + goodsCartCreateTimeMin + 
				", goodsCartCreateTimeMax = " + goodsCartCreateTimeMax + 
				", goodsCartUpdateTime = " + goodsCartUpdateTime + 
				", goodsCartUpdateTimeMin = " + goodsCartUpdateTimeMin + 
				", goodsCartUpdateTimeMax = " + goodsCartUpdateTimeMax + 
				" }";
    }

}
