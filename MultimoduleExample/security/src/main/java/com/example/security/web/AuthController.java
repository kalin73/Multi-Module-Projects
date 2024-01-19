package com.example.security.web;

import com.example.security.domain.dto.AuthRequest;
import com.example.security.domain.entity.UserCredential;
import com.example.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return this.authService.saveUser(user);
    }

    @GetMapping("/token")
    public String getToken(@RequestBody AuthRequest user) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.email(), user.password()));

        if(!authenticate.isAuthenticated()){
            throw new RuntimeException("Invalid access!");
        }

        return this.authService.generateToken(user.email());
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        this.authService.validateToken(token);

        return "Token is valid!";
    }

}
