package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserGoodsOrderLogisticsDTO数据传输对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserGoodsOrderLogisticsDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372034984197109L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	//t_goods_order表的字段对应的属性
	// 订单编号
	private Long goodsOrderId;
	// 订单号
	private String goodsOrderOrderNo;
	// 订单金额
	private Long goodsOrderTotalAmount;
	// 实付金额
	private Long goodsOrderPayAmount;
	// 优惠金额
	private Long goodsOrderDiscountAmount;
	// 赠送积分
	private Long goodsOrderIntegralAmount;
	// 运费
	private Long goodsOrderExpressFee;
	// 订单状态
	private Byte goodsOrderOrderStatus;
	// 支付时间
	private Date goodsOrderPayTime;
	// 支付方式
	private Byte goodsOrderPayType;
	// 支付订单号
	private String goodsOrderTransactionNo;
	// 是否支付成功
	private Byte goodsOrderPaySuccess;
	// 发货时间
	private Date goodsOrderDeliverTime;
	// 成交时间
	private Date goodsOrderDealTime;
	//t_goods_order_logistics表的字段对应的属性
	// 收货人
	private String goodsOrderLogisticsRealName;
	// 手机号
	private String goodsOrderLogisticsPhone;
	// 省
	private String goodsOrderLogisticsProvince;
	// 市
	private String goodsOrderLogisticsCity;
	// 区/县
	private String goodsOrderLogisticsDistrict;
	// 详细地址
	private String goodsOrderLogisticsAddress;
	// 是否已发货
	private Byte goodsOrderLogisticsIsDeliver;
	// 物流公司名称
	private String goodsOrderLogisticsLogisticsCompany;
	// 物流公司编码
	private String goodsOrderLogisticsLogisticsCode;
	// 物流单号
	private String goodsOrderLogisticsLogisticsNo;
	// 版本号
	private Integer goodsOrderLogisticsVersion;
	// 创建时间
	private Date goodsOrderLogisticsCreateTime;
	// 更新时间
	private Date goodsOrderLogisticsUpdateTime;
	
    public UserGoodsOrderLogisticsDTO () {}

    public UserGoodsOrderLogisticsDTO (Long userId, String userPhone, String userEmail, String userDetailNickname, String userDetailHeadicon, Long goodsOrderId, String goodsOrderOrderNo, Long goodsOrderTotalAmount, Long goodsOrderPayAmount, Long goodsOrderDiscountAmount, Long goodsOrderIntegralAmount, Long goodsOrderExpressFee, Byte goodsOrderOrderStatus, Date goodsOrderPayTime, Byte goodsOrderPayType, String goodsOrderTransactionNo, Byte goodsOrderPaySuccess, Date goodsOrderDeliverTime, Date goodsOrderDealTime, String goodsOrderLogisticsRealName, String goodsOrderLogisticsPhone, String goodsOrderLogisticsProvince, String goodsOrderLogisticsCity, String goodsOrderLogisticsDistrict, String goodsOrderLogisticsAddress, Byte goodsOrderLogisticsIsDeliver, String goodsOrderLogisticsLogisticsCompany, String goodsOrderLogisticsLogisticsCode, String goodsOrderLogisticsLogisticsNo, Integer goodsOrderLogisticsVersion, Date goodsOrderLogisticsCreateTime, Date goodsOrderLogisticsUpdateTime) {
        this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.goodsOrderId = goodsOrderId;
		this.goodsOrderOrderNo = goodsOrderOrderNo;
		this.goodsOrderTotalAmount = goodsOrderTotalAmount;
		this.goodsOrderPayAmount = goodsOrderPayAmount;
		this.goodsOrderDiscountAmount = goodsOrderDiscountAmount;
		this.goodsOrderIntegralAmount = goodsOrderIntegralAmount;
		this.goodsOrderExpressFee = goodsOrderExpressFee;
		this.goodsOrderOrderStatus = goodsOrderOrderStatus;
		this.goodsOrderPayTime = goodsOrderPayTime;
		this.goodsOrderPayType = goodsOrderPayType;
		this.goodsOrderTransactionNo = goodsOrderTransactionNo;
		this.goodsOrderPaySuccess = goodsOrderPaySuccess;
		this.goodsOrderDeliverTime = goodsOrderDeliverTime;
		this.goodsOrderDealTime = goodsOrderDealTime;
		this.goodsOrderLogisticsRealName = goodsOrderLogisticsRealName;
		this.goodsOrderLogisticsPhone = goodsOrderLogisticsPhone;
		this.goodsOrderLogisticsProvince = goodsOrderLogisticsProvince;
		this.goodsOrderLogisticsCity = goodsOrderLogisticsCity;
		this.goodsOrderLogisticsDistrict = goodsOrderLogisticsDistrict;
		this.goodsOrderLogisticsAddress = goodsOrderLogisticsAddress;
		this.goodsOrderLogisticsIsDeliver = goodsOrderLogisticsIsDeliver;
		this.goodsOrderLogisticsLogisticsCompany = goodsOrderLogisticsLogisticsCompany;
		this.goodsOrderLogisticsLogisticsCode = goodsOrderLogisticsLogisticsCode;
		this.goodsOrderLogisticsLogisticsNo = goodsOrderLogisticsLogisticsNo;
		this.goodsOrderLogisticsVersion = goodsOrderLogisticsVersion;
		this.goodsOrderLogisticsCreateTime = goodsOrderLogisticsCreateTime;
		this.goodsOrderLogisticsUpdateTime = goodsOrderLogisticsUpdateTime;
		
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

	public Long getGoodsOrderId() {
		return goodsOrderId;
	}

	public void setGoodsOrderId(Long goodsOrderId) {
		this.goodsOrderId = goodsOrderId;
	}

	public String getGoodsOrderOrderNo() {
		return goodsOrderOrderNo;
	}

	public void setGoodsOrderOrderNo(String goodsOrderOrderNo) {
		this.goodsOrderOrderNo = goodsOrderOrderNo;
	}

	public Long getGoodsOrderTotalAmount() {
		return goodsOrderTotalAmount;
	}

	public void setGoodsOrderTotalAmount(Long goodsOrderTotalAmount) {
		this.goodsOrderTotalAmount = goodsOrderTotalAmount;
	}

	public Long getGoodsOrderPayAmount() {
		return goodsOrderPayAmount;
	}

	public void setGoodsOrderPayAmount(Long goodsOrderPayAmount) {
		this.goodsOrderPayAmount = goodsOrderPayAmount;
	}

	public Long getGoodsOrderDiscountAmount() {
		return goodsOrderDiscountAmount;
	}

	public void setGoodsOrderDiscountAmount(Long goodsOrderDiscountAmount) {
		this.goodsOrderDiscountAmount = goodsOrderDiscountAmount;
	}

	public Long getGoodsOrderIntegralAmount() {
		return goodsOrderIntegralAmount;
	}

	public void setGoodsOrderIntegralAmount(Long goodsOrderIntegralAmount) {
		this.goodsOrderIntegralAmount = goodsOrderIntegralAmount;
	}

	public Long getGoodsOrderExpressFee() {
		return goodsOrderExpressFee;
	}

	public void setGoodsOrderExpressFee(Long goodsOrderExpressFee) {
		this.goodsOrderExpressFee = goodsOrderExpressFee;
	}

	public Byte getGoodsOrderOrderStatus() {
		return goodsOrderOrderStatus;
	}

	public void setGoodsOrderOrderStatus(Byte goodsOrderOrderStatus) {
		this.goodsOrderOrderStatus = goodsOrderOrderStatus;
	}

	public Date getGoodsOrderPayTime() {
		return goodsOrderPayTime;
	}

	public void setGoodsOrderPayTime(Date goodsOrderPayTime) {
		this.goodsOrderPayTime = goodsOrderPayTime;
	}

	public Byte getGoodsOrderPayType() {
		return goodsOrderPayType;
	}

	public void setGoodsOrderPayType(Byte goodsOrderPayType) {
		this.goodsOrderPayType = goodsOrderPayType;
	}

	public String getGoodsOrderTransactionNo() {
		return goodsOrderTransactionNo;
	}

	public void setGoodsOrderTransactionNo(String goodsOrderTransactionNo) {
		this.goodsOrderTransactionNo = goodsOrderTransactionNo;
	}

	public Byte getGoodsOrderPaySuccess() {
		return goodsOrderPaySuccess;
	}

	public void setGoodsOrderPaySuccess(Byte goodsOrderPaySuccess) {
		this.goodsOrderPaySuccess = goodsOrderPaySuccess;
	}

	public Date getGoodsOrderDeliverTime() {
		return goodsOrderDeliverTime;
	}

	public void setGoodsOrderDeliverTime(Date goodsOrderDeliverTime) {
		this.goodsOrderDeliverTime = goodsOrderDeliverTime;
	}

	public Date getGoodsOrderDealTime() {
		return goodsOrderDealTime;
	}

	public void setGoodsOrderDealTime(Date goodsOrderDealTime) {
		this.goodsOrderDealTime = goodsOrderDealTime;
	}

	public String getGoodsOrderLogisticsRealName() {
		return goodsOrderLogisticsRealName;
	}

	public void setGoodsOrderLogisticsRealName(String goodsOrderLogisticsRealName) {
		this.goodsOrderLogisticsRealName = goodsOrderLogisticsRealName;
	}

	public String getGoodsOrderLogisticsPhone() {
		return goodsOrderLogisticsPhone;
	}

	public void setGoodsOrderLogisticsPhone(String goodsOrderLogisticsPhone) {
		this.goodsOrderLogisticsPhone = goodsOrderLogisticsPhone;
	}

	public String getGoodsOrderLogisticsProvince() {
		return goodsOrderLogisticsProvince;
	}

	public void setGoodsOrderLogisticsProvince(String goodsOrderLogisticsProvince) {
		this.goodsOrderLogisticsProvince = goodsOrderLogisticsProvince;
	}

	public String getGoodsOrderLogisticsCity() {
		return goodsOrderLogisticsCity;
	}

	public void setGoodsOrderLogisticsCity(String goodsOrderLogisticsCity) {
		this.goodsOrderLogisticsCity = goodsOrderLogisticsCity;
	}

	public String getGoodsOrderLogisticsDistrict() {
		return goodsOrderLogisticsDistrict;
	}

	public void setGoodsOrderLogisticsDistrict(String goodsOrderLogisticsDistrict) {
		this.goodsOrderLogisticsDistrict = goodsOrderLogisticsDistrict;
	}

	public String getGoodsOrderLogisticsAddress() {
		return goodsOrderLogisticsAddress;
	}

	public void setGoodsOrderLogisticsAddress(String goodsOrderLogisticsAddress) {
		this.goodsOrderLogisticsAddress = goodsOrderLogisticsAddress;
	}

	public Byte getGoodsOrderLogisticsIsDeliver() {
		return goodsOrderLogisticsIsDeliver;
	}

	public void setGoodsOrderLogisticsIsDeliver(Byte goodsOrderLogisticsIsDeliver) {
		this.goodsOrderLogisticsIsDeliver = goodsOrderLogisticsIsDeliver;
	}

	public String getGoodsOrderLogisticsLogisticsCompany() {
		return goodsOrderLogisticsLogisticsCompany;
	}

	public void setGoodsOrderLogisticsLogisticsCompany(String goodsOrderLogisticsLogisticsCompany) {
		this.goodsOrderLogisticsLogisticsCompany = goodsOrderLogisticsLogisticsCompany;
	}

	public String getGoodsOrderLogisticsLogisticsCode() {
		return goodsOrderLogisticsLogisticsCode;
	}

	public void setGoodsOrderLogisticsLogisticsCode(String goodsOrderLogisticsLogisticsCode) {
		this.goodsOrderLogisticsLogisticsCode = goodsOrderLogisticsLogisticsCode;
	}

	public String getGoodsOrderLogisticsLogisticsNo() {
		return goodsOrderLogisticsLogisticsNo;
	}

	public void setGoodsOrderLogisticsLogisticsNo(String goodsOrderLogisticsLogisticsNo) {
		this.goodsOrderLogisticsLogisticsNo = goodsOrderLogisticsLogisticsNo;
	}

	public Integer getGoodsOrderLogisticsVersion() {
		return goodsOrderLogisticsVersion;
	}

	public void setGoodsOrderLogisticsVersion(Integer goodsOrderLogisticsVersion) {
		this.goodsOrderLogisticsVersion = goodsOrderLogisticsVersion;
	}

	public Date getGoodsOrderLogisticsCreateTime() {
		return goodsOrderLogisticsCreateTime;
	}

	public void setGoodsOrderLogisticsCreateTime(Date goodsOrderLogisticsCreateTime) {
		this.goodsOrderLogisticsCreateTime = goodsOrderLogisticsCreateTime;
	}

	public Date getGoodsOrderLogisticsUpdateTime() {
		return goodsOrderLogisticsUpdateTime;
	}

	public void setGoodsOrderLogisticsUpdateTime(Date goodsOrderLogisticsUpdateTime) {
		this.goodsOrderLogisticsUpdateTime = goodsOrderLogisticsUpdateTime;
	}

	
    @Override
    public String toString() {
        return "UserGoodsOrderLogisticsDTO {" +
                "userId = " + userId + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", goodsOrderId = " + goodsOrderId + 
				", goodsOrderOrderNo = " + goodsOrderOrderNo + 
				", goodsOrderTotalAmount = " + goodsOrderTotalAmount + 
				", goodsOrderPayAmount = " + goodsOrderPayAmount + 
				", goodsOrderDiscountAmount = " + goodsOrderDiscountAmount + 
				", goodsOrderIntegralAmount = " + goodsOrderIntegralAmount + 
				", goodsOrderExpressFee = " + goodsOrderExpressFee + 
				", goodsOrderOrderStatus = " + goodsOrderOrderStatus + 
				", goodsOrderPayTime = " + goodsOrderPayTime + 
				", goodsOrderPayType = " + goodsOrderPayType + 
				", goodsOrderTransactionNo = " + goodsOrderTransactionNo + 
				", goodsOrderPaySuccess = " + goodsOrderPaySuccess + 
				", goodsOrderDeliverTime = " + goodsOrderDeliverTime + 
				", goodsOrderDealTime = " + goodsOrderDealTime + 
				", goodsOrderLogisticsRealName = " + goodsOrderLogisticsRealName + 
				", goodsOrderLogisticsPhone = " + goodsOrderLogisticsPhone + 
				", goodsOrderLogisticsProvince = " + goodsOrderLogisticsProvince + 
				", goodsOrderLogisticsCity = " + goodsOrderLogisticsCity + 
				", goodsOrderLogisticsDistrict = " + goodsOrderLogisticsDistrict + 
				", goodsOrderLogisticsAddress = " + goodsOrderLogisticsAddress + 
				", goodsOrderLogisticsIsDeliver = " + goodsOrderLogisticsIsDeliver + 
				", goodsOrderLogisticsLogisticsCompany = " + goodsOrderLogisticsLogisticsCompany + 
				", goodsOrderLogisticsLogisticsCode = " + goodsOrderLogisticsLogisticsCode + 
				", goodsOrderLogisticsLogisticsNo = " + goodsOrderLogisticsLogisticsNo + 
				", goodsOrderLogisticsVersion = " + goodsOrderLogisticsVersion + 
				", goodsOrderLogisticsCreateTime = " + goodsOrderLogisticsCreateTime + 
				", goodsOrderLogisticsUpdateTime = " + goodsOrderLogisticsUpdateTime + 
				" }";
    }

}
