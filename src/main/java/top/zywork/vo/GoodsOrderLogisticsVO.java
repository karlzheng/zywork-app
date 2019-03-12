package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * GoodsOrderLogisticsVO值对象类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class GoodsOrderLogisticsVO extends BaseVO {

    private static final long serialVersionUID = -9223372034922708657L;

    // 订单编号
	private Long id;
	// 收货人
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String realName;
	// 手机号
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 11, message = "必须是1-11个字符")
	private String phone;
	// 省
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String province;
	// 市
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String city;
	// 区/县
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 20, message = "必须是1-20个字符")
	private String district;
	// 详细地址
	@NotBlank(message = "此项是必须项")
	@Size(min = 1, max = 255, message = "必须是1-255个字符")
	private String address;
	// 是否已发货
	private Byte isDeliver;
	// 物流公司名称
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String logisticsCompany;
	// 物流公司编码
	@Size(min = 0, max = 20, message = "必须小于20个字符")
	private String logisticsCode;
	// 物流单号
	@Size(min = 0, max = 32, message = "必须小于32个字符")
	private String logisticsNo;
	// 版本号
	private Integer version;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public GoodsOrderLogisticsVO () {}

    public GoodsOrderLogisticsVO (Long id, String realName, String phone, String province, String city, String district, String address, Byte isDeliver, String logisticsCompany, String logisticsCode, String logisticsNo, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.realName = realName;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.isDeliver = isDeliver;
		this.logisticsCompany = logisticsCompany;
		this.logisticsCode = logisticsCode;
		this.logisticsNo = logisticsNo;
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

	public Byte getIsDeliver() {
		return isDeliver;
	}

	public void setIsDeliver(Byte isDeliver) {
		this.isDeliver = isDeliver;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getLogisticsCode() {
		return logisticsCode;
	}

	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
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
        return "GoodsOrderLogisticsVO {" +
                "id = " + id + 
				", realName = " + realName + 
				", phone = " + phone + 
				", province = " + province + 
				", city = " + city + 
				", district = " + district + 
				", address = " + address + 
				", isDeliver = " + isDeliver + 
				", logisticsCompany = " + logisticsCompany + 
				", logisticsCode = " + logisticsCode + 
				", logisticsNo = " + logisticsNo + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
