package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.common.BeanUtils;
import top.zywork.dao.ModulePermissionDAO;
import top.zywork.dos.ModulePermissionDO;
import top.zywork.dto.ModulePermissionDTO;
import top.zywork.dto.PagerDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.ModulePermissionService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    @SuppressWarnings({"unchecked"})
    public PagerDTO listByUserId(Long userId) {
        PagerDTO pagerDTO = new PagerDTO();
        List<Object> modulePermissionDOList = modulePermissionDAO.listByUserId(userId);
        List<Object> modulePermissionDTOList = new ArrayList<>();
        if (modulePermissionDOList != null && modulePermissionDOList.size() > 0) {
            modulePermissionDTOList = BeanUtils.copyList(modulePermissionDOList, ModulePermissionDTO.class);
        }
        pagerDTO.setRows(modulePermissionDTOList);
        pagerDTO.setTotal((long) (modulePermissionDTOList.size()));
        return pagerDTO;
    }

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
