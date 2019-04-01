package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.FundsWithdrawDAO;
import top.zywork.dos.FundsWithdrawDO;
import top.zywork.dto.FundsWithdrawDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.FundsWithdrawService;

import javax.annotation.PostConstruct;

/**
 * FundsWithdrawServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "fundsWithdrawService")
public class FundsWithdrawServiceImpl extends AbstractBaseService implements FundsWithdrawService {

    private FundsWithdrawDAO fundsWithdrawDAO;

    @Autowired
    public void setFundsWithdrawDAO(FundsWithdrawDAO fundsWithdrawDAO) {
        super.setBaseDAO(fundsWithdrawDAO);
        this.fundsWithdrawDAO = fundsWithdrawDAO;
    }

    @PostConstruct
    public void init() {
        super.init(FundsWithdrawDO.class, FundsWithdrawDTO.class);
    }
}
