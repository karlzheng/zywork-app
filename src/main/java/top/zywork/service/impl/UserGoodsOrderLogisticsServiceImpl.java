package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserGoodsOrderLogisticsDAO;
import top.zywork.dos.UserGoodsOrderLogisticsDO;
import top.zywork.dto.UserGoodsOrderLogisticsDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserGoodsOrderLogisticsService;

import javax.annotation.PostConstruct;

/**
 * UserGoodsOrderLogisticsServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userGoodsOrderLogisticsService")
public class UserGoodsOrderLogisticsServiceImpl extends AbstractBaseService implements UserGoodsOrderLogisticsService {

    private UserGoodsOrderLogisticsDAO userGoodsOrderLogisticsDAO;

    @Autowired
    public void setUserGoodsOrderLogisticsDAO(UserGoodsOrderLogisticsDAO userGoodsOrderLogisticsDAO) {
        super.setBaseDAO(userGoodsOrderLogisticsDAO);
        this.userGoodsOrderLogisticsDAO = userGoodsOrderLogisticsDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserGoodsOrderLogisticsDO.class, UserGoodsOrderLogisticsDTO.class);
    }
}
