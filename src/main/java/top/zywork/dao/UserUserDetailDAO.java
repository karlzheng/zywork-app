package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserUserDetailDAO数据访问接口<br/>
 *
 * 创建于2018-12-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface UserUserDetailDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);
}
