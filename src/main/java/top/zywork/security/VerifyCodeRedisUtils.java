package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 用于操作验证码的redis类<br/>
 *
 * 创建于2018-12-07<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class VerifyCodeRedisUtils {

    private static final String CODE_PREFIX = "verify_code::";

    @Value("${verify.code.expiration}")
    private Long verifyCodeExpiration;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储验证码
     * @param sessionId 用于标识哪个用户
     * @param code
     */
    public void storeCode(String sessionId, String code) {
        redisTemplate.opsForValue().set(CODE_PREFIX + sessionId, code, verifyCodeExpiration, TimeUnit.SECONDS);
    }

    /**
     * 判断验证码是否存在
     * @param sessionId 用于标识哪个用户
     * @return
     */
    public boolean existsCode(String sessionId) {
        return redisTemplate.hasKey(CODE_PREFIX + sessionId);
    }

    /**
     * 获取验证码
     * @param sessionId 用于标识哪个用户
     * @return
     */
    public String getCode(String sessionId) {
        return (String) redisTemplate.opsForValue().get(CODE_PREFIX + sessionId);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
