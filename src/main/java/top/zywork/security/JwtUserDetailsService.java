package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.zywork.dao.SpringSecurityDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringSecurity 用户服务<br/>
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Service
public class JwtUserDetailsService implements MyUserDetailsService {

    private SpringSecurityDAO springSecurityDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名去查找用户和用户对应的角色
        UserDO userDO = springSecurityDAO.loadUserByUsername(username);
        if (userDO != null) {
            List<String> roles = springSecurityDAO.loadRolesByUsername(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            // authorities就是用户对应的角色, access list即为用户可访问的url
            return new JwtUser(userDO.getId(), username, userDO.getPassword(), userDO.getIsActive() == 0, authorities, null);
        } else {
            return new JwtUser(0L, null, null, null, null);
        }
    }

    @Override
    public UserDO loadUserByUserId(Long userId) {
        return springSecurityDAO.loadUserByUserId(userId);
    }

    @Autowired
    public void setSpringSecurityDAO(SpringSecurityDAO springSecurityDAO) {
        this.springSecurityDAO = springSecurityDAO;
    }
}
