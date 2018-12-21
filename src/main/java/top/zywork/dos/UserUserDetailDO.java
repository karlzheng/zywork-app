package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserDetailDO数据对象实体类<br/>
 *
 * 创建于2018-12-21<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserDetailDO extends BaseDO {

	private static final long serialVersionUID = -9223372036400234002L;

	//t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	private String userPhone;
	// 用户邮箱
	private String userEmail;
	// 创建时间
	private Date userCreateTime;
	//t_user_detail表的字段对应的属性
	// 昵称
	private String userDetailNickname;
	// 头像地址
	private String userDetailHeadicon;
	// 身份证号
	private String userDetailIdentity;
	// 真实姓名
	private String userDetailRealName;
	// 性别
	private Byte userDetailGender;
	// 生日
	private Date userDetailBirthday;
	// 年龄
	private Integer userDetailAge;
	// QQ号
	private String userDetailQq;
	// QQ二维码
	private String userDetailQqQrcode;
	// 微信号
	private String userDetailWechat;
	// 微信二维码
	private String userDetailWechatQrcode;
	// 支付宝账号
	private String userDetailAlipay;
	// 支付宝二维码
	private String userDetailAlipayQrcode;
	// 分享码
	private String userDetailShareCode;

	public UserUserDetailDO () {}

	public UserUserDetailDO (Long userId, String userPhone, String userEmail, Date userCreateTime, String userDetailNickname, String userDetailHeadicon, String userDetailIdentity, String userDetailRealName, Byte userDetailGender, Date userDetailBirthday, Integer userDetailAge, String userDetailQq, String userDetailQqQrcode, String userDetailWechat, String userDetailWechatQrcode, String userDetailAlipay, String userDetailAlipayQrcode, String userDetailShareCode) {
		this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userCreateTime = userCreateTime;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailIdentity = userDetailIdentity;
		this.userDetailRealName = userDetailRealName;
		this.userDetailGender = userDetailGender;
		this.userDetailBirthday = userDetailBirthday;
		this.userDetailAge = userDetailAge;
		this.userDetailQq = userDetailQq;
		this.userDetailQqQrcode = userDetailQqQrcode;
		this.userDetailWechat = userDetailWechat;
		this.userDetailWechatQrcode = userDetailWechatQrcode;
		this.userDetailAlipay = userDetailAlipay;
		this.userDetailAlipayQrcode = userDetailAlipayQrcode;
		this.userDetailShareCode = userDetailShareCode;

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

	public Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
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

	public String getUserDetailIdentity() {
		return userDetailIdentity;
	}

	public void setUserDetailIdentity(String userDetailIdentity) {
		this.userDetailIdentity = userDetailIdentity;
	}

	public String getUserDetailRealName() {
		return userDetailRealName;
	}

	public void setUserDetailRealName(String userDetailRealName) {
		this.userDetailRealName = userDetailRealName;
	}

	public Byte getUserDetailGender() {
		return userDetailGender;
	}

	public void setUserDetailGender(Byte userDetailGender) {
		this.userDetailGender = userDetailGender;
	}

	public Date getUserDetailBirthday() {
		return userDetailBirthday;
	}

	public void setUserDetailBirthday(Date userDetailBirthday) {
		this.userDetailBirthday = userDetailBirthday;
	}

	public Integer getUserDetailAge() {
		return userDetailAge;
	}

	public void setUserDetailAge(Integer userDetailAge) {
		this.userDetailAge = userDetailAge;
	}

	public String getUserDetailQq() {
		return userDetailQq;
	}

	public void setUserDetailQq(String userDetailQq) {
		this.userDetailQq = userDetailQq;
	}

	public String getUserDetailQqQrcode() {
		return userDetailQqQrcode;
	}

	public void setUserDetailQqQrcode(String userDetailQqQrcode) {
		this.userDetailQqQrcode = userDetailQqQrcode;
	}

	public String getUserDetailWechat() {
		return userDetailWechat;
	}

	public void setUserDetailWechat(String userDetailWechat) {
		this.userDetailWechat = userDetailWechat;
	}

	public String getUserDetailWechatQrcode() {
		return userDetailWechatQrcode;
	}

	public void setUserDetailWechatQrcode(String userDetailWechatQrcode) {
		this.userDetailWechatQrcode = userDetailWechatQrcode;
	}

	public String getUserDetailAlipay() {
		return userDetailAlipay;
	}

	public void setUserDetailAlipay(String userDetailAlipay) {
		this.userDetailAlipay = userDetailAlipay;
	}

	public String getUserDetailAlipayQrcode() {
		return userDetailAlipayQrcode;
	}

	public void setUserDetailAlipayQrcode(String userDetailAlipayQrcode) {
		this.userDetailAlipayQrcode = userDetailAlipayQrcode;
	}

	public String getUserDetailShareCode() {
		return userDetailShareCode;
	}

	public void setUserDetailShareCode(String userDetailShareCode) {
		this.userDetailShareCode = userDetailShareCode;
	}


	@Override
	public String toString() {
		return "UserUserDetailDO {" +
				"userId = " + userId +
				", userPhone = " + userPhone +
				", userEmail = " + userEmail +
				", userCreateTime = " + userCreateTime +
				", userDetailNickname = " + userDetailNickname +
				", userDetailHeadicon = " + userDetailHeadicon +
				", userDetailIdentity = " + userDetailIdentity +
				", userDetailRealName = " + userDetailRealName +
				", userDetailGender = " + userDetailGender +
				", userDetailBirthday = " + userDetailBirthday +
				", userDetailAge = " + userDetailAge +
				", userDetailQq = " + userDetailQq +
				", userDetailQqQrcode = " + userDetailQqQrcode +
				", userDetailWechat = " + userDetailWechat +
				", userDetailWechatQrcode = " + userDetailWechatQrcode +
				", userDetailAlipay = " + userDetailAlipay +
				", userDetailAlipayQrcode = " + userDetailAlipayQrcode +
				", userDetailShareCode = " + userDetailShareCode +
				" }";
	}

}
