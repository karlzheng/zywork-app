package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.FundsFrezeeDAO;
import top.zywork.dos.FundsFrezeeDO;
import top.zywork.dto.FundsFrezeeDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.FundsFrezeeService;

import javax.annotation.PostConstruct;

/**
 * FundsFrezeeServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "fundsFrezeeService")
public class FundsFrezeeServiceImpl extends AbstractBaseService implements FundsFrezeeService {

    private FundsFrezeeDAO fundsFrezeeDAO;

    @Autowired
    public void setFundsFrezeeDAO(FundsFrezeeDAO fundsFrezeeDAO) {
        super.setBaseDAO(fundsFrezeeDAO);
        this.fundsFrezeeDAO = fundsFrezeeDAO;
    }

    @PostConstruct
    public void init() {
        super.init(FundsFrezeeDO.class, FundsFrezeeDTO.class);
    }
}
