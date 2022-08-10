package com.example.firstspring.service.mapper;

import com.example.firstspring.dto.ProductDto;
import com.example.firstspring.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);
}
