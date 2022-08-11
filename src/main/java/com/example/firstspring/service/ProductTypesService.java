package com.example.firstspring.service;

import com.example.firstspring.dto.ProductTypeDto;
import com.example.firstspring.dto.ResponseDto;

import java.util.List;

public interface ProductTypesService {

    ResponseDto<String> addProduct(ProductTypeDto dto);

    abstract ResponseDto<List<ProductTypeDto>> getAll();

    ResponseDto<ProductTypeDto> getOne(Integer id);
}
