package com.example.firstspring.controller;


import com.example.firstspring.dto.ProductDto;
import com.example.firstspring.dto.ResponseDto;
import com.example.firstspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseDto<String> addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<ProductDto> findById(@PathVariable Integer id){
        return productService.findById(id);
    }
}
