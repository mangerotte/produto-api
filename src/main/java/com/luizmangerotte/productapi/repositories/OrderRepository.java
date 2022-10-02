package com.luizmangerotte.productapi.repositories;

import com.luizmangerotte.productapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<User, Long> {
}
