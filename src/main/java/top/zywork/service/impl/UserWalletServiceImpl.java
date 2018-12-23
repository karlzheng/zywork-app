package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserWalletDAO;
import top.zywork.dos.UserWalletDO;
import top.zywork.dto.UserWalletDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserWalletService;

import javax.annotation.PostConstruct;

/**
 * UserWalletServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userWalletService")
public class UserWalletServiceImpl extends AbstractBaseService implements UserWalletService {

    private UserWalletDAO userWalletDAO;

    @Autowired
    public void setUserWalletDAO(UserWalletDAO userWalletDAO) {
        super.setBaseDAO(userWalletDAO);
        this.userWalletDAO = userWalletDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserWalletDO.class, UserWalletDTO.class);
    }
}
