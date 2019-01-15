package top.zywork.service;

import top.zywork.vo.ResponseStatusVO;

/**
 * 支付服务接口。一般情况下建议先生成支付订单，再发起支付<br/>
 *
 * 创建于2019-01-15<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface PayService {

    /**
     * 使用余额支付，没有考虑支付完成后对其他表的操作（事务），实际使用中，请基于此实现再次实现对应场景下的余额支付
     * @param userId 用户编号
     * @param totalFee 支付金额，单位为分
     * @return
     */
    ResponseStatusVO payByBalance(Long userId, int totalFee);

    /**
     * 微信公众号支付
     * @param openid 用户openid
     * @param orderNo 订单号
     * @param ip ip地址
     * @param body 订单主体信息
     * @param attach 订单附加信息
     * @param totalFee 支付金额，单位为分
     * @return
     */
    ResponseStatusVO payByGzhWxpay(String openid, String orderNo, String ip, String body, String attach, int totalFee);

    /**
     * 微信小程序支付
     * @param openid 用户openid
     * @param orderNo 订单号
     * @param ip ip地址
     * @param body 订单主体信息
     * @param attach 订单附加信息
     * @param totalFee 支付金额，单位为分
     * @return
     */
    ResponseStatusVO payByXcxWxpay(String openid, String orderNo, String ip, String body, String attach, int totalFee);

    /**
     * 支付宝支付
     * @return
     */
    ResponseStatusVO payByAlipay();

    /**
     * 银联支付
     * @return
     */
    ResponseStatusVO payByUnionpay();

}
