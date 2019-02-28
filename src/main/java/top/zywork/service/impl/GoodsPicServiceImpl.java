package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.dao.GoodsPicDAO;
import top.zywork.dos.GoodsPicDO;
import top.zywork.dto.GoodsPicDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsPicService;

import javax.annotation.PostConstruct;

/**
 * GoodsPicServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-27<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsPicService")
public class GoodsPicServiceImpl extends AbstractBaseService implements GoodsPicService {

    private GoodsPicDAO goodsPicDAO;

    @Override
    public GoodsPicDTO saveObj(GoodsPicDTO goodsPicDTO) {
        GoodsPicDO goodsPicDO = BeanUtils.copy(goodsPicDTO, GoodsPicDO.class);
        goodsPicDAO.save(goodsPicDO);
        goodsPicDTO.setId(goodsPicDO.getId());
        return goodsPicDTO;
    }

    @Autowired
    public void setGoodsPicDAO(GoodsPicDAO goodsPicDAO) {
        super.setBaseDAO(goodsPicDAO);
        this.goodsPicDAO = goodsPicDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsPicDO.class, GoodsPicDTO.class);
    }

}
