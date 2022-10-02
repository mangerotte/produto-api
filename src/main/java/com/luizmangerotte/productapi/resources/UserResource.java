package com.luizmangerotte.productapi.resources;


import com.luizmangerotte.productapi.model.User;
import com.luizmangerotte.productapi.model.dto.UserDto;
import com.luizmangerotte.productapi.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private static final String ID = "/{id}";
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = ID)
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDto obj){
        return new ResponseEntity<>(userService.insert(obj), HttpStatus.CREATED);
    }
    @PutMapping(value = ID)
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        return new ResponseEntity<>(userService.update(id, obj), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = ID)
    public ResponseEntity<User> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}


