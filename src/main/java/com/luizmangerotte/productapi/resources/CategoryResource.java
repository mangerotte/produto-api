package com.luizmangerotte.productapi.resources;


import com.luizmangerotte.productapi.model.Category;
import com.luizmangerotte.productapi.model.Order;
import com.luizmangerotte.productapi.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private static final String ID = "/{id}";
    @Autowired
    private CategoryServiceImpl categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = ID)
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category obj){
        return new ResponseEntity<>(categoryService.insert(obj), HttpStatus.CREATED);
    }
    @PutMapping(value = ID)
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category obj){
        return new ResponseEntity<>(categoryService.update(id, obj), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = ID)
    public ResponseEntity<Category> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
