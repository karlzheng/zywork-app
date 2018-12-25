package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.AccountDetailDAO;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dao.UserWithdrawDAO;
import top.zywork.dos.AccountDetailDO;
import top.zywork.dos.UserWithdrawDO;
import top.zywork.dto.UserWalletDTO;
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
    public void saveWithdraw(Long userId, String withdrawNo, Long amount, Long bankcardId) {
        userWithdrawDAO.saveWithdraw(userId, withdrawNo, amount, bankcardId);
    }

    @Override
    public int checkWithdraw(String withdrawNo, Byte withdrawStatus, String description, Long checkedUserId, Integer newVersion) {
        return userWithdrawDAO.updateWithdrawCheck(withdrawNo, withdrawStatus, description, checkedUserId, newVersion);
    }

    @Override
    public int cancelWithdraw(String withdrawNo, Integer newVersion) {
        return userWithdrawDAO.updateWithdraw(withdrawNo, WithdrawStatusEnum.CANCELED.getValue().byteValue(), newVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int completeWithdraw(String withdrawNo, Byte withdrawStatus, Long userId, Long amount, Integer newVersion) {
        int updateRows = userWithdrawDAO.updateWithdraw(withdrawNo, withdrawStatus, newVersion);
        if (withdrawStatus == WithdrawStatusEnum.SUCCESS.getValue().byteValue()) {
            // 如果提现成功，则更新钱包余额和可用余额
            saveAccountDetail(userId, amount, FundsChangeTypeEnum.WITHDRAW.getValue());
            Integer version = userWalletDAO.getVersionById(userId);
            updateWallet(userId, -amount, version + 1);
        }
        return updateRows;
    }

    private void updateWallet(Long userId, Long amount, int newVersion) {
        int updateRows = userWalletDAO.updateWallet(userId, amount, newVersion);
        if (updateRows == 0) {
            // 如果版本号有问题，此记录已经被更新过，则再次尝试更新
            updateWallet(userId, amount, newVersion + 1);
        }
    }

    private void saveAccountDetail(Long userId, Long amount, String fundsChangeType) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(-amount);
        accountDetailDO.setType((byte) 1);
        accountDetailDO.setSubType(fundsChangeType);
        accountDetailDAO.save(accountDetailDO);
    }

    @Override
    public long getTotalUncompleteWithdraw(Long userId) {
        Long totalUncomplete = userWithdrawDAO.getTotalUncompleteWithdraw(userId);
        return totalUncomplete == null ? 0 : totalUncomplete;
    }

    @Override
    public long getAvailableWithdraw(UserWalletDTO userWalletDTO) {
        Long totalUncomplete = userWithdrawDAO.getTotalUncompleteWithdraw(userWalletDTO.getId());
        return userWalletDTO.getUsableRmbBalance() - (totalUncomplete == null ? 0 : totalUncomplete);

    }

    @Override
    public UserWithdrawDO getByWithdrawNo(String withdrawNo) {
        return userWithdrawDAO.getByWithdrawNo(withdrawNo);
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
