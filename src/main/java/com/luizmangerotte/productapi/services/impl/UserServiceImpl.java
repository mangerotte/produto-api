package com.luizmangerotte.productapi.services.impl;


import com.luizmangerotte.productapi.error.exceptions.DatabaseException;
import com.luizmangerotte.productapi.error.exceptions.ResourceNotFoundException;
import com.luizmangerotte.productapi.model.User;
import com.luizmangerotte.productapi.model.dto.UserDto;
import com.luizmangerotte.productapi.repositories.UserRepository;
import com.luizmangerotte.productapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto findById(Long id) {
        return Optional.ofNullable(
                modelMapper.map(userRepository
                .findById(id), UserDto.class))
                .orElseThrow(()-> new ResourceNotFoundException(id));
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
        findByEmail(obj);
        return userRepository.save(modelMapper.map(obj, User.class));
    }
    @Override
    public User update(Long id, User obj) {
        try {
            User objDb = userRepository.getReferenceById(id);
            updateData(userRepository.getReferenceById(id), objDb);
            return userRepository.save(objDb);
        }catch (EntityNotFoundException enfe) {
            throw new ResourceNotFoundException(id);
        }

    }

    @Override
    public void updateData(User obj, User objDb) {
        objDb.setEmail(obj.getEmail());
        objDb.setName(obj.getName());
        objDb.setPassword(obj.getPassword());
    }
    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException erdae){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException dive){
            throw new DatabaseException(dive.getMessage());
        }
    }
    private void findByEmail(UserDto userDto){
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()){
            throw new DataIntegrityViolationException("E-mail already exists.");}
    }
}
