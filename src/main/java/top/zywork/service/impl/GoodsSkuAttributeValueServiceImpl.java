package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsSkuAttributeValueDAO;
import top.zywork.dos.GoodsSkuAttributeValueDO;
import top.zywork.dto.GoodsSkuAttributeValueDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsSkuAttributeValueService;

import javax.annotation.PostConstruct;

/**
 * GoodsSkuAttributeValueServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-28<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsSkuAttributeValueService")
public class GoodsSkuAttributeValueServiceImpl extends AbstractBaseService implements GoodsSkuAttributeValueService {

    private GoodsSkuAttributeValueDAO goodsSkuAttributeValueDAO;

    @Autowired
    public void setGoodsSkuAttributeValueDAO(GoodsSkuAttributeValueDAO goodsSkuAttributeValueDAO) {
        super.setBaseDAO(goodsSkuAttributeValueDAO);
        this.goodsSkuAttributeValueDAO = goodsSkuAttributeValueDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsSkuAttributeValueDO.class, GoodsSkuAttributeValueDTO.class);
    }
}
