package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dao.UserWithdrawDAO;
import top.zywork.dos.UserWithdrawDO;
import top.zywork.dto.UserWalletDTO;
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

    @Override
    public void saveWithdraw(Long userId, String withdrawNo, Long amount, Long bankcardId) {
        userWithdrawDAO.saveWithdraw(userId, withdrawNo, amount, bankcardId);
    }

    @Override
    public void checkWithdraw(String withdrawNo, Byte withdrawStatus, String description, Long checkedUserId) {
        userWithdrawDAO.updateWithdrawCheck(withdrawNo, withdrawStatus, description, checkedUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWithdraw(String withdrawNo, Byte withdrawStatus, Long userId, Long amount) {
        userWithdrawDAO.updateWithdraw(withdrawNo, withdrawStatus);
        if (withdrawStatus == WithdrawStatusEnum.SUCCESS.getValue().byteValue()) {
            // 如果提现成功，则更新钱包余额和可用余额
            userWithdrawDAO.updateWallet(userId, amount);
        }
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
}
