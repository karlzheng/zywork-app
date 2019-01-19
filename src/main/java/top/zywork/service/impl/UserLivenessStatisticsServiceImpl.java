package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserLivenessStatisticsDAO;
import top.zywork.service.UserLivenessStatisticsService;
import top.zywork.vo.StatisticsDayCountVO;

import java.util.Date;
import java.util.List;

/**
 * 用户活跃度统计服务接口实现类<br/>
 *
 * 创建于2019-01-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service
public class UserLivenessStatisticsServiceImpl implements UserLivenessStatisticsService {

    private UserLivenessStatisticsDAO userLivenessStatisticsDAO;

    @Override
    public Long countAllRegUser() {
        return userLivenessStatisticsDAO.countAllRegUser();
    }

    @Override
    public List<StatisticsDayCountVO> countDayRegUserByTime(Date beginTime, Date endTime) {
        return userLivenessStatisticsDAO.countDayRegUserByTime(beginTime, endTime);
    }

    @Override
    public Long countAllRegUserByTime(Date beginTime, Date endTime) {
        return userLivenessStatisticsDAO.countAllRegUserByTime(beginTime, endTime);
    }

    @Override
    public List<StatisticsDayCountVO> getDayDauByTime(Date beginTime, Date endTime) {
        return userLivenessStatisticsDAO.getDayDauByTime(beginTime, endTime);
    }

    @Override
    public Long getAllDauByTime(Date beginTime, Date endTime) {
        return userLivenessStatisticsDAO.getAllDauByTime(beginTime, endTime);
    }

    @Autowired
    public void setUserLivenessStatisticsDAO(UserLivenessStatisticsDAO userLivenessStatisticsDAO) {
        this.userLivenessStatisticsDAO = userLivenessStatisticsDAO;
    }

}
