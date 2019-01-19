package top.zywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.common.DateParseUtils;
import top.zywork.common.RegexUtils;
import top.zywork.enums.DatePatternEnum;
import top.zywork.service.UserLivenessStatisticsService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.vo.StatisticsDayCountVO;
import top.zywork.vo.echarts.BasicLineChartVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 用户活跃度统计控制器类<br/>
 *
 * 创建于2019-01-17<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-liveness-stat")
public class UserLivenessStatisticsController {

    private UserLivenessStatisticsService userLivenessStatisticsService;

    /**
     * 统计注册用户数，包括所有注册用户数，今日新增注册用户数，昨日新增注册用户数
     * @return
     */
    @PostMapping("reg-count")
    public ResponseStatusVO countRegUser() {
        Long totalUsers = userLivenessStatisticsService.countAllRegUser();
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endCalendar.set(Calendar.MINUTE, 59);
        endCalendar.set(Calendar.SECOND, 59);
        endCalendar.set(Calendar.MILLISECOND, 999);
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.add(Calendar.DATE , -1);
        beginCalendar.set(Calendar.HOUR_OF_DAY, 0);
        beginCalendar.set(Calendar.MINUTE, 0);
        beginCalendar.set(Calendar.SECOND, 0);
        beginCalendar.set(Calendar.MILLISECOND, 0);
        List<StatisticsDayCountVO> statisticsDayCountVOList = userLivenessStatisticsService.countDayRegUserByTime(beginCalendar.getTime(), endCalendar.getTime());
        return ResponseStatusVO.ok("注册用户统计：总用户数、昨日新增，今日新增", new Object[]{totalUsers, statisticsDayCountVOList});
    }

    /**
     * 指定时间周期内的总新增用户数
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @PostMapping("reg-all-count-by-date")
    public ResponseStatusVO countAllRegUserByTime(String beginDateStr, String endDateStr) {
        if (!RegexUtils.match(RegexUtils.REGEX_DATE, beginDateStr) || !RegexUtils.match(RegexUtils.REGEX_DATE, endDateStr)) {
            return ResponseStatusVO.dataError("时间字符串格式错误，正确的格式：yyyy-MM-dd", null);
        }
        Calendar beginCalendar = DateParseUtils.parseCalendar(beginDateStr, DatePatternEnum.DATE.getValue());
        Calendar endCalendar = DateParseUtils.parseCalendar(endDateStr, DatePatternEnum.DATE.getValue());
        Long totalCount = userLivenessStatisticsService.countAllRegUserByTime(beginCalendar.getTime(), endCalendar.getTime());
        return ResponseStatusVO.ok(beginDateStr + "至" + endDateStr + "新增用户数", totalCount);
    }

    /**
     * 指定时间周期内的每日新增用户数（用于echarts统计）
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @PostMapping("reg-count-by-date")
    public ResponseStatusVO countRegUserByTime(String beginDateStr, String endDateStr) {
        if (!RegexUtils.match(RegexUtils.REGEX_DATE, beginDateStr) || !RegexUtils.match(RegexUtils.REGEX_DATE, endDateStr)) {
            return ResponseStatusVO.dataError("时间字符串格式错误，正确的格式：yyyy-MM-dd", null);
        }
        Calendar beginCalendar = DateParseUtils.parseCalendar(beginDateStr, DatePatternEnum.DATE.getValue());
        Calendar endCalendar = DateParseUtils.parseCalendar(endDateStr, DatePatternEnum.DATE.getValue());
        List<StatisticsDayCountVO> statisticsDayCountVOList = userLivenessStatisticsService.countDayRegUserByTime(beginCalendar.getTime(), endCalendar.getTime());
        BasicLineChartVO basicLineChartVO = new BasicLineChartVO();
        List<String> xAxisData = new ArrayList<>();
        List<Number> seriesData = new ArrayList<>();
        for (StatisticsDayCountVO statisticsDayCountVO : statisticsDayCountVOList) {
            xAxisData.add(statisticsDayCountVO.getDateStr());
            seriesData.add(statisticsDayCountVO.getTotalCount());
        }
        basicLineChartVO.setxAxisData(xAxisData);
        basicLineChartVO.setSeriesData(seriesData);
        return ResponseStatusVO.ok(beginDateStr + "至" + endDateStr + "的每日新增用户数", basicLineChartVO);
    }

    /**
     * 获取指定周期内的总活跃用户数
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @PostMapping("all-dau")
    public ResponseStatusVO getAllDauByTime(String beginDateStr, String endDateStr) {
        if (!RegexUtils.match(RegexUtils.REGEX_DATE, beginDateStr) || !RegexUtils.match(RegexUtils.REGEX_DATE, endDateStr)) {
            return ResponseStatusVO.dataError("时间字符串格式错误，正确的格式：yyyy-MM-dd", null);
        }
        Calendar beginCalendar = DateParseUtils.parseCalendar(beginDateStr, DatePatternEnum.DATE.getValue());
        Calendar endCalendar = DateParseUtils.parseCalendar(endDateStr, DatePatternEnum.DATE.getValue());
        Long totalCount = userLivenessStatisticsService.getAllDauByTime(beginCalendar.getTime(), endCalendar.getTime());
        return ResponseStatusVO.ok(beginDateStr + "至" + endDateStr + "总日活跃用户数", totalCount);
    }

    /**
     * 获取指定周期内的每日活跃用户数（用于echarts统计）
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @PostMapping("dau-by-date")
    public ResponseStatusVO getDayDauByTime(String beginDateStr, String endDateStr) {
        if (!RegexUtils.match(RegexUtils.REGEX_DATE, beginDateStr) || !RegexUtils.match(RegexUtils.REGEX_DATE, endDateStr)) {
            return ResponseStatusVO.dataError("时间字符串格式错误，正确的格式：yyyy-MM-dd", null);
        }
        Calendar beginCalendar = DateParseUtils.parseCalendar(beginDateStr, DatePatternEnum.DATE.getValue());
        Calendar endCalendar = DateParseUtils.parseCalendar(endDateStr, DatePatternEnum.DATE.getValue());
        List<StatisticsDayCountVO> statisticsDayCountVOList = userLivenessStatisticsService.getDayDauByTime(beginCalendar.getTime(), endCalendar.getTime());
        BasicLineChartVO basicLineChartVO = new BasicLineChartVO();
        List<String> xAxisData = new ArrayList<>();
        List<Number> seriesData = new ArrayList<>();
        for (StatisticsDayCountVO statisticsDayCountVO : statisticsDayCountVOList) {
            xAxisData.add(statisticsDayCountVO.getDateStr());
            seriesData.add(statisticsDayCountVO.getTotalCount());
        }
        basicLineChartVO.setxAxisData(xAxisData);
        basicLineChartVO.setSeriesData(seriesData);
        return ResponseStatusVO.ok(beginDateStr + "至" + endDateStr + "的每日活跃用户数", basicLineChartVO);
    }

    @Autowired
    public void setUserLivenessStatisticsService(UserLivenessStatisticsService userLivenessStatisticsService) {
        this.userLivenessStatisticsService = userLivenessStatisticsService;
    }
}
