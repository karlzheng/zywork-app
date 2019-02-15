package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProcessDO数据对象实体类<br/>
 *
 * 创建于2019-02-15<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ProcessDO extends BaseDO {

    private static final long serialVersionUID = -9223372035988052821L;

    // 流程编号
	private Long id;
	// 流程Name
	private String processName;
	// 流程Key
	private String processKey;
	// 流程文件路径
	private String filePath;
	// 流程描述
	private String description;
	// 是否部署
	private Byte isDeploy;
	// 部署时间
	private Date deployTime;
	// 版本号
	private Integer version;
	// 上传时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public ProcessDO () {}

    public ProcessDO (Long id, String processName, String processKey, String filePath, String description, Byte isDeploy, Date deployTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.processName = processName;
		this.processKey = processKey;
		this.filePath = filePath;
		this.description = description;
		this.isDeploy = isDeploy;
		this.deployTime = deployTime;
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

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getIsDeploy() {
		return isDeploy;
	}

	public void setIsDeploy(Byte isDeploy) {
		this.isDeploy = isDeploy;
	}

	public Date getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
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
        return "ProcessDO {" +
                "id = " + id + 
				", processName = " + processName + 
				", processKey = " + processKey + 
				", filePath = " + filePath + 
				", description = " + description + 
				", isDeploy = " + isDeploy + 
				", deployTime = " + deployTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
