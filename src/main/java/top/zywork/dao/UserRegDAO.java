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
     * 公众号、小程序登录时保存用户基础信息
     * @param userRegDO
     */
    void saveWeixinUser(UserRegDO userRegDO);

    /**
     * 公众号、小程序登录时保存用户详情
     * @param userId
     * @param nickname
     * @param headicon
     * @param gender
     * @param shareCode
     */
    void saveWeixinUserDetail(@Param("userId") Long userId, @Param("nickname") String nickname,
                           @Param("headicon") String headicon, @Param("gender") Byte gender,
                           @Param("shareCode") String shareCode);

    /**
     * 公众号、小程序登录时保存用户社交登录信息，如openid
     * @param userId
     * @param openid
     * @param unionId
     */
    void saveWeixinUserSocial(@Param("userId") Long userId, @Param("openid") String openid, @Param("unionId") String unionId,
                              @Param("accessToken") String accessToken, @Param("sessionKey") String sessionKey, @Param("socialType") String socialType);

    /**
     * 更新公众号，小程序用户信息
     * @param openid
     * @param nickname
     * @param headicon
     * @param gender
     */
    void updateWeixinUserDetail(@Param("openid") String openid, @Param("nickname") String nickname, @Param("headicon") String headicon, @Param("gender") Byte gender);

    /**
     * 更新第三方登录的access token 或 session key
     * @param openid
     * @param accessToken
     * @param sessionKey
     */
    void updateWeixinUserSocial(@Param("openid") String openid, @Param("accessToken") String accessToken, @Param("sessionKey") String sessionKey);

    /**
     * 根据openid获取session_key
     * @param openid
     * @return
     */
    String getSessionKeyByOpenid(String openid);

    /**
     * 根据openid及手机号更新用户手机号
     * @param openid
     * @param phone
     */
    void updateUserPhone(@Param("openid") String openid, @Param("phone") String phone);

    /**
     * 用户注册时保存分享码
     * @param userId
     * @param shareCode
     */
    void saveShareCode(@Param("userId") Long userId, @Param("shareCode") String shareCode);

    /**
     * 根据分享码获取用户id
     * @param shareCode
     * @return
     */
    Long getUserIdByShareCode(String shareCode);

    /**
     * 注册用户时，需要在用户钱包表中插入一条对应的记录
     * @param userId
     */
    void saveUserWallet(Long userId);

}
