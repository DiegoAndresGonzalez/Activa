package com.activa.programa.controller;

import com.activa.programa.dto.RefProductRequestDTO;
import com.activa.programa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clientProduct")
    public ResponseEntity<RefProductRequestDTO> saveRefProduct(@RequestBody RefProductRequestDTO refProductRequestDTO){
        clientService.saveProduct(refProductRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(refProductRequestDTO);
    }

}