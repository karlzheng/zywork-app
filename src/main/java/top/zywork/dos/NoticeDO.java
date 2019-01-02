package top.zywork.dos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * NoticeDO数据对象实体类<br/>
 *
 * 创建于2019-01-02<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class NoticeDO extends BaseDO {

    private static final long serialVersionUID = -9223372036526163675L;

    // 公告编号
	private Long id;
	// 公告标题
	private String title;
	// 公告摘要
	private String summary;
	// 公告内容
	private String content;
	// 版本号
	private Integer version;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 是否激活
	private Byte isActive;
	
    public NoticeDO () {}

    public NoticeDO (Long id, String title, String summary, String content, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
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
        return "NoticeDO {" +
                "id = " + id + 
				", title = " + title + 
				", summary = " + summary + 
				", content = " + content + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
