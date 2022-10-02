package com.luizmangerotte.productapi.services.impl;


import com.luizmangerotte.productapi.model.User;
import com.luizmangerotte.productapi.model.dto.UserDto;
import com.luizmangerotte.productapi.repositories.UserRepository;
import com.luizmangerotte.productapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto findById(Long id) {
        return modelMapper.map(userRepository
                .findById(id), UserDto.class);
    }
    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user-> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public User insert(UserDto obj) {
        return null;
    }

    @Override
    public User update(Long id, User obj) {
        return null;
    }

    @Override
    public void updateData(User obj, User objDb) {

    }

    @Override
    public void delete(Long id) {

    }
}
