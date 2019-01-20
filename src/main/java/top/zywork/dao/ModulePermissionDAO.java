package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * ModulePermissionDAO数据访问接口<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface ModulePermissionDAO extends BaseDAO {

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 根据用户编号获取用户所有模块权限
     * @param userId
     * @return
     */
    List<Object> listByUserId(Long userId);

    /**
     * 按权限的id排序获取指定模块下的所有权限
     * @param id
     * @return
     */
    List<Object> listByIdAsc(Long id);

}
