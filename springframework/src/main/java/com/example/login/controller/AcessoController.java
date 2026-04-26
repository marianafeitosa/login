package com.example.login.controller;

import com.example.login.controller.dto.request.AcessoRequest;
import com.example.login.entity.Token;
import com.example.login.security.AuthTokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    private final AuthTokenService service;

    public AcessoController(AuthTokenService service) {
        this.service = service;
    }

    @PostMapping("/entrar")
    public Token autenticar(@RequestBody AcessoRequest dados) {
        return service.gerar(dados.getUser(), dados.getPass());
    }
}