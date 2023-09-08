package com.activa.programa.service;

import com.activa.programa.dto.AuthResponse;
import com.activa.programa.dto.LoginRequestDTO;
import com.activa.programa.dto.RegisterRequestDTO;
import com.activa.programa.model.RoleModel;
import com.activa.programa.model.UserModel;
import com.activa.programa.repository.UserModelRepository;
import com.activa.programa.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserModelRepository userRepository;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequestDTO loginRequestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        UserDetails userDetails = userRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequestDTO registerRequestDTO){
        UserModel userModel = UserModel.builder()
                .username(registerRequestDTO.getUsername())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                        .roleModel(RoleModel.USER)
                .build();
        userRepository.save(userModel);
        return AuthResponse.builder()
                .token(jwtService.getToken(userModel))
                .build();
    }
}