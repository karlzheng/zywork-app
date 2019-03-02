package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsSkuAttributeValueQuery查询对象类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsSkuAttributeValueQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036562355524L;

    //t_goods_info表的字段对应的属性
	// 商品编号
	private Long goodsInfoId;
	// 商品编号（最小值）
	private Long goodsInfoIdMin;
	// 商品编号（最大值）
	private Long goodsInfoIdMax;
	// 店铺编号
	private Long goodsInfoShopId;
	// 店铺编号（最小值）
	private Long goodsInfoShopIdMin;
	// 店铺编号（最大值）
	private Long goodsInfoShopIdMax;
	// 类目编号
	private Long goodsInfoCategoryId;
	// 类目编号（最小值）
	private Long goodsInfoCategoryIdMin;
	// 类目编号（最大值）
	private Long goodsInfoCategoryIdMax;
	// 上架状态
	private Byte goodsInfoShelfStatus;
	// 上架状态（最小值）
	private Byte goodsInfoShelfStatusMin;
	// 上架状态（最大值）
	private Byte goodsInfoShelfStatusMax;
	//t_goods_sku表的字段对应的属性
	// SKU编号
	private Long goodsSkuId;
	// SKU编号（最小值）
	private Long goodsSkuIdMin;
	// SKU编号（最大值）
	private Long goodsSkuIdMax;
	// 上架状态
	private Byte goodsSkuShelfStatus;
	// 上架状态（最小值）
	private Byte goodsSkuShelfStatusMin;
	// 上架状态（最大值）
	private Byte goodsSkuShelfStatusMax;
	//t_goods_category_attribute表的字段对应的属性
	// 属性编号
	private Long goodsCategoryAttributeAttrId;
	// 属性编号（最小值）
	private Long goodsCategoryAttributeAttrIdMin;
	// 属性编号（最大值）
	private Long goodsCategoryAttributeAttrIdMax;
	// 属性排序
	private Integer goodsCategoryAttributeAttrOrder;
	// 属性排序（最小值）
	private Integer goodsCategoryAttributeAttrOrderMin;
	// 属性排序（最大值）
	private Integer goodsCategoryAttributeAttrOrderMax;
	//t_goods_attribute表的字段对应的属性
	// 属性名称
	private String goodsAttributeAttrName;
	// 属性代码
	private String goodsAttributeAttrCode;
	// 数据类型
	private String goodsAttributeAttrType;
	// 数据长度
	private Integer goodsAttributeAttrLength;
	// 数据长度（最小值）
	private Integer goodsAttributeAttrLengthMin;
	// 数据长度（最大值）
	private Integer goodsAttributeAttrLengthMax;
	// 是否必填
	private Byte goodsAttributeAttrRequired;
	// 是否必填（最小值）
	private Byte goodsAttributeAttrRequiredMin;
	// 是否必填（最大值）
	private Byte goodsAttributeAttrRequiredMax;
	// 是否前端显示
	private Byte goodsAttributeAttrDisplay;
	// 是否前端显示（最小值）
	private Byte goodsAttributeAttrDisplayMin;
	// 是否前端显示（最大值）
	private Byte goodsAttributeAttrDisplayMax;
	//t_goods_attribute_value表的字段对应的属性
	// 属性值
	private String goodsAttributeValueAttrValue;
	
    public GoodsSkuAttributeValueQuery () {}

    public GoodsSkuAttributeValueQuery (Long goodsInfoId, Long goodsInfoIdMin, Long goodsInfoIdMax, Long goodsInfoShopId, Long goodsInfoShopIdMin, Long goodsInfoShopIdMax, Long goodsInfoCategoryId, Long goodsInfoCategoryIdMin, Long goodsInfoCategoryIdMax, Byte goodsInfoShelfStatus, Byte goodsInfoShelfStatusMin, Byte goodsInfoShelfStatusMax, Long goodsSkuId, Long goodsSkuIdMin, Long goodsSkuIdMax, Byte goodsSkuShelfStatus, Byte goodsSkuShelfStatusMin, Byte goodsSkuShelfStatusMax, Long goodsCategoryAttributeAttrId, Long goodsCategoryAttributeAttrIdMin, Long goodsCategoryAttributeAttrIdMax, Integer goodsCategoryAttributeAttrOrder, Integer goodsCategoryAttributeAttrOrderMin, Integer goodsCategoryAttributeAttrOrderMax, String goodsAttributeAttrName, String goodsAttributeAttrCode, String goodsAttributeAttrType, Integer goodsAttributeAttrLength, Integer goodsAttributeAttrLengthMin, Integer goodsAttributeAttrLengthMax, Byte goodsAttributeAttrRequired, Byte goodsAttributeAttrRequiredMin, Byte goodsAttributeAttrRequiredMax, Byte goodsAttributeAttrDisplay, Byte goodsAttributeAttrDisplayMin, Byte goodsAttributeAttrDisplayMax, String goodsAttributeValueAttrValue) {
        this.goodsInfoId = goodsInfoId;
		this.goodsInfoIdMin = goodsInfoIdMin;
		this.goodsInfoIdMax = goodsInfoIdMax;
		this.goodsInfoShopId = goodsInfoShopId;
		this.goodsInfoShopIdMin = goodsInfoShopIdMin;
		this.goodsInfoShopIdMax = goodsInfoShopIdMax;
		this.goodsInfoCategoryId = goodsInfoCategoryId;
		this.goodsInfoCategoryIdMin = goodsInfoCategoryIdMin;
		this.goodsInfoCategoryIdMax = goodsInfoCategoryIdMax;
		this.goodsInfoShelfStatus = goodsInfoShelfStatus;
		this.goodsInfoShelfStatusMin = goodsInfoShelfStatusMin;
		this.goodsInfoShelfStatusMax = goodsInfoShelfStatusMax;
		this.goodsSkuId = goodsSkuId;
		this.goodsSkuIdMin = goodsSkuIdMin;
		this.goodsSkuIdMax = goodsSkuIdMax;
		this.goodsSkuShelfStatus = goodsSkuShelfStatus;
		this.goodsSkuShelfStatusMin = goodsSkuShelfStatusMin;
		this.goodsSkuShelfStatusMax = goodsSkuShelfStatusMax;
		this.goodsCategoryAttributeAttrId = goodsCategoryAttributeAttrId;
		this.goodsCategoryAttributeAttrIdMin = goodsCategoryAttributeAttrIdMin;
		this.goodsCategoryAttributeAttrIdMax = goodsCategoryAttributeAttrIdMax;
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
		this.goodsCategoryAttributeAttrOrderMin = goodsCategoryAttributeAttrOrderMin;
		this.goodsCategoryAttributeAttrOrderMax = goodsCategoryAttributeAttrOrderMax;
		this.goodsAttributeAttrName = goodsAttributeAttrName;
		this.goodsAttributeAttrCode = goodsAttributeAttrCode;
		this.goodsAttributeAttrType = goodsAttributeAttrType;
		this.goodsAttributeAttrLength = goodsAttributeAttrLength;
		this.goodsAttributeAttrLengthMin = goodsAttributeAttrLengthMin;
		this.goodsAttributeAttrLengthMax = goodsAttributeAttrLengthMax;
		this.goodsAttributeAttrRequired = goodsAttributeAttrRequired;
		this.goodsAttributeAttrRequiredMin = goodsAttributeAttrRequiredMin;
		this.goodsAttributeAttrRequiredMax = goodsAttributeAttrRequiredMax;
		this.goodsAttributeAttrDisplay = goodsAttributeAttrDisplay;
		this.goodsAttributeAttrDisplayMin = goodsAttributeAttrDisplayMin;
		this.goodsAttributeAttrDisplayMax = goodsAttributeAttrDisplayMax;
		this.goodsAttributeValueAttrValue = goodsAttributeValueAttrValue;
		
    }

    public Long getGoodsInfoId() {
		return goodsInfoId;
	}

	public void setGoodsInfoId(Long goodsInfoId) {
		this.goodsInfoId = goodsInfoId;
	}

	public Long getGoodsInfoIdMin() {
		return goodsInfoIdMin;
	}

	public void setGoodsInfoIdMin(Long goodsInfoIdMin) {
		this.goodsInfoIdMin = goodsInfoIdMin;
	}

	public Long getGoodsInfoIdMax() {
		return goodsInfoIdMax;
	}

	public void setGoodsInfoIdMax(Long goodsInfoIdMax) {
		this.goodsInfoIdMax = goodsInfoIdMax;
	}

	public Long getGoodsInfoShopId() {
		return goodsInfoShopId;
	}

	public void setGoodsInfoShopId(Long goodsInfoShopId) {
		this.goodsInfoShopId = goodsInfoShopId;
	}

	public Long getGoodsInfoShopIdMin() {
		return goodsInfoShopIdMin;
	}

	public void setGoodsInfoShopIdMin(Long goodsInfoShopIdMin) {
		this.goodsInfoShopIdMin = goodsInfoShopIdMin;
	}

	public Long getGoodsInfoShopIdMax() {
		return goodsInfoShopIdMax;
	}

	public void setGoodsInfoShopIdMax(Long goodsInfoShopIdMax) {
		this.goodsInfoShopIdMax = goodsInfoShopIdMax;
	}

	public Long getGoodsInfoCategoryId() {
		return goodsInfoCategoryId;
	}

	public void setGoodsInfoCategoryId(Long goodsInfoCategoryId) {
		this.goodsInfoCategoryId = goodsInfoCategoryId;
	}

	public Long getGoodsInfoCategoryIdMin() {
		return goodsInfoCategoryIdMin;
	}

	public void setGoodsInfoCategoryIdMin(Long goodsInfoCategoryIdMin) {
		this.goodsInfoCategoryIdMin = goodsInfoCategoryIdMin;
	}

	public Long getGoodsInfoCategoryIdMax() {
		return goodsInfoCategoryIdMax;
	}

	public void setGoodsInfoCategoryIdMax(Long goodsInfoCategoryIdMax) {
		this.goodsInfoCategoryIdMax = goodsInfoCategoryIdMax;
	}

	public Byte getGoodsInfoShelfStatus() {
		return goodsInfoShelfStatus;
	}

	public void setGoodsInfoShelfStatus(Byte goodsInfoShelfStatus) {
		this.goodsInfoShelfStatus = goodsInfoShelfStatus;
	}

	public Byte getGoodsInfoShelfStatusMin() {
		return goodsInfoShelfStatusMin;
	}

	public void setGoodsInfoShelfStatusMin(Byte goodsInfoShelfStatusMin) {
		this.goodsInfoShelfStatusMin = goodsInfoShelfStatusMin;
	}

	public Byte getGoodsInfoShelfStatusMax() {
		return goodsInfoShelfStatusMax;
	}

	public void setGoodsInfoShelfStatusMax(Byte goodsInfoShelfStatusMax) {
		this.goodsInfoShelfStatusMax = goodsInfoShelfStatusMax;
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

	public Byte getGoodsSkuShelfStatus() {
		return goodsSkuShelfStatus;
	}

	public void setGoodsSkuShelfStatus(Byte goodsSkuShelfStatus) {
		this.goodsSkuShelfStatus = goodsSkuShelfStatus;
	}

	public Byte getGoodsSkuShelfStatusMin() {
		return goodsSkuShelfStatusMin;
	}

	public void setGoodsSkuShelfStatusMin(Byte goodsSkuShelfStatusMin) {
		this.goodsSkuShelfStatusMin = goodsSkuShelfStatusMin;
	}

	public Byte getGoodsSkuShelfStatusMax() {
		return goodsSkuShelfStatusMax;
	}

	public void setGoodsSkuShelfStatusMax(Byte goodsSkuShelfStatusMax) {
		this.goodsSkuShelfStatusMax = goodsSkuShelfStatusMax;
	}

	public Long getGoodsCategoryAttributeAttrId() {
		return goodsCategoryAttributeAttrId;
	}

	public void setGoodsCategoryAttributeAttrId(Long goodsCategoryAttributeAttrId) {
		this.goodsCategoryAttributeAttrId = goodsCategoryAttributeAttrId;
	}

	public Long getGoodsCategoryAttributeAttrIdMin() {
		return goodsCategoryAttributeAttrIdMin;
	}

	public void setGoodsCategoryAttributeAttrIdMin(Long goodsCategoryAttributeAttrIdMin) {
		this.goodsCategoryAttributeAttrIdMin = goodsCategoryAttributeAttrIdMin;
	}

	public Long getGoodsCategoryAttributeAttrIdMax() {
		return goodsCategoryAttributeAttrIdMax;
	}

	public void setGoodsCategoryAttributeAttrIdMax(Long goodsCategoryAttributeAttrIdMax) {
		this.goodsCategoryAttributeAttrIdMax = goodsCategoryAttributeAttrIdMax;
	}

	public Integer getGoodsCategoryAttributeAttrOrder() {
		return goodsCategoryAttributeAttrOrder;
	}

	public void setGoodsCategoryAttributeAttrOrder(Integer goodsCategoryAttributeAttrOrder) {
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
	}

	public Integer getGoodsCategoryAttributeAttrOrderMin() {
		return goodsCategoryAttributeAttrOrderMin;
	}

	public void setGoodsCategoryAttributeAttrOrderMin(Integer goodsCategoryAttributeAttrOrderMin) {
		this.goodsCategoryAttributeAttrOrderMin = goodsCategoryAttributeAttrOrderMin;
	}

	public Integer getGoodsCategoryAttributeAttrOrderMax() {
		return goodsCategoryAttributeAttrOrderMax;
	}

	public void setGoodsCategoryAttributeAttrOrderMax(Integer goodsCategoryAttributeAttrOrderMax) {
		this.goodsCategoryAttributeAttrOrderMax = goodsCategoryAttributeAttrOrderMax;
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

	public Integer getGoodsAttributeAttrLengthMin() {
		return goodsAttributeAttrLengthMin;
	}

	public void setGoodsAttributeAttrLengthMin(Integer goodsAttributeAttrLengthMin) {
		this.goodsAttributeAttrLengthMin = goodsAttributeAttrLengthMin;
	}

	public Integer getGoodsAttributeAttrLengthMax() {
		return goodsAttributeAttrLengthMax;
	}

	public void setGoodsAttributeAttrLengthMax(Integer goodsAttributeAttrLengthMax) {
		this.goodsAttributeAttrLengthMax = goodsAttributeAttrLengthMax;
	}

	public Byte getGoodsAttributeAttrRequired() {
		return goodsAttributeAttrRequired;
	}

	public void setGoodsAttributeAttrRequired(Byte goodsAttributeAttrRequired) {
		this.goodsAttributeAttrRequired = goodsAttributeAttrRequired;
	}

	public Byte getGoodsAttributeAttrRequiredMin() {
		return goodsAttributeAttrRequiredMin;
	}

	public void setGoodsAttributeAttrRequiredMin(Byte goodsAttributeAttrRequiredMin) {
		this.goodsAttributeAttrRequiredMin = goodsAttributeAttrRequiredMin;
	}

	public Byte getGoodsAttributeAttrRequiredMax() {
		return goodsAttributeAttrRequiredMax;
	}

	public void setGoodsAttributeAttrRequiredMax(Byte goodsAttributeAttrRequiredMax) {
		this.goodsAttributeAttrRequiredMax = goodsAttributeAttrRequiredMax;
	}

	public Byte getGoodsAttributeAttrDisplay() {
		return goodsAttributeAttrDisplay;
	}

	public void setGoodsAttributeAttrDisplay(Byte goodsAttributeAttrDisplay) {
		this.goodsAttributeAttrDisplay = goodsAttributeAttrDisplay;
	}

	public Byte getGoodsAttributeAttrDisplayMin() {
		return goodsAttributeAttrDisplayMin;
	}

	public void setGoodsAttributeAttrDisplayMin(Byte goodsAttributeAttrDisplayMin) {
		this.goodsAttributeAttrDisplayMin = goodsAttributeAttrDisplayMin;
	}

	public Byte getGoodsAttributeAttrDisplayMax() {
		return goodsAttributeAttrDisplayMax;
	}

	public void setGoodsAttributeAttrDisplayMax(Byte goodsAttributeAttrDisplayMax) {
		this.goodsAttributeAttrDisplayMax = goodsAttributeAttrDisplayMax;
	}

	public String getGoodsAttributeValueAttrValue() {
		return goodsAttributeValueAttrValue;
	}

	public void setGoodsAttributeValueAttrValue(String goodsAttributeValueAttrValue) {
		this.goodsAttributeValueAttrValue = goodsAttributeValueAttrValue;
	}

	
    @Override
    public String toString() {
        return "GoodsSkuAttributeValueQuery {" +
                "goodsInfoId = " + goodsInfoId + 
				", goodsInfoIdMin = " + goodsInfoIdMin + 
				", goodsInfoIdMax = " + goodsInfoIdMax + 
				", goodsInfoShopId = " + goodsInfoShopId + 
				", goodsInfoShopIdMin = " + goodsInfoShopIdMin + 
				", goodsInfoShopIdMax = " + goodsInfoShopIdMax + 
				", goodsInfoCategoryId = " + goodsInfoCategoryId + 
				", goodsInfoCategoryIdMin = " + goodsInfoCategoryIdMin + 
				", goodsInfoCategoryIdMax = " + goodsInfoCategoryIdMax + 
				", goodsInfoShelfStatus = " + goodsInfoShelfStatus + 
				", goodsInfoShelfStatusMin = " + goodsInfoShelfStatusMin + 
				", goodsInfoShelfStatusMax = " + goodsInfoShelfStatusMax + 
				", goodsSkuId = " + goodsSkuId + 
				", goodsSkuIdMin = " + goodsSkuIdMin + 
				", goodsSkuIdMax = " + goodsSkuIdMax + 
				", goodsSkuShelfStatus = " + goodsSkuShelfStatus + 
				", goodsSkuShelfStatusMin = " + goodsSkuShelfStatusMin + 
				", goodsSkuShelfStatusMax = " + goodsSkuShelfStatusMax + 
				", goodsCategoryAttributeAttrId = " + goodsCategoryAttributeAttrId + 
				", goodsCategoryAttributeAttrIdMin = " + goodsCategoryAttributeAttrIdMin + 
				", goodsCategoryAttributeAttrIdMax = " + goodsCategoryAttributeAttrIdMax + 
				", goodsCategoryAttributeAttrOrder = " + goodsCategoryAttributeAttrOrder + 
				", goodsCategoryAttributeAttrOrderMin = " + goodsCategoryAttributeAttrOrderMin + 
				", goodsCategoryAttributeAttrOrderMax = " + goodsCategoryAttributeAttrOrderMax + 
				", goodsAttributeAttrName = " + goodsAttributeAttrName + 
				", goodsAttributeAttrCode = " + goodsAttributeAttrCode + 
				", goodsAttributeAttrType = " + goodsAttributeAttrType + 
				", goodsAttributeAttrLength = " + goodsAttributeAttrLength + 
				", goodsAttributeAttrLengthMin = " + goodsAttributeAttrLengthMin + 
				", goodsAttributeAttrLengthMax = " + goodsAttributeAttrLengthMax + 
				", goodsAttributeAttrRequired = " + goodsAttributeAttrRequired + 
				", goodsAttributeAttrRequiredMin = " + goodsAttributeAttrRequiredMin + 
				", goodsAttributeAttrRequiredMax = " + goodsAttributeAttrRequiredMax + 
				", goodsAttributeAttrDisplay = " + goodsAttributeAttrDisplay + 
				", goodsAttributeAttrDisplayMin = " + goodsAttributeAttrDisplayMin + 
				", goodsAttributeAttrDisplayMax = " + goodsAttributeAttrDisplayMax + 
				", goodsAttributeValueAttrValue = " + goodsAttributeValueAttrValue + 
				" }";
    }

}
