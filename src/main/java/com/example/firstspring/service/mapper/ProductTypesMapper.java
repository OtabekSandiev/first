package com.example.firstspring.service.mapper;

import com.example.firstspring.dto.ProductTypeDto;
import com.example.firstspring.entity.ProductTypes;

@Mapper(componentModel = "spring")
public interface ProductTypesMapper {

    ProductTypes toEntity(ProductTypeDto productTypeDto);
    ProductTypeDto toDto(ProductTypes productTypes);
}
