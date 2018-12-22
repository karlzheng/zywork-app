package top.zywork.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserPasswordDAO;
import top.zywork.service.UserPasswordService;

/**
 * 用户密码操作Service实现类<br/>
 *
 * 创建于2018-12-21<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class UserPasswordServiceImpl implements UserPasswordService {

    private UserPasswordDAO userPasswordDAO;

    @Override
    public void resetLoginPwdByEmail(String email, String password) {
        userPasswordDAO.resetLoginPwdByEmail(email, new BCryptPasswordEncoder().encode(password));
    }

    @Override
    public void resetLoginPwdByPhone(String phone, String password) {
        userPasswordDAO.resetLoginPwdByPhone(phone, new BCryptPasswordEncoder().encode(password));
    }

    @Override
    public boolean updateLoginPwd(Long userId, String oldPassword, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = userPasswordDAO.getLoginPwd(userId);
        if (StringUtils.isBlank(oldPassword) && "".equals(pwd)) {
            userPasswordDAO.updateLoginPwd(userId, bCryptPasswordEncoder.encode(password));
            return true;
        } else if (bCryptPasswordEncoder.matches(oldPassword, pwd)) {
            userPasswordDAO.updateLoginPwd(userId, bCryptPasswordEncoder.encode(password));
            return true;
        }
        return false;
    }

    @Override
    public void resetPayPwdByEmail(String email, String password) {
        userPasswordDAO.resetPayPwdByEmail(email, new BCryptPasswordEncoder().encode(password));
    }

    @Override
    public void resetPayPwdByPhone(String phone, String password) {
        userPasswordDAO.resetPayPwdByPhone(phone, new BCryptPasswordEncoder().encode(password));
    }

    @Override
    public boolean updatePayPwd(Long userId, String oldPassword, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = userPasswordDAO.getPayPwd(userId);
        if (StringUtils.isBlank(oldPassword) && "".equals(pwd)) {
            userPasswordDAO.updatePayPwd(userId, bCryptPasswordEncoder.encode(password));
            return true;
        } else if (bCryptPasswordEncoder.matches(oldPassword, pwd)) {
            userPasswordDAO.updatePayPwd(userId, bCryptPasswordEncoder.encode(password));
            return true;
        }
        return false;
    }

    @Autowired
    public void setUserPasswordDAO(UserPasswordDAO userPasswordDAO) {
        this.userPasswordDAO = userPasswordDAO;
    }
}
