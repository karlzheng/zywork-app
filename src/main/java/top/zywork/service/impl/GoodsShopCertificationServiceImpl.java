package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsShopCertificationDAO;
import top.zywork.dos.GoodsShopCertificationDO;
import top.zywork.dto.GoodsShopCertificationDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsShopCertificationService;

import javax.annotation.PostConstruct;

/**
 * GoodsShopCertificationServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsShopCertificationService")
public class GoodsShopCertificationServiceImpl extends AbstractBaseService implements GoodsShopCertificationService {

    private GoodsShopCertificationDAO goodsShopCertificationDAO;

    @Autowired
    public void setGoodsShopCertificationDAO(GoodsShopCertificationDAO goodsShopCertificationDAO) {
        super.setBaseDAO(goodsShopCertificationDAO);
        this.goodsShopCertificationDAO = goodsShopCertificationDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsShopCertificationDO.class, GoodsShopCertificationDTO.class);
    }
}
