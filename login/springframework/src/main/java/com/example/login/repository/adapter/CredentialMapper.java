package com.example.login.repository.adapter;

import com.example.login.entity.Credential;
import com.example.login.repository.orm.CredentialDocument;

public class CredentialMapper {

    public static CredentialDocument toDocument(Credential entity) {
        return new CredentialDocument(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getUserTypes()
        );
    }

    public static Credential toEntity(CredentialDocument doc) {
        return new Credential(
                doc.getId(),
                doc.getUsername(),
                doc.getPassword(),
                doc.getUserTypes()
        );
    }
}