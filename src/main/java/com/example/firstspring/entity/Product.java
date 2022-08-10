package com.example.firstspring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static org.hibernate.id.SequenceGenerator.SEQUENCE;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(generator = "springniki")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq", allocationSize = 1)
    @GenericGenerator(name = "springniki", strategy = SEQUENCE, parameters =
            {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "postgresniki"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "55"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })


    @Column(name = "id")
    private Integer id;

    @Column(name ="name")
    private String name;

    @ManyToOne
    private ProductTypes type;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Double price;

}
