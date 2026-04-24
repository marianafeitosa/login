package com.example.login.repository.mongo;

import com.example.login.repository.orm.CredentialDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CredentialMongoRepository extends MongoRepository<CredentialDocument, String> {

    Optional<CredentialDocument> findByUsername(String username);
}