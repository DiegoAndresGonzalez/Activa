package com.activa.programa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ref_producto")
public class RefProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cod_producto")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "cod_linea")
    private LineTypeModel lineTypeModel;

    @ManyToOne
    @JoinColumn(name = "cod_medida")
    private MeasurementModel measurementModel;

    @ManyToOne
    @JoinColumn(name = "cod_talla")
    private SizeModel sizeModel;

}