package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.FundsRechargeDAO;
import top.zywork.dos.FundsRechargeDO;
import top.zywork.dto.FundsRechargeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.FundsRechargeService;

import javax.annotation.PostConstruct;

/**
 * FundsRechargeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "fundsRechargeService")
public class FundsRechargeServiceImpl extends AbstractBaseService implements FundsRechargeService {

    private FundsRechargeDAO fundsRechargeDAO;

    @Autowired
    public void setFundsRechargeDAO(FundsRechargeDAO fundsRechargeDAO) {
        super.setBaseDAO(fundsRechargeDAO);
        this.fundsRechargeDAO = fundsRechargeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(FundsRechargeDO.class, FundsRechargeDTO.class);
    }
}
