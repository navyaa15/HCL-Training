package com.hcld2.jwtdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 2000)
    private String content;
    @Column(nullable = false)
    private String author;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Post(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.author = name;
    }
}
