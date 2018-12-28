package top.zywork.service;

/**
 * 用户邀请Service接口<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface UserInviteService {

    /**
     * 保存用户层级关系及用户路径
     * @param pUserId
     * @param userId
     */
    void saveUserHierarchy(Long pUserId, Long userId);

}
