package com.example.michele.domain;

import com.example.michele.common.Person;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД authors</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name = "authors")
public class Author extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author_requisites;

    /**
     * <p>Конструктор автора</p>
     */
    public Author() {

    }

    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Long getId() {
        return id;
    }

    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getAuthor_requisites() {
        return author_requisites;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param author_requisites новое значение для поля
     */
    public void setAuthor_requisites(String author_requisites) {
        this.author_requisites = author_requisites;
    }
}
