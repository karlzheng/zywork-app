package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.dao.GoodsAttributeValueDAO;
import top.zywork.dos.GoodsAttributeValueDO;
import top.zywork.dto.GoodsAttributeValueDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.GoodsAttributeValueService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * GoodsAttributeValueServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "goodsAttributeValueService")
public class GoodsAttributeValueServiceImpl extends AbstractBaseService implements GoodsAttributeValueService {

    private GoodsAttributeValueDAO goodsAttributeValueDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<Object> dataTransferObjList) {
        if (dataTransferObjList != null && dataTransferObjList.size() > 0) {
            GoodsAttributeValueDTO goodsAttributeValueDTO = (GoodsAttributeValueDTO) dataTransferObjList.get(0);
            goodsAttributeValueDAO.removeBySkuId(goodsAttributeValueDTO.getGoodsSkuId());
        }
        return goodsAttributeValueDAO.saveBatch(BeanUtils.copyList(dataTransferObjList, GoodsAttributeValueDO.class));
    }

    @Autowired
    public void setGoodsAttributeValueDAO(GoodsAttributeValueDAO goodsAttributeValueDAO) {
        super.setBaseDAO(goodsAttributeValueDAO);
        this.goodsAttributeValueDAO = goodsAttributeValueDAO;
    }

    @PostConstruct
    public void init() {
        super.init(GoodsAttributeValueDO.class, GoodsAttributeValueDTO.class);
    }
}
