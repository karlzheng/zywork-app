package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zywork.ali.AliyunSmsConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysConfigQueryServiceTest {

    @Autowired
    private SysConfigQueryService sysConfigQueryService;

    @Test
    public void testGetByName() {
        AliyunSmsConfig aliyunSmsConfig = sysConfigQueryService.getByName("aliyun_sms_config", AliyunSmsConfig.class);
        if (aliyunSmsConfig != null) {
            System.out.println("******** " + aliyunSmsConfig.getAccessKeyId() + " ********");
        }
    }

}
