package com.example.michele.repos;

import com.example.michele.domain.Typography;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы typography</p>
 * @author Кузнецов Михаил
 */
public interface TypographyRepo extends JpaRepository<Typography,Long> {
    Typography findByName(String name);
    Typography findByid(Long id);
    void deleteById(Long id);
}
