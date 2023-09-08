package com.activa.programa.controller;

import com.activa.programa.dto.ClientRequestDTO;
import com.activa.programa.dto.ClientResponseDTO;
import com.activa.programa.dto.RefProductRequestDTO;
import com.activa.programa.model.ClientModel;
import com.activa.programa.service.ClientService;
import com.activa.programa.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductMapper productMapper;


    @PostMapping("/clientProduct")
    public ResponseEntity<RefProductRequestDTO> saveRefProduct(@RequestBody RefProductRequestDTO refProductRequestDTO){
        clientService.saveProduct(refProductRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(refProductRequestDTO);
    }

    @PostMapping(value = "clientData")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> saveClientData(@RequestBody ClientRequestDTO clientRequestDTO){
        ClientModel savedClient = clientService.insertClientData(clientRequestDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ClientResponseDTO clientResponseDTO = productMapper.mapToClientResponse(savedClient);
        return ResponseEntity.ok("Guardado");
    }

}