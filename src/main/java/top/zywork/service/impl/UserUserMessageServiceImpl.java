package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserUserMessageDAO;
import top.zywork.dos.UserUserMessageDO;
import top.zywork.dto.UserUserMessageDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserUserMessageService;

import javax.annotation.PostConstruct;

/**
 * UserUserMessageServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userUserMessageService")
public class UserUserMessageServiceImpl extends AbstractBaseService implements UserUserMessageService {

    private UserUserMessageDAO userUserMessageDAO;

    @Autowired
    public void setUserUserMessageDAO(UserUserMessageDAO userUserMessageDAO) {
        super.setBaseDAO(userUserMessageDAO);
        this.userUserMessageDAO = userUserMessageDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserUserMessageDO.class, UserUserMessageDTO.class);
    }
}
