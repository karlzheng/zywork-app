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
     * @param amount
     * @param bankcardId
     */
    int saveWithdraw(Long userId, Long amount, Long bankcardId);

    /**
     * 审核用户提现，审核后人工完成提现
     * @param userId 用户编号
     * @param withdrawId 提现编号
     * @param transactionNo 用户提现记录编号
     * @param withdrawStatus 审核状态
     * @param description 审核描述
     * @param checkedUserId 审核人编号
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int checkWithdraw(Long userId, Long withdrawId, String transactionNo, Byte withdrawStatus, String description, Long checkedUserId, Integer newVersion);

    /**
     *
     * @param transactionNo
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int cancelWithdraw(String transactionNo, Integer newVersion);

    /**
     * 完成用户提现记录，如提现成功或提现失败
     * @param withdrawId
     * @param transactionNo
     * @param withdrawStatus
     * @param userId
     * @param amount
     * @param completeUserId
     * @param newVersion 更新的版本号
     * @return 如果版本错误，已经被更新过，则不更新，返回0
     */
    int completeWithdraw(Long withdrawId, String transactionNo, Byte withdrawStatus, Long userId, Long amount, Long completeUserId, Integer newVersion);

    /**
     * 获取提现记录信息，包含用户编号和提现金额
     * @param transactionNo
     * @return
     */
    UserWithdrawDO getByTransactionNo(String transactionNo);

    /**
     * 获取可提现金额
     * @param userId
     * @return
     */
    long getAvailableWithdraw(Long userId);
}
