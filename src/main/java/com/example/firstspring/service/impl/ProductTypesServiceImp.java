package com.example.firstspring.service.impl;

import com.example.firstspring.dto.ProductTypeDto;
import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.entity.ProductTypes;
import com.example.firstspring.repository.ProductTypesRepository;
import com.example.firstspring.service.ProductTypesService;
import com.example.firstspring.service.mapper.ProductTypesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductTypesServiceImp implements ProductTypesService {

    private final ProductTypesRepository repository;
    private final ProductTypesMapper mapper;

    @Override
    public ResponseDto<String> addProduct(ProductTypeDto dto) {
        try {
            repository.save(mapper.toEntity(dto));
            return ResponseDto.<String>builder().success(true).message("Muvaffaqiyatli saqlandi").build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseDto.<String>builder().success(false).message(e.getMessage()).build();
        }
    }

    @Override
    public ResponseDto<List<ProductTypeDto>> getAll() {
        List<ProductTypes> productTypes = repository.findAll();
        List<ProductTypeDto> productTypeDto = productTypes.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

        return ResponseDto.<List<ProductTypeDto>>builder().message("OK").success(true).data(productTypeDto).build();
    }

    @Override
    public ResponseDto<ProductTypeDto> getOne(Integer id) {
        Optional<ProductTypes> _productTypes = repository.findById(id);
        if (_productTypes.isEmpty()) {
            return ResponseDto.<ProductTypeDto>builder().message("NOT FOUND").data(null).success(false).build();
        }

        return ResponseDto.<ProductTypeDto>builder()
                .message("OK")
                .success(true)
                .data(_productTypes.map(mapper::toDto).get())
                .build();
    }
}
