package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserGoodsCartDTO数据传输对象类<br/>
 *
 * 创建于2019-03-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsCartDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372036728048488L;

    //t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	//t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_goods_sku表的字段对应的属性
	// SKU编号
	private Long goodsSkuId;
	// 商品编号
	private Long goodsSkuGoodsId;
	//t_goods_pic表的字段对应的属性
	// 图片URL
	private String goodsPicPicUrl;
	//t_goods_cart表的字段对应的属性
	// 购买数量
	private Integer goodsCartQuantity;
	// 创建时间
	private Date goodsCartCreateTime;
	// 更新时间
	private Date goodsCartUpdateTime;
	
    public UserGoodsCartDTO () {}

    public UserGoodsCartDTO (String userDetailNickname, String userDetailHeadicon, Long userId, String userPhone, String userEmail, Long goodsSkuId, Long goodsSkuGoodsId, String goodsPicPicUrl, Integer goodsCartQuantity, Date goodsCartCreateTime, Date goodsCartUpdateTime) {
        this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.goodsSkuId = goodsSkuId;
		this.goodsSkuGoodsId = goodsSkuGoodsId;
		this.goodsPicPicUrl = goodsPicPicUrl;
		this.goodsCartQuantity = goodsCartQuantity;
		this.goodsCartCreateTime = goodsCartCreateTime;
		this.goodsCartUpdateTime = goodsCartUpdateTime;
		
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

	public Long getGoodsSkuGoodsId() {
		return goodsSkuGoodsId;
	}

	public void setGoodsSkuGoodsId(Long goodsSkuGoodsId) {
		this.goodsSkuGoodsId = goodsSkuGoodsId;
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

	public Date getGoodsCartCreateTime() {
		return goodsCartCreateTime;
	}

	public void setGoodsCartCreateTime(Date goodsCartCreateTime) {
		this.goodsCartCreateTime = goodsCartCreateTime;
	}

	public Date getGoodsCartUpdateTime() {
		return goodsCartUpdateTime;
	}

	public void setGoodsCartUpdateTime(Date goodsCartUpdateTime) {
		this.goodsCartUpdateTime = goodsCartUpdateTime;
	}

	
    @Override
    public String toString() {
        return "UserGoodsCartDTO {" +
                "userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", goodsSkuId = " + goodsSkuId + 
				", goodsSkuGoodsId = " + goodsSkuGoodsId + 
				", goodsPicPicUrl = " + goodsPicPicUrl + 
				", goodsCartQuantity = " + goodsCartQuantity + 
				", goodsCartCreateTime = " + goodsCartCreateTime + 
				", goodsCartUpdateTime = " + goodsCartUpdateTime + 
				" }";
    }

}
