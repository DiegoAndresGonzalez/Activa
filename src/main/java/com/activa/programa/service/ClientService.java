package com.activa.programa.service;

import com.activa.programa.dto.RefProductRequestDTO;
import com.activa.programa.model.LineTypeModel;
import com.activa.programa.model.MeasurementModel;
import com.activa.programa.model.ProductModel;
import com.activa.programa.model.RefProductModel;
import com.activa.programa.model.SizeModel;
import com.activa.programa.repository.ILineTypeRepository;
import com.activa.programa.repository.IMeasurementRepository;
import com.activa.programa.repository.IProductRepository;
import com.activa.programa.repository.IRefProductRepository;
import com.activa.programa.repository.ISizeRepository;
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
}