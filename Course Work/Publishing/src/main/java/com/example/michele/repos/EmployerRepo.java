package com.example.michele.repos;

import com.example.michele.domain.Employer;
import com.example.michele.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы employer</p>
 * @author Кузнецов Михаил
 */
public interface EmployerRepo extends JpaRepository<Employer,Long> {
    Employer findByName(String name);
    void deleteById(Long id);
    Employer findByid(Long id);
    Employer findByUser(User user);
}
