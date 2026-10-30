package com.hcld2.jwtdemo.entity;

import jakarta.persistence.*;
import jakarta.annotation.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public User(@NotBlank String username, @Nullable String encode) {
            this.username = username;
            this.password = password;
        }
    }
