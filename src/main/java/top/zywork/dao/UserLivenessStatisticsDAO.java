package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.zywork.vo.StatisticsDayCountVO;

import java.util.Date;
import java.util.List;

/**
 * 用户活跃度统计DAO<br/>
 *
 * 创建于2019-01-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Repository
public interface UserLivenessStatisticsDAO {

    /**
     * 查询所有注册用户数
     * @return
     */
    Long countAllRegUser();

    /**
     * 查询指定时间段内的每日注册用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StatisticsDayCountVO> countDayRegUserByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 查询指定时间段内的总注册用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    Long countAllRegUserByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 查询指定时间段内的每日活跃用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StatisticsDayCountVO> getDayDauByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 查询指定时间段内的总活跃用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    Long getAllDauByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

}
