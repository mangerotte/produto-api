package com.luizmangerotte.productapi.services;

import com.luizmangerotte.productapi.model.Category;
import com.luizmangerotte.productapi.model.Order;

import java.util.List;
import java.util.Optional;


public interface CategoryService {


    Optional<Category> findById(Long id);
    List<Category> findAll();
    Category insert(Category obj);
    Category update(Long id, Category obj);

    void updateData(Category obj, Category objDb);
    void delete(Long id);


}
