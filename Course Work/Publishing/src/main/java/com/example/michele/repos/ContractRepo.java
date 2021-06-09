package com.example.michele.repos;

import com.example.michele.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы contract</p>
 * @author Кузнецов Михаил
 */
public interface ContractRepo extends JpaRepository<Contract, Long> {
    Contract findByid(Long id);
    List<Contract> findByClientId(Long id);
    List<Contract> findAllByProduction(Production production);
    List<Contract> findAllByAuthor(Author author);
    List<Contract> findAllByTypography(Typography typography);
    List<Contract> findAllByEmployer(Employer employer);
}
