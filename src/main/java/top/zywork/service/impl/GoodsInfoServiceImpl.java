package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsInfoDAO;
import top.zywork.dos.GoodsInfoDO;
import top.zywork.dto.GoodsInfoDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsInfoService;

import javax.annotation.PostConstruct;

/**
 * GoodsInfoServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsInfoService")
public class GoodsInfoServiceImpl extends AbstractBaseService implements GoodsInfoService {

    private GoodsInfoDAO goodsInfoDAO;

    @Autowired
    public void setGoodsInfoDAO(GoodsInfoDAO goodsInfoDAO) {
        super.setBaseDAO(goodsInfoDAO);
        this.goodsInfoDAO = goodsInfoDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsInfoDO.class, GoodsInfoDTO.class);
    }
}
