package top.zywork.dos;

import java.util.Date;

/**
 * 分销用户信息实体类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class DistributionUserDO {

    private Long userId;
    private String phone;
    private Integer level;
    private Date createTime;

    public DistributionUserDO() {}

    public DistributionUserDO(Long userId, String phone, Integer level, Date createTime) {
        this.userId = userId;
        this.phone = phone;
        this.level = level;
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
