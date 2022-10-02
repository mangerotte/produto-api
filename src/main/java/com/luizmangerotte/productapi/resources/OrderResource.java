package com.luizmangerotte.productapi.resources;


import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order obj){
        return new ResponseEntity<>(orderService.insert(obj), HttpStatus.CREATED);
    }
    @PutMapping(value = ID)
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order obj){
        return new ResponseEntity<>(orderService.update(id, obj), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = ID)
    public ResponseEntity<Order> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
