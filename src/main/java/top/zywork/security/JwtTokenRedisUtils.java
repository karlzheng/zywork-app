package top.zywork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.zywork.common.DateFormatUtils;
import top.zywork.common.RedisUtils;
import top.zywork.enums.DatePatternEnum;

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

    private static final String DAY_ACCESS_USER_COUNT = "jwt_token::dau";

    @Value("${jwt.access-token.redis-expiration}")
    private Long accessTokenExpiration;

    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储token
     * @param userId
     * @param jwtToken
     */
    public void storeToken(String userId, JwtToken jwtToken) {
        RedisUtils.save(redisTemplate, TOKEN_PREFIX + userId, jwtToken, accessTokenExpiration, TimeUnit.SECONDS);
    }

    /**
     * 判断token是否存在
     * @param userId
     * @return
     */
    public Boolean existsToken(String userId) {
        return RedisUtils.exists(redisTemplate, TOKEN_PREFIX + userId);
    }

    /**
     * 获取token
     * @param userId
     * @return
     */
    public JwtToken getToken(String userId) {
        Object obj = RedisUtils.get(redisTemplate, TOKEN_PREFIX + userId);
        return obj == null ? null : (JwtToken) obj;
    }

    /**
     * 重置token失效时间
     * @param userId
     */
    public void refreshTokenExpiration(String userId) {
        RedisUtils.refreshExpiration(redisTemplate, TOKEN_PREFIX + userId, accessTokenExpiration, TimeUnit.SECONDS);

    }

    /**
     * 移除token
     * @param userId
     */
    public void removeToken(String userId) {
        RedisUtils.delete(redisTemplate, TOKEN_PREFIX + userId);
    }

    /**
     * 登录时统计活跃用户<br/>
     * 此种方法的问题在于：<br/>
     * 1、如果用户不断的登录，退出，再登录，则同一个用户每一次的登录都会被视为活跃用户<br/>
     */
    public void countDau() {
        redisTemplate.opsForValue().increment(DAY_ACCESS_USER_COUNT);
    }

    /**
     * 已经登录后，使用jwt token统计日活跃用户<br/>
     * 统计逻辑为：如果用户登录，则设置jwt token的lastUseDate为"login"，
     * 在此方法中判断jwt token最后使用日期，如果与今日日期不一致，则表示为活跃用户，活跃用户加1后，需要更新缓存中的jwt token的最后使用日期为今日日期<br/>
     * 如果用户使用jwt token再次登录，在同一天的话，缓存中的lastUseDate与今日日期是一致的，所以不更新活跃用户<br/>
     * 如果不在同一天，如昨天登录的jwt token，今天来使用，那么lastUseDate与今日日期不一致，所以为活跃用户<br/>
     * 此种方法的问题在于：<br/>
     * 1、如果用户从多个不同的端登录并使用jwt token，同一个用户会被视为多个活跃用户<br/>
     * @param jwtTokenKey
     * @param jwtTokenInRedis
     */
    public void countDau(String jwtTokenKey, JwtToken jwtTokenInRedis) {
        String today = DateFormatUtils.format(System.currentTimeMillis(), DatePatternEnum.DATE.getValue());
        if (!jwtTokenInRedis.getLastUseData().equals(today)) {
            redisTemplate.opsForValue().increment(DAY_ACCESS_USER_COUNT);
            // 设置最后访问时间为今天
            jwtTokenInRedis.setLastUseData(today);
            storeToken(jwtTokenKey, jwtTokenInRedis);
        }
    }

    /**
     * 删除DAU缓存数据
     */
    public void removeDau() {
        RedisUtils.delete(redisTemplate, DAY_ACCESS_USER_COUNT);
    }

    /**
     * 获取日活用户
     * @return
     */
    public int getDau() {
        Object count = RedisUtils.get(redisTemplate, DAY_ACCESS_USER_COUNT);
        return count == null ? 0 : (Integer) count;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
