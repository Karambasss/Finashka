package com.example.michele.demo.repos;

import com.example.michele.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    void deleteById(Long id);
    User findByid(Long id);
}
