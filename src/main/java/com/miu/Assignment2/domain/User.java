package com.miu.Assignment2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    long id;
    String name;
    @OneToMany
    @JoinColumn(name = "user-id")
    List<Post> posts;
}
