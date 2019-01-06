package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.common.ExceptionUtils;
import top.zywork.dao.RolePermissionDAO;
import top.zywork.dos.RolePermissionDO;
import top.zywork.dto.RolePermissionDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.RolePermissionService;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<Object> dataTransferObjList) {
        try {
            if (dataTransferObjList != null && dataTransferObjList.size() > 0) {
                rolePermissionDAO.removeById(((RolePermissionDTO) dataTransferObjList.get(0)).getRoleId());
                return rolePermissionDAO.saveBatch(BeanUtils.copyList(dataTransferObjList, RolePermissionDTO.class));
            }
            return 0;
        } catch (RuntimeException e) {
            throw ExceptionUtils.serviceException(e);
        }
    }

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
