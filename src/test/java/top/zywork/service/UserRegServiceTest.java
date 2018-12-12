package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegServiceTest {

    @Autowired
    private UserRegService userRegService;

    @Test
    public void testSaveUser() {
        userRegService.saveUser("wgssmarter@126.com", new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    public void testSaveUserMobile() {
        userRegService.saveUserMobile("18888888888", new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    public void testSaveGzhUser() {
        userRegService.saveGzhUser("openid", new BCryptPasswordEncoder().encode("123456"), "wgssmarter@126.com", "headicon", (byte) 0);
    }

}
