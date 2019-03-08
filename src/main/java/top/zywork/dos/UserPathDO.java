package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UserPathDO数据对象实体类<br/>
 *
 * 创建于2019-03-08<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserPathDO extends BaseDO {

    private static final long serialVersionUID = -9223372036308282620L;

    // 路径编号
	private Long id;
	// 用户路径
	private String userPath;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public UserPathDO () {}

    public UserPathDO (Long id, String userPath, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.userPath = userPath;
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

	public String getUserPath() {
		return userPath;
	}

	public void setUserPath(String userPath) {
		this.userPath = userPath;
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
        return "UserPathDO {" +
                "id = " + id + 
				", userPath = " + userPath + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
