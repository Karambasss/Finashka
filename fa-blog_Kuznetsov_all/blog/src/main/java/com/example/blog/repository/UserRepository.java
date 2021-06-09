package com.example.blog.repository;

import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "SELECT * " +
                    "FROM t_user " +
                    "WHERE login = :login AND password = :password",
            nativeQuery=true
    )
    Optional<User> findByLoginAndPassword(
            @Param("login") String login,
            @Param("password") String password
    );
}
