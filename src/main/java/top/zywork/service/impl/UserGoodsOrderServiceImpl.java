package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserGoodsOrderDAO;
import top.zywork.dos.UserGoodsOrderDO;
import top.zywork.dto.UserGoodsOrderDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserGoodsOrderService;

import javax.annotation.PostConstruct;

/**
 * UserGoodsOrderServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-12<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userGoodsOrderService")
public class UserGoodsOrderServiceImpl extends AbstractBaseService implements UserGoodsOrderService {

    private UserGoodsOrderDAO userGoodsOrderDAO;

    @Autowired
    public void setUserGoodsOrderDAO(UserGoodsOrderDAO userGoodsOrderDAO) {
        super.setBaseDAO(userGoodsOrderDAO);
        this.userGoodsOrderDAO = userGoodsOrderDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserGoodsOrderDO.class, UserGoodsOrderDTO.class);
    }
}
