package com.miu.Assignment2.repo;

import com.miu.Assignment2.domain.Post;
import com.miu.Assignment2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.posts from User u WHERE u.id = :id")
    public List<Post> getAllPostsByUserId(Long id);

    @Query(value="select u FROM User u WHERE size(u.posts)>1")
    public List<User> getUsersWithMoreThanOnePost();
}
