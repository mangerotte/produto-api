package com.luizmangerotte.productapi.services;

import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.model.User;

import java.util.List;


public interface OrderService {


    Order findById(Long id);
    List<Order> findAll();
    Order insert(Order obj);
    Order update(Long id, Order obj);

    void updateData(Order obj, Order objDb);
    void delete(Long id);


}
