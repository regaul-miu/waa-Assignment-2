package com.miu.Assignment2.service.impl;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.User;
import com.miu.Assignment2.domain.dto.UserDto;
import com.miu.Assignment2.repo.UserRepo;
import com.miu.Assignment2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public List<Post> getAllPostsByUserId(Long id) {
        return userRepo.getAllPostsByUserId(id);
    }

    @Override
    public List<User> getUsersWithMoreThanOnePost() {
        return userRepo.getUsersWithMoreThanOnePost();
    }
}
