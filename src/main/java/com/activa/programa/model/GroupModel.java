package com.activa.programa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "grupo")
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Integer nitGrupo;
    private String nombreGrupo;
    private String direccionGrupo;
    private Integer telefonoGrupo;
    private String correoGrupo;
    private String contactoGrupo;
    private String tipoGrupo;
    private String cargoGrupo;

}