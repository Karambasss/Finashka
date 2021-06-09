package com.example.blog.controller;

import com.example.blog.entity.Tag;
import com.example.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping(value = "/tags")
    public ResponseEntity<Tag> create(@RequestBody Tag tag) {
        final Tag resTag = tagService.create(tag);
        return new ResponseEntity<>(resTag, HttpStatus.CREATED);
    }

    @GetMapping(value = "/tags")
    public ResponseEntity<List<Tag>> read() {
        final List<Tag> tags = tagService.findAll();

        return tags != null && !tags.isEmpty()
                ? new ResponseEntity<>(tags, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tags/{id}")
    public ResponseEntity<Tag> read(@PathVariable(name = "id") int id) {
        final Optional<Tag> tag = tagService.findById(id);

        return tag
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/tags/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Tag tag) {
        boolean success = tagService.update(tag, id);
        return success
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/tags/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean success = tagService.delete(id);
        return success
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
