package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户密码操作DAO接口<br/>
 *
 * 创建于2018-12-21<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserPasswordDAO {

    /**
     * 使用邮箱重置登录密码
     * @param email
     * @param password
     */
    void resetLoginPwdByEmail(@Param("email") String email, @Param("password") String password);

    /**
     * 使用手机重置登录密码
     * @param phone
     * @param password
     */
    void resetLoginPwdByPhone(@Param("phone") String phone, @Param("password") String password);

    /**
     * 更新登录密码
     * @param userId
     * @param password
     */
    void updateLoginPwd(@Param("userId") Long userId, @Param("password") String password);

    /**
     * 获取登录密码
     * @param userId
     * @return
     */
    String getLoginPwd(Long userId);

    /**
     * 使用邮箱重置支付密码
     * @param email
     * @param password
     */
    void resetPayPwdByEmail(@Param("email") String email, @Param("password") String password);

    /**
     * 使用手机重置支付密码
     * @param phone
     * @param password
     */
    void resetPayPwdByPhone(@Param("phone") String phone, @Param("password") String password);

    /**
     * 更新支付密码
     * @param userId
     * @param password
     */
    void updatePayPwd(@Param("userId") Long userId, @Param("password") String password);

    /**
     * 获取支付密码
     * @param userId
     * @return
     */
    String getPayPwd(Long userId);

}
