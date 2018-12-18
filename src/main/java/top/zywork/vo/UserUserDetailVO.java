package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserUserDetailVO值对象类<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserUserDetailVO extends BaseVO {

    private static final long serialVersionUID = -9223372035410795703L;

    //t_user表的字段对应的属性
	// 用户编号
	private Long userId;
	// 手机号
	@Size(min = 0, max = 11, message = "必须小于11个字符")
	private String userPhone;
	// 用户邮箱
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userEmail;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userCreateTime;
	//t_user_detail表的字段对应的属性
	// 昵称
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailNickname;
	// 头像地址
	@Size(min = 0, max = 500, message = "必须小于500个字符")
	private String userDetailHeadicon;
	// 身份证号
	@Size(min = 0, max = 18, message = "必须小于18个字符")
	private String userDetailIdentity;
	// 真实姓名
	@Size(min = 0, max = 10, message = "必须小于10个字符")
	private String userDetailRealName;
	// 性别
	private Byte userDetailGender;
	// 生日
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date userDetailBirthday;
	// 年龄
	private Integer userDetailAge;
	// QQ号
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String userDetailQq;
	// 微信号
	@Size(min = 0, max = 50, message = "必须小于50个字符")
	private String userDetailWechat;
	// 支付宝账号
	@Size(min = 0, max = 100, message = "必须小于100个字符")
	private String userDetailAlipay;
	
    public UserUserDetailVO () {}

    public UserUserDetailVO (Long userId, String userPhone, String userEmail, Date userCreateTime, String userDetailNickname, String userDetailHeadicon, String userDetailIdentity, String userDetailRealName, Byte userDetailGender, Date userDetailBirthday, Integer userDetailAge, String userDetailQq, String userDetailWechat, String userDetailAlipay) {
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
		this.userDetailWechat = userDetailWechat;
		this.userDetailAlipay = userDetailAlipay;
		
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

	public String getUserDetailWechat() {
		return userDetailWechat;
	}

	public void setUserDetailWechat(String userDetailWechat) {
		this.userDetailWechat = userDetailWechat;
	}

	public String getUserDetailAlipay() {
		return userDetailAlipay;
	}

	public void setUserDetailAlipay(String userDetailAlipay) {
		this.userDetailAlipay = userDetailAlipay;
	}

	
    @Override
    public String toString() {
        return "UserUserDetailVO {" +
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
				", userDetailWechat = " + userDetailWechat + 
				", userDetailAlipay = " + userDetailAlipay + 
				" }";
    }

}
