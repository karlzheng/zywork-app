package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserMessageDAO;
import top.zywork.dos.UserMessageDO;
import top.zywork.dto.UserMessageDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserMessageService;

import javax.annotation.PostConstruct;

/**
 * UserMessageServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userMessageService")
public class UserMessageServiceImpl extends AbstractBaseService implements UserMessageService {

    private UserMessageDAO userMessageDAO;

    @Autowired
    public void setUserMessageDAO(UserMessageDAO userMessageDAO) {
        super.setBaseDAO(userMessageDAO);
        this.userMessageDAO = userMessageDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserMessageDO.class, UserMessageDTO.class);
    }
}
