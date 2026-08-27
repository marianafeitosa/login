package com.example.login.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtSecurity {

    private static final long EXPIRATION_MILLISECONDS = 3600000;

    private final SecretKey key = Keys.hmacShaKeyFor(
            "segredo-super-secreto-com-mais-de-32-caracteres".getBytes()
    );

    public String generateToken(UserDetails user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + EXPIRATION_MILLISECONDS
                ))
                .signWith(key)
                .compact();
    }

    public long getExpirationSeconds() {
        return EXPIRATION_MILLISECONDS / 1000;
    }
}