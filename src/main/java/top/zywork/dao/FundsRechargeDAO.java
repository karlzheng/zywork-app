package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * FundsRechargeDAO数据访问接口<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface FundsRechargeDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);
}
