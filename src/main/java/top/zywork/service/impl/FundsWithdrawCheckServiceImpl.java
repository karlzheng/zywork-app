package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.FundsWithdrawCheckDAO;
import top.zywork.dos.FundsWithdrawCheckDO;
import top.zywork.dto.FundsWithdrawCheckDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.FundsWithdrawCheckService;

import javax.annotation.PostConstruct;

/**
 * FundsWithdrawCheckServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "fundsWithdrawCheckService")
public class FundsWithdrawCheckServiceImpl extends AbstractBaseService implements FundsWithdrawCheckService {

    private FundsWithdrawCheckDAO fundsWithdrawCheckDAO;

    @Autowired
    public void setFundsWithdrawCheckDAO(FundsWithdrawCheckDAO fundsWithdrawCheckDAO) {
        super.setBaseDAO(fundsWithdrawCheckDAO);
        this.fundsWithdrawCheckDAO = fundsWithdrawCheckDAO;
    }

    @PostConstruct
    public void init() {
        super.init(FundsWithdrawCheckDO.class, FundsWithdrawCheckDTO.class);
    }
}
