package com.activa.programa.service.mapper;

import com.activa.programa.dto.*;
import com.activa.programa.model.*;
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

    ClientModel mapToClientModel(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO mapToClientResponse(ClientModel clientModel);

}