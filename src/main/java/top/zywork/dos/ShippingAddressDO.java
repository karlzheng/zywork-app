package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ShippingAddressDO数据对象实体类<br/>
 *
 * 创建于2019-01-03<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ShippingAddressDO extends BaseDO {

    private static final long serialVersionUID = -9223372035034991531L;

    // 地址编号
	private Long id;
	// 用户编号
	private Long userId;
	// 收货人
	private String realName;
	// 手机号
	private String phone;
	// 省
	private String province;
	// 市
	private String city;
	// 区/县
	private String district;
	// 详细地址
	private String address;
	// 是否默认
	private Byte isDefault;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ShippingAddressDO () {}

    public ShippingAddressDO (Long id, Long userId, String realName, String phone, String province, String city, String district, String address, Byte isDefault, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userId = userId;
		this.realName = realName;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.isDefault = isDefault;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Byte isDefault) {
		this.isDefault = isDefault;
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
        return "ShippingAddressDO {" +
                "id = " + id + 
				", userId = " + userId + 
				", realName = " + realName + 
				", phone = " + phone + 
				", province = " + province + 
				", city = " + city + 
				", district = " + district + 
				", address = " + address + 
				", isDefault = " + isDefault + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
