package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.dos.UserWithdrawDO;

/**
 * 用户提现DAO接口<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserWithdrawDAO {

    /**
     * 保存提现记录
     * @param userId
     * @param amount
     * @param bankcardId
     */
    int saveWithdraw(@Param("userId") Long userId, @Param("withdrawNo") String withdrawNo, @Param("amount") Long amount, @Param("bankcardId") Long bankcardId);

    /**
     * 更新用户提现，如审核未通过，需要提交未通过说明
     * @param withdrawNo 用户提现单号
     * @param withdrawStatus 审核状态
     * @param description 审核描述
     * @param checkedUserId 审核人编号
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int updateWithdrawCheck(@Param("withdrawNo") String withdrawNo, @Param("withdrawStatus") Byte withdrawStatus,
                             @Param("description") String description, @Param("checkedUserId") Long checkedUserId, @Param("newVersion") Integer newVersion);

    /**
     * 更新用户提现最终状态，如提现成功，提现失败
     * @param withdrawNo 用户提现单号
     * @param withdrawStatus 提现状态
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int updateWithdraw(@Param("withdrawNo") String withdrawNo, @Param("withdrawStatus") Byte withdrawStatus, @Param("newVersion") Integer newVersion);

    /**
     * 获取所有未完成的即complete_time为null的提现总额
     * @param userId
     * @return
     */
    Long getTotalUncompleteWithdraw(Long userId);

    /**
     * 获取提现记录信息，包含用户编号和提现金额
     * @param withdrawNo
     * @return
     */
    UserWithdrawDO getByWithdrawNo(String withdrawNo);

}
