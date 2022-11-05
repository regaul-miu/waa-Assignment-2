package com.miu.Assignment2.service;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(long id);

    void save(PostDto postDto);

    void deleteById(long id);


}
