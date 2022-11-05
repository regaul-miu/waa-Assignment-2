package com.miu.Assignment2.service;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.User;
import com.miu.Assignment2.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getById(Long id);

    void save(User user);

    List<Post> getAllPostsByUserId(Long id);

    List<User> getUsersWithMoreThanOnePost();
}
