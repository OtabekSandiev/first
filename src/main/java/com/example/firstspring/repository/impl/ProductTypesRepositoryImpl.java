package com.example.firstspring.repository.impl;

import com.example.firstspring.entity.ProductTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductTypesRepositoryImpl {

    private final EntityManager entityManager;

    public List<ProductTypes> findAll(){
        Query query = entityManager.createQuery("select p from ProductTypes p left join fetch p.products");
        return query.getResultList();
    }
}
