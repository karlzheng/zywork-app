package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.AccountDetailDAO;
import top.zywork.dao.UserRechargeDAO;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dos.AccountDetailDO;
import top.zywork.enums.FundsChangeTypeEnum;
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

    private AccountDetailDAO accountDetailDAO;

    @Override
    public void rechargeByThirdParty(Long userId, Long amount, String outTradeNo, String tradeNo, String rechargeType, byte isSuccess) {
        userRechargeDAO.saveRechargeThirdParty(userId, amount, outTradeNo, tradeNo, rechargeType, isSuccess);
        updateWallet(userId, amount);
    }

    @Override
    public void rechargeByHuman(Long userId, Long amount) {
        userRechargeDAO.saveRechargeHuman(userId, amount, FundsChangeTypeEnum.RECHARGE_HUMAN.getValue());
        saveAccountDetail(userId, amount, FundsChangeTypeEnum.RECHARGE_HUMAN.getValue());
        updateWallet(userId, amount);
    }

    private void updateWallet(Long userId, Long amount) {
        userWalletDAO.updateWalletIn(userId, amount);
    }

    private void saveAccountDetail(Long userId, Long amount, String fundsChangeType) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(amount);
        accountDetailDO.setType((byte) 0);
        accountDetailDO.setSubType(fundsChangeType);
        accountDetailDAO.save(accountDetailDO);
    }

    @Autowired
    public void setUserRechargeDAO(UserRechargeDAO userRechargeDAO) {
        this.userRechargeDAO = userRechargeDAO;
    }

    @Autowired
    public void setUserWalletDAO(UserWalletDAO userWalletDAO) {
        this.userWalletDAO = userWalletDAO;
    }

    @Autowired
    public void setAccountDetailDAO(AccountDetailDAO accountDetailDAO) {
        this.accountDetailDAO = accountDetailDAO;
    }
}
