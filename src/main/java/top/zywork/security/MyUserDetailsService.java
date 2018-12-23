package top.zywork.security;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 自定义用户详情接口，继承自SpringSecurity的UserDetailsService接口<br/>
 *
 * 创建于2018-12-23<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public interface MyUserDetailsService extends UserDetailsService {

    /**
     * 根据用户编号获取用户详情
     * @param userId
     * @return
     */
    UserDO loadUserByUserId(Long userId);

}
