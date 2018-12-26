package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserWalletDAO数据访问接口<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface UserWalletDAO extends BaseDAO {

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 充值时更新用户钱包余额和可用余额
     * @param userId
     * @param amount
     * @param newVersion
     */
    int updateWalletRecharge(@Param("userId") Long userId, @Param("amount") Long amount, @Param("newVersion") Integer newVersion);

    /**
     * 提现时更新用户钱包余额和可用余额
     * @param userId
     * @param amount
     */
    int updateWalletWithdraw(@Param("userId") Long userId, @Param("amount") Long amount);
}
