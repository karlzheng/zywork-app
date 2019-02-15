package top.zywork.query;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ProcessQuery查询对象类<br/>
 *
 * 创建于2019-02-15<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class ProcessQuery extends PageQuery {

    private static final long serialVersionUID = -9223372035545950720L;

    // 流程编号
	private Long id;
	// 流程编号（最小值）
	private Long idMin;
	// 流程编号（最大值）
	private Long idMax;
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
	// 是否部署（最小值）
	private Byte isDeployMin;
	// 是否部署（最大值）
	private Byte isDeployMax;
	// 部署时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deployTime;
	// 部署时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deployTimeMin;
	// 部署时间（最大值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deployTimeMax;
	// 版本号
	private Integer version;
	// 版本号（最小值）
	private Integer versionMin;
	// 版本号（最大值）
	private Integer versionMax;
	// 上传时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	// 上传时间（最小值）
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTimeMin;
	// 上传时间（最大值）
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
	
    public ProcessQuery () {}

    public ProcessQuery (Long id, Long idMin, Long idMax, String processName, String processKey, String filePath, String description, Byte isDeploy, Byte isDeployMin, Byte isDeployMax, Date deployTime, Date deployTimeMin, Date deployTimeMax, Integer version, Integer versionMin, Integer versionMax, Date createTime, Date createTimeMin, Date createTimeMax, Date updateTime, Date updateTimeMin, Date updateTimeMax, Byte isActive, Byte isActiveMin, Byte isActiveMax) {
        this.id = id;
		this.idMin = idMin;
		this.idMax = idMax;
		this.processName = processName;
		this.processKey = processKey;
		this.filePath = filePath;
		this.description = description;
		this.isDeploy = isDeploy;
		this.isDeployMin = isDeployMin;
		this.isDeployMax = isDeployMax;
		this.deployTime = deployTime;
		this.deployTimeMin = deployTimeMin;
		this.deployTimeMax = deployTimeMax;
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

	public Byte getIsDeployMin() {
		return isDeployMin;
	}

	public void setIsDeployMin(Byte isDeployMin) {
		this.isDeployMin = isDeployMin;
	}

	public Byte getIsDeployMax() {
		return isDeployMax;
	}

	public void setIsDeployMax(Byte isDeployMax) {
		this.isDeployMax = isDeployMax;
	}

	public Date getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}

	public Date getDeployTimeMin() {
		return deployTimeMin;
	}

	public void setDeployTimeMin(Date deployTimeMin) {
		this.deployTimeMin = deployTimeMin;
	}

	public Date getDeployTimeMax() {
		return deployTimeMax;
	}

	public void setDeployTimeMax(Date deployTimeMax) {
		this.deployTimeMax = deployTimeMax;
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
        return "ProcessQuery {" +
                "id = " + id + 
				", idMin = " + idMin + 
				", idMax = " + idMax + 
				", processName = " + processName + 
				", processKey = " + processKey + 
				", filePath = " + filePath + 
				", description = " + description + 
				", isDeploy = " + isDeploy + 
				", isDeployMin = " + isDeployMin + 
				", isDeployMax = " + isDeployMax + 
				", deployTime = " + deployTime + 
				", deployTimeMin = " + deployTimeMin + 
				", deployTimeMax = " + deployTimeMax + 
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
