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
        int saveRows = userWithdrawService.saveWithdraw(jwtUser.getUserId(), UUIDUtils.simpleUuid(), amount, bankcardId);
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
     * @param withdrawNo
     * @return
     */
    @PostMapping("user/cancel")
    @SysLog(description = "取消提现申请")
    public ResponseStatusVO cancelWithdraw(String withdrawNo) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        UserWithdrawDO userWithdrawDO = userWithdrawService.getByWithdrawNo(withdrawNo);
        if (userWithdrawDO == null || userWithdrawDO.getWithdrawStatus().byteValue() != WithdrawStatusEnum.CHECKING.getValue()) {
            return ResponseStatusVO.dataError("提现单号不正确或提现申请不是审核中状态", null);
        }
        if (userWithdrawDO.getUserId() != jwtUser.getUserId()) {
            return ResponseStatusVO.dataError("提现单号不属于此用户", null);
        }
        int updateRows = userWithdrawService.cancelWithdraw(withdrawNo, userWithdrawDO.getVersion() + 1);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("已取消提现", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在取消前提现记录已被更新", null);
        }
    }

    /**
     * 提现申请审核，注意权限配置，审核完成后，再由人工完成提现并确认或第三方系统完成提现自动确认
     *
     * @param withdrawNo
     * @param withdrawStatus
     * @param description
     * @return
     */
    @PostMapping("admin/check")
    @SysLog(description = "提现申请审核")
    public ResponseStatusVO checkWithdraw(String withdrawNo, Byte withdrawStatus, String description) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (StringUtils.isEmpty(withdrawNo) || withdrawStatus == null
                || (withdrawStatus != WithdrawStatusEnum.CHECKED.getValue().byteValue()
                || withdrawStatus != WithdrawStatusEnum.UNCHECKED.getValue().byteValue())) {
            return ResponseStatusVO.dataError("审核状态错误，1通过，2未通过", null);
        }
        UserWithdrawDO userWithdrawDO = userWithdrawService.getByWithdrawNo(withdrawNo);
        if (userWithdrawDO == null || userWithdrawDO.getWithdrawStatus().byteValue() != WithdrawStatusEnum.CHECKING.getValue()) {
            return ResponseStatusVO.dataError("提现单号不正确或提现申请不是审核中状态", null);
        }
        int updateRows = userWithdrawService.checkWithdraw(withdrawNo, withdrawStatus, description, jwtUser.getUserId(), userWithdrawDO.getVersion() + 1);
        if (updateRows == 1) {
            return ResponseStatusVO.ok("审核成功", null);
        } else {
            return ResponseStatusVO.dataError("数据版本号有问题，在审核前提现记录已被更新", null);
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
     * @param withdrawNo
     * @param withdrawStatus
     * @return
     */
    @PostMapping("admin/confirm-human")
    @SysLog(description = "人工完成提现操作")
    public ResponseStatusVO confirmWithdrawHuman(String withdrawNo, Byte withdrawStatus) {
        if (StringUtils.isEmpty(withdrawNo) || withdrawStatus == null
                || (withdrawStatus != WithdrawStatusEnum.SUCCESS.getValue().byteValue()
                || withdrawStatus != WithdrawStatusEnum.FAILURE.getValue().byteValue())) {
            return ResponseStatusVO.dataError("请选择正确的提现单号和审核状态", null);
        }
        UserWithdrawDO userWithdrawDO = userWithdrawService.getByWithdrawNo(withdrawNo);
        if (userWithdrawDO == null || userWithdrawDO.getWithdrawStatus().byteValue() != WithdrawStatusEnum.CHECKED.getValue()) {
            return ResponseStatusVO.dataError("提现单号不正确或提现申请不是已通过状态", null);
        }
        int updateRows = userWithdrawService.completeWithdraw(withdrawNo, withdrawStatus, userWithdrawDO.getUserId(), userWithdrawDO.getAmount(), userWithdrawDO.getVersion() + 1);
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
