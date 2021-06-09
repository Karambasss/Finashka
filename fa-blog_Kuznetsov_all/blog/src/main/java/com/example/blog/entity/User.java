package com.example.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    public User(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
