package top.zywork.service;

/**
 * 用户密码操作Service接口<br/>
 *
 * 创建于2018-12-21<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface UserPasswordService {

    /**
     * 使用邮箱重置登录密码
     * @param email
     * @param password
     */
    void resetLoginPwdByEmail(String email, String password);

    /**
     * 使用手机重置登录密码
     * @param phone
     * @param password
     */
    void resetLoginPwdByPhone(String phone, String password);

    /**
     * 更新登录密码
     * @param userId
     * @param oldPassword
     * @param password
     * @return 返回false，则表示旧密码错误，true表示更新成功
     */
    boolean updateLoginPwd(Long userId, String oldPassword, String password);

    /**
     * 使用邮箱重置支付密码
     * @param email
     * @param password
     */
    void resetPayPwdByEmail(String email, String password);

    /**
     * 使用手机重置支付密码
     * @param phone
     * @param password
     */
    void resetPayPwdByPhone(String phone, String password);

    /**
     * 更新支付密码
     * @param userId
     * @param oldPassword
     * @param password
     * @return 返回false，则表示旧密码错误，true表示更新成功
     */
    boolean updatePayPwd(Long userId, String oldPassword, String password);

}
