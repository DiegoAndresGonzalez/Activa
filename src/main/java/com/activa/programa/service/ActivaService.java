package com.activa.programa.service;

import com.activa.programa.dto.LineTypeRequestDTO;
import com.activa.programa.dto.ProductRequestDTO;
import com.activa.programa.model.LineTypeModel;
import com.activa.programa.model.ProductModel;
import com.activa.programa.repository.ILineTypeRepository;
import com.activa.programa.repository.IProductRepository;
import com.activa.programa.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivaService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ILineTypeRepository lineTypeRepository;

    public ProductModel createProduct(ProductRequestDTO productRequest){

        ProductModel productModel = productMapper.mapToProductDTO(productRequest);
        return productRepository.save(productModel);

    }

    public LineTypeModel createLineType(LineTypeRequestDTO lineTypeRequest){

        LineTypeModel lineTypeModel = productMapper.mapToLineTypeDTO(lineTypeRequest);
        return lineTypeRepository.save(lineTypeModel);

    }

}