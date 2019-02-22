package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsShopCertificationCheckDAO;
import top.zywork.dos.GoodsShopCertificationCheckDO;
import top.zywork.dto.GoodsShopCertificationCheckDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsShopCertificationCheckService;

import javax.annotation.PostConstruct;

/**
 * GoodsShopCertificationCheckServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-22<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsShopCertificationCheckService")
public class GoodsShopCertificationCheckServiceImpl extends AbstractBaseService implements GoodsShopCertificationCheckService {

    private GoodsShopCertificationCheckDAO goodsShopCertificationCheckDAO;

    @Autowired
    public void setGoodsShopCertificationCheckDAO(GoodsShopCertificationCheckDAO goodsShopCertificationCheckDAO) {
        super.setBaseDAO(goodsShopCertificationCheckDAO);
        this.goodsShopCertificationCheckDAO = goodsShopCertificationCheckDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsShopCertificationCheckDO.class, GoodsShopCertificationCheckDTO.class);
    }
}
