package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserOrganizationDAO;
import top.zywork.dos.UserOrganizationDO;
import top.zywork.dto.UserOrganizationDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserOrganizationService;

import javax.annotation.PostConstruct;

/**
 * UserOrganizationServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-24<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userOrganizationService")
public class UserOrganizationServiceImpl extends AbstractBaseService implements UserOrganizationService {

    private UserOrganizationDAO userOrganizationDAO;

    @Autowired
    public void setUserOrganizationDAO(UserOrganizationDAO userOrganizationDAO) {
        super.setBaseDAO(userOrganizationDAO);
        this.userOrganizationDAO = userOrganizationDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserOrganizationDO.class, UserOrganizationDTO.class);
    }
}
