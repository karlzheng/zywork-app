package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.dao.GoodsCategoryAttributeDAO;
import top.zywork.dos.GoodsCategoryAttributeDO;
import top.zywork.dto.GoodsCategoryAttributeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsCategoryAttributeService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * GoodsCategoryAttributeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-02-13<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsCategoryAttributeService")
public class GoodsCategoryAttributeServiceImpl extends AbstractBaseService implements GoodsCategoryAttributeService {

    private GoodsCategoryAttributeDAO goodsCategoryAttributeDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<Object> dataTransferObjList) {
        if (dataTransferObjList != null && dataTransferObjList.size() > 0) {
            GoodsCategoryAttributeDTO goodsCategoryAttributeDTO = (GoodsCategoryAttributeDTO) dataTransferObjList.get(0);
            goodsCategoryAttributeDAO.removeAttributeByCategoryId(goodsCategoryAttributeDTO.getGoodsCategoryId());
            return goodsCategoryAttributeDAO.saveBatch(BeanUtils.copyList(dataTransferObjList, GoodsCategoryAttributeDO.class));
        }
        return 0;
    }

    @Autowired
    public void setGoodsCategoryAttributeDAO(GoodsCategoryAttributeDAO goodsCategoryAttributeDAO) {
        super.setBaseDAO(goodsCategoryAttributeDAO);
        this.goodsCategoryAttributeDAO = goodsCategoryAttributeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsCategoryAttributeDO.class, GoodsCategoryAttributeDTO.class);
    }
}
