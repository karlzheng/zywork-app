package top.zywork.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 自定义实现SpringSecurity中的UserDetails<br/>
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class JwtUser implements UserDetails {

    private Long userId;
    private String password;
    private final String username;
    private final Collection<SimpleGrantedAuthority> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private final Date tokenCreateDate;

    public JwtUser(long userId, String username, String password, Collection<SimpleGrantedAuthority> authorities, Date tokenCreateDate) {
        this(userId, username, password, true, true, true, true, authorities, tokenCreateDate);
    }

    public JwtUser(long userId, String username, String password, boolean enabled, Collection<SimpleGrantedAuthority> authorities, Date tokenCreateDate) {
        this(userId, username, password, enabled, true, true, true, authorities, tokenCreateDate);
    }

    public JwtUser(long userId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<SimpleGrantedAuthority> authorities, Date tokenCreateDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = authorities;
        this.tokenCreateDate = tokenCreateDate;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Date getTokenCreateDate() {
        return tokenCreateDate;
    }

}
