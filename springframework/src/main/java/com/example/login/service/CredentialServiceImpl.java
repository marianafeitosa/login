package com.example.login.service;

import com.example.login.entity.Credential;
import com.example.login.repository.CredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository repo;
    private final PasswordEncoder encoder;

    public CredentialServiceImpl(CredentialRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public Credential save(Credential credential) {
        String senha = encoder.encode(credential.getPassword());

        Credential novo = new Credential(
                credential.getId(),
                credential.getUsername(),
                senha,
                credential.getUserTypes()
        );

        return repo.save(novo);
    }

    @Override
    public Credential update(Credential credential) {
        String senha = encoder.encode(credential.getPassword());

        Credential atualizado = new Credential(
                credential.getId(),
                credential.getUsername(),
                senha,
                credential.getUserTypes()
        );

        return repo.update(atualizado);
    }
    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
    @Override
    public List<Credential> findAll() {
        return repo.findAll();
    }
}