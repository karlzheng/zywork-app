package top.zywork.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户充值DAO接口<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Repository
public interface UserRechargeDAO {

    /**
     * 保存第三方的充值记录
     * @param transactionNo 交易编号
     * @param userId 用户编号
     * @param amount 金额
     * @param outTradeNo 商户订单号
     * @param tradeNo 支付系统订单号
     * @param rechargeType 充值类型
     * @param isSuccess 0表示成功
     */
    void saveRechargeThirdParty(@Param("transactionNo") String transactionNo, @Param("userId") Long userId, @Param("amount") Long amount, @Param("outTradeNo") String outTradeNo,
                                @Param("tradeNo") String tradeNo, @Param("rechargeType") String rechargeType, @Param("isSuccess") byte isSuccess);

    /**
     * 保存系统工作充值的记录
     * @param transactionNo 交易编号
     * @param userId
     * @param amount
     * @param rechargeType 充值类型
     */
    void saveRechargeHuman(@Param("transactionNo") String transactionNo, @Param("userId") Long userId, @Param("amount") Long amount, @Param("rechargeType") String rechargeType);

}
