package com.example.login.security;

import com.example.login.entity.Token;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    private final AuthenticationManager authenticationManager;
    private final JwtSecurity jwtSecurity;
    private final UserDetailsService userDetailsService;

    public AuthTokenService(AuthenticationManager authenticationManager,
                            JwtSecurity jwtSecurity,
                            UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtSecurity = jwtSecurity;
        this.userDetailsService = userDetailsService;
    }

    public Token gerar(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails user = userDetailsService.loadUserByUsername(username);
        String token = jwtSecurity.generateToken(user);

        return new Token(token);
    }
}