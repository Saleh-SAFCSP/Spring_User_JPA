package com.example.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor @Data @NoArgsConstructor
@Entity
public class MyUser {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String role;
    @Column(unique = true,nullable = false)
    private String email;
}
