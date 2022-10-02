package com.luizmangerotte.productapi.resources;


import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.model.dto.UserDto;
import com.luizmangerotte.productapi.services.impl.OrderServiceImpl;
import com.luizmangerotte.productapi.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    private static final String ID = "/{id}";
    @Autowired
    private OrderServiceImpl orderService;
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = ID)
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

}
