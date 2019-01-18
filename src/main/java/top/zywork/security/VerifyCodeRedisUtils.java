package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.zywork.common.RedisUtils;

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

    public static final String CODE_LOGIN_PREFIX = "verify_code_login::";
    public static final String CODE_REG_PREFIX = "verify_code_reg::";
    public static final String CODE_RESET_LOGIN_PWD_PREFIX = "verify_code_reset_login_pwd::";
    public static final String CODE_RESET_PAY_PWD_PREFIX = "verify_code_reset_pay_pwd::";

    @Value("${verify.code.expiration}")
    private Long verifyCodeExpiration;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储验证码
     * @param prefix
     * @param userIdentity 用于标识哪个用户
     * @param code
     */
    public void storeCode(String prefix, String userIdentity, String code) {
        RedisUtils.save(redisTemplate, prefix + userIdentity, code, verifyCodeExpiration, TimeUnit.SECONDS);
    }

    /**
     * 判断验证码是否存在
     * @param prefix
     * @param userIdentity 用于标识哪个用户
     * @return
     */
    public Boolean existsCode(String prefix, String userIdentity) {
        return RedisUtils.exists(redisTemplate, prefix + userIdentity);
    }

    /**
     * 获取验证码
     * @param prefix
     * @param userIdentity 用于标识哪个用户
     * @return
     */
    public String getCode(String prefix, String userIdentity) {
        return (String) RedisUtils.get(redisTemplate, prefix + userIdentity);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
