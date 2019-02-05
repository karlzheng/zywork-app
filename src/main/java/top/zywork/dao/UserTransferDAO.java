package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户转账DAO接口<br/>
 *
 * 创建于2019-01-06<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserTransferDAO {

    /**
     * 保存转账记录，转出方
     * @param transactionNo
     * @param userId
     * @param toUserId
     * @param amount
     * @param transferType
     * @return
     */
    int saveTransfer(@Param("transactionNo") String transactionNo, @Param("userId") Long userId, @Param("toUserId") Long toUserId, @Param("amount") Long amount, @Param("transferType") String transferType);

    /**
     * 保存转账记录，收款方
     * @param transactionNo
     * @param userId
     * @param fromUserId
     * @param amount
     * @param transferType
     * @return
     */
    int saveTransferTo(@Param("transactionNo") String transactionNo, @Param("userId") Long userId, @Param("fromUserId") Long fromUserId, @Param("amount") Long amount, @Param("transferType") String transferType);

}
