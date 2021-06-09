package com.example.michele.domain;

import com.example.michele.common.Person;

import javax.persistence.*;
/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД clients</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name = "clients")
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String requisites;
    private String organization_name;
    @OneToOne
    @JoinColumn(name = "user_client_id")
    User user;
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
    public String getOrganization_name() {
        return organization_name;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param organization_name новое значение для поля
     */
    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
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
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param requisites новое значение для поля
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
}
