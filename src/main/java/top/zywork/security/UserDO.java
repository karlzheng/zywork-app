package top.zywork.security;

import top.zywork.dos.BaseDO;

/**
 * UserDO数据对象实体类，用于SpringSecurity<br/>
 *
 * 创建于2018-12-07<br/>
 *
 * @author http://zywork.top 王振宇
 * @version 1.0
 */
public class UserDO extends BaseDO {

    private static final long serialVersionUID = -9223372036368593343L;

    // 用户编号
	private Long id;
	// 登录密码
	private String password;
	// 是否激活
	private Byte isActive;
	
    public UserDO() {}

    public UserDO(Long id, String password, Byte isActive) {
        this.id = id;
		this.password = password;
		this.isActive = isActive;
		
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	
    @Override
    public String toString() {
        return "UserDO {" +
                "id = " + id +
				", password = " + password +
				", isActive = " + isActive + 
				" }";
    }

}
