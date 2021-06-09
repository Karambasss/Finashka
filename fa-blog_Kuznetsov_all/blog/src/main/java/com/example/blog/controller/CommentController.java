package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<Comment> create(@RequestBody Comment comment) {
        final Comment resComment = commentService.create(comment);
        return new ResponseEntity<>(resComment, HttpStatus.CREATED);
    }

    @GetMapping(value = "/comments")
    public ResponseEntity<List<Comment>> read() {
        final List<Comment> comments = commentService.findAll();

        return comments != null && !comments.isEmpty()
                ? new ResponseEntity<>(comments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> read(@PathVariable(name = "id") int id) {
        final Optional<Comment> comment = commentService.findById(id);

        return comment
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/comments/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Comment comment) {
        boolean success = commentService.update(comment, id);
        return success
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/comments/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean success = commentService.delete(id);
        return success
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
