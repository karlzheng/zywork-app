package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * UserPathDAO数据访问接口<br/>
 *
 * 创建于2019-03-08<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface UserPathDAO extends BaseDAO {

    @Override
    List<Object> listAllByCondition(@Param("query") Object queryObj);

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);
}
