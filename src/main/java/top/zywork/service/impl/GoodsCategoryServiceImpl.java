package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.GoodsCategoryDAO;
import top.zywork.dos.GoodsCategoryDO;
import top.zywork.dto.GoodsCategoryDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsCategoryService;

import javax.annotation.PostConstruct;

/**
 * GoodsCategoryServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsCategoryService")
public class GoodsCategoryServiceImpl extends AbstractBaseService implements GoodsCategoryService {

    private GoodsCategoryDAO goodsCategoryDAO;

    @Autowired
    public void setGoodsCategoryDAO(GoodsCategoryDAO goodsCategoryDAO) {
        super.setBaseDAO(goodsCategoryDAO);
        this.goodsCategoryDAO = goodsCategoryDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsCategoryDO.class, GoodsCategoryDTO.class);
    }
}
