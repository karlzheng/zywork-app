package top.zywork.security;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * JWT工具类<br/>
 *
 * 创建于2018-09-12<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    public static final String JWT_CLAIMS = "jwt_claims";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access-token.expiration}")
    private Long accessTokenExpiration;

    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    /**
     * 生成jwt token
     * @param subject 主题
     * @param claims 用户相关信息组成的Map
     * @param expiration 过期时间
     * @return
     */
    public String generateToken(String subject, Map<String, Object> claims, long expiration) {
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(subject)
                .setClaims(claims)
                .setExpiration(generateExpirationDate(expiration))
                .signWith(SIGNATURE_ALGORITHM, secret)
                .compressWith(CompressionCodecs.DEFLATE)
                .compact();
    }

    /**
     * 生成jwt token
     * @param subject 主题
     * @param claims 用户信息组成的Map
     * @return
     */
    public String generateToken(String subject, Map<String, Object> claims) {
        return generateToken(subject, claims, accessTokenExpiration);
    }

    /**
     * 生成jwt token
     * @param jwtUser JwtUser对象
     * @return
     */
    public String generateToken(JwtUser jwtUser) {
        Map<String, Object> claims = generateClaims(jwtUser);
        return generateToken(jwtUser.getUsername(), claims);
    }

    /**
     * 通过JwtUser对象生成JwtClaims对象
     * @param jwtUser JwtUser对象
     * @return
     */
    public Map<String, Object> generateClaims(JwtUser jwtUser) {
        Map<String, Object> claims = new HashMap<>(1);
        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setUserId(jwtUser.getUserId());
        jwtClaims.setUsername(jwtUser.getUsername());
        jwtClaims.setAuthorities(jwtUser.getAuthorities());
        jwtClaims.setEnabled(true);
        jwtClaims.setCreateDate(new Date());
        jwtClaims.setNonExpired(true);
        jwtClaims.setNonLocked(true);
        jwtClaims.setAccessTokenExpiration(accessTokenExpiration);
        claims.put(JWT_CLAIMS, JSON.toJSONString(jwtClaims));
        return claims;
    }

    /**
     * 通过jwt token获取Claims对象
     * @param token jwt token
     * @return
     */
    public Claims getTokenClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            logger.error("jwt token error!");
        }
        return claims;
    }

    /**
     * 通过jwt token获取Claims对象中存储的JwtClaims
     * @param token jwt token
     * @return
     */
    public JwtClaims getTokenJwtClaims(String token) {
        JwtClaims jwtClaims = null;
        Claims claims = getTokenClaims(token);
        if (claims != null) {
            jwtClaims = JSON.parseObject((String) claims.get(JWT_CLAIMS), JwtClaims.class);
        }
        return jwtClaims;
    }

    /**
     * 从JwtClaims中获取JwtUser对象
     * @param jwtClaims JwtClaims对象
     * @return
     */
    public JwtUser getTokenJwtUser(JwtClaims jwtClaims) {
        return new JwtUser(jwtClaims.getUserId(), jwtClaims.getUsername(), new BCryptPasswordEncoder().encode("password"), jwtClaims.getEnabled(),
                jwtClaims.getNonExpired(), true, jwtClaims.getNonLocked(), jwtClaims.getAuthorities(), jwtClaims.getCreateDate());
    }

    /**
     * 计算过期时间
     * @param expiration
     * @return
     */
    public Date generateExpirationDate(long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 判断token是否过期
     * @param jwtClaims
     * @return
     */
    public Boolean isTokenExpired(JwtClaims jwtClaims) {
        Date expiration = generateExpirationDate(jwtClaims.getAccessTokenExpiration());
        return expiration.before(new Date());
    }

    /**
     * 判断是否在上一次密码修改前创建的token
     * @param created
     * @param lastPasswordReset
     * @return
     */
    public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    /**
     * 验证token是否有效
     * @param jwtUser JwtUser对象
     * @param jwtClaims JwtClaims对象
     * @return
     */
    public Boolean validateToken(JwtUser jwtUser, JwtClaims jwtClaims) {
        return jwtClaims.getUserId() == jwtUser.getUserId() && jwtClaims.getUsername().equals(jwtUser.getUsername()) && !isTokenExpired(jwtClaims);
    }

}