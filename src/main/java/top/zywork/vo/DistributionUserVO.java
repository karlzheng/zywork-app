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
public class DistributionUserVO {

    private Long userId;
    private String phone;
    private String email;
    private Integer level;
    private String nickname;
    private String headicon;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public DistributionUserVO() {}

    public DistributionUserVO(Long userId, String phone, String email, Integer level, String nickname, String headicon, Date createTime) {
        this.userId = userId;
        this.phone = phone;
        this.email = email;
        this.level = level;
        this.nickname = nickname;
        this.headicon = headicon;
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
}
