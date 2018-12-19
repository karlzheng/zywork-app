package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserUserSocialDAO;
import top.zywork.dos.UserUserSocialDO;
import top.zywork.dto.UserUserSocialDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserUserSocialService;

import javax.annotation.PostConstruct;

/**
 * UserUserSocialServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userUserSocialService")
public class UserUserSocialServiceImpl extends AbstractBaseService implements UserUserSocialService {

    private UserUserSocialDAO userUserSocialDAO;

    @Autowired
    public void setUserUserSocialDAO(UserUserSocialDAO userUserSocialDAO) {
        super.setBaseDAO(userUserSocialDAO);
        this.userUserSocialDAO = userUserSocialDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserUserSocialDO.class, UserUserSocialDTO.class);
    }
}
