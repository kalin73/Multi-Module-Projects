package com.example.security.service;

import com.example.security.domain.dto.CustomUserDetails;
import com.example.security.domain.entity.UserCredential;
import com.example.security.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserCredential userCredential = this.userCredentialRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid user!"));

        return new CustomUserDetails(userCredential);
    }
}
