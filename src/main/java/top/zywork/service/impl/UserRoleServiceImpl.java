package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserRoleDAO;
import top.zywork.dos.UserRoleDO;
import top.zywork.dto.UserRoleDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserRoleService;

import javax.annotation.PostConstruct;

/**
 * UserRoleServiceImpl服务接口实现类<br/>
 *
 * 创建于2018-12-19<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userRoleService")
public class UserRoleServiceImpl extends AbstractBaseService implements UserRoleService {

    private UserRoleDAO userRoleDAO;

    @Autowired
    public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
        super.setBaseDAO(userRoleDAO);
        this.userRoleDAO = userRoleDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserRoleDO.class, UserRoleDTO.class);
    }
}
