package com.example.firstspring.service.impl;


import com.example.firstspring.dto.ProductDto;
import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.entity.Product;
import com.example.firstspring.repository.ProductRepository;
import com.example.firstspring.service.ProductService;
import com.example.firstspring.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
//        productMapper = Mappers.getMapper(ProductMapper.class);
        this.productMapper = productMapper;
    }

    @Override
    public ResponseDto<String> addProduct(ProductDto dto) {
        try {
            productRepository.save(productMapper.toEntity(dto));
            return ResponseDto.<String>builder().success(true).message("Muvaffaqiyatli saqlandi").build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseDto.<String>builder().success(false).message(e.getMessage()).build();
        }
    }

    @Override
    public ResponseDto<ProductDto> findById(Integer id){
        try {
            Optional<Product> productOptional = productRepository.findById(id);
            if (productOptional.isEmpty()){
                return ResponseDto.<ProductDto>builder().success(false).message("NOT FOUND").build();
            }
            Product product = productOptional.get();

            ProductDto productDto = productMapper.toDto(product);

            return ResponseDto.<ProductDto>builder().success(true).message("OK").data(productDto).build();
        }catch (Exception e){
            return ResponseDto.<ProductDto>builder().success(false).message(e.getMessage()).build();
        }
    }
}
