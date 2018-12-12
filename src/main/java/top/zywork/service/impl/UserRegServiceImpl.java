package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.dao.UserRegDAO;
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

    @Override
    public void saveUser(String email, String password) {
        userRegDAO.saveUser(email, password);
    }

    @Override
    public void saveUserMobile(String phone, String password) {
        userRegDAO.saveUserMobile(phone, password);
    }

    @Override
    public void saveGzhUser(String openid, String password, String nickname, String headicon, byte gender) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setPassword(password);
        userRegDAO.saveGzhUser(userRegDO);
        userRegDAO.saveGzhUserDetail(userRegDO.getId(), nickname, headicon, gender);
        userRegDAO.saveGzhUserSocial(userRegDO.getId(), openid);
    }

    @Autowired
    public void setUserRegDAO(UserRegDAO userRegDAO) {
        this.userRegDAO = userRegDAO;
    }
}
