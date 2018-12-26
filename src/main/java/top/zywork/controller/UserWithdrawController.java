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
import top.zywork.enums.ResponseStatusEnum;
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
     * @param amount
     * @param bankcardId
     * @param payPassword
     * @return
     */
    @PostMapping("submit")
    @SysLog(description = "提交提现申请")
    public ResponseStatusVO submitWithdraw(Long amount, Long bankcardId, String payPassword) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            if (amount != null && StringUtils.isNotEmpty(payPassword) && bankcardId != null) {
                Object obj = userWalletService.getById(jwtUser.getUserId());
                if (obj != null) {
                    UserWalletDTO userWalletDTO = (UserWalletDTO) obj;
                    if (new BCryptPasswordEncoder().matches(payPassword, userWalletDTO.getPayPassword())) {
                        if (amount > 0) {
                            int saveRows = userWithdrawService.saveWithdraw(jwtUser.getUserId(), UUIDUtils.simpleUuid(), amount, bankcardId);
                            if (saveRows == 1) {
                                statusVO.dataErrorStatus(ResponseStatusEnum.OK.getCode(), "提现申请提交成功", null);
                            } else {
                                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "提现金额必须小于等于可提现余额", null);
                            }
                        } else {
                            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "提现金额必须大于0", null);
                        }
                    } else {
                        statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "支付密码错误", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "此用户无钱包记录", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "必须填写提现金额、支付密码，并选择提现银行卡", null);
            }
        } else {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 获取可提现金额
     * @param
     * @return
     */
    @PostMapping("available")
    public ResponseStatusVO getAvailableWithdraw() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            Long availableWithdraw = userWithdrawService.getAvailableWithdraw(jwtUser.getUserId());
            statusVO.dataErrorStatus(ResponseStatusEnum.OK.getCode(), "获取可提现金额", availableWithdraw);
        } else {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 取消提现申请
     * @param withdrawNo
     * @return
     */
    @PostMapping("cancel")
    @SysLog(description = "取消提现申请")
    public ResponseStatusVO cancelWithdraw(String withdrawNo) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            UserWithdrawDO userWithdrawDO = userWithdrawService.getByWithdrawNo(withdrawNo);
            if (userWithdrawDO != null && userWithdrawDO.getWithdrawStatus().byteValue() == WithdrawStatusEnum.CHECKING.getValue()) {
                if (userWithdrawDO.getUserId() == jwtUser.getUserId()) {
                    int updateRows = userWithdrawService.cancelWithdraw(withdrawNo, userWithdrawDO.getVersion() + 1);
                    if (updateRows == 1) {
                        statusVO.errorStatus(ResponseStatusEnum.OK.getCode(), "已取消提现", null);
                    } else {
                        statusVO.errorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在取消前提现记录已被更新", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "提现单号不属于此用户", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "提现单号不正确或提现申请不是审核中状态", null);
            }
        } else {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 提现申请审核，注意权限配置，审核完成后，再由人工完成提现并确认或第三方系统完成提现自动确认
     * @param withdrawNo
     * @param withdrawStatus
     * @param description
     * @return
     */
    @PostMapping("check")
    @SysLog(description = "提现申请审核")
    public ResponseStatusVO checkWithdraw(String withdrawNo, Byte withdrawStatus, String description) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser != null) {
            if (StringUtils.isNotEmpty(withdrawNo) && withdrawStatus != null
                    && (withdrawStatus == WithdrawStatusEnum.CHECKED.getValue().byteValue()
                    || withdrawStatus == WithdrawStatusEnum.UNCHECKED.getValue().byteValue())) {
                UserWithdrawDO userWithdrawDO = userWithdrawService.getByWithdrawNo(withdrawNo);
                if (userWithdrawDO != null && userWithdrawDO.getWithdrawStatus().byteValue() == WithdrawStatusEnum.CHECKING.getValue()) {
                    int updateRows = userWithdrawService.checkWithdraw(withdrawNo, withdrawStatus, description, jwtUser.getUserId(), userWithdrawDO.getVersion() + 1);
                    if (updateRows == 1) {
                        statusVO.errorStatus(ResponseStatusEnum.OK.getCode(), "审核成功", null);
                    } else {
                        statusVO.errorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在审核前提现记录已被更新", null);
                    }
                } else {
                    statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "提现单号不正确或提现申请不是审核中状态", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "审核状态错误，1通过，2未通过", null);
            }
        } else {
            statusVO.errorStatus(ResponseStatusEnum.AUTHENTICATION_ERROR.getCode(), ResponseStatusEnum.AUTHENTICATION_ERROR.getMessage(), null);
        }
        return statusVO;
    }

    /**
     * 第三方系统完成提现
     * @return
     */
    public ResponseStatusVO doWithdrawThirdParty() {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        return statusVO;
    }

    /**
     * 由系统人工确认完成提现，注意权限配置
     * @param withdrawNo
     * @param withdrawStatus
     * @return
     */
    @PostMapping("confirm-human")
    @SysLog(description = "人工完成提现操作")
    public ResponseStatusVO confirmWithdrawHuman(String withdrawNo, Byte withdrawStatus) {
        ResponseStatusVO statusVO = new ResponseStatusVO();
        if (StringUtils.isNotEmpty(withdrawNo) && withdrawStatus != null
                && (withdrawStatus == WithdrawStatusEnum.SUCCESS.getValue().byteValue()
                || withdrawStatus == WithdrawStatusEnum.FAILURE.getValue().byteValue())) {
            UserWithdrawDO userWithdrawDO = userWithdrawService.getByWithdrawNo(withdrawNo);
            if (userWithdrawDO != null && userWithdrawDO.getWithdrawStatus().byteValue() == WithdrawStatusEnum.CHECKED.getValue()) {
                int updateRows = userWithdrawService.completeWithdraw(withdrawNo, withdrawStatus, userWithdrawDO.getUserId(), userWithdrawDO.getAmount(), userWithdrawDO.getVersion() + 1);
                if (updateRows == 1) {
                    statusVO.dataErrorStatus(ResponseStatusEnum.OK.getCode(), "已人工完成提现操作，提现" + WithdrawStatusEnum.findByValue(withdrawStatus.intValue()).getDes(), null);
                } else {
                    statusVO.errorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "数据版本号有问题，在完成提现前提现记录已被更新", null);
                }
            } else {
                statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "提现单号不正确或提现申请不是已通过状态", null);
            }
        } else {
            statusVO.dataErrorStatus(ResponseStatusEnum.DATA_ERROR.getCode(), "请选择正确的提现单号和审核状态", null);
        }
        return statusVO;
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
