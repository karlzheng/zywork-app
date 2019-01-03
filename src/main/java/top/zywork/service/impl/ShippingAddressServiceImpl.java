package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ShippingAddressDAO;
import top.zywork.dos.ShippingAddressDO;
import top.zywork.dto.ShippingAddressDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ShippingAddressService;

import javax.annotation.PostConstruct;

/**
 * ShippingAddressServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-03<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "shippingAddressService")
public class ShippingAddressServiceImpl extends AbstractBaseService implements ShippingAddressService {

    private ShippingAddressDAO shippingAddressDAO;

    @Autowired
    public void setShippingAddressDAO(ShippingAddressDAO shippingAddressDAO) {
        super.setBaseDAO(shippingAddressDAO);
        this.shippingAddressDAO = shippingAddressDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ShippingAddressDO.class, ShippingAddressDTO.class);
    }
}
