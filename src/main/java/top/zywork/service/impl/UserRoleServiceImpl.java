package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.BeanUtils;
import top.zywork.dao.UserRoleDAO;
import top.zywork.dos.UserRoleDO;
import top.zywork.dto.UserRoleDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserRoleService;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveBatch(List<Object> dataTransferObjList) {
        if (dataTransferObjList != null && dataTransferObjList.size() > 0) {
            UserRoleDTO userRoleDTO = (UserRoleDTO) dataTransferObjList.get(0);
            userRoleDAO.removeUserRoleByUserId(userRoleDTO.getUserId());
            return userRoleDAO.saveBatch(BeanUtils.copyList(dataTransferObjList, UserRoleDO.class));
        }
        return 0;
    }

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
