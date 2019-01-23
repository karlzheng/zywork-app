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
     * 保存邮箱注册用户信息<br/>
     * 1、基体信息
     * 2、分享码信息（详情）
     * 3、钱包信息
     * @param email
     * @param password
     * @param roleId
     * @param inviteUserId
     */
    void saveUser(String email, String password, Long roleId, Long inviteUserId);

    /**
     * 保存手机注册用户信息
     * 1、基体信息
     * 2、分享码信息（详情）
     * 3、钱包信息
     * @param phone
     * @param password
     * @param roleId
     * @param inviteUserId
     */
    void saveUserMobile(String phone, String password, Long roleId, Long inviteUserId);

    /**
     * 保存微信公众号、小程序登录用户信息
     * 1、基本信息
     * 2、分享码信息（详情）
     * 3、钱包信息
     * @param openid
     * @param unionId
     * @param accessToken
     * @param sessionKey
     * @param socialType
     * @param password
     * @param nickname
     * @param headicon
     * @param gender
     * @param roleId
     * @param inviteUserId
     */
    void saveWeixinUser(String openid, String unionId, String accessToken, String sessionKey, String socialType, String password,
                        String nickname, String headicon, Byte gender, Long roleId, Long inviteUserId);

    /**
     * 保存小程序用户信息
     * @param openid
     * @param nickname
     * @param headicon
     * @param gender
     */
    void updateWeixinUserDetail(String openid, String nickname, String headicon, Byte gender);

    /**
     * 更新第三方登录的access token 或 session key
     * @param openid
     * @param accessToken
     * @param sessionKey
     */
    void updateWeixinUserSocial(String openid, String accessToken, String sessionKey);

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
    void updateUserPhone(String openid, String phone);

    /**
     * 根据分享码获取用户id
     * @param shareCode
     * @return
     */
    Long getUserIdByShareCode(String shareCode);

}
