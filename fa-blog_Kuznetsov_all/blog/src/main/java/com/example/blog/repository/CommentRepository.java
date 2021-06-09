package com.example.blog.repository;

import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
