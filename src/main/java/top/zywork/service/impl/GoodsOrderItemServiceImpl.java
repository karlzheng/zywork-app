package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsOrderItemDAO;
import top.zywork.dos.GoodsOrderItemDO;
import top.zywork.dto.GoodsOrderItemDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsOrderItemService;

import javax.annotation.PostConstruct;

/**
 * GoodsOrderItemServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsOrderItemService")
public class GoodsOrderItemServiceImpl extends AbstractBaseService implements GoodsOrderItemService {

    private GoodsOrderItemDAO goodsOrderItemDAO;

    @Autowired
    public void setGoodsOrderItemDAO(GoodsOrderItemDAO goodsOrderItemDAO) {
        super.setBaseDAO(goodsOrderItemDAO);
        this.goodsOrderItemDAO = goodsOrderItemDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsOrderItemDO.class, GoodsOrderItemDTO.class);
    }
}
