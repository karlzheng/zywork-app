package top.zywork.service;

import top.zywork.dos.UserWithdrawDO;

/**
 * 用户提现Service接口<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface UserWithdrawService {

    /**
     * 保存提现记录
     * @param userId
     * @param withdrawNo
     * @param amount
     * @param bankcardId
     */
    int saveWithdraw(Long userId, String withdrawNo, Long amount, Long bankcardId);

    /**
     * 审核用户提现，审核后人工完成提现
     * @param withdrawNo 用户提现记录编号
     * @param withdrawStatus 审核状态
     * @param description 审核描述
     * @param checkedUserId 审核人编号
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int checkWithdraw(String withdrawNo, Byte withdrawStatus, String description, Long checkedUserId, Integer newVersion);

    /**
     *
     * @param withdrawNo
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int cancelWithdraw(String withdrawNo, Integer newVersion);

    /**
     * 完成用户提现记录，如提现成功或提现失败
     * @param withdrawNo
     * @param withdrawStatus
     * @param userId
     * @param amount
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int completeWithdraw(String withdrawNo, Byte withdrawStatus, Long userId, Long amount, Integer newVersion);

    /**
     * 获取提现记录信息，包含用户编号和提现金额
     * @param withdrawNo
     * @return
     */
    UserWithdrawDO getByWithdrawNo(String withdrawNo);

    /**
     * 获取可提现金额
     * @param userId
     * @return
     */
    long getAvailableWithdraw(Long userId);
}
