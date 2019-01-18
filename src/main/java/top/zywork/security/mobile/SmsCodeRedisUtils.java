package top.zywork.security.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.zywork.common.RedisUtils;

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
    public static final String SMS_CODE_REG_PREFIX = "sms_code_reg::";
    public static final String SMS_CODE_RESET_LOGIN_PWD_PREFIX = "sms_code_reset_login_pwd::";
    public static final String SMS_CODE_RESET_PAY_PWD_PREFIX = "sms_code_reset_pay_pwd::";

    @Value("${verify.sms-code.expiration}")
    private Long smsCodeExpiration;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储验证码
     * @param prefix
     * @param phone
     * @param code
     */
    public void storeCode(String prefix, String phone, String code) {
        RedisUtils.save(redisTemplate, prefix + phone, code, smsCodeExpiration, TimeUnit.SECONDS);
    }

    /**
     * 判断验证码是否存在
     * @param prefix
     * @param phone
     * @return
     */
    public Boolean existsCode(String prefix, String phone) {
        return RedisUtils.exists(redisTemplate, prefix + phone);
    }

    /**
     * 获取验证码
     * @param prefix
     * @param phone
     * @return
     */
    public String getCode(String prefix, String phone) {
        return (String) RedisUtils.get(redisTemplate, prefix + phone);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
