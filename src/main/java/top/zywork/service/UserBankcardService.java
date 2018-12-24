package top.zywork.service;

import top.zywork.dto.UserBankcardDTO;

/**
 * UserBankcardService服务接口<br/>
 *
 * 创建于2018-12-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public interface UserBankcardService extends BaseService {

    /**
     * 根据银行卡号获取UserBankcardDO对象
     * @param bankcardNo
     * @return
     */
    UserBankcardDTO getByCardNo(String bankcardNo);

}
