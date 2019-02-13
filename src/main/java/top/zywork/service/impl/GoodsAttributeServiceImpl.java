package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsAttributeDAO;
import top.zywork.dos.GoodsAttributeDO;
import top.zywork.dto.GoodsAttributeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsAttributeService;

import javax.annotation.PostConstruct;

/**
 * GoodsAttributeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsAttributeService")
public class GoodsAttributeServiceImpl extends AbstractBaseService implements GoodsAttributeService {

    private GoodsAttributeDAO goodsAttributeDAO;

    @Autowired
    public void setGoodsAttributeDAO(GoodsAttributeDAO goodsAttributeDAO) {
        super.setBaseDAO(goodsAttributeDAO);
        this.goodsAttributeDAO = goodsAttributeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsAttributeDO.class, GoodsAttributeDTO.class);
    }
}
