package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegServiceTest {

    @Autowired
    private UserRegService userRegService;

    @Autowired
    private DefaultRoleQueryService defaultRoleQueryService;

    @Test
    public void testSaveUser() {
        userRegService.saveUser("wgssmart@126.com", "123456", defaultRoleQueryService.getDefaultRole());
    }

    @Test
    public void testSaveUserMobile() {
        userRegService.saveUserMobile("18888888899", "123456", defaultRoleQueryService.getDefaultRole());
    }

    @Test
    public void testSaveGzhUser() {
        userRegService.saveGzhUser("openid_wechat", "123456", "wgssmarter@126.com", "headicon", (byte) 0, defaultRoleQueryService.getDefaultRole());
    }

}
