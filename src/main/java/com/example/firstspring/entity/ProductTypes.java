package com.example.firstspring.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "product_types")
public class ProductTypes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Product> products;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "unitId")
    private Integer unitId;



}
