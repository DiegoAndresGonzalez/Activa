package com.activa.programa.controller;

import com.activa.programa.dto.AuthResponse;
import com.activa.programa.dto.LoginRequestDTO;
import com.activa.programa.dto.RegisterRequestDTO;
import com.activa.programa.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        AuthResponse authResponse = authService.login(loginRequestDTO);
        return ResponseEntity.ok(authResponse);
    }

    @PreAuthorize("permitAll")
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO){
        AuthResponse authResponse = authService.register(registerRequestDTO);
        return ResponseEntity.ok(authResponse);
    }



}