package com.example.firstspring.controller;


import com.example.firstspring.dto.ProductTypeDto;
import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.service.ProductTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product-type")
@RequiredArgsConstructor
public class ProductTypesController {

    private final ProductTypesService productTypesService;

    @PostMapping
    public @ResponseBody
    ResponseDto<String> add(@RequestBody ProductTypeDto productTypeDto){
        return productTypesService.addProduct(productTypeDto);
    }

    @GetMapping
    public @ResponseBody
    ResponseDto<List<ProductTypeDto>> getAll(){
        return productTypesService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseDto<ProductTypeDto> getOne(@PathVariable Integer id){
        return productTypesService.getOne(id);
    }
}
