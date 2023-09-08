package com.activa.programa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

    private Integer cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String contacto;
    private Integer telefono;

}