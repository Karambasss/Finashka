package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import com.example.blog.service.CommentService;
import com.example.blog.service.UserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/join")
    public ResponseEntity<User> join(@RequestBody JoinUser joinUser) {
        User user = new User(joinUser.getLogin(), joinUser.getEmail(), joinUser.getPassword());
        User resUser = userService.create(user);
        return new ResponseEntity<>(resUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody LoginUser loginUser) {
        Optional<User> user = userService.authorize(loginUser.getLogin(), loginUser.getPassword());
        return user
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @NoArgsConstructor
    @Data
    static class JoinUser {
        private String login;
        private String password;
        private String email;
    }

    @NoArgsConstructor
    @Data
    static class LoginUser {
        private String login;
        private String password;
    }
}
