package com.luizmangerotte.productapi.resources;


import com.luizmangerotte.productapi.model.Product;
import com.luizmangerotte.productapi.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private static final String ID = "/{id}";
    @Autowired
    private ProductServiceImpl productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = ID)
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product obj){
        return new ResponseEntity<>(productService.insert(obj), HttpStatus.CREATED);
    }
    @PutMapping(value = ID)
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj){
        return new ResponseEntity<>(productService.update(id, obj), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = ID)
    public ResponseEntity<Product> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
