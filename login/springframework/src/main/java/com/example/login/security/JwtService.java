package com.example.login.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final String KEY = "minha-chave-super-secreta-123456789";
    private static final long TIME = 1000 * 60 * 20; // 20 min

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(KEY.getBytes());
    }

    public String createToken(UserDetails user) {
        Date now = new Date();

        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(now)
                .expiration(new Date(now.getTime() + TIME))
                .signWith(getKey())
                .compact();
    }

    public String extractUser(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validToken(String token, UserDetails user) {
        return extractUser(token).equals(user.getUsername()) && !isExpired(token);
    }

    private boolean isExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}