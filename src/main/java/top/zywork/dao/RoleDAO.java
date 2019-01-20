package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RoleDAO数据访问接口<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface RoleDAO extends BaseDAO {

    @Override
    List<Object> listPageByCondition(@Param("query") Object queryObj);

    @Override
    Long countByCondition(@Param("query") Object queryObj);

    /**
     * 根据角色名称获取角色编号
     * @param title
     * @return
     */
    Long getByTitle(String title);

    /**
     * 删除所有角色
     */
    void removeAll();
}
