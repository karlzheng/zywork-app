package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserDetailQuery查询对象类<br/>
 *
 * 创建于2018-12-21<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserDetailQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036068598148L;

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
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCreateTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCreateTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCreateTimeMax;
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
	// 性别（最小值）
	private Byte userDetailGenderMin;
	// 性别（最大值）
	private Byte userDetailGenderMax;
	// 生日
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userDetailBirthday;
	// 生日（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userDetailBirthdayMin;
	// 生日（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userDetailBirthdayMax;
	// 年龄
	private Integer userDetailAge;
	// 年龄（最小值）
	private Integer userDetailAgeMin;
	// 年龄（最大值）
	private Integer userDetailAgeMax;
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
	
    public UserUserDetailQuery () {}

    public UserUserDetailQuery (Long userId, Long userIdMin, Long userIdMax, String userPhone, String userEmail, Date userCreateTime, Date userCreateTimeMin, Date userCreateTimeMax, String userDetailNickname, String userDetailHeadicon, String userDetailIdentity, String userDetailRealName, Byte userDetailGender, Byte userDetailGenderMin, Byte userDetailGenderMax, Date userDetailBirthday, Date userDetailBirthdayMin, Date userDetailBirthdayMax, Integer userDetailAge, Integer userDetailAgeMin, Integer userDetailAgeMax, String userDetailQq, String userDetailQqQrcode, String userDetailWechat, String userDetailWechatQrcode, String userDetailAlipay, String userDetailAlipayQrcode, String userDetailShareCode) {
        this.userId = userId;
		this.userIdMin = userIdMin;
		this.userIdMax = userIdMax;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userCreateTime = userCreateTime;
		this.userCreateTimeMin = userCreateTimeMin;
		this.userCreateTimeMax = userCreateTimeMax;
		this.userDetailNickname = userDetailNickname;
		this.userDetailHeadicon = userDetailHeadicon;
		this.userDetailIdentity = userDetailIdentity;
		this.userDetailRealName = userDetailRealName;
		this.userDetailGender = userDetailGender;
		this.userDetailGenderMin = userDetailGenderMin;
		this.userDetailGenderMax = userDetailGenderMax;
		this.userDetailBirthday = userDetailBirthday;
		this.userDetailBirthdayMin = userDetailBirthdayMin;
		this.userDetailBirthdayMax = userDetailBirthdayMax;
		this.userDetailAge = userDetailAge;
		this.userDetailAgeMin = userDetailAgeMin;
		this.userDetailAgeMax = userDetailAgeMax;
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

	public Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public Date getUserCreateTimeMin() {
		return userCreateTimeMin;
	}

	public void setUserCreateTimeMin(Date userCreateTimeMin) {
		this.userCreateTimeMin = userCreateTimeMin;
	}

	public Date getUserCreateTimeMax() {
		return userCreateTimeMax;
	}

	public void setUserCreateTimeMax(Date userCreateTimeMax) {
		this.userCreateTimeMax = userCreateTimeMax;
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

	public Byte getUserDetailGenderMin() {
		return userDetailGenderMin;
	}

	public void setUserDetailGenderMin(Byte userDetailGenderMin) {
		this.userDetailGenderMin = userDetailGenderMin;
	}

	public Byte getUserDetailGenderMax() {
		return userDetailGenderMax;
	}

	public void setUserDetailGenderMax(Byte userDetailGenderMax) {
		this.userDetailGenderMax = userDetailGenderMax;
	}

	public Date getUserDetailBirthday() {
		return userDetailBirthday;
	}

	public void setUserDetailBirthday(Date userDetailBirthday) {
		this.userDetailBirthday = userDetailBirthday;
	}

	public Date getUserDetailBirthdayMin() {
		return userDetailBirthdayMin;
	}

	public void setUserDetailBirthdayMin(Date userDetailBirthdayMin) {
		this.userDetailBirthdayMin = userDetailBirthdayMin;
	}

	public Date getUserDetailBirthdayMax() {
		return userDetailBirthdayMax;
	}

	public void setUserDetailBirthdayMax(Date userDetailBirthdayMax) {
		this.userDetailBirthdayMax = userDetailBirthdayMax;
	}

	public Integer getUserDetailAge() {
		return userDetailAge;
	}

	public void setUserDetailAge(Integer userDetailAge) {
		this.userDetailAge = userDetailAge;
	}

	public Integer getUserDetailAgeMin() {
		return userDetailAgeMin;
	}

	public void setUserDetailAgeMin(Integer userDetailAgeMin) {
		this.userDetailAgeMin = userDetailAgeMin;
	}

	public Integer getUserDetailAgeMax() {
		return userDetailAgeMax;
	}

	public void setUserDetailAgeMax(Integer userDetailAgeMax) {
		this.userDetailAgeMax = userDetailAgeMax;
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
        return "UserUserDetailQuery {" +
                "userId = " + userId + 
				", userIdMin = " + userIdMin + 
				", userIdMax = " + userIdMax + 
				", userPhone = " + userPhone + 
				", userEmail = " + userEmail + 
				", userCreateTime = " + userCreateTime + 
				", userCreateTimeMin = " + userCreateTimeMin + 
				", userCreateTimeMax = " + userCreateTimeMax + 
				", userDetailNickname = " + userDetailNickname + 
				", userDetailHeadicon = " + userDetailHeadicon + 
				", userDetailIdentity = " + userDetailIdentity + 
				", userDetailRealName = " + userDetailRealName + 
				", userDetailGender = " + userDetailGender + 
				", userDetailGenderMin = " + userDetailGenderMin + 
				", userDetailGenderMax = " + userDetailGenderMax + 
				", userDetailBirthday = " + userDetailBirthday + 
				", userDetailBirthdayMin = " + userDetailBirthdayMin + 
				", userDetailBirthdayMax = " + userDetailBirthdayMax + 
				", userDetailAge = " + userDetailAge + 
				", userDetailAgeMin = " + userDetailAgeMin + 
				", userDetailAgeMax = " + userDetailAgeMax + 
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
