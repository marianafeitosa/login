package com.example.login.repository;

import com.example.login.entity.Credential;
import com.example.login.repository.adapter.CredentialMapper;
import com.example.login.repository.mongo.CredentialMongoRepository;
import com.example.login.repository.orm.CredentialDocument;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CredentialRepositoryImpl implements CredentialRepository {

    private final CredentialMongoRepository mongo;

    public CredentialRepositoryImpl(CredentialMongoRepository mongo) {
        this.mongo = mongo;
    }

    @Override
    public Credential save(Credential credential) {
        CredentialDocument doc = mongo.save(CredentialMapper.toDocument(credential));
        return CredentialMapper.toEntity(doc);
    }

    @Override
    public Credential update(Credential credential) {
        CredentialDocument doc = mongo.save(CredentialMapper.toDocument(credential));
        return CredentialMapper.toEntity(doc);
    }

    @Override
    public void deleteById(String id) {
        mongo.deleteById(id);
    }

    @Override
    public Credential findByUsername(String username) {
        return mongo.findByUsername(username)
                .map(CredentialMapper::toEntity)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Override
    public List<Credential> findAll() {
        return mongo.findAll()
                .stream()
                .map(CredentialMapper::toEntity)
                .collect(Collectors.toList());
    }
}