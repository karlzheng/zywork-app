package top.zywork.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.annotation.SysLog;
import top.zywork.common.UUIDUtils;
import top.zywork.dos.UserWithdrawDO;
import top.zywork.dto.UserWalletDTO;
import top.zywork.enums.WithdrawStatusEnum;
import top.zywork.security.JwtUser;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserWalletService;
import top.zywork.service.UserWithdrawService;
import top.zywork.vo.ResponseStatusVO;

/**
 * 用户提现控制器类<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/withdraw")
public class UserWithdrawController {

    private UserWithdrawService userWithdrawService;

    private UserWalletService userWalletService;

    /**
     * 提交提现申请
     *
     * @param amount
     * @param bankcardId
     * @param payPassword
     * @return
     */
    @PostMapping("user/submit")
    @SysLog(description = "提交提现申请", requestParams = false)
    public ResponseStatusVO submitWithdraw(Long amount, Long bankcardId, String payPassword) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (amount == null || StringUtils.isEmpty(payPassword) || bankcardId == null) {
            return ResponseStatusVO.dataError("必须填写提现金额、支付密码，并选择提现银行卡", null);
        }
        if (amount <= 0) {
            return ResponseStatusVO.dataError("提现金额必须大于0", null);
        }
        Object obj = userWalletService.getById(jwtUser.getUserId());
        if (obj == null) {
            return ResponseStatusVO.dataError("此用户无钱包记录", null);
        }
        UserWalletDTO userWalletDTO = (UserWalletDTO) obj;
        if (!new BCryptPasswordEncoder().matches(payPassword, userWalletDTO.getPayPassword())) {
            return ResponseStatusVO.dataError("支付密码错误", null);
        }
        int saveRows = userWithdrawService.saveWithdraw(jwtUser.getUserId(), amount, bankcardId);
        if (saveRows == 1) {
            return ResponseStatusVO.ok("提现申请提交成功", null);
        } else {
            return ResponseStatusVO.dataError("提现金额必须小于等于可提现余额", null);
        }
    }

    /**
     * 获取可提现或转账的金额
     *
     * @param
     * @return
     */
    @PostMapping("user/available")
    public ResponseStatusVO getAvailableWithdraw() {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        Long availableWithdraw = userWithdrawService.getAvailableWithdraw(jwtUser.getUserId());
        return ResponseStatusVO.ok("获取可提现或可转账金额", availableWithdraw);
    }

    /**
     * 取消提现申请
     *
     * @param transactionNo
     * @return
     */
    @PostMapping("user/cancel")
    @SysLog(description = "取消提现申请")
    public ResponseStatusVO cancelWithdraw(String transactionNo) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UserWithdrawDO userWithdrawDO = userWithdrawService.getByTransactionNo(transactionNo);
        if (userWithdrawDO == null || userWithdrawDO.getWithdrawStatus().byteValue() != WithdrawStatusEnum.CHECKING.getValue()) {
            return ResponseStatusVO.dataError("交易编号不正确或提现申请不是审核中状态", null);
        }
        if (userWithdrawDO.getUserId() != jwtUser.getUserId()) {
            return ResponseStatusVO.dataError("交易编号不属于此用户", null);
        }
        int updateRows = userWithdrawService.cancelWithdraw(transactionNo, userWithdrawDO.getVersion() + 1);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("已取消提现", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在取消前提现记录已被更新", null);
        }
    }

    /**
     * 提现申请审核，注意权限配置，审核完成后，再由人工完成提现并确认或第三方系统完成提现自动确认
     *
     * @param transactionNo
     * @param withdrawStatus
     * @param description
     * @return
     */
    @PostMapping("admin/check")
    @SysLog(description = "提现申请审核")
    public ResponseStatusVO checkWithdraw(String transactionNo, Byte withdrawStatus, String description) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        boolean isStatusError = withdrawStatus == null
                || (withdrawStatus != WithdrawStatusEnum.CHECKED.getValue().byteValue() && withdrawStatus != WithdrawStatusEnum.UNCHECKED.getValue().byteValue());
        if (isStatusError) {
            return ResponseStatusVO.dataError("审核状态错误，1通过，2未通过", null);
        }
        if (StringUtils.isEmpty(transactionNo)) {
            return ResponseStatusVO.dataError("交易编号不能为空", null);
        }
        UserWithdrawDO userWithdrawDO = userWithdrawService.getByTransactionNo(transactionNo);
        if (userWithdrawDO == null || userWithdrawDO.getWithdrawStatus().byteValue() != WithdrawStatusEnum.CHECKING.getValue()) {
            return ResponseStatusVO.dataError("交易编号不正确或提现申请不是审核中状态", null);
        }
        int updateRows = userWithdrawService.checkWithdraw(userWithdrawDO.getUserId(), userWithdrawDO.getId(), transactionNo,
                withdrawStatus, description, jwtUser.getUserId(), userWithdrawDO.getVersion() + 1);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("审核成功", null);
        } else {
            return ResponseStatusVO.dataError("可用余额不足，请检查用户可用余额是否大于等于提现金额，或数据版本号有问题，在审核前提现记录已被更新", null);
        }
    }

    /**
     * 第三方系统完成提现
     *
     * @return
     */
    public ResponseStatusVO doWithdrawThirdParty() {
        return null;
    }

    /**
     * 由系统人工确认完成提现，注意权限配置
     *
     * @param transactionNo
     * @param withdrawStatus
     * @return
     */
    @PostMapping("admin/confirm-human")
    @SysLog(description = "人工完成提现操作")
    public ResponseStatusVO confirmWithdrawHuman(String transactionNo, Byte withdrawStatus) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        boolean isStatusError = withdrawStatus == null
                || (withdrawStatus != WithdrawStatusEnum.SUCCESS.getValue().byteValue() && withdrawStatus != WithdrawStatusEnum.FAILURE.getValue().byteValue());
        if (isStatusError) {
            return ResponseStatusVO.dataError("审核状态错误，4成功，5失败", null);
        }
        if (StringUtils.isEmpty(transactionNo)) {
            return ResponseStatusVO.dataError("交易编号不能为空", null);
        }
        UserWithdrawDO userWithdrawDO = userWithdrawService.getByTransactionNo(transactionNo);
        if (userWithdrawDO == null || userWithdrawDO.getWithdrawStatus().byteValue() != WithdrawStatusEnum.CHECKED.getValue()) {
            return ResponseStatusVO.dataError("交易编号不正确或提现申请不是已通过状态", null);
        }
        int updateRows = userWithdrawService.completeWithdraw(userWithdrawDO.getId(), transactionNo, withdrawStatus, userWithdrawDO.getUserId(), userWithdrawDO.getAmount(), jwtUser.getUserId(), userWithdrawDO.getVersion() + 1);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("已人工完成提现操作，提现" + WithdrawStatusEnum.findByValue(withdrawStatus.intValue()).getDes(), null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在完成提现前提现记录已被更新", null);
        }
    }

    @Autowired
    public void setUserWithdrawService(UserWithdrawService userWithdrawService) {
        this.userWithdrawService = userWithdrawService;
    }

    @Autowired
    public void setUserWalletService(UserWalletService userWalletService) {
        this.userWalletService = userWalletService;
    }
}
