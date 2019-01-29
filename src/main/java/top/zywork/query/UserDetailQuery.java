package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserDetailQuery查询对象类<br/>
 *
 * 创建于2019-01-29<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserDetailQuery extends PageQuery {

    private static final long serialVersionUID = -9223372036473213255L;

    // 用户编号
	private Long id;
	// 用户编号（最小值）
	private Long idMin;
	// 用户编号（最大值）
	private Long idMax;
	// 昵称
	private String nickname;
	// 头像地址
	private String headicon;
	// 性别
	private Byte gender;
	// 性别（最小值）
	private Byte genderMin;
	// 性别（最大值）
	private Byte genderMax;
	// 生日
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthday;
	// 生日（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthdayMin;
	// 生日（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date birthdayMax;
	// 年龄
	private Integer age;
	// 年龄（最小值）
	private Integer ageMin;
	// 年龄（最大值）
	private Integer ageMax;
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
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 创建时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 创建时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMax;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 更新时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMin;
	// 更新时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTimeMax;
	// 是否激活
	private Byte isActive;
	// 是否激活（最小值）
	private Byte isActiveMin;
	// 是否激活（最大值）
	private Byte isActiveMax;
	
    public UserDetailQuery () {}

    public UserDetailQuery (Long id, Long idMin, Long idMax, String nickname, String headicon, Byte gender, Byte genderMin, Byte genderMax, Date birthday, Date birthdayMin, Date birthdayMax, Integer age, Integer ageMin, Integer ageMax, String qq, String qqQrcode, String wechat, String wechatQrcode, String alipay, String alipayQrcode, String shareCode, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.nickname = nickname;
		this.headicon = headicon;
		this.gender = gender;
		this.genderMin = genderMin;
		this.genderMax = genderMax;
		this.birthday = birthday;
		this.birthdayMin = birthdayMin;
		this.birthdayMax = birthdayMax;
		this.age = age;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.qq = qq;
		this.qqQrcode = qqQrcode;
		this.wechat = wechat;
		this.wechatQrcode = wechatQrcode;
		this.alipay = alipay;
		this.alipayQrcode = alipayQrcode;
		this.shareCode = shareCode;
		this.version = version;
		this.versionMin = versionMin;
		this.versionMax = versionMax;
		this.createTime = createTime;
		this.createTimeMin = createTimeMin;
		this.createTimeMax = createTimeMax;
		this.updateTime = updateTime;
		this.updateTimeMin = updateTimeMin;
		this.updateTimeMax = updateTimeMax;
		this.isActive = isActive;
		this.isActiveMin = isActiveMin;
		this.isActiveMax = isActiveMax;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMin() {
		return idMin;
	}

	public void setIdMin(Long idMin) {
		this.idMin = idMin;
	}

	public Long getIdMax() {
		return idMax;
	}

	public void setIdMax(Long idMax) {
		this.idMax = idMax;
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

	public Byte getGenderMin() {
		return genderMin;
	}

	public void setGenderMin(Byte genderMin) {
		this.genderMin = genderMin;
	}

	public Byte getGenderMax() {
		return genderMax;
	}

	public void setGenderMax(Byte genderMax) {
		this.genderMax = genderMax;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthdayMin() {
		return birthdayMin;
	}

	public void setBirthdayMin(Date birthdayMin) {
		this.birthdayMin = birthdayMin;
	}

	public Date getBirthdayMax() {
		return birthdayMax;
	}

	public void setBirthdayMax(Date birthdayMax) {
		this.birthdayMax = birthdayMax;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
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

	public Integer getVersionMin() {
		return versionMin;
	}

	public void setVersionMin(Integer versionMin) {
		this.versionMin = versionMin;
	}

	public Integer getVersionMax() {
		return versionMax;
	}

	public void setVersionMax(Integer versionMax) {
		this.versionMax = versionMax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTimeMin() {
		return createTimeMin;
	}

	public void setCreateTimeMin(Date createTimeMin) {
		this.createTimeMin = createTimeMin;
	}

	public Date getCreateTimeMax() {
		return createTimeMax;
	}

	public void setCreateTimeMax(Date createTimeMax) {
		this.createTimeMax = createTimeMax;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTimeMin() {
		return updateTimeMin;
	}

	public void setUpdateTimeMin(Date updateTimeMin) {
		this.updateTimeMin = updateTimeMin;
	}

	public Date getUpdateTimeMax() {
		return updateTimeMax;
	}

	public void setUpdateTimeMax(Date updateTimeMax) {
		this.updateTimeMax = updateTimeMax;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getIsActiveMin() {
		return isActiveMin;
	}

	public void setIsActiveMin(Byte isActiveMin) {
		this.isActiveMin = isActiveMin;
	}

	public Byte getIsActiveMax() {
		return isActiveMax;
	}

	public void setIsActiveMax(Byte isActiveMax) {
		this.isActiveMax = isActiveMax;
	}

	
    @Override
    public String toString() {
        return "UserDetailQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", nickname = " + nickname + 
				", headicon = " + headicon + 
				", gender = " + gender + 
				", genderMin = " + genderMin + 
				", genderMax = " + genderMax + 
				", birthday = " + birthday + 
				", birthdayMin = " + birthdayMin + 
				", birthdayMax = " + birthdayMax + 
				", age = " + age + 
				", ageMin = " + ageMin + 
				", ageMax = " + ageMax + 
				", qq = " + qq + 
				", qqQrcode = " + qqQrcode + 
				", wechat = " + wechat + 
				", wechatQrcode = " + wechatQrcode + 
				", alipay = " + alipay + 
				", alipayQrcode = " + alipayQrcode + 
				", shareCode = " + shareCode + 
				", version = " + version + 
				", versionMin = " + versionMin + 
				", versionMax = " + versionMax + 
				", createTime = " + createTime + 
				", createTimeMin = " + createTimeMin + 
				", createTimeMax = " + createTimeMax + 
				", updateTime = " + updateTime + 
				", updateTimeMin = " + updateTimeMin + 
				", updateTimeMax = " + updateTimeMax + 
				", isActive = " + isActive + 
				", isActiveMin = " + isActiveMin + 
				", isActiveMax = " + isActiveMax + 
				" }";
    }

}
