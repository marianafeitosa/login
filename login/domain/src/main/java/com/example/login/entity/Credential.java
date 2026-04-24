package com.example.login.entity;

import com.example.login.entity.types.UserType;
import java.util.List;

public class Credential {

    private String id;
    private String username;
    private String password;
    private List<UserType> userTypes;

    public Credential() {}

    public Credential(String id, String username, String password, List<UserType> userTypes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userTypes = userTypes;
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<UserType> getUserTypes() { return userTypes; }
}