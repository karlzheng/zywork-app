package top.zywork.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 分销用户信息VO类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class DistributionUserHierarchyVO {

    private Long id;
    private Long ancestorId;
    private String ancestorPhone;
    private String ancestorNickname;
    private String ancestorHeadicon;
    private String usersId;
    private String usersPhone;
    private String usersNickname;
    private String usersHeadicon;
    private Integer level;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public DistributionUserHierarchyVO() {}

    public DistributionUserHierarchyVO(Long id, Long ancestorId, String ancestorPhone, String ancestorNickname, String ancestorHeadicon, String usersId, String usersPhone, String usersNickname, String usersHeadicon, Integer level, Date createTime) {
        this.id = id;
        this.ancestorId = ancestorId;
        this.ancestorPhone = ancestorPhone;
        this.ancestorNickname = ancestorNickname;
        this.ancestorHeadicon = ancestorHeadicon;
        this.usersId = usersId;
        this.usersPhone = usersPhone;
        this.usersNickname = usersNickname;
        this.usersHeadicon = usersHeadicon;
        this.level = level;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(Long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public String getAncestorPhone() {
        return ancestorPhone;
    }

    public void setAncestorPhone(String ancestorPhone) {
        this.ancestorPhone = ancestorPhone;
    }

    public String getAncestorNickname() {
        return ancestorNickname;
    }

    public void setAncestorNickname(String ancestorNickname) {
        this.ancestorNickname = ancestorNickname;
    }

    public String getAncestorHeadicon() {
        return ancestorHeadicon;
    }

    public void setAncestorHeadicon(String ancestorHeadicon) {
        this.ancestorHeadicon = ancestorHeadicon;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getUsersPhone() {
        return usersPhone;
    }

    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone;
    }

    public String getUsersNickname() {
        return usersNickname;
    }

    public void setUsersNickname(String usersNickname) {
        this.usersNickname = usersNickname;
    }

    public String getUsersHeadicon() {
        return usersHeadicon;
    }

    public void setUsersHeadicon(String usersHeadicon) {
        this.usersHeadicon = usersHeadicon;
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
