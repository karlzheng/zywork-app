package top.zywork.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.annotation.SysLog;
import top.zywork.dto.UserWalletDTO;
import top.zywork.security.JwtUser;
import top.zywork.security.MyUserDetailsService;
import top.zywork.security.SecurityUtils;
import top.zywork.service.UserTransferService;
import top.zywork.service.UserWalletService;
import top.zywork.vo.ResponseStatusVO;

/**
 * 用户转账控制器类<br/>
 *
 * 创建于2019-01-06<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/transfer")
public class UserTransferController {

    private UserWalletService userWalletService;

    private MyUserDetailsService jwtUserDetailsService;

    private UserTransferService userTransferService;

    /**
     * 用户转账
     *
     * @param toPhone     对方手机号
     * @param amount      转账金额
     * @param payPassword 支付密码
     * @return
     */
    @PostMapping("user/trans")
    @SysLog(description = "用户转账", requestParams = false)
    public ResponseStatusVO transfer(String toPhone, Long amount, String payPassword) {
        JwtUser jwtUser = SecurityUtils.getJwtUser();
        if (jwtUser == null) {
            return ResponseStatusVO.authenticationError();
        }
        if (amount == null || StringUtils.isEmpty(payPassword)) {
            return ResponseStatusVO.dataError("必须填写转账金额，支付密码", null);
        }
        if (amount <= 0) {
            return ResponseStatusVO.dataError("转账金额必须大于0", null);
        }
        Object obj = userWalletService.getById(jwtUser.getUserId());
        if (obj == null) {
            return ResponseStatusVO.dataError("此用户无钱包记录", null);
        }
        UserWalletDTO userWalletDTO = (UserWalletDTO) obj;
        if (!new BCryptPasswordEncoder().matches(payPassword, userWalletDTO.getPayPassword())) {
            return ResponseStatusVO.dataError("支付密码错误", null);
        }
        JwtUser toJwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(toPhone);
        if (StringUtils.isEmpty(toJwtUser.getUsername())) {
            return ResponseStatusVO.dataError("对方账户填写错误", null);
        }
        int savedRows = userTransferService.saveTransfer(jwtUser.getUserId(), toJwtUser.getUserId(), amount);
        if (savedRows == 1) {
            return ResponseStatusVO.ok("转账成功", null);
        } else {
            return ResponseStatusVO.dataError("转账金额必须小于等于可转账余额", null);
        }
    }

    @Autowired
    public void setUserWalletService(UserWalletService userWalletService) {
        this.userWalletService = userWalletService;
    }

    @Autowired
    public void setJwtUserDetailsService(MyUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Autowired
    public void setUserTransferService(UserTransferService userTransferService) {
        this.userTransferService = userTransferService;
    }
}
