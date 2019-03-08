package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.query.DistributionUserHierarchyQuery;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * 分销数据查询DAO接口<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface DistributionDAO {

    /**
     * 查询所有顶级分销商，及上面没有分销商
     * @return
     */
    List<Object> listAllTop(@Param("query") Object queryObj);

    /**
     * 所有顶级分销商计数
     * @return
     */
    Long countAllTop();

    /**
     * 分页查询指定用户的上级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param levels 用户上面的几级经销商，如查询用户上面的一级经销商，则new Long[]{1}，如果查询用户上面的一级和二级经销商，则new Long[]{1, 2}
     * @param pageQuery 分页对象
     * @return
     */
    List<Object> listAboveUsers(@Param("userId") Long userId, @Param("distributionLevel") Integer distributionLevel, @Param("levels") Long[] levels, @Param("query") PageQuery pageQuery);

    /**
     * 指定用户上级分销商计数
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param levels 用户上面的几级经销商，如查询用户上面的一级经销商，则new Long[]{1}，如果查询用户上面的一级和二级经销商，则new Long[]{1, 2}
     * @return
     */
    Long countAboveUsers(@Param("userId") Long userId, @Param("distributionLevel") Integer distributionLevel, @Param("levels") Long[] levels);

    /**
     * 分页查询指定用户的直接上级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param level 用户上面的几级经销商，如查询用户上面的二级经销商，则level = 2
     * @return
     */
    List<Object> allDirectAboveUsers(@Param("userId") Long userId, @Param("distributionLevel") Integer distributionLevel, @Param("level") Long level);

    /**
     * 分页查询指定用户的下级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param levels 用户下面的几级经销商，如查询用户下面的二级经销商，则new Long[]{2}，如果查询用户上面的二级和三级经销商，则new Long[]{2, 3}
     * @param pageQuery 分页对象
     * @return
     */
    List<Object> listBelowUsers(@Param("userId") Long userId, @Param("distributionLevel") Integer distributionLevel, @Param("levels") Long[] levels, @Param("query") PageQuery pageQuery);

    /**
     * 指定用户的下级经销商计数
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param levels 用户下面的几级经销商，如查询用户下面的二级经销商，则new Long[]{2}，如果查询用户上面的二级和三级经销商，则new Long[]{2, 3}
     * @return
     */
    Long countBelowUsers(@Param("userId") Long userId, @Param("distributionLevel") Integer distributionLevel, @Param("levels") Long[] levels);

    /**
     * 分页查询指定用户的直接下级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param level 用户下面的几级经销商，如查询用户下面的二级经销商，level = 2
     * @return
     */
    List<Object> allDirectBelowUsers(@Param("userId") Long userId, @Param("distributionLevel") Integer distributionLevel, @Param("level") Long level);

    /**
     * 分页查询指定用户的关系路径
     * @param userId 用户编号
     * @param pageQuery 分页对象
     * @return
     */
    List<Object> listUserPathsByUserId(@Param("userId") Long userId, @Param("query") PageQuery pageQuery);

    /**
     * 指定用户的关系路径计数
     * @param userId 用户编号
     * @return
     */
    Long countUserPathsByUserId(@Param("userId") Long userId);

    /**
     * 条件查询用户关系
     * @param distributionUserHierarchyQuery
     * @return
     */
    List<Object> listUserHierarchy(@Param("query") DistributionUserHierarchyQuery distributionUserHierarchyQuery);

    /**
     * 根据条件对用户关系计数
     * @param distributionUserHierarchyQuery
     * @return
     */
    Long countUserHierarchy(@Param("query") DistributionUserHierarchyQuery distributionUserHierarchyQuery);

}
