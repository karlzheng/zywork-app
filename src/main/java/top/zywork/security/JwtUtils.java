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

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    public static final String JWT_CLAIMS = "jwt_claims";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access-token.expiration}")
    private Long accessTokenExpiration;

    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    public String generateToken(String subject, Map<String, Object> claims, long expiration) {
        return Jwts.builder()
                .setId(UUID.randomUUID().toString()) // 随机uuid
                .setClaims(claims) // 用户相关信息，如authorities
                .signWith(SIGNATURE_ALGORITHM, secret) // 加密
                .compressWith(CompressionCodecs.DEFLATE) // 压缩
                .compact();
    }

    public String generateToken(String subject, Map<String, Object> claims) {
        return generateToken(subject, claims, accessTokenExpiration);
    }

    public String generateToken(JwtUser jwtUser) {
        Map<String, Object> claims = generateClaims(jwtUser);
        return generateToken(jwtUser.getUsername(), claims);
    }

    public Map<String, Object> generateClaims(JwtUser jwtUser) {
        Map<String, Object> claims = new HashMap<>();
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

    public JwtClaims getTokenJwtClaims(String token) {
        JwtClaims jwtClaims = null;
        Claims claims = getTokenClaims(token);
        if (claims != null) {
            jwtClaims = JSON.parseObject((String) claims.get(JWT_CLAIMS), JwtClaims.class);
        }
        return jwtClaims;
    }

    public JwtUser getTokenJwtUser(JwtClaims jwtClaims) {
        return new JwtUser(jwtClaims.getUserId(), jwtClaims.getUsername(), new BCryptPasswordEncoder().encode("password"), jwtClaims.getEnabled(),
                jwtClaims.getNonExpired(), true, jwtClaims.getNonLocked(), jwtClaims.getAuthorities());
    }

    public Date generateExpirationDate(long expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public Boolean isTokenExpired(JwtClaims jwtClaims) {
        Date expiration = generateExpirationDate(jwtClaims.getAccessTokenExpiration());
        return expiration.before(new Date());
    }

    public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public Boolean validateToken(JwtUser jwtUser, JwtClaims jwtClaims) {
        return jwtClaims.getUserId() == jwtUser.getUserId() && jwtClaims.getUsername().equals(jwtUser.getUsername()) && !isTokenExpired(jwtClaims);
    }

}