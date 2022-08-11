package com.example.firstspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class   ProductTypeDto {

    private Integer id;
    private String name;
    private String barcode;
    private List<ProductDto> products;
    private Integer unitId;
}
