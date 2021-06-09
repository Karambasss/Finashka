package com.example.michele.repos;

import com.example.michele.domain.Client;
import com.example.michele.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
/**
 * <p>Данный класс позволяет находить из БД данные по любому полю из таблицы client</p>
 * @author Кузнецов Михаил
 */
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByName(String name);
    Client findByid(Long id);
    Client findByUser(User user);
}
