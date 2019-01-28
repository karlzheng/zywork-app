package top.zywork.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.zywork.annotation.ExposeClass;
import top.zywork.common.DateUtils;
import top.zywork.dos.StatisticsDauDO;
import top.zywork.security.JwtTokenRedisUtils;
import top.zywork.service.StatisticsDauService;

import java.time.LocalDateTime;

/**
 * DAU保存作业<br/>
 *
 * 创建于2019-01-17<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@ExposeClass(type = "job")
public class DauSaveJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(DauSaveJob.class);

    private JwtTokenRedisUtils jwtTokenRedisUtils;

    private StatisticsDauService statisticsDauService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("begin to execute DauSaveJob......");
        int dauCount = jwtTokenRedisUtils.getDau();
        jwtTokenRedisUtils.removeDau();
        StatisticsDauDO statisticsDauDO = new StatisticsDauDO();
        statisticsDauDO.setDau((long) dauCount);
        statisticsDauDO.setStatisticsTime(DateUtils.millisToDate(DateUtils.millis(LocalDateTime.now().minusSeconds(60))));
        statisticsDauService.save(statisticsDauDO);
        logger.info("executed DauSaveJob......");
    }

    @Autowired
    public void setJwtTokenRedisUtils(JwtTokenRedisUtils jwtTokenRedisUtils) {
        this.jwtTokenRedisUtils = jwtTokenRedisUtils;
    }

    @Autowired
    public void setStatisticsDauService(StatisticsDauService statisticsDauService) {
        this.statisticsDauService = statisticsDauService;
    }
}
