package com.activa.programa.service.mapper;

import com.activa.programa.dto.LineTypeRequestDTO;
import com.activa.programa.dto.ProductRequestDTO;
import com.activa.programa.dto.RefProductRequestDTO;
import com.activa.programa.model.LineTypeModel;
import com.activa.programa.model.MeasurementModel;
import com.activa.programa.model.ProductModel;
import com.activa.programa.model.RefProductModel;
import com.activa.programa.model.SizeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    ProductModel mapToProductDTO(ProductRequestDTO productRequestDTO);
    LineTypeModel mapToLineTypeDTO(LineTypeRequestDTO lineTypeRequestDTO);

    @Mapping(target = "dimension", source = "dimensionMedida")
    MeasurementModel mapToMeasurementDTO(RefProductRequestDTO refProductRequestDTO);
    RefProductModel mapToRefProductDTO(RefProductRequestDTO refProductRequestDTO);

    @Mapping(target = "dimension", source = "dimensionTalla")
    @Mapping(target = "observaciones", source = "observacionesTalla")
    @Mapping(target = "especificaciones", source = "especificacionesTalla")
    SizeModel mapToSizeDTO(RefProductRequestDTO refProductRequestDTO);

}