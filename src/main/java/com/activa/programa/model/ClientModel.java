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
<<<<<<< HEAD
@Entity()
@Table(name = "cliente")
=======
@Entity(name = "cliente")
>>>>>>> 12680f085440c1896ffdef6938a71ce36b22a093
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
<<<<<<< HEAD
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String contacto;
    private Integer telefono;
=======
    private Integer cedulaCliente;
    private String nombreCliente;
    private String apellidoCliente;

    @ManyToOne
    @JoinColumn(name = "cod_grupo")
    private GroupModel groupModel;
    private String direccionCliente;
    private String contactoCliente;
    private Integer telefonoCliente;
>>>>>>> 12680f085440c1896ffdef6938a71ce36b22a093

}