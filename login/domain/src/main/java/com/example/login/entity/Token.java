package com.example.login.entity;

public class Token {

    private String accessToken;

    public Token() {}

    public Token(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}