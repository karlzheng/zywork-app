package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.PermissionDAO;
import top.zywork.dos.PermissionDO;
import top.zywork.dto.PermissionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.PermissionService;

import javax.annotation.PostConstruct;

/**
 * PermissionServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "permissionService")
public class PermissionServiceImpl extends AbstractBaseService implements PermissionService {

    private PermissionDAO permissionDAO;

    @Autowired
    public void setPermissionDAO(PermissionDAO permissionDAO) {
        super.setBaseDAO(permissionDAO);
        this.permissionDAO = permissionDAO;
    }

    @PostConstruct
    public void init() {
        super.init(PermissionDO.class, PermissionDTO.class);
    }
}
