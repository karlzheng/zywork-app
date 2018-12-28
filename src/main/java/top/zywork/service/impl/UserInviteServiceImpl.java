package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserInviteDAO;
import top.zywork.service.UserInviteService;

/**
 * 用户邀请Service接口实现类<br/>
 *
 * 创建于2018-12-28<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class UserInviteServiceImpl implements UserInviteService {

    private UserInviteDAO userInviteDAO;

    @Override
    public void saveUserHierarchy(Long pUserId, Long userId) {
        userInviteDAO.saveUserHierarchy(pUserId, userId);
    }

    @Autowired
    public void setUserInviteDAO(UserInviteDAO userInviteDAO) {
        this.userInviteDAO = userInviteDAO;
    }
}
