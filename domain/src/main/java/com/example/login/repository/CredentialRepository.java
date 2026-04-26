package com.example.login.repository;

import com.example.login.entity.Credential;
import java.util.List;

public interface CredentialRepository {
    Credential save(Credential credential);
    Credential update(Credential credential);
    void deleteById(String id);
    List<Credential> findAll();
    Credential findByUsername(String username);
}