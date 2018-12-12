package top.zywork.dos;

/**
 * 微信登录保存用户基础信息时用到的do对象<br/>
 *
 * 创建于2018-12-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class UserRegDO {

    private Long id;
    private String password;

    public UserRegDO() {}

    public UserRegDO(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
