package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * NoticeVO值对象类<br/>
 *
 * 创建于2019-01-07<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class NoticeVO extends BaseVO {

    private static final long serialVersionUID = -9223372036844275783L;

    // 公告编号
	private Long id;
	// 公告标题
	@Size(min = 0, max = 50, message = "必须小于50个字符")
	private String title;
	// 公告摘要
	@Size(min = 0, max = 255, message = "必须小于255个字符")
	private String summary;
	// 公告内容
	@Size(min = 0, max = 5000, message = "必须小于5000个字符")
	private String content;
	// 截止时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
	// 置顶状态
	private Byte stickStatus;
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
	
    public NoticeVO () {}

    public NoticeVO (Long id, String title, String summary, String content, Date endTime, Byte stickStatus, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.endTime = endTime;
		this.stickStatus = stickStatus;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Byte getStickStatus() {
		return stickStatus;
	}

	public void setStickStatus(Byte stickStatus) {
		this.stickStatus = stickStatus;
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
        return "NoticeVO {" +
                "id = " + id + 
				", title = " + title + 
				", summary = " + summary + 
				", content = " + content + 
				", endTime = " + endTime + 
				", stickStatus = " + stickStatus + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
