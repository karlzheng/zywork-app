package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.dos.UserRegDO;

/**
 * 用户注册保存用户信息DAO接口<br/>
 *
 * 创建于2018-12-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserRegDAO {

    /**
     * 邮箱注册保存用户信息
     * @param userRegDO
     */
    void saveUser(UserRegDO userRegDO);

    /**
     * 手机注册保存用户信息
     * @param userRegDO
     */
    void saveUserMobile(UserRegDO userRegDO);

    /**
     * 公众号登录时保存用户基础信息
     * @param userRegDO
     */
    void saveGzhUser(UserRegDO userRegDO);

    /**
     * 公众号登录时保存用户详情
     * @param userId
     * @param nickname
     * @param headicon
     * @param gender
     */
    void saveGzhUserDetail(@Param("userId") Long userId, @Param("nickname") String nickname, @Param("headicon") String headicon, @Param("gender") byte gender);

    /**
     * 公众号登录时保存用户社交登录信息，如openid
     * @param userId
     * @param openid
     */
    void saveGzhUserSocial(@Param("userId") Long userId, @Param("openid") String openid);

}
