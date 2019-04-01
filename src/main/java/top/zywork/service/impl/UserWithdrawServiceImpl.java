package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.TransactionNoGenerator;
import top.zywork.dao.AccountDetailDAO;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dao.UserWithdrawDAO;
import top.zywork.dos.AccountDetailDO;
import top.zywork.dos.UserWithdrawDO;
import top.zywork.enums.FundsChangeTypeEnum;
import top.zywork.enums.WithdrawStatusEnum;
import top.zywork.service.UserWithdrawService;

/**
 * 用户提现Service实现类<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class UserWithdrawServiceImpl implements UserWithdrawService {

    private UserWithdrawDAO userWithdrawDAO;

    private UserWalletDAO userWalletDAO;

    private AccountDetailDAO accountDetailDAO;

    @Override
    public int saveWithdraw(Long userId, Long amount, Long bankcardId) {
        return userWithdrawDAO.saveWithdraw(userId, TransactionNoGenerator.generateNo(), amount, bankcardId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int checkWithdraw(Long userId, Long withdrawId, String transactionNo, Byte withdrawStatus, String description, Long checkedUserId, Integer newVersion) {
        int updatedRows = userWithdrawDAO.updateWithdrawCheck(userId, transactionNo, withdrawStatus, description, checkedUserId, newVersion);
        if (updatedRows == 1) {
            userWithdrawDAO.saveWithdrawCheck(withdrawId, transactionNo, withdrawStatus, description, checkedUserId);
        }
        return updatedRows;
    }

    @Override
    public int cancelWithdraw(String transactionNo, Integer newVersion) {
        return userWithdrawDAO.updateWithdraw(transactionNo, WithdrawStatusEnum.CANCELED.getValue().byteValue(), newVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int completeWithdraw(Long withdrawId, String transactionNo, Byte withdrawStatus, Long userId, Long amount, Long completeUserId, Integer newVersion) {
        int updateRows = userWithdrawDAO.updateWithdraw(transactionNo, withdrawStatus, newVersion);
        if (updateRows == 1) {
            userWithdrawDAO.saveWithdrawCheck(withdrawId, transactionNo, withdrawStatus,  withdrawStatus == WithdrawStatusEnum.SUCCESS.getValue().byteValue() ? "提现成功" : "提现失败", completeUserId);
            if ( withdrawStatus == WithdrawStatusEnum.SUCCESS.getValue().byteValue()) {
                // 如果提现成功，则更新钱包余额和可用余额
                saveAccountDetail(transactionNo, userId, amount);
                userWalletDAO.updateWalletOut(userId, amount);
            }
        }
        return updateRows;
    }

    private void saveAccountDetail(String transactionNo, Long userId, Long amount) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setTransactionNo(transactionNo);
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(-amount);
        accountDetailDO.setType((byte) 1);
        accountDetailDO.setSubType(FundsChangeTypeEnum.WITHDRAW.getValue());
        accountDetailDAO.save(accountDetailDO);
    }

    @Override
    public long getAvailableWithdraw(Long userId) {
        return userWithdrawDAO.getAvailableWithdraw(userId);
    }

    @Override
    public UserWithdrawDO getByTransactionNo(String transactionNo) {
        return userWithdrawDAO.getByTransactionNo(transactionNo);
    }

    @Autowired
    public void setUserWithdrawDAO(UserWithdrawDAO userWithdrawDAO) {
        this.userWithdrawDAO = userWithdrawDAO;
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
