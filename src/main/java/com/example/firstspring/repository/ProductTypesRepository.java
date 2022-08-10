package com.example.firstspring.repository;

import com.example.firstspring.entity.ProductTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypesRepository extends JpaRepository<ProductTypes, Integer> {
}
