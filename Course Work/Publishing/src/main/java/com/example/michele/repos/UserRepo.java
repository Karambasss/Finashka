package com.example.michele.repos;

import com.example.michele.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы user</p>
 * @author Кузнецов Михаил
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByid(Long id);
    void deleteById(Long id);
}
