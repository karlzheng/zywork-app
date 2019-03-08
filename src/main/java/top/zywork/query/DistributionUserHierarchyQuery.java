package top.zywork.query;

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
public class DistributionUserHierarchyQuery extends PageQuery {

    private Long id;
    private Long idMin;
    private Long idMax;
    private Long ancestorId;
    private Long ancestorIdMin;
    private Long ancestorIdMax;
    private String ancestorPhone;
    private String ancestorNickname;
    private String ancestorHeadicon;
    private Long usersId;
    private Long usersIdMin;
    private Long usersIdMax;
    private String usersPhone;
    private String usersNickname;
    private String usersHeadicon;
    private Integer level;
    private Integer levelMin;
    private Integer levelMax;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeMin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeMax;

    public DistributionUserHierarchyQuery() {}

    public DistributionUserHierarchyQuery(Long id, Long idMin, Long idMax, Long ancestorId, Long ancestorIdMin, Long ancestorIdMax, String ancestorPhone, String ancestorNickname, String ancestorHeadicon, Long usersId, Long usersIdMin, Long usersIdMax, String usersPhone, String usersNickname, String usersHeadicon, Integer level, Integer levelMin, Integer levelMax, Date createTime, Date createTimeMin, Date createTimeMax) {
        this.id = id;
        this.idMin = idMin;
        this.idMax = idMax;
        this.ancestorId = ancestorId;
        this.ancestorIdMin = ancestorIdMin;
        this.ancestorIdMax = ancestorIdMax;
        this.ancestorPhone = ancestorPhone;
        this.ancestorNickname = ancestorNickname;
        this.ancestorHeadicon = ancestorHeadicon;
        this.usersId = usersId;
        this.usersIdMin = usersIdMin;
        this.usersIdMax = usersIdMax;
        this.usersPhone = usersPhone;
        this.usersNickname = usersNickname;
        this.usersHeadicon = usersHeadicon;
        this.level = level;
        this.levelMin = levelMin;
        this.levelMax = levelMax;
        this.createTime = createTime;
        this.createTimeMin = createTimeMin;
        this.createTimeMax = createTimeMax;
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

    public Long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(Long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public Long getAncestorIdMin() {
        return ancestorIdMin;
    }

    public void setAncestorIdMin(Long ancestorIdMin) {
        this.ancestorIdMin = ancestorIdMin;
    }

    public Long getAncestorIdMax() {
        return ancestorIdMax;
    }

    public void setAncestorIdMax(Long ancestorIdMax) {
        this.ancestorIdMax = ancestorIdMax;
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

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getUsersIdMin() {
        return usersIdMin;
    }

    public void setUsersIdMin(Long usersIdMin) {
        this.usersIdMin = usersIdMin;
    }

    public Long getUsersIdMax() {
        return usersIdMax;
    }

    public void setUsersIdMax(Long usersIdMax) {
        this.usersIdMax = usersIdMax;
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

    public Integer getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(Integer levelMin) {
        this.levelMin = levelMin;
    }

    public Integer getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(Integer levelMax) {
        this.levelMax = levelMax;
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

}
