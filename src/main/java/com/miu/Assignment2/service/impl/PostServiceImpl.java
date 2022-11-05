package com.miu.Assignment2.service.impl;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.dto.PostDto;
import com.miu.Assignment2.repo.PostRepo;
import com.miu.Assignment2.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<PostDto> findAll() {
        return postRepo.findAll().stream()
                .map(p->modelMapper.map(p,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }


}
