package top.zywork.security;

/**
 * 用户角色与权限url，用于SpringSecurity<br/>
 *
 * 创建于2018-12-07<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
public class RolePermissionDO {

    private String role;
    private String permission;

    public RolePermissionDO() {}

    public RolePermissionDO(String role, String permission) {
        this.role = role;
        this.permission = permission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
