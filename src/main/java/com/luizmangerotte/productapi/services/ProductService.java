package com.luizmangerotte.productapi.services;

import com.luizmangerotte.productapi.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductService {


    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product insert(Product obj);
    Product update(Long id, Product obj);

    void updateData(Product obj, Product objDb);
    void delete(Long id);


}
