package com.example.login.controller.dto.response;

import java.util.List;

public class AcessoResponse {

    private String codigo;
    private String user;
    private List<String> permissoes;

    public AcessoResponse() {
    }

    public AcessoResponse(String codigo, String user, List<String> permissoes) {
        this.codigo = codigo;
        this.user = user;
        this.permissoes = permissoes;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUser() {
        return user;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }
}