package top.zywork.service;

/**
 * 用户转账Service接口<br/>
 *
 * 创建于2019-01-06<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface UserTransferService {

    /**
     * 保存用户转账记录
     * @param userId
     * @param toUserId
     * @param amount
     * @return
     */
    int saveTransfer(Long userId, Long toUserId, Long amount);

}
