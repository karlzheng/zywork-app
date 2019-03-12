package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsOrderLogisticsDAO;
import top.zywork.dos.GoodsOrderLogisticsDO;
import top.zywork.dto.GoodsOrderLogisticsDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsOrderLogisticsService;

import javax.annotation.PostConstruct;

/**
 * GoodsOrderLogisticsServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsOrderLogisticsService")
public class GoodsOrderLogisticsServiceImpl extends AbstractBaseService implements GoodsOrderLogisticsService {

    private GoodsOrderLogisticsDAO goodsOrderLogisticsDAO;

    @Autowired
    public void setGoodsOrderLogisticsDAO(GoodsOrderLogisticsDAO goodsOrderLogisticsDAO) {
        super.setBaseDAO(goodsOrderLogisticsDAO);
        this.goodsOrderLogisticsDAO = goodsOrderLogisticsDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsOrderLogisticsDO.class, GoodsOrderLogisticsDTO.class);
    }
}
