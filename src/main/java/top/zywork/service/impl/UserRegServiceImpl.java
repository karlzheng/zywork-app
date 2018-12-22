package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zywork.common.RandomUtils;
import top.zywork.dao.UserRegDAO;
import top.zywork.dao.UserRoleRegDAO;
import top.zywork.dos.UserRegDO;
import top.zywork.enums.RandomCodeEnum;
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

    @Value("${user.share-code.length}")
    private Integer shareCodeLength;

    private UserRegDAO userRegDAO;

    private UserRoleRegDAO userRoleRegDAO;

    @Override
    public void saveUser(String email, String password, Long roleId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setEmail(email);
        userRegDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userRegDAO.saveUser(userRegDO);
        userRegDAO.saveShareCode(userRegDO.getId(), generateShareCode());
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
    }

    @Override
    public void saveUserMobile(String phone, String password, Long roleId) {
        UserRegDO userRegDO = new UserRegDO();
        userRegDO.setPhone(phone);
        userRegDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userRegDAO.saveUserMobile(userRegDO);
        userRegDAO.saveShareCode(userRegDO.getId(), generateShareCode());
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
    }

    @Override
    public void saveGzhUser(String openid, String password, String nickname, String headicon, byte gender, Long roleId) {
        UserRegDO userRegDO = new UserRegDO();
        // userRegDO.setPassword(new BCryptPasswordEncoder().encode(password));
        userRegDAO.saveGzhUser(userRegDO);
        userRegDAO.saveGzhUserDetail(userRegDO.getId(), nickname, headicon, gender, generateShareCode());
        userRegDAO.saveGzhUserSocial(userRegDO.getId(), openid);
        if (roleId != null) {
            userRoleRegDAO.saveUserRole(userRegDO.getId(), roleId);
        }
    }

    /**
     * 生成用户分享码
     */
    private String generateShareCode() {
        String shareCode = RandomUtils.randomCode(RandomCodeEnum.MIX_CODE, shareCodeLength);
        if (userRegDAO.countShareCode(shareCode) == 0) {
            // 如果分享码不存在，则返回生成的分享码
            return shareCode;
        } else {
            // 如果分享码已存在，则继续生成分享码
            return generateShareCode();
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
