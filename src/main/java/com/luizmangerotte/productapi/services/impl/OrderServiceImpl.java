package com.luizmangerotte.productapi.services.impl;

import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.repositories.OrderRepository;
import com.luizmangerotte.productapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order insert(Order obj) {
        return null;
    }

    @Override
    public Order update(Long id, Order obj) {
        return null;
    }

    @Override
    public void updateData(Order obj, Order objDb) {

    }

    @Override
    public void delete(Long id) {

    }
}
