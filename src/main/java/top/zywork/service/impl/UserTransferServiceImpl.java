package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.AccountDetailDAO;
import top.zywork.dao.UserTransferDAO;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dos.AccountDetailDO;
import top.zywork.enums.FundsChangeTypeEnum;
import top.zywork.service.UserTransferService;

/**
 * 用户转账Service实现类<br/>
 *
 * 创建于2019-01-06<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class UserTransferServiceImpl implements UserTransferService {

    private UserTransferDAO userTransferDAO;

    private UserWalletDAO userWalletDAO;

    private AccountDetailDAO accountDetailDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveTransfer(Long userId, Long toUserId, Long amount) {
        int savedRows = userTransferDAO.saveTransfer(userId, toUserId, amount, FundsChangeTypeEnum.TRANSFER_OUT.getValue());
        if (savedRows == 1) {
            userTransferDAO.saveTransferTo(toUserId, userId, amount, FundsChangeTypeEnum.TRANSFER_IN.getValue());
            updateWallet(userId, toUserId, amount);
            saveAccountDetail(userId, amount);
            saveAccountDetailTo(toUserId, amount);
        }
        return savedRows;
    }

    private void updateWallet(Long userId, Long toUserId, Long amount) {
        userWalletDAO.updateWalletOut(userId, amount);
        userWalletDAO.updateWalletIn(toUserId, amount);
    }

    private void saveAccountDetail(Long userId, Long amount) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(-amount);
        accountDetailDO.setType((byte) 1);
        accountDetailDO.setSubType(FundsChangeTypeEnum.TRANSFER_OUT.getValue());
        accountDetailDAO.save(accountDetailDO);
    }

    private void saveAccountDetailTo(Long userId, Long amount) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(amount);
        accountDetailDO.setType((byte) 0);
        accountDetailDO.setSubType(FundsChangeTypeEnum.TRANSFER_IN.getValue());
        accountDetailDAO.save(accountDetailDO);
    }

    @Autowired
    public void setUserTransferDAO(UserTransferDAO userTransferDAO) {
        this.userTransferDAO = userTransferDAO;
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
