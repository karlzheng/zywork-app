package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserUserDetailDO数据对象实体类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserDetailDO extends BaseDO {

	private static final long serialVersionUID = -9223372036793895459L;

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
	// 版本号
	private Integer userDetailVersion;

	public UserUserDetailDO () {}

	public UserUserDetailDO (Long userId, String userPhone, String userEmail, Date userCreateTime, String userDetailNickname, String userDetailHeadicon, Byte userDetailGender, Date userDetailBirthday, Integer userDetailAge, String userDetailQq, String userDetailQqQrcode, String userDetailWechat, String userDetailWechatQrcode, String userDetailAlipay, String userDetailAlipayQrcode, String userDetailShareCode, Integer userDetailVersion) {
		this.userId = userId;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userCreateTime = userCreateTime;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
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
		this.userDetailVersion = userDetailVersion;

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

	public Integer getUserDetailVersion() {
		return userDetailVersion;
	}

	public void setUserDetailVersion(Integer userDetailVersion) {
		this.userDetailVersion = userDetailVersion;
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
				", userDetailVersion = " + userDetailVersion +
				" }";
	}

}
