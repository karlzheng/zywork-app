package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.UserRechargeDAO;
import top.zywork.dao.UserWalletDAO;
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

    private UserWalletDAO userWalletDAO;

    @Override
    public void rechargeByThirdParty(Long userId, Long amount, String outTradeNo, String tradeNo, String rechargeType, byte isSuccess) {
        userRechargeDAO.saveRechargeThirdParty(userId, amount, outTradeNo, tradeNo, rechargeType, isSuccess);
        updateWallet(userId, amount);
    }

    @Override
    public void rechargeByHuman(Long userId, Long amount) {
        userRechargeDAO.saveRechargeHuman(userId, amount);
        updateWallet(userId, amount);
    }

    private void updateWallet(Long userId, Long amount) {
        Integer version = userWalletDAO.getVersionById(userId);
        int updateRows = userWalletDAO.updateWallet(userId, amount, version + 1);
        if (updateRows == 0) {
            // 如果版本号有问题，此记录已经被更新过，则再次尝试更新
            updateWallet(userId, amount);
        }
    }

    @Autowired
    public void setUserRechargeDAO(UserRechargeDAO userRechargeDAO) {
        this.userRechargeDAO = userRechargeDAO;
    }

    @Autowired
    public void setUserWalletDAO(UserWalletDAO userWalletDAO) {
        this.userWalletDAO = userWalletDAO;
    }
}
