package top.zywork.dos;

import java.util.Date;

/**
 * 分销用户路径实体类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class DistributionUserPathDO {

    private Long id;
    private String userPath;
    private Date createTime;

    public DistributionUserPathDO() {}

    public DistributionUserPathDO(Long id, String userPath, Date createTime) {
        this.id = id;
        this.userPath = userPath;
        this.createTime = createTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
