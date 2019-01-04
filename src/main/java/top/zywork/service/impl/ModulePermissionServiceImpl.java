package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.ModulePermissionDAO;
import top.zywork.dos.ModulePermissionDO;
import top.zywork.dto.ModulePermissionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ModulePermissionService;

import javax.annotation.PostConstruct;

/**
 * ModulePermissionServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "modulePermissionService")
public class ModulePermissionServiceImpl extends AbstractBaseService implements ModulePermissionService {

    private ModulePermissionDAO modulePermissionDAO;

    @Autowired
    public void setModulePermissionDAO(ModulePermissionDAO modulePermissionDAO) {
        super.setBaseDAO(modulePermissionDAO);
        this.modulePermissionDAO = modulePermissionDAO;
    }

    @PostConstruct
    public void init() {
        super.init(ModulePermissionDO.class, ModulePermissionDTO.class);
    }
}
