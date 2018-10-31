package top.zywork.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class JwtClaims {

    private Long userId;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    private Boolean enabled;
    private Boolean nonLocked;
    private Boolean nonExpired;
    private Date createDate;
    private Long accessTokenExpiration;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(Boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public Boolean getNonExpired() {
        return nonExpired;
    }

    public void setNonExpired(Boolean nonExpired) {
        this.nonExpired = nonExpired;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getAccessTokenExpiration() {
        return accessTokenExpiration;
    }

    public void setAccessTokenExpiration(Long accessTokenExpiration) {
        this.accessTokenExpiration = accessTokenExpiration;
    }
}
