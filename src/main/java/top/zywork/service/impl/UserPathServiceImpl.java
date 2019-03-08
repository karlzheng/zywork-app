package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserPathDAO;
import top.zywork.dos.UserPathDO;
import top.zywork.dto.UserPathDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserPathService;

import javax.annotation.PostConstruct;

/**
 * UserPathServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-03-08<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userPathService")
public class UserPathServiceImpl extends AbstractBaseService implements UserPathService {

    private UserPathDAO userPathDAO;

    @Autowired
    public void setUserPathDAO(UserPathDAO userPathDAO) {
        super.setBaseDAO(userPathDAO);
        this.userPathDAO = userPathDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserPathDO.class, UserPathDTO.class);
    }
}
