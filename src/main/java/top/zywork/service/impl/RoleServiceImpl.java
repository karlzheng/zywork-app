package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.RoleDAO;
import top.zywork.dos.RoleDO;
import top.zywork.dto.RoleDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.RoleService;

import javax.annotation.PostConstruct;

/**
 * RoleServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "roleService")
public class RoleServiceImpl extends AbstractBaseService implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        super.setBaseDAO(roleDAO);
        this.roleDAO = roleDAO;
    }

    @PostConstruct
    public void init() {
        super.init(RoleDO.class, RoleDTO.class);
    }
}
