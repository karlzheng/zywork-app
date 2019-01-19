package top.zywork.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * StatisticsDauVO值对象类<br/>
 *
 * 创建于2019-01-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class StatisticsDauVO extends BaseVO {

    private static final long serialVersionUID = -9223372035377947259L;

    // DAU编号
	private Long id;
	// DAU
	@NotNull(message = "此项是必须项")
	private Long dau;
	// 统计时间
	@NotNull(message = "此项是必须项")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date statisticsTime;
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
	
    public StatisticsDauVO () {}

    public StatisticsDauVO (Long id, Long dau, Date statisticsTime, Integer version, Date createTime, Date updateTime, Byte isActive) {
        this.id = id;
		this.dau = dau;
		this.statisticsTime = statisticsTime;
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

	public Long getDau() {
		return dau;
	}

	public void setDau(Long dau) {
		this.dau = dau;
	}

	public Date getStatisticsTime() {
		return statisticsTime;
	}

	public void setStatisticsTime(Date statisticsTime) {
		this.statisticsTime = statisticsTime;
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
        return "StatisticsDauVO {" +
                "id = " + id + 
				", dau = " + dau + 
				", statisticsTime = " + statisticsTime + 
				", version = " + version + 
				", createTime = " + createTime + 
				", updateTime = " + updateTime + 
				", isActive = " + isActive + 
				" }";
    }

}
