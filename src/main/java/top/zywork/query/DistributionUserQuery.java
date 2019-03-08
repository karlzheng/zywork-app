package top.zywork.query;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 分销用户信息Query类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class DistributionUserQuery extends PageQuery {

    private Long userId;
    private Long userIdMin;
    private Long userIdMax;
    private String phone;
    private String email;
    private Integer level;
    private Integer levelMin;
    private Integer levelMax;
    private String nickname;
    private String headicon;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeMin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeMax;

    public DistributionUserQuery() {}

    public DistributionUserQuery(Long userId, Long userIdMin, Long userIdMax, String phone, String email, Integer level, Integer levelMax, Integer levelMin, String nickname, String headicon, Date createTime, Date createTimeMin, Date createTimeMax) {
        this.userId = userId;
        this.userIdMin = userIdMin;
        this.userIdMax = userIdMax;
        this.phone = phone;
        this.email = email;
        this.level = level;
        this.levelMin = levelMin;
        this.levelMax = levelMax;
        this.nickname = nickname;
        this.headicon = headicon;
        this.createTime = createTime;
        this.createTimeMin = createTimeMin;
        this.createTimeMax = createTimeMax;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserIdMin() {
        return userIdMin;
    }

    public void setUserIdMin(Long userIdMin) {
        this.userIdMin = userIdMin;
    }

    public Long getUserIdMax() {
        return userIdMax;
    }

    public void setUserIdMax(Long userIdMax) {
        this.userIdMax = userIdMax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadicon() {
        return headicon;
    }

    public void setHeadicon(String headicon) {
        this.headicon = headicon;
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
