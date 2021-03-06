package top.zywork.service;

import top.zywork.vo.StatisticsDayCountVO;

import java.util.Date;
import java.util.List;

/**
 * 用户活跃度统计服务接口<br/>
 *
 * 创建于2019-01-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface UserLivenessStatisticsService {

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
    List<StatisticsDayCountVO> countDayRegUserByTime(Date beginTime, Date endTime);

    /**
     * 查询指定时间段内的总注册用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    Long countAllRegUserByTime(Date beginTime, Date endTime);

    /**
     * 查询指定时间段内的每日活跃用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StatisticsDayCountVO> getDayDauByTime(Date beginTime, Date endTime);

    /**
     * 查询指定时间段内的总活跃用户数
     * @param beginTime
     * @param endTime
     * @return
     */
    Long getAllDauByTime(Date beginTime, Date endTime);

}
