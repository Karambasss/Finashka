package com.example.michele.domain;

import com.example.michele.common.Person;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД employees</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name="employees")
public class Employer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Double salary;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    /**
     * Конструктор для заполнения полей
     * @param name имя
     * @param surname фамилия
     * @param age возраст
     * @param telephone_number телефонный номер
     * @param adress адресс
     * @param email почта
     * @param id айди
     * @param salary зарплата
     */
    public Employer(String name, String surname, Integer age, String telephone_number, String adress, String email, Long id, Double salary) {
        super(name, surname, age, telephone_number, adress, email);
        this.id = id;
        this.salary = salary;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public User getUser() {
        return user;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param user новое значение для поля
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Конструктор
     */
    public Employer() {

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
    public Double getSalary() {
        return salary;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param salary новое значение для поля
     * @throws NumberFormatException выброс ошибки парсинга
     */
    public void setSalary(Double salary) throws NumberFormatException {
        this.salary = salary;
    }
}
