package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.common.ExceptionUtils;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAddress(ShippingAddressDTO shippingAddressDTO) {
        try {
            Integer version = shippingAddressDAO.getVersionById(shippingAddressDTO.getId());
            version = version == null ? 1 : version;
            shippingAddressDTO.setVersion(version + 1);
            int updateRows = shippingAddressDAO.update(BeanUtils.copy(shippingAddressDTO, ShippingAddressDO.class));
            if (shippingAddressDTO.getIsDefault() == 1) {
                shippingAddressDAO.updateNoDefault(shippingAddressDTO.getUserId());
            }
            return updateRows;
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

    @Override
    public int updateNoDefault(Long userId) {
        return shippingAddressDAO.updateNoDefault(userId);
    }

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
