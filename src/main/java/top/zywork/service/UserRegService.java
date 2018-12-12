package top.zywork.service;

/**
 * 用户注册保存用户信息Service接口<br/>
 *
 * 创建于2018-12-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface UserRegService {

    /**
     * 保存邮箱注册用户信息
     * @param email
     * @param password
     */
    void saveUser(String email, String password);

    /**
     * 保存手机注册用户信息
     * @param phone
     * @param password
     */
    void saveUserMobile(String phone, String password);

    /**
     * 保存微信公众号登录用户信息
     * @param openid
     * @param password
     * @param nickname
     * @param headicon
     * @param gender
     */
    void saveGzhUser(String openid, String password, String nickname, String headicon, byte gender);

}
