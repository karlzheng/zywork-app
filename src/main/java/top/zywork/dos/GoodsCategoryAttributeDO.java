package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsCategoryAttributeDO数据对象实体类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsCategoryAttributeDO extends BaseDO {

    private static final long serialVersionUID = -9223372034730224217L;

    //t_goods_category表的字段对应的属性
	// 类目编号
	private Long goodsCategoryId;
	// 类目名称
	private String goodsCategoryTitle;
	//t_goods_attribute表的字段对应的属性
	// 商品属性编号
	private Long goodsAttributeId;
	// 属性名称
	private String goodsAttributeAttrName;
	// 属性代码
	private String goodsAttributeAttrCode;
	// 数据类型
	private String goodsAttributeAttrType;
	// 数据长度
	private Integer goodsAttributeAttrLength;
	// 是否必填
	private Byte goodsAttributeAttrRequired;
	// 是否前端显示
	private Byte goodsAttributeAttrDisplay;
	//t_goods_category_attribute表的字段对应的属性
	// 属性排序
	private Integer goodsCategoryAttributeAttrOrder;
	// 创建时间
	private Date goodsCategoryAttributeCreateTime;
	
    public GoodsCategoryAttributeDO () {}

    public GoodsCategoryAttributeDO (Long goodsCategoryId, String goodsCategoryTitle, Long goodsAttributeId, String goodsAttributeAttrName, String goodsAttributeAttrCode, String goodsAttributeAttrType, Integer goodsAttributeAttrLength, Byte goodsAttributeAttrRequired, Byte goodsAttributeAttrDisplay, Integer goodsCategoryAttributeAttrOrder, Date goodsCategoryAttributeCreateTime) {
        this.goodsCategoryId = goodsCategoryId;
		this.goodsCategoryTitle = goodsCategoryTitle;
		this.goodsAttributeId = goodsAttributeId;
		this.goodsAttributeAttrName = goodsAttributeAttrName;
		this.goodsAttributeAttrCode = goodsAttributeAttrCode;
		this.goodsAttributeAttrType = goodsAttributeAttrType;
		this.goodsAttributeAttrLength = goodsAttributeAttrLength;
		this.goodsAttributeAttrRequired = goodsAttributeAttrRequired;
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

	public Byte getGoodsAttributeAttrRequired() {
		return goodsAttributeAttrRequired;
	}

	public void setGoodsAttributeAttrRequired(Byte goodsAttributeAttrRequired) {
		this.goodsAttributeAttrRequired = goodsAttributeAttrRequired;
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
        return "GoodsCategoryAttributeDO {" +
                "goodsCategoryId = " + goodsCategoryId + 
				", goodsCategoryTitle = " + goodsCategoryTitle + 
				", goodsAttributeId = " + goodsAttributeId + 
				", goodsAttributeAttrName = " + goodsAttributeAttrName + 
				", goodsAttributeAttrCode = " + goodsAttributeAttrCode + 
				", goodsAttributeAttrType = " + goodsAttributeAttrType + 
				", goodsAttributeAttrLength = " + goodsAttributeAttrLength + 
				", goodsAttributeAttrRequired = " + goodsAttributeAttrRequired + 
				", goodsAttributeAttrDisplay = " + goodsAttributeAttrDisplay + 
				", goodsCategoryAttributeAttrOrder = " + goodsCategoryAttributeAttrOrder + 
				", goodsCategoryAttributeCreateTime = " + goodsCategoryAttributeCreateTime + 
				" }";
    }

}
