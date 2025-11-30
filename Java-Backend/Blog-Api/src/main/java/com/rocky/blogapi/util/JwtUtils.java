package com.rocky.blogapi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "rocky.jwt")// 讀取 yml 中的 rocky.jwt 配置
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;

    /**
     * 生成 Token
     * @param userId
     * @return
     */
    public String generateToken(long userId){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime()+expire*1000);

        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 解析 Token，獲取 Claims (包含用戶信息)
     * @param token
     * @return
     */
    public Claims getClaimsByToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * Token 是否過期
     * @param expiration
     * @return
     */
    public boolean isTokenExpired(Date expiration){
        return expiration.before(new Date());
    }
}
