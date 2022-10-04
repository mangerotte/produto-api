package com.luizmangerotte.productapi.services.impl;

import com.luizmangerotte.productapi.model.Category;
import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.repositories.CategoryRepository;
import com.luizmangerotte.productapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category insert(Category obj) {
        return categoryRepository.save(obj);
    }

    @Override
    public Category update(Long id, Category obj) {
        Category objDb = categoryRepository.getReferenceById(id);
        updateData(obj, objDb);
        return categoryRepository.save(objDb);
    }

    @Override
    public void updateData(Category obj, Category objDb) {
        objDb.setName(obj.getName());
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
