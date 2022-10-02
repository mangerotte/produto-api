package com.luizmangerotte.productapi.services;

import com.luizmangerotte.productapi.model.Order;

import java.util.List;
import java.util.Optional;


public interface OrderService {


    Optional<Order> findById(Long id);
    List<Order> findAll();
    Order insert(Order obj);
    Order update(Long id, Order obj);

    void updateData(Order obj, Order objDb);
    void delete(Long id);


}
