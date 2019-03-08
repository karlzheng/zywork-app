package top.zywork.service;

import top.zywork.dto.PagerDTO;
import top.zywork.query.DistributionUserHierarchyQuery;
import top.zywork.query.PageQuery;

import java.util.List;

/**
 * 分销数据查询Service接口<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface DistributionService {

    /**
     * 查询所有顶级分销商，及上面没有分销商
     * @return
     */
    PagerDTO listAllTop(Object queryObj);

    /**
     * 分页查询指定用户上面的几级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param levels 用户上面的几级经销商，如查询用户上面的一级经销商，则new Long[]{1}，如果查询用户上面的一级和二级经销商，则new Long[]{1, 2}
     * @param pageQuery 分页对象
     * @return
     */
    PagerDTO listAboveUsers(Long userId, Integer distributionLevel, Long[] levels, PageQuery pageQuery);

    /**
     * 分页查询指定用户的直接上级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param level 用户上面的几级经销商，如查询用户上面的二级经销商，则level = 2
     * @return
     */
    PagerDTO allDirectAboveUsers(Long userId, Integer distributionLevel, Long level);

    /**
     * 分页查询指定用户下面的几级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param levels 用户下面的几级经销商，如查询用户下面的二级经销商，则new Long[]{2}，如果查询用户上面的二级和三级经销商，则new Long[]{2, 3}
     * @param pageQuery 分页对象
     * @return
     */
    PagerDTO listBelowUsers(Long userId, Integer distributionLevel, Long[] levels, PageQuery pageQuery);

    /**
     * 分页查询指定用户的直接下级经销商
     * @param userId 指定用户编号
     * @param distributionLevel 分销级别
     * @param level 用户下面的几级经销商，如查询用户下面的二级经销商，level = 2
     * @return
     */
    PagerDTO allDirectBelowUsers(Long userId, Integer distributionLevel, Long level);

    /**
     * 分页查询指定用户的关系路径
     * @param userId 用户编号
     * @param pageQuery 分页对象
     * @return
     */
    PagerDTO listUserPathsByUserId(Long userId, PageQuery pageQuery);

    /**
     * 条件查询用户关系
     * @param distributionUserHierarchyQuery
     * @return
     */
    PagerDTO listUserHierarchy(DistributionUserHierarchyQuery distributionUserHierarchyQuery);

}
