package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SchedulerDO数据对象实体类<br/>
 *
 * 创建于2019-01-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class SchedulerDO extends BaseDO {

    private static final long serialVersionUID = -9223372035639857891L;

    // 作业编号
	private Long id;
	// 作业名称
	private String name;
	// 完整类名
	private String className;
	// cron表达式
	private String cronExpression;
	// 作业组名称
	private String groupName;
	// 触发器名称
	private String triggerName;
	// 触发器组
	private String triggerGroup;
	// 作业描述
	private String description;
	// 作业状态
	private Byte jobStatus;
	// 状态更新时间
	private Date jobStatusTime;
	// 自动启动
	private Byte autoStart;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public SchedulerDO () {}

    public SchedulerDO (Long id, String name, String className, String cronExpression, String groupName, String triggerName, String triggerGroup, String description, Byte jobStatus, Date jobStatusTime, Byte autoStart, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.name = name;
		this.className = className;
		this.cronExpression = cronExpression;
		this.groupName = groupName;
		this.triggerName = triggerName;
		this.triggerGroup = triggerGroup;
		this.description = description;
		this.jobStatus = jobStatus;
		this.jobStatusTime = jobStatusTime;
		this.autoStart = autoStart;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroup() {
		return triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Byte jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Date getJobStatusTime() {
		return jobStatusTime;
	}

	public void setJobStatusTime(Date jobStatusTime) {
		this.jobStatusTime = jobStatusTime;
	}

	public Byte getAutoStart() {
		return autoStart;
	}

	public void setAutoStart(Byte autoStart) {
		this.autoStart = autoStart;
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
        return "SchedulerDO {" +
                "id = " + id + 
				", name = " + name + 
				", className = " + className + 
				", cronExpression = " + cronExpression + 
				", groupName = " + groupName + 
				", triggerName = " + triggerName + 
				", triggerGroup = " + triggerGroup + 
				", description = " + description + 
				", jobStatus = " + jobStatus + 
				", jobStatusTime = " + jobStatusTime + 
				", autoStart = " + autoStart + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
