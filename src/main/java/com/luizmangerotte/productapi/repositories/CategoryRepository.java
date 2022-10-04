package com.luizmangerotte.productapi.repositories;

import com.luizmangerotte.productapi.model.Category;
import com.luizmangerotte.productapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
