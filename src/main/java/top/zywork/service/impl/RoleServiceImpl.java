package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.RoleDAO;
import top.zywork.dos.RoleDO;
import top.zywork.dto.RoleDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.RoleService;
import top.zywork.vo.RoleExportVO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings({"unchecked"})
    public void importRoles(List roleVOList) {
        roleDAO.removeAll();
        roleDAO.saveBatch(roleVOList);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<RoleExportVO> exportRoles() {
        List<RoleExportVO> roleExportVOList = new ArrayList<>();
        List<RoleDO> roleDOList = (List) roleDAO.listAllIdAsc();
        for (RoleDO roleDO : roleDOList) {
            RoleExportVO roleExportVO = new RoleExportVO(roleDO.getTitle(), roleDO.getDescription(), roleDO.getIsDefault());
            roleExportVOList.add(roleExportVO);
        }
        return roleExportVOList;
    }

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
