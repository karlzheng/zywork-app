package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.UserDetailDAO;
import top.zywork.dos.UserDetailDO;
import top.zywork.dto.UserDetailDTO;
import top.zywork.service.AbstractBaseService;
import top.zywork.service.UserDetailService;

import javax.annotation.PostConstruct;

/**
 * UserDetailServiceImpl服务接口实现类<br/>
 *
 * 创建于2019-01-29<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
@Service(value = "userDetailService")
public class UserDetailServiceImpl extends AbstractBaseService implements UserDetailService {

    private UserDetailDAO userDetailDAO;

    @Autowired
    public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
        super.setBaseDAO(userDetailDAO);
        this.userDetailDAO = userDetailDAO;
    }

    @PostConstruct
    public void init() {
        super.init(UserDetailDO.class, UserDetailDTO.class);
    }
}
