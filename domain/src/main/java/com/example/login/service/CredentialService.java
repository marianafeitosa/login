package com.example.login.service;
import com.example.login.entity.Credential;
import java.util.List;

public interface CredentialService {
    Credential save(Credential credential);
    Credential update(Credential credential);
    void deleteById(String id);
    List<Credential> findAll();
}