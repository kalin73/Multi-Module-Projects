package com.example.security.service;

import com.example.security.domain.entity.UserCredential;
import com.example.security.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String saveUser(UserCredential userCredential) {
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        this.userCredentialRepository.save(userCredential);

        return "User added to the system.";
    }

    public String generateToken(String email){
        return this.jwtService.generateToken(email);
    }

    public void validateToken(String token){
        this.jwtService.validateToken(token);
    }
}
