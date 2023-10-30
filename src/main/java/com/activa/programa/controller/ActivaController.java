package com.activa.programa.controller;

import com.activa.programa.dto.LineTypeRequestDTO;
import com.activa.programa.dto.ProductRequestDTO;
import com.activa.programa.service.ActivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivaController {

    @Autowired
    private ActivaService activaService;

    @PostMapping("/product")
    public ResponseEntity<ProductRequestDTO> saveProduct(@RequestBody ProductRequestDTO productRequestDTO){
        activaService.createProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRequestDTO);
    }

    @PostMapping("/line")
    public ResponseEntity<LineTypeRequestDTO> saveLineType(@RequestBody LineTypeRequestDTO lineTypeRequestDTO){
        activaService.createLineType(lineTypeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(lineTypeRequestDTO);
    }

}
