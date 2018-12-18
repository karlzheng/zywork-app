package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.UserRegDAO;
import top.zywork.dao.UserRoleRegDAO;
import top.zywork.dos.UserRegDO;
import top.zywork.service.UserRegService;

/**
 * 用户注册保存用户信息Service接口实现类<br/>
 *
 * 创建于2018-12-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserRegServiceImpl implements UserRegService {

    private UserRegDAO userRegDAO;

    private UserRoleRegDAO userRoleRegDAO;

    @Override
    public void saveUser(String email, String password, Long roleId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setEmail(email);
        userRegDO.setPassword(password);
        userRegDAO.saveUser(userRegDO);
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
    }

    @Override
    public void saveUserMobile(String phone, String password, Long roleId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setPhone(phone);
        userRegDO.setPassword(password);
        userRegDAO.saveUserMobile(userRegDO);
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
    }

    @Override
    public void saveGzhUser(String openid, String password, String nickname, String headicon, byte gender, Long roleId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setPassword(password);
        userRegDAO.saveGzhUser(userRegDO);
        userRegDAO.saveGzhUserDetail(userRegDO.getId(), nickname, headicon, gender);
        userRegDAO.saveGzhUserSocial(userRegDO.getId(), openid);
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
    }

    @Autowired
    public void setUserRegDAO(UserRegDAO userRegDAO) {
        this.userRegDAO = userRegDAO;
    }

    @Autowired
    public void setUserRoleRegDAO(UserRoleRegDAO userRoleRegDAO) {
        this.userRoleRegDAO = userRoleRegDAO;
    }
}
