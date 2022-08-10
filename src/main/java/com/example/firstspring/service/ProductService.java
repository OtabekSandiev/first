package com.example.firstspring.service;

import com.example.firstspring.dto.ProductDto;
import com.example.firstspring.dto.ResponseDto;

public interface ProductService {

    ResponseDto<String> addProduct(ProductDto dto);

    ResponseDto<ProductDto> findById(Integer id);
}
