package com.example.michele.repos;

import com.example.michele.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы author</p>
 * @author Кузнецов Михаил
 */
public interface AuthorRepo extends JpaRepository<Author,Long> {
    Author findByName(String name);
    Author findByid(Long id);
    void deleteById(Long id);
}
