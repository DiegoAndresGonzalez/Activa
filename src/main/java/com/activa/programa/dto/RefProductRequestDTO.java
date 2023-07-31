package com.activa.programa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefProductRequestDTO {

    private String descripcion;
    private String nombreProducto;
    private String nombreLinea;
    private String dimensionMedida;
    private String dimensionTalla;
    private String observacionesTalla;
    private String especificacionesTalla;

}