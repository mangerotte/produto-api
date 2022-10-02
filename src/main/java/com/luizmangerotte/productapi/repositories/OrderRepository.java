package com.luizmangerotte.productapi.repositories;

import com.luizmangerotte.productapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
