package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.StatisticsDauDAO;
import top.zywork.dos.StatisticsDauDO;
import top.zywork.dto.StatisticsDauDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.StatisticsDauService;

import javax.annotation.PostConstruct;

/**
 * StatisticsDauServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-18<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "statisticsDauService")
public class StatisticsDauServiceImpl extends AbstractBaseService implements StatisticsDauService {

    private StatisticsDauDAO statisticsDauDAO;

    @Autowired
    public void setStatisticsDauDAO(StatisticsDauDAO statisticsDauDAO) {
        super.setBaseDAO(statisticsDauDAO);
        this.statisticsDauDAO = statisticsDauDAO;
    }

    @PostConstruct
    public void init() {
        super.init(StatisticsDauDO.class, StatisticsDauDTO.class);
    }
}
