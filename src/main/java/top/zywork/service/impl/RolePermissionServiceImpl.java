package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.RolePermissionDAO;
import top.zywork.dos.RolePermissionDO;
import top.zywork.dto.RolePermissionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.RolePermissionService;

import javax.annotation.PostConstruct;

/**
 * RolePermissionServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "rolePermissionService")
public class RolePermissionServiceImpl extends AbstractBaseService implements RolePermissionService {

    private RolePermissionDAO rolePermissionDAO;

    @Autowired
    public void setRolePermissionDAO(RolePermissionDAO rolePermissionDAO) {
        super.setBaseDAO(rolePermissionDAO);
        this.rolePermissionDAO = rolePermissionDAO;
    }

    @PostConstruct
    public void init() {
        super.init(RolePermissionDO.class, RolePermissionDTO.class);
    }
}
