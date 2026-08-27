package com.example.login.controller;

import com.example.login.controller.dto.request.AcessoRequest;
import com.example.login.entity.Token;
import com.example.login.security.AuthTokenService;
import com.example.login.security.JwtSecurity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    private static final String ACCESS_TOKEN_COOKIE = "ACCESS_TOKEN_COOKIE";

    private final AuthTokenService service;
    private final JwtSecurity jwtSecurity;

    public AcessoController(AuthTokenService service,
                            JwtSecurity jwtSecurity) {
        this.service = service;
        this.jwtSecurity = jwtSecurity;
    }

    @PostMapping("/entrar")
    public ResponseEntity<Void> autenticar(
            @RequestBody AcessoRequest dados) {

        Token token = service.gerar(
                dados.getUser(),
                dados.getPass()
        );

        ResponseCookie cookie = ResponseCookie.from(
                        ACCESS_TOKEN_COOKIE,
                        token.getAccessToken()
                )
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(jwtSecurity.getExpirationSeconds())
                .build();

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.SET_COOKIE,
                        cookie.toString()
                )
                .build();
    }
}