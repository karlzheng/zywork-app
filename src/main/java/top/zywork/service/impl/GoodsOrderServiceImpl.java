package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsOrderDAO;
import top.zywork.dos.GoodsOrderDO;
import top.zywork.dto.GoodsOrderDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsOrderService;

import javax.annotation.PostConstruct;

/**
 * GoodsOrderServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsOrderService")
public class GoodsOrderServiceImpl extends AbstractBaseService implements GoodsOrderService {

    private GoodsOrderDAO goodsOrderDAO;

    @Autowired
    public void setGoodsOrderDAO(GoodsOrderDAO goodsOrderDAO) {
        super.setBaseDAO(goodsOrderDAO);
        this.goodsOrderDAO = goodsOrderDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsOrderDO.class, GoodsOrderDTO.class);
    }
}
