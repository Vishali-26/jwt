package com.example.assessment.jwt;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);

    private Key secretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    // @Value("${app.jwt-secret}")
    //private String jwtSecret;
    //@Value("${app.jwt-expiration-milliseconds}")
    //private String jwtExpirationDate;
    public String generateToken(Authentication authenticate){
        UserDetails userPrincipal = (UserDetails) authenticate
                .getPrincipal();
        return Jwts.builder().
                setSubject(userPrincipal.getUsername()).
                setIssuedAt(new Date()).
                setExpiration(new Date(s:System.currentTimeMillis()+jwtExpirationDate)).
                signWith(secretKey(), SignatureAlgorithm.HS256).
                compact();
    }
    public String getUserNameFromToken(String token){
        return Jwts.parserBuilder().
                setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(secretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            e.printStackTrace();
        }
        return false;
    }
}