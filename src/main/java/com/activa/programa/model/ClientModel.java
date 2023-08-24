package com.activa.programa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Integer cedulaCliente;
    private String nombreCliente;
    private String apellidoCliente;

    @ManyToOne
    @JoinColumn(name = "cod_grupo")
    private GroupModel groupModel;
    private String direccionCliente;
    private String contactoCliente;
    private Integer telefonoCliente;

}