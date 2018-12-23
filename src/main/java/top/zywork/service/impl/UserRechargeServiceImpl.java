package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.UserRechargeDAO;
import top.zywork.service.UserRechargeService;

/**
 * 用户充值Service实现类<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRechargeServiceImpl implements UserRechargeService {

    private UserRechargeDAO userRechargeDAO;

    @Override
    public void rechargeByThirdParty(Long userId, Long amount, String outTradeNo, String tradeNo, String rechargeType, byte isSuccess) {
        userRechargeDAO.saveRechargeThirdParty(userId, amount, outTradeNo, tradeNo, rechargeType, isSuccess);
        userRechargeDAO.updateWallet(userId, amount);
    }

    @Override
    public void rechargeByHuman(Long userId, Long amount) {
        userRechargeDAO.saveRechargeHuman(userId, amount);
        userRechargeDAO.updateWallet(userId, amount);
    }

    @Autowired
    public void setUserRechargeDAO(UserRechargeDAO userRechargeDAO) {
        this.userRechargeDAO = userRechargeDAO;
    }
}
