package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户邀请DAO接口<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserInviteDAO {

    /**
     * 保存用户层级关系及用户路径
     * @param pUserId
     * @param userId
     */
    void saveUserHierarchy(@Param("pUserId") Long pUserId, @Param("userId") Long userId);

}
