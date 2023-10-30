package com.activa.programa.service;

import com.activa.programa.dto.AuthResponse;
import com.activa.programa.dto.LoginRequestDTO;
import com.activa.programa.dto.RegisterRequestDTO;
import com.activa.programa.model.RoleModel;
import com.activa.programa.model.UserModel;
import com.activa.programa.repository.UserModelRepository;
import com.activa.programa.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserModelRepository userModelRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequestDTO loginRequestDTO){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(), loginRequestDTO.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        UserModel userModel = userModelRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("El usuario no fue encontrado."));

        String jwt = jwtService.generateToken(userModel, generateExtraClaims(userModel));

        return new AuthResponse(jwt);
    }

    public AuthResponse register(RegisterRequestDTO registerRequestDTO){
        if (userModelRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()){
            throw new RuntimeException("El usuario ya existe.");
        }
        UserModel newUser = productMapper.mapToUserModel(registerRequestDTO);
        newUser.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        newUser.setRoleModel(RoleModel.USER);
        String jwt = jwtService.generateToken(newUser, generateExtraClaims(newUser));
        userModelRepository.save(newUser);

        AuthResponse response = new AuthResponse();
        response.setToken(jwt);

        return response;
    }

    public Map<String, Object> generateExtraClaims(UserModel userModel){
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("name", userModel.getUsername());
        extraClaims.put("role", userModel.getRoleModel().name());

        return extraClaims;
    }

}