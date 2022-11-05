package com.miu.Assignment2.controller;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.User;
import com.miu.Assignment2.domain.dto.UserDto;
import com.miu.Assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") Long id){
        return userService.getById(id);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }
    @GetMapping("{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPostsByUserId(Long id){
        return  userService.getAllPostsByUserId(id);
    }
    @GetMapping("moreThan1Post")
    public List<User> getUsersWithMoreThanOnePost(){
        return userService.getUsersWithMoreThanOnePost();
    }
}
