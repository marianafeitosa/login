package com.example.login.security;

import com.example.login.entity.Credential;
import com.example.login.repository.CredentialRepository;
import com.example.login.security.dto.UserAuthDetail;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    private final CredentialRepository repo;

    public UserAuthService(CredentialRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Credential user = repo.findByUsername(username);
        return new UserAuthDetail(user);
    }
}