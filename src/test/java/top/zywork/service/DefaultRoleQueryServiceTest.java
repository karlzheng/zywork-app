package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultRoleQueryServiceTest {

    @Autowired
    private DefaultRoleQueryService defaultRoleQueryService;

    @Test
    public void testGetDefaultRole() {
        System.out.println("******** " + defaultRoleQueryService.getDefaultRole() + " ********");
    }
}
