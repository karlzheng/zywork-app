package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.TransactionNoGenerator;
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
        String transactionNo = TransactionNoGenerator.generateNo();
        userRechargeDAO.saveRechargeThirdParty(transactionNo, userId, amount, outTradeNo, tradeNo, rechargeType, isSuccess);
        saveAccountDetail(transactionNo, userId, amount);
        updateWallet(userId, amount);
    }

    @Override
    public void rechargeByHuman(Long userId, Long amount) {
        String transactionNo = TransactionNoGenerator.generateNo();
        userRechargeDAO.saveRechargeHuman(transactionNo, userId, amount, FundsChangeTypeEnum.RECHARGE_HUMAN.getValue());
        saveAccountDetail(transactionNo, userId, amount);
        updateWallet(userId, amount);
    }

    private void updateWallet(Long userId, Long amount) {
        userWalletDAO.updateWalletIn(userId, amount);
    }

    private void saveAccountDetail(String transactionNo, Long userId, Long amount) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setTransactionNo(transactionNo);
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(amount);
        accountDetailDO.setType((byte) 0);
        accountDetailDO.setSubType(FundsChangeTypeEnum.RECHARGE_HUMAN.getValue());
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
