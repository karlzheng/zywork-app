package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsShopDAO;
import top.zywork.dos.GoodsShopDO;
import top.zywork.dto.GoodsShopDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsShopService;

import javax.annotation.PostConstruct;

/**
 * GoodsShopServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsShopService")
public class GoodsShopServiceImpl extends AbstractBaseService implements GoodsShopService {

    private GoodsShopDAO goodsShopDAO;

    @Autowired
    public void setGoodsShopDAO(GoodsShopDAO goodsShopDAO) {
        super.setBaseDAO(goodsShopDAO);
        this.goodsShopDAO = goodsShopDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsShopDO.class, GoodsShopDTO.class);
    }
}
