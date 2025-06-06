package com.microservice.product.service;

import com.microservice.product.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);
    
    void save(Product product);

    List<Product> findByIdCourse(Long idCourse);

}
