package com.example.login.controller.dto.request;

import java.util.List;

public class AcessoRequest {

    private String user;
    private String pass;
    private List<String> permissoes;

    public String getUser() { return user; }
    public String getPass() { return pass; }
    public List<String> getPermissoes() { return permissoes; }
}