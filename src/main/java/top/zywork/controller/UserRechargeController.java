package top.zywork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.annotation.SysLog;
import top.zywork.security.MyUserDetailsService;
import top.zywork.security.UserDO;
import top.zywork.service.UserRechargeService;
import top.zywork.vo.ResponseStatusVO;

/**
 * 用户充值控制器类<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@RestController
@RequestMapping("/user-recharge")
public class UserRechargeController {

    private UserRechargeService userRechargeService;

    private MyUserDetailsService jwtUserDetailsService;

    public ResponseStatusVO rechargeByWxpay() {
        return null;
    }

    public ResponseStatusVO rechargeByAlipay() {
        return null;
    }

    public ResponseStatusVO rechargeByUnionpay() {
        return null;
    }

    /**
     * 系统人工充值
     *
     * @param userId 用户编号
     * @param amount 充值金额
     * @return
     */
    @PostMapping("admin/human")
    @SysLog(description = "系统人工充值")
    public ResponseStatusVO rechargeByHuman(Long userId, Long amount) {
        if (amount == null || amount <= 0) {
            return ResponseStatusVO.dataError("充值金额必须大于0", null);
        }
        UserDO userDO = jwtUserDetailsService.loadUserByUserId(userId);
        if (userDO == null) {
            return ResponseStatusVO.dataError("不存在的用户编号", null);
        }
        userRechargeService.rechargeByHuman(userId, amount);
        return ResponseStatusVO.ok("充值成功", null);
    }

    @Autowired
    public void setUserRechargeService(UserRechargeService userRechargeService) {
        this.userRechargeService = userRechargeService;
    }

    @Autowired
    public void setJwtUserDetailsService(MyUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }
}
