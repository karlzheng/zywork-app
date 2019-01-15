package top.zywork.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zywork.vo.ResponseStatusVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceTest {

    @Autowired
    private PayService payService;

    @Test
    public void testPayByBalance() {
        System.out.println(payService.payByBalance(31L, 10));
    }

}
