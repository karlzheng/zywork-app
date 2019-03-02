package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsCategoryAttributeQuery查询对象类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsCategoryAttributeQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036512012799L;

    //t_goods_category表的字段对应的属性
	// 类目编号
	private Long goodsCategoryId;
	// 类目编号（最小值）
	private Long goodsCategoryIdMin;
	// 类目编号（最大值）
	private Long goodsCategoryIdMax;
	// 类目名称
	private String goodsCategoryTitle;
	//t_goods_attribute表的字段对应的属性
	// 商品属性编号
	private Long goodsAttributeId;
	// 商品属性编号（最小值）
	private Long goodsAttributeIdMin;
	// 商品属性编号（最大值）
	private Long goodsAttributeIdMax;
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
	//t_goods_category_attribute表的字段对应的属性
	// 属性排序
	private Integer goodsCategoryAttributeAttrOrder;
	// 属性排序（最小值）
	private Integer goodsCategoryAttributeAttrOrderMin;
	// 属性排序（最大值）
	private Integer goodsCategoryAttributeAttrOrderMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCategoryAttributeCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCategoryAttributeCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date goodsCategoryAttributeCreateTimeMax;
	
    public GoodsCategoryAttributeQuery () {}

    public GoodsCategoryAttributeQuery (Long goodsCategoryId, Long goodsCategoryIdMin, Long goodsCategoryIdMax, String goodsCategoryTitle, Long goodsAttributeId, Long goodsAttributeIdMin, Long goodsAttributeIdMax, String goodsAttributeAttrName, String goodsAttributeAttrCode, String goodsAttributeAttrType, Integer goodsAttributeAttrLength, Integer goodsAttributeAttrLengthMin, Integer goodsAttributeAttrLengthMax, Byte goodsAttributeAttrRequired, Byte goodsAttributeAttrRequiredMin, Byte goodsAttributeAttrRequiredMax, Byte goodsAttributeAttrDisplay, Byte goodsAttributeAttrDisplayMin, Byte goodsAttributeAttrDisplayMax, Integer goodsCategoryAttributeAttrOrder, Integer goodsCategoryAttributeAttrOrderMin, Integer goodsCategoryAttributeAttrOrderMax, Date goodsCategoryAttributeCreateTime, Date goodsCategoryAttributeCreateTimeMin, Date goodsCategoryAttributeCreateTimeMax) {
        this.goodsCategoryId = goodsCategoryId;
		this.goodsCategoryIdMin = goodsCategoryIdMin;
		this.goodsCategoryIdMax = goodsCategoryIdMax;
		this.goodsCategoryTitle = goodsCategoryTitle;
		this.goodsAttributeId = goodsAttributeId;
		this.goodsAttributeIdMin = goodsAttributeIdMin;
		this.goodsAttributeIdMax = goodsAttributeIdMax;
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
		this.goodsCategoryAttributeAttrOrder = goodsCategoryAttributeAttrOrder;
		this.goodsCategoryAttributeAttrOrderMin = goodsCategoryAttributeAttrOrderMin;
		this.goodsCategoryAttributeAttrOrderMax = goodsCategoryAttributeAttrOrderMax;
		this.goodsCategoryAttributeCreateTime = goodsCategoryAttributeCreateTime;
		this.goodsCategoryAttributeCreateTimeMin = goodsCategoryAttributeCreateTimeMin;
		this.goodsCategoryAttributeCreateTimeMax = goodsCategoryAttributeCreateTimeMax;
		
    }

    public Long getGoodsCategoryId() {
		return goodsCategoryId;
	}

	public void setGoodsCategoryId(Long goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}

	public Long getGoodsCategoryIdMin() {
		return goodsCategoryIdMin;
	}

	public void setGoodsCategoryIdMin(Long goodsCategoryIdMin) {
		this.goodsCategoryIdMin = goodsCategoryIdMin;
	}

	public Long getGoodsCategoryIdMax() {
		return goodsCategoryIdMax;
	}

	public void setGoodsCategoryIdMax(Long goodsCategoryIdMax) {
		this.goodsCategoryIdMax = goodsCategoryIdMax;
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

	public Long getGoodsAttributeIdMin() {
		return goodsAttributeIdMin;
	}

	public void setGoodsAttributeIdMin(Long goodsAttributeIdMin) {
		this.goodsAttributeIdMin = goodsAttributeIdMin;
	}

	public Long getGoodsAttributeIdMax() {
		return goodsAttributeIdMax;
	}

	public void setGoodsAttributeIdMax(Long goodsAttributeIdMax) {
		this.goodsAttributeIdMax = goodsAttributeIdMax;
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

	public Date getGoodsCategoryAttributeCreateTime() {
		return goodsCategoryAttributeCreateTime;
	}

	public void setGoodsCategoryAttributeCreateTime(Date goodsCategoryAttributeCreateTime) {
		this.goodsCategoryAttributeCreateTime = goodsCategoryAttributeCreateTime;
	}

	public Date getGoodsCategoryAttributeCreateTimeMin() {
		return goodsCategoryAttributeCreateTimeMin;
	}

	public void setGoodsCategoryAttributeCreateTimeMin(Date goodsCategoryAttributeCreateTimeMin) {
		this.goodsCategoryAttributeCreateTimeMin = goodsCategoryAttributeCreateTimeMin;
	}

	public Date getGoodsCategoryAttributeCreateTimeMax() {
		return goodsCategoryAttributeCreateTimeMax;
	}

	public void setGoodsCategoryAttributeCreateTimeMax(Date goodsCategoryAttributeCreateTimeMax) {
		this.goodsCategoryAttributeCreateTimeMax = goodsCategoryAttributeCreateTimeMax;
	}

	
    @Override
    public String toString() {
        return "GoodsCategoryAttributeQuery {" +
                "goodsCategoryId = " + goodsCategoryId + 
				", goodsCategoryIdMin = " + goodsCategoryIdMin + 
				", goodsCategoryIdMax = " + goodsCategoryIdMax + 
				", goodsCategoryTitle = " + goodsCategoryTitle + 
				", goodsAttributeId = " + goodsAttributeId + 
				", goodsAttributeIdMin = " + goodsAttributeIdMin + 
				", goodsAttributeIdMax = " + goodsAttributeIdMax + 
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
				", goodsCategoryAttributeAttrOrder = " + goodsCategoryAttributeAttrOrder + 
				", goodsCategoryAttributeAttrOrderMin = " + goodsCategoryAttributeAttrOrderMin + 
				", goodsCategoryAttributeAttrOrderMax = " + goodsCategoryAttributeAttrOrderMax + 
				", goodsCategoryAttributeCreateTime = " + goodsCategoryAttributeCreateTime + 
				", goodsCategoryAttributeCreateTimeMin = " + goodsCategoryAttributeCreateTimeMin + 
				", goodsCategoryAttributeCreateTimeMax = " + goodsCategoryAttributeCreateTimeMax + 
				" }";
    }

}
