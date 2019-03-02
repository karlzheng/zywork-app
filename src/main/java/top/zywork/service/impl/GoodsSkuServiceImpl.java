package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsSkuDAO;
import top.zywork.dos.GoodsSkuDO;
import top.zywork.dto.GoodsSkuDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsSkuService;

import javax.annotation.PostConstruct;

/**
 * GoodsSkuServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsSkuService")
public class GoodsSkuServiceImpl extends AbstractBaseService implements GoodsSkuService {

    private GoodsSkuDAO goodsSkuDAO;

    @Autowired
    public void setGoodsSkuDAO(GoodsSkuDAO goodsSkuDAO) {
        super.setBaseDAO(goodsSkuDAO);
        this.goodsSkuDAO = goodsSkuDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsSkuDO.class, GoodsSkuDTO.class);
    }
}
