package com.luizmangerotte.productapi.services.impl;

import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.model.User;
import com.luizmangerotte.productapi.repositories.OrderRepository;
import com.luizmangerotte.productapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order insert(Order obj) {
        return orderRepository.save(obj);
    }

    @Override
    public Order update(Long id, Order obj) {
        Order objDb = orderRepository.getReferenceById(id);
        updateData(obj, objDb);
        return orderRepository.save(objDb);
    }

    @Override
    public void updateData(Order obj, Order objDb) {
        objDb.setClient(obj.getClient());
        objDb.setInstant(obj.getInstant());
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
