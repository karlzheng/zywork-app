package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class JwtTokenRedisUtils {

    private static final String TOKEN_PREFIX = "jwt_token::";

    @Value("${jwt.access-token.redis-expiration}")
    private Long accessTokenExpiration;

    private RedisTemplate<String, String> redisTemplate;

    public void storeToken(String userId, String token) {
        redisTemplate.opsForValue().set(TOKEN_PREFIX + userId, token, accessTokenExpiration, TimeUnit.SECONDS);
    }

    public boolean existsToken(String userId) {
        return redisTemplate.hasKey(TOKEN_PREFIX + userId);
    }

    public String getToken(String userId) {
        return redisTemplate.opsForValue().get(TOKEN_PREFIX + userId);
    }

    public void refreshTokenExpiration(String userId) {
        redisTemplate.expire(TOKEN_PREFIX + userId, accessTokenExpiration, TimeUnit.SECONDS);
    }

    public void removeToken(String userId) {
        redisTemplate.delete(TOKEN_PREFIX + userId);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
