package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserBankcardDAO;
import top.zywork.dos.UserBankcardDO;
import top.zywork.dto.UserBankcardDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserBankcardService;

import javax.annotation.PostConstruct;

/**
 * UserBankcardServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userBankcardService")
public class UserBankcardServiceImpl extends AbstractBaseService implements UserBankcardService {

    private UserBankcardDAO userBankcardDAO;

    @Autowired
    public void setUserBankcardDAO(UserBankcardDAO userBankcardDAO) {
        super.setBaseDAO(userBankcardDAO);
        this.userBankcardDAO = userBankcardDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserBankcardDO.class, UserBankcardDTO.class);
    }
}
