package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.*;
import top.zywork.dos.ModuleDO;
import top.zywork.dos.ModulePermissionDO;
import top.zywork.dos.PermissionDO;
import top.zywork.dos.RolePermissionDO;
import top.zywork.enums.SqlSortOrderEnum;
import top.zywork.query.ModulePermissionQuery;
import top.zywork.query.ModuleQuery;
import top.zywork.service.PermissionImportExportService;
import top.zywork.vo.PermissionImportExportVO;
import top.zywork.vo.PermissionInnerVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限导入导出服务接口实现类<br/>
 *
 * 创建于2019-01-04<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service
public class PermissionImportExportServiceImpl implements PermissionImportExportService {

    private ModuleDAO moduleDAO;

    private PermissionDAO permissionDAO;

    private RolePermissionDAO rolePermissionDAO;

    private RoleDAO roleDAO;

    private ModulePermissionDAO modulePermissionDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importPermissions(List<PermissionImportExportVO> permissionImportExportVOList) {
        // 移除所有角色权限配置
        rolePermissionDAO.removeAll();
        // 移除所有权限
        permissionDAO.removeAll();
        // 移除所有模块
        moduleDAO.removeAll();
        for (PermissionImportExportVO permissionImportExportVO : permissionImportExportVOList) {
            ModuleDO moduleDO = new ModuleDO();
            moduleDO.setTitle(permissionImportExportVO.getModuleTitle());
            // 保存模块信息
            moduleDAO.save(moduleDO);
            Long moduleId = moduleDO.getId();
            List<PermissionInnerVO> permissionInnerVOList = permissionImportExportVO.getPermissions();
            for (PermissionInnerVO permissionInnerVO : permissionInnerVOList) {
                PermissionDO permissionDO = new PermissionDO();
                permissionDO.setModuleId(moduleId);
                permissionDO.setTitle(permissionInnerVO.getTitle());
                permissionDO.setPermission(permissionInnerVO.getPermission());
                // 保存权限信息
                permissionDAO.save(permissionDO);
                String[] roles = permissionInnerVO.getRoles();
                // 获取角色权限配置信息
                List<Object> rolePermissionDOList = new ArrayList<>();
                for (String role : roles) {
                    Long id = roleDAO.getByTitle(role);
                    RolePermissionDO rolePermissionDO = new RolePermissionDO();
                    rolePermissionDO.setRoleId(id);
                    rolePermissionDO.setPermissionId(permissionDO.getId());
                    rolePermissionDOList.add(rolePermissionDO);
                }
                // 批量保存角色权限信息
                rolePermissionDAO.saveBatch(rolePermissionDOList);
            }
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<PermissionImportExportVO> exportPermissions() {
        List<PermissionImportExportVO> permissionImportExportVOList = new ArrayList<>();
        // 获取所有模块信息
        ModuleQuery moduleQuery = new ModuleQuery();
        moduleQuery.setSortColumn("id");
        moduleQuery.setSortOrder(SqlSortOrderEnum.ASC.getValue());
        List<ModuleDO> moduleDOList = (List) moduleDAO.listAllByCondition(moduleQuery);
        for (ModuleDO moduleDO : moduleDOList) {
            PermissionImportExportVO permissionImportExportVO = new PermissionImportExportVO();
            permissionImportExportVO.setModuleTitle(moduleDO.getTitle());
            ModulePermissionQuery modulePermissionQuery = new ModulePermissionQuery();
            modulePermissionQuery.setSortColumn("permissionId");
            modulePermissionQuery.setSortOrder(SqlSortOrderEnum.ASC.getValue());
            List<ModulePermissionDO> modulePermissionDOList = (List) modulePermissionDAO.listAllByCondition(modulePermissionQuery);
            // 根据模块获取所有权限信息
            List<PermissionInnerVO> permissionInnerVOList = new ArrayList<>();
            for (ModulePermissionDO modulePermissionDO : modulePermissionDOList) {
                PermissionInnerVO permissionInnerVO = new PermissionInnerVO();
                permissionInnerVO.setPermission(modulePermissionDO.getPermissionPermission());
                permissionInnerVO.setTitle(modulePermissionDO.getPermissionTitle());
                // 根据权限信息获取与之绑定的角色信息
                List<String> roleNames = rolePermissionDAO.listRolesByPermissionId(modulePermissionDO.getPermissionId());
                String[] roles = new String[roleNames.size()];
                permissionInnerVO.setRoles(roleNames.toArray(roles));
                permissionInnerVOList.add(permissionInnerVO);
            }
            permissionImportExportVO.setPermissions(permissionInnerVOList);
            permissionImportExportVOList.add(permissionImportExportVO);
        }
        return permissionImportExportVOList;
    }

    @Autowired
    public void setModuleDAO(ModuleDAO moduleDAO) {
        this.moduleDAO = moduleDAO;
    }

    @Autowired
    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    @Autowired
    public void setRolePermissionDAO(RolePermissionDAO rolePermissionDAO) {
        this.rolePermissionDAO = rolePermissionDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Autowired
    public void setModulePermissionDAO(ModulePermissionDAO modulePermissionDAO) {
        this.modulePermissionDAO = modulePermissionDAO;
    }
}
