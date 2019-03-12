package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserGoodsOrderItemDAO;
import top.zywork.dos.UserGoodsOrderItemDO;
import top.zywork.dto.UserGoodsOrderItemDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserGoodsOrderItemService;

import javax.annotation.PostConstruct;

/**
 * UserGoodsOrderItemServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userGoodsOrderItemService")
public class UserGoodsOrderItemServiceImpl extends AbstractBaseService implements UserGoodsOrderItemService {

    private UserGoodsOrderItemDAO userGoodsOrderItemDAO;

    @Autowired
    public void setUserGoodsOrderItemDAO(UserGoodsOrderItemDAO userGoodsOrderItemDAO) {
        super.setBaseDAO(userGoodsOrderItemDAO);
        this.userGoodsOrderItemDAO = userGoodsOrderItemDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserGoodsOrderItemDO.class, UserGoodsOrderItemDTO.class);
    }
}
