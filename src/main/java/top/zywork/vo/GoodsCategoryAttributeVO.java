package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsCategoryAttributeVO值对象类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsCategoryAttributeVO extends BaseVO {

    private static final long serialVersionUID = -9223372035373166673L;

    //t_goods_category表的字段对应的属性
	// 类目编号
	private Long goodsCategoryId;
	// 类目名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String goodsCategoryTitle;
	//t_goods_attribute表的字段对应的属性
	// 商品属性编号
	@NotNull(message = "此项是必须项")
	private Long goodsAttributeId;
	// 属性名称
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String goodsAttributeAttrName;
	// 属性代码
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 50, message = "必须是1-50个字符")
	private String goodsAttributeAttrCode;
	// 数据类型
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String goodsAttributeAttrType;
	// 数据长度
	@NotNull(message = "此项是必须项")
	private Integer goodsAttributeAttrLength;
	// 是否前端显示
	@NotNull(message = "此项是必须项")
	private Byte goodsAttributeAttrDisplay;
	//t_goods_category_attribute表的字段对应的属性
	// 属性排序
	@NotNull(message = "此项是必须项")
	private Integer goodsCategoryAttributeAttrOrder;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCategoryAttributeCreateTime;
	
    public GoodsCategoryAttributeVO () {}

    public GoodsCategoryAttributeVO (Long goodsCategoryId, String goodsCategoryTitle, Long goodsAttributeId, String goodsAttributeAttrName, String goodsAttributeAttrCode, String goodsAttributeAttrType, Integer goodsAttributeAttrLength, Byte goodsAttributeAttrDisplay, Integer goodsCategoryAttributeAttrOrder, Date goodsCategoryAttributeCreateTime) {
        this.goodsCategoryId = goodsCategoryId;
		this.goodsCategoryTitle = goodsCategoryTitle;
		this.goodsAttributeId = goodsAttributeId;
		this.goodsAttributeAttrName = goodsAttributeAttrName;
		this.goodsAttributeAttrCode = goodsAttributeAttrCode;
		this.goodsAttributeAttrType = goodsAttributeAttrType;
		this.goodsAttributeAttrLength = goodsAttributeAttrLength;
		this.goodsAttributeAttrDisplay = goodsAttributeAttrDisplay;
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
		this.goodsCategoryAttributeCreateTime = goodsCategoryAttributeCreateTime;
		
    }

    public Long getGoodsCategoryId() {
		return goodsCategoryId;
	}

	public void setGoodsCategoryId(Long goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}

	public String getGoodsCategoryTitle() {
		return goodsCategoryTitle;
	}

	public void setGoodsCategoryTitle(String goodsCategoryTitle) {
		this.goodsCategoryTitle = goodsCategoryTitle;
	}

	public Long getGoodsAttributeId() {
		return goodsAttributeId;
	}

	public void setGoodsAttributeId(Long goodsAttributeId) {
		this.goodsAttributeId = goodsAttributeId;
	}

	public String getGoodsAttributeAttrName() {
		return goodsAttributeAttrName;
	}

	public void setGoodsAttributeAttrName(String goodsAttributeAttrName) {
		this.goodsAttributeAttrName = goodsAttributeAttrName;
	}

	public String getGoodsAttributeAttrCode() {
		return goodsAttributeAttrCode;
	}

	public void setGoodsAttributeAttrCode(String goodsAttributeAttrCode) {
		this.goodsAttributeAttrCode = goodsAttributeAttrCode;
	}

	public String getGoodsAttributeAttrType() {
		return goodsAttributeAttrType;
	}

	public void setGoodsAttributeAttrType(String goodsAttributeAttrType) {
		this.goodsAttributeAttrType = goodsAttributeAttrType;
	}

	public Integer getGoodsAttributeAttrLength() {
		return goodsAttributeAttrLength;
	}

	public void setGoodsAttributeAttrLength(Integer goodsAttributeAttrLength) {
		this.goodsAttributeAttrLength = goodsAttributeAttrLength;
	}

	public Byte getGoodsAttributeAttrDisplay() {
		return goodsAttributeAttrDisplay;
	}

	public void setGoodsAttributeAttrDisplay(Byte goodsAttributeAttrDisplay) {
		this.goodsAttributeAttrDisplay = goodsAttributeAttrDisplay;
	}

	public Integer getGoodsCategoryAttributeAttrOrder() {
		return goodsCategoryAttributeAttrOrder;
	}

	public void setGoodsCategoryAttributeAttrOrder(Integer goodsCategoryAttributeAttrOrder) {
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
	}

	public Date getGoodsCategoryAttributeCreateTime() {
		return goodsCategoryAttributeCreateTime;
	}

	public void setGoodsCategoryAttributeCreateTime(Date goodsCategoryAttributeCreateTime) {
		this.goodsCategoryAttributeCreateTime = goodsCategoryAttributeCreateTime;
	}

	
    @Override
    public String toString() {
        return "GoodsCategoryAttributeVO {" +
                "goodsCategoryId = " + goodsCategoryId + 
				", goodsCategoryTitle = " + goodsCategoryTitle + 
				", goodsAttributeId = " + goodsAttributeId + 
				", goodsAttributeAttrName = " + goodsAttributeAttrName + 
				", goodsAttributeAttrCode = " + goodsAttributeAttrCode + 
				", goodsAttributeAttrType = " + goodsAttributeAttrType + 
				", goodsAttributeAttrLength = " + goodsAttributeAttrLength + 
				", goodsAttributeAttrDisplay = " + goodsAttributeAttrDisplay + 
				", goodsCategoryAttributeAttrOrder = " + goodsCategoryAttributeAttrOrder + 
				", goodsCategoryAttributeCreateTime = " + goodsCategoryAttributeCreateTime + 
				" }";
    }

}
