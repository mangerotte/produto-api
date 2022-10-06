package com.luizmangerotte.productapi.services.impl;

import com.luizmangerotte.productapi.model.Product;
import com.luizmangerotte.productapi.repositories.ProductRepository;
import com.luizmangerotte.productapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product insert(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public Product update(Long id, Product obj) {
        Product objDb = productRepository.getReferenceById(id);
        updateData(obj, objDb);
        return productRepository.save(objDb);
    }

    @Override
    public void updateData(Product obj, Product objDb) {
        objDb.setName(obj.getName());
        objDb.setDescription(obj.getDescription());
        obj.setPrice(obj.getPrice());
        obj.setImgUrl(obj.getImgUrl());
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
