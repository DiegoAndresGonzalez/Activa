package com.activa.programa.service;

import com.activa.programa.dto.ClientRequestDTO;
import com.activa.programa.dto.RefProductRequestDTO;
import com.activa.programa.model.*;
import com.activa.programa.repository.*;
import com.activa.programa.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ILineTypeRepository lineTypeRepository;

    @Autowired
    private IMeasurementRepository measurementRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IRefProductRepository refProductRepository;

    @Autowired
    private ISizeRepository sizeRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ClientRepository clientRepository;

    public RefProductModel saveProduct(RefProductRequestDTO refProductDTO){

        ProductModel productModel = productRepository.findByNombre(refProductDTO.getNombreProducto());
        LineTypeModel lineTypeModel = lineTypeRepository.findByNombre(refProductDTO.getNombreLinea());
        MeasurementModel measurementModel = productMapper.mapToMeasurementDTO(refProductDTO);
        SizeModel sizeModel = productMapper.mapToSizeDTO(refProductDTO);

        productRepository.save(productModel);
        lineTypeRepository.save(lineTypeModel);
        measurementRepository.save(measurementModel);
        sizeRepository.save(sizeModel);

        RefProductModel refProductModel = productMapper.mapToRefProductDTO(refProductDTO);
        refProductModel.setProductModel(productModel);
        refProductModel.setLineTypeModel(lineTypeModel);
        refProductModel.setMeasurementModel(measurementModel);
        refProductModel.setSizeModel(sizeModel);
        return refProductRepository.save(refProductModel);

    }

    public ClientModel insertClientData(ClientRequestDTO clientRequestDTO){
        ClientModel clientModel = productMapper.mapToClientModel(clientRequestDTO);
        return clientRepository.save(clientModel);
    }

}