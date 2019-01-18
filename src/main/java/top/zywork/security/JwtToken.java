package top.zywork.security;

/**
 * JwtToken类，包含jwt token值，和token被使用的时刻时间（只需要日期）对应的字符串<br/>
 *
 * 创建于2019-01-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class JwtToken {

    private String token;
    // 最后使用jwt token的时间日期字符串如2019-01-17
    private String lastUseData;

    public JwtToken() {}

    public JwtToken(String token, String lastUseData) {
        this.token = token;
        this.lastUseData = lastUseData;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLastUseData() {
        return lastUseData;
    }

    public void setLastUseData(String lastUseData) {
        this.lastUseData = lastUseData;
    }

}
