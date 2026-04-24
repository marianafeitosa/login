package com.example.login.controller;

import com.example.login.controller.dto.request.AcessoRequest;
import com.example.login.controller.dto.request.AtualizarAcessoRequest;
import com.example.login.controller.dto.response.AcessoResponse;
import com.example.login.entity.Credential;
import com.example.login.entity.types.UserType;
import com.example.login.service.CredentialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CredentialService service;

    public UsuarioController(CredentialService service) {
        this.service = service;
    }

    @PostMapping
    public AcessoResponse criar(@RequestBody AcessoRequest dados) {
        List<UserType> permissoes = dados.getPermissoes()
                .stream()
                .map(UserType::valueOf)
                .collect(Collectors.toList());

        Credential user = new Credential(null, dados.getUser(), dados.getPass(), permissoes);
        Credential salvo = service.save(user);

        return new AcessoResponse(
                salvo.getId(),
                salvo.getUsername(),
                salvo.getUserTypes().stream().map(Enum::name).collect(Collectors.toList())
        );
    }

    @PutMapping
    public AcessoResponse atualizar(@RequestBody AtualizarAcessoRequest dados) {
        List<UserType> permissoes = dados.getPermissoes()
                .stream()
                .map(UserType::valueOf)
                .collect(Collectors.toList());

        Credential user = new Credential(dados.getCodigo(), dados.getUser(), dados.getPass(), permissoes);
        Credential atualizado = service.update(user);

        return new AcessoResponse(
                atualizado.getId(),
                atualizado.getUsername(),
                atualizado.getUserTypes().stream().map(Enum::name).collect(Collectors.toList())
        );
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable String id) {
        service.deleteById(id);
        return "Removido: " + id;
    }

    @GetMapping
    public String status() {
        return "API rodando";
    }
}