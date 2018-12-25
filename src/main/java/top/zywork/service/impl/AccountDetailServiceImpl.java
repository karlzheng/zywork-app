package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.AccountDetailDAO;
import top.zywork.dos.AccountDetailDO;
import top.zywork.dto.AccountDetailDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.AccountDetailService;

import javax.annotation.PostConstruct;

/**
 * AccountDetailServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-25<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "accountDetailService")
public class AccountDetailServiceImpl extends AbstractBaseService implements AccountDetailService {

    private AccountDetailDAO accountDetailDAO;

    @Autowired
    public void setAccountDetailDAO(AccountDetailDAO accountDetailDAO) {
        super.setBaseDAO(accountDetailDAO);
        this.accountDetailDAO = accountDetailDAO;
    }

    @PostConstruct
    public void init() {
        super.init(AccountDetailDO.class, AccountDetailDTO.class);
    }
}
