package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 用于操作jwt token的redis类<br/>
 *
 * 创建于2018-12-07<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class JwtTokenRedisUtils {

    private static final String TOKEN_PREFIX = "jwt_token::user";

    @Value("${jwt.access-token.redis-expiration}")
    private Long accessTokenExpiration;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储token
     * @param userId
     * @param token
     */
    public void storeToken(String userId, String token) {
        redisTemplate.opsForValue().set(TOKEN_PREFIX + userId, token, accessTokenExpiration, TimeUnit.SECONDS);
    }

    /**
     * 判断token是否存在
     * @param userId
     * @return
     */
    public Boolean existsToken(String userId) {
        return redisTemplate.hasKey(TOKEN_PREFIX + userId);
    }

    /**
     * 获取token
     * @param userId
     * @return
     */
    public String getToken(String userId) {
        return (String) redisTemplate.opsForValue().get(TOKEN_PREFIX + userId);
    }

    /**
     * 重置token失效时间
     * @param userId
     */
    public void refreshTokenExpiration(String userId) {
        redisTemplate.expire(TOKEN_PREFIX + userId, accessTokenExpiration, TimeUnit.SECONDS);
    }

    /**
     * 移除token
     * @param userId
     */
    public void removeToken(String userId) {
        redisTemplate.delete(TOKEN_PREFIX + userId);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
