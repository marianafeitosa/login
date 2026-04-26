package com.example.login.repository.orm;

import com.example.login.entity.types.UserType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "usuarios")
public class CredentialDocument {

        @Id
        private String id;
        private String username;
        private String password;
        private List<UserType> userTypes;

        public CredentialDocument() {
        }

        public CredentialDocument(String id, String username, String password, List<UserType> userTypes) {
                this.id = id;
                this.username = username;
                this.password = password;
                this.userTypes = userTypes;
        }

        public String getId() {
                return id;
        }

        public String getUsername() {
                return username;
        }

        public String getPassword() {
                return password;
        }

        public List<UserType> getUserTypes() {
                return userTypes;
        }
}