package top.zywork.service;

import top.zywork.dto.ShippingAddressDTO;

/**
 * ShippingAddressService服务接口<br/>
 *
 * 创建于2019-01-03<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface ShippingAddressService extends BaseService {


    int updateAddress(ShippingAddressDTO shippingAddressDTO);

    /**
     * 根据用户编号把默认的用户收货地址设置为非默认的
     * @param userId
     * @return
     */
    int updateNoDefault(Long userId);

}
