package top.zywork.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserDetailDTO数据传输对象类<br/>
 *
 * 创建于2019-01-29<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserDetailDTO extends BaseDTO {

    private static final long serialVersionUID = -9223372035057882624L;

    // 用户编号
	private Long id;
	// 昵称
	private String nickname;
	// 头像地址
	private String headicon;
	// 性别
	private Byte gender;
	// 生日
	private Date birthday;
	// 年龄
	private Integer age;
	// QQ号
	private String qq;
	// QQ二维码
	private String qqQrcode;
	// 微信号
	private String wechat;
	// 微信二维码
	private String wechatQrcode;
	// 支付宝账号
	private String alipay;
	// 支付宝二维码
	private String alipayQrcode;
	// 分享码
	private String shareCode;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserDetailDTO () {}

    public UserDetailDTO (Long id, String nickname, String headicon, Byte gender, Date birthday, Integer age, String qq, String qqQrcode, String wechat, String wechatQrcode, String alipay, String alipayQrcode, String shareCode, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.nickname = nickname;
		this.headicon = headicon;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.qq = qq;
		this.qqQrcode = qqQrcode;
		this.wechat = wechat;
		this.wechatQrcode = wechatQrcode;
		this.alipay = alipay;
		this.alipayQrcode = alipayQrcode;
		this.shareCode = shareCode;
		this.version = version;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadicon() {
		return headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQqQrcode() {
		return qqQrcode;
	}

	public void setQqQrcode(String qqQrcode) {
		this.qqQrcode = qqQrcode;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getWechatQrcode() {
		return wechatQrcode;
	}

	public void setWechatQrcode(String wechatQrcode) {
		this.wechatQrcode = wechatQrcode;
	}

	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	public String getAlipayQrcode() {
		return alipayQrcode;
	}

	public void setAlipayQrcode(String alipayQrcode) {
		this.alipayQrcode = alipayQrcode;
	}

	public String getShareCode() {
		return shareCode;
	}

	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "UserDetailDTO {" +
                "id = " + id + 
				", nickname = " + nickname + 
				", headicon = " + headicon + 
				", gender = " + gender + 
				", birthday = " + birthday + 
				", age = " + age + 
				", qq = " + qq + 
				", qqQrcode = " + qqQrcode + 
				", wechat = " + wechat + 
				", wechatQrcode = " + wechatQrcode + 
				", alipay = " + alipay + 
				", alipayQrcode = " + alipayQrcode + 
				", shareCode = " + shareCode + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
