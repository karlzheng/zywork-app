package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 用于操作短信验证码的redis类<br/>
 *
 * 创建于2018-12-07<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class SmsCodeRedisUtils {

    public static final String SMS_CODE_LOGIN_PREFIX = "sms_code_login::";

    @Value("${verify.sms-code.expiration}")
    private Long smsCodeExpiration;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储验证码
     * @param phone
     * @param code
     */
    public void storeCode(String prefix, String phone, String code) {
        redisTemplate.opsForValue().set(prefix + phone, code, smsCodeExpiration, TimeUnit.SECONDS);
    }

    /**
     * 判断验证码是否存在
     * @param phone
     * @return
     */
    public boolean existsCode(String prefix, String phone) {
        return redisTemplate.hasKey(prefix + phone);
    }

    /**
     * 获取验证码
     * @param phone
     * @return
     */
    public String getCode(String prefix, String phone) {
        return (String) redisTemplate.opsForValue().get(prefix + phone);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
