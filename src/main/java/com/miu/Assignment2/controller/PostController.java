package com.miu.Assignment2.controller;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.dto.PostDto;
import com.miu.Assignment2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/")
public class PostController {
    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public PostDto getById(@PathVariable("id") long id){
        return postService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto postDto){
        postService.save(postDto);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id){
        postService.deleteById(id);
    }


}
