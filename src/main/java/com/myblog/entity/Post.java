package com.myblog.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String content;

//    One post can have many comments
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    private List<Comment> comments;
}
