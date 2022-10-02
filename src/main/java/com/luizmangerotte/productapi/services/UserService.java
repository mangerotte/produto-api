package com.luizmangerotte.productapi.services;

import com.luizmangerotte.productapi.model.User;
import com.luizmangerotte.productapi.model.dto.UserDto;

import java.util.List;


public interface UserService {


    UserDto findById(Long id);
    List<UserDto> findAll();
    User insert(UserDto obj);
    User update(Long id, User obj);

    void updateData(User obj, User objDb);
    void delete(Long id);


}
