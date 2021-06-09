package com.example.michele.repos;

import com.example.michele.domain.Production;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы production</p>
 * @author Кузнецов Михаил
 */
public interface ProductionRepo extends JpaRepository<Production, Long> {
    Production findByName(String name);
    Production findByid(Long id);
    void deleteById(Long id);
}
