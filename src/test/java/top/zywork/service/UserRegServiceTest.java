package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zywork.enums.SocialTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegServiceTest {

    @Autowired
    private UserRegService userRegService;

    @Autowired
    private DefaultRoleQueryService defaultRoleQueryService;

    @Test
    public void testSaveUser() {
        userRegService.saveUser("wgssmart@126.com", "123456", defaultRoleQueryService.getDefaultRole(), null);
    }

    @Test
    public void testSaveUserMobile() {
        userRegService.saveUserMobile("18888888899", "123456", defaultRoleQueryService.getDefaultRole(), null);
    }

    @Test
    public void testSaveGzhUser() {
        userRegService.saveWeixinUser("openid_wechat", "123456", "access_token", "session_key",
                SocialTypeEnum.WEIXIN_XCX.getValue(), "", "nickname", "headicon", (byte) 0, defaultRoleQueryService.getDefaultRole(), null);
    }

}
