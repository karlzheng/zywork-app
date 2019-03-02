package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * GoodsSkuAttributeValueDTO数据传输对象类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsSkuAttributeValueDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035448171361L;

    //t_goods_info表的字段对应的属性
	// 商品编号
	private Long goodsInfoId;
	// 店铺编号
	private Long goodsInfoShopId;
	// 类目编号
	private Long goodsInfoCategoryId;
	// 上架状态
	private Byte goodsInfoShelfStatus;
	//t_goods_sku表的字段对应的属性
	// SKU编号
	private Long goodsSkuId;
	// 上架状态
	private Byte goodsSkuShelfStatus;
	//t_goods_category_attribute表的字段对应的属性
	// 属性编号
	private Long goodsCategoryAttributeAttrId;
	// 属性排序
	private Integer goodsCategoryAttributeAttrOrder;
	//t_goods_attribute表的字段对应的属性
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
	//t_goods_attribute_value表的字段对应的属性
	// 属性值
	private String goodsAttributeValueAttrValue;
	
    public GoodsSkuAttributeValueDTO () {}

    public GoodsSkuAttributeValueDTO (Long goodsInfoId, Long goodsInfoShopId, Long goodsInfoCategoryId, Byte goodsInfoShelfStatus, Long goodsSkuId, Byte goodsSkuShelfStatus, Long goodsCategoryAttributeAttrId, Integer goodsCategoryAttributeAttrOrder, String goodsAttributeAttrName, String goodsAttributeAttrCode, String goodsAttributeAttrType, Integer goodsAttributeAttrLength, Byte goodsAttributeAttrRequired, Byte goodsAttributeAttrDisplay, String goodsAttributeValueAttrValue) {
        this.goodsInfoId = goodsInfoId;
		this.goodsInfoShopId = goodsInfoShopId;
		this.goodsInfoCategoryId = goodsInfoCategoryId;
		this.goodsInfoShelfStatus = goodsInfoShelfStatus;
		this.goodsSkuId = goodsSkuId;
		this.goodsSkuShelfStatus = goodsSkuShelfStatus;
		this.goodsCategoryAttributeAttrId = goodsCategoryAttributeAttrId;
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
		this.goodsAttributeAttrName = goodsAttributeAttrName;
		this.goodsAttributeAttrCode = goodsAttributeAttrCode;
		this.goodsAttributeAttrType = goodsAttributeAttrType;
		this.goodsAttributeAttrLength = goodsAttributeAttrLength;
		this.goodsAttributeAttrRequired = goodsAttributeAttrRequired;
		this.goodsAttributeAttrDisplay = goodsAttributeAttrDisplay;
		this.goodsAttributeValueAttrValue = goodsAttributeValueAttrValue;
		
    }

    public Long getGoodsInfoId() {
		return goodsInfoId;
	}

	public void setGoodsInfoId(Long goodsInfoId) {
		this.goodsInfoId = goodsInfoId;
	}

	public Long getGoodsInfoShopId() {
		return goodsInfoShopId;
	}

	public void setGoodsInfoShopId(Long goodsInfoShopId) {
		this.goodsInfoShopId = goodsInfoShopId;
	}

	public Long getGoodsInfoCategoryId() {
		return goodsInfoCategoryId;
	}

	public void setGoodsInfoCategoryId(Long goodsInfoCategoryId) {
		this.goodsInfoCategoryId = goodsInfoCategoryId;
	}

	public Byte getGoodsInfoShelfStatus() {
		return goodsInfoShelfStatus;
	}

	public void setGoodsInfoShelfStatus(Byte goodsInfoShelfStatus) {
		this.goodsInfoShelfStatus = goodsInfoShelfStatus;
	}

	public Long getGoodsSkuId() {
		return goodsSkuId;
	}

	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public Byte getGoodsSkuShelfStatus() {
		return goodsSkuShelfStatus;
	}

	public void setGoodsSkuShelfStatus(Byte goodsSkuShelfStatus) {
		this.goodsSkuShelfStatus = goodsSkuShelfStatus;
	}

	public Long getGoodsCategoryAttributeAttrId() {
		return goodsCategoryAttributeAttrId;
	}

	public void setGoodsCategoryAttributeAttrId(Long goodsCategoryAttributeAttrId) {
		this.goodsCategoryAttributeAttrId = goodsCategoryAttributeAttrId;
	}

	public Integer getGoodsCategoryAttributeAttrOrder() {
		return goodsCategoryAttributeAttrOrder;
	}

	public void setGoodsCategoryAttributeAttrOrder(Integer goodsCategoryAttributeAttrOrder) {
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
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

	public String getGoodsAttributeValueAttrValue() {
		return goodsAttributeValueAttrValue;
	}

	public void setGoodsAttributeValueAttrValue(String goodsAttributeValueAttrValue) {
		this.goodsAttributeValueAttrValue = goodsAttributeValueAttrValue;
	}

	
    @Override
    public String toString() {
        return "GoodsSkuAttributeValueDTO {" +
                "goodsInfoId = " + goodsInfoId + 
				", goodsInfoShopId = " + goodsInfoShopId + 
				", goodsInfoCategoryId = " + goodsInfoCategoryId + 
				", goodsInfoShelfStatus = " + goodsInfoShelfStatus + 
				", goodsSkuId = " + goodsSkuId + 
				", goodsSkuShelfStatus = " + goodsSkuShelfStatus + 
				", goodsCategoryAttributeAttrId = " + goodsCategoryAttributeAttrId + 
				", goodsCategoryAttributeAttrOrder = " + goodsCategoryAttributeAttrOrder + 
				", goodsAttributeAttrName = " + goodsAttributeAttrName + 
				", goodsAttributeAttrCode = " + goodsAttributeAttrCode + 
				", goodsAttributeAttrType = " + goodsAttributeAttrType + 
				", goodsAttributeAttrLength = " + goodsAttributeAttrLength + 
				", goodsAttributeAttrRequired = " + goodsAttributeAttrRequired + 
				", goodsAttributeAttrDisplay = " + goodsAttributeAttrDisplay + 
				", goodsAttributeValueAttrValue = " + goodsAttributeValueAttrValue + 
				" }";
    }

}
