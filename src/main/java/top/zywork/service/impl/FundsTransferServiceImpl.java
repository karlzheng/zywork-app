package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.FundsTransferDAO;
import top.zywork.dos.FundsTransferDO;
import top.zywork.dto.FundsTransferDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.FundsTransferService;

import javax.annotation.PostConstruct;

/**
 * FundsTransferServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "fundsTransferService")
public class FundsTransferServiceImpl extends AbstractBaseService implements FundsTransferService {

    private FundsTransferDAO fundsTransferDAO;

    @Autowired
    public void setFundsTransferDAO(FundsTransferDAO fundsTransferDAO) {
        super.setBaseDAO(fundsTransferDAO);
        this.fundsTransferDAO = fundsTransferDAO;
    }

    @PostConstruct
    public void init() {
        super.init(FundsTransferDO.class, FundsTransferDTO.class);
    }
}
