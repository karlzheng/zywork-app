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
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 钱包进账
     * @param userId
     * @param amount
     */
    int updateWalletIn(@Param("userId") Long userId, @Param("amount") Long amount);

    /**
     * 钱包出账
     * @param userId
     * @param amount
     */
    int updateWalletOut(@Param("userId") Long userId, @Param("amount") Long amount);
}
