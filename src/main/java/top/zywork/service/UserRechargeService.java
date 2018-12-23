package top.zywork.service;

/**
 * 用户充值Service接口<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface UserRechargeService {

    /**
     * 使用第三方支付系统充值
     * @param userId
     * @param amount
     * @param outTradeNo
     * @param tradeNo
     * @param rechargeType
     * @param isSuccess
     */
    void rechargeByThirdParty(Long userId, Long amount, String outTradeNo, String tradeNo, String rechargeType, byte isSuccess);

    /**
     * 系统人工给指定的用户充值
     * @param userId
     * @param amount
     */
    void rechargeByHuman(Long userId, Long amount);

}
