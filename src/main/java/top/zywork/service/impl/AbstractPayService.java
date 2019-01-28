package top.zywork.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.AccountDetailDAO;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dos.AccountDetailDO;
import top.zywork.enums.FundsChangeTypeEnum;
import top.zywork.enums.PaymentTypeEnum;
import top.zywork.enums.SysConfigEnum;
import top.zywork.service.PayService;
import top.zywork.service.SysConfigService;
import top.zywork.vo.ResponseStatusVO;
import top.zywork.weixin.*;

import java.util.Map;

/**
 * 支付服务接口实现类<br/>
 *
 * 创建于2019-01-15<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public abstract class AbstractPayService implements PayService {

    private static final Logger logger = LoggerFactory.getLogger(AbstractPayService.class);

    private UserWalletDAO userWalletDAO;

    private AccountDetailDAO accountDetailDAO;

    private SysConfigService sysConfigService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseStatusVO payByBalance(Long userId, int totalFee) {
        int updatedRows = userWalletDAO.updateWalletOut(userId, (long) totalFee);
        if (updatedRows == 0) {
            return ResponseStatusVO.dataError("可用余额不足", null);
        }
        saveAccountDetail(userId, (long) totalFee);
        return ResponseStatusVO.ok("余额支付成功", null);
    }

    private void saveAccountDetail(Long userId, Long amount) {
        AccountDetailDO accountDetailDO = new AccountDetailDO();
        accountDetailDO.setUserId(userId);
        accountDetailDO.setAmount(-amount);
        accountDetailDO.setType((byte) 1);
        accountDetailDO.setSubType(FundsChangeTypeEnum.CONSUME.getValue());
        accountDetailDO.setPayType(PaymentTypeEnum.WALLET_PAY.getValue().byteValue());
        accountDetailDAO.save(accountDetailDO);
    }

    @Override
    public ResponseStatusVO payByGzhWxpay(String openid, String orderNo, String ip, String body, String attach, int totalFee) {
        WeixinGzhConfig weixinGzhConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
        WXPayConfig wxPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);
        Map<String, String> unifiedOrderResult = WeixinUtils.unifiedOrder(weixinGzhConfig.getAppId(), wxPayConfig.getMchId(), wxPayConfig.getApiSecret(), openid, orderNo, ip, body, attach, totalFee, wxPayConfig.getPayNotifyUrl());
        if (!WeixinUtils.isReturnSuccess(unifiedOrderResult)) {
            logger.error("weixin gzh unified order fail");
            return ResponseStatusVO.error("微信公众号端统一下单请求失败", null);
        }
        if (!WeixinUtils.isResultSuccess(unifiedOrderResult)) {
            logger.error("weixin gzh unified order fail, err code: {}, err code des: {}", WeixinUtils.errCode(unifiedOrderResult), WeixinUtils.errCodeDes(unifiedOrderResult));
            return ResponseStatusVO.error("微信公众号端统一下单失败", null);
        }
        PayData payData = WeixinUtils.payData(WeixinUtils.payDataMap(weixinGzhConfig.getAppId(), wxPayConfig.getApiSecret(), unifiedOrderResult));
        return ResponseStatusVO.ok("已获取公众号JS发起支付请求需要的数据", payData);
    }

    @Override
    public ResponseStatusVO payByXcxWxpay(String openid, String orderNo, String ip, String body, String attach, int totalFee) {
        WeixinXcxConfig weixinXcxConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_XCX_CONFIG.getValue(), WeixinXcxConfig.class);
        WXPayConfig wxPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);
        Map<String, String> unifiedOrderResult = WeixinUtils.unifiedOrder(weixinXcxConfig.getAppId(), wxPayConfig.getMchId(), wxPayConfig.getApiSecret(), openid, orderNo, ip, body, attach, totalFee, wxPayConfig.getPayNotifyUrl());
        if (!WeixinUtils.isReturnSuccess(unifiedOrderResult)) {
            logger.error("weixin xcx unified order fail");
            return ResponseStatusVO.error("微信小程序端统一下单请求失败", null);
        }
        if (!WeixinUtils.isResultSuccess(unifiedOrderResult)) {
            logger.error("weixin xcx unified order error, err code: {}, err code des: {}", WeixinUtils.errCode(unifiedOrderResult), WeixinUtils.errCodeDes(unifiedOrderResult));
            return ResponseStatusVO.error("微信小程序端统一下单失败", null);
        }
        PayData payData = WeixinUtils.payData(WeixinUtils.payDataMap(weixinXcxConfig.getAppId(), wxPayConfig.getApiSecret(), unifiedOrderResult));
        return ResponseStatusVO.ok("已获取小程序API发起支付请求需要的数据", payData);
    }

    @Override
    public ResponseStatusVO payByAlipay() {
        return null;
    }

    @Override
    public ResponseStatusVO payByUnionpay() {
        return null;
    }

    @Override
    public ResponseStatusVO sendRedpackByWxpay(String openid, String billNo, String ip, String sendName, int totalAmount,
                                               int totalNum, String wishing, String actName, String remark, String sceneId) {
        WeixinGzhConfig weixinGzhConfig = sysConfigService.getByName(SysConfigEnum.WEIXIN_GZH_CONFIG.getValue(), WeixinGzhConfig.class);
        WXPayConfig wxPayConfig = sysConfigService.getByName(SysConfigEnum.WX_PAY_CONFIG.getValue(), WXPayConfig.class);
        Map<String, String> redpackResultMap = WeixinUtils.sendRedpack(weixinGzhConfig.getAppId(), wxPayConfig.getMchId(), wxPayConfig.getApiSecret(), openid, ip, billNo, sendName, totalAmount, totalNum, wishing, actName, remark, sceneId);
        if (!WeixinUtils.isReturnSuccess(redpackResultMap)) {
            logger.error("weixin gzh send redpack fail");
            return ResponseStatusVO.error("微信公众号端发送普通红包请求失败", null);
        }
        if (!WeixinUtils.isResultSuccess(redpackResultMap)) {
            logger.error("weixin gzh send redpack error, err code: {}, err code des: {}", WeixinUtils.errCode(redpackResultMap), WeixinUtils.errCodeDes(redpackResultMap));
            return ResponseStatusVO.error("微信公众号端发送普通红包失败", null);
        }
        return ResponseStatusVO.ok("微信公众号端发送普通红包成功", WeixinUtils.redpackResult(redpackResultMap));
    }

    @Autowired
    public void setAccountDetailDAO(AccountDetailDAO accountDetailDAO) {
        this.accountDetailDAO = accountDetailDAO;
    }

    @Autowired
    public void setUserWalletDAO(UserWalletDAO userWalletDAO) {
        this.userWalletDAO = userWalletDAO;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

}
