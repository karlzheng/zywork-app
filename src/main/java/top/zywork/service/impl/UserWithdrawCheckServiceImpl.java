package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserWithdrawCheckDAO;
import top.zywork.dos.UserWithdrawCheckDO;
import top.zywork.dto.UserWithdrawCheckDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserWithdrawCheckService;

import javax.annotation.PostConstruct;

/**
 * UserWithdrawCheckServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-04-01<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userWithdrawCheckService")
public class UserWithdrawCheckServiceImpl extends AbstractBaseService implements UserWithdrawCheckService {

    private UserWithdrawCheckDAO userWithdrawCheckDAO;

    @Autowired
    public void setUserWithdrawCheckDAO(UserWithdrawCheckDAO userWithdrawCheckDAO) {
        super.setBaseDAO(userWithdrawCheckDAO);
        this.userWithdrawCheckDAO = userWithdrawCheckDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserWithdrawCheckDO.class, UserWithdrawCheckDTO.class);
    }
}
