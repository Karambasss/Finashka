package com.example.blog.service;

import com.example.blog.entity.Tag;
import com.example.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(long id) {
        return tagRepository.findById(id);
    }

    public boolean update(Tag tag, long id) {
        if (tagRepository.existsById(id)) {
            tag.setId(id);
            tagRepository.save(tag);
            return true;
        }
        return false;
    }

    public boolean delete(long id) {
        if (tagRepository.existsById(id)) {
            tagRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
