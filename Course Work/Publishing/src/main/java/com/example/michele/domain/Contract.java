package com.example.michele.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Set;
/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД contracts</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_of_agreement;
    private Integer price;
    private Integer value;
    private String client_requisites;
    private String publisher_requisites;
    private String author_requisites;
    private String status = "Не обработан";
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employer employer;
    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;
    @ManyToOne
    @JoinColumn(name = "production_id")
    Production production;
    @ManyToOne
    @JoinColumn(name = "author_ids")
    Author author;
    @ManyToOne
    @JoinColumn(name = "typography_id")
    Typography typography;
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
    public Date getDate_of_agreement() {
        return date_of_agreement;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param date_of_agreement новое значение для поля
     */
    public void setDate_of_agreement(Date date_of_agreement) {
        this.date_of_agreement = date_of_agreement;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param price новое значение для поля
     * @throws NumberFormatException выброс ошибки парсинга
     */
    public void setPrice(Integer price) throws NumberFormatException {
        this.price = price;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Integer getValue() {
        return value;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param value новое значение для поля
     * @throws NumberFormatException выброс ошибки парсинга
     */
    public void setValue(Integer value) throws NumberFormatException {
        this.value = value;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getClient_requisites() {
        return client_requisites;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param client_requisites новое значение для поля
     */
    public void setClient_requisites(String client_requisites) {
        this.client_requisites = client_requisites;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getPublisher_requisites() {
        return publisher_requisites;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param publisher_requisites новое значение для поля
     */
    public void setPublisher_requisites(String publisher_requisites) {
        this.publisher_requisites = publisher_requisites;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Employer getEmployer() {
        return employer;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param employer новое значение для поля
     */
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Client getClient() {
        return client;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param client новое значение для поля
     */
    public void setClient(Client client) {
        this.client = client;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Production getProduction() {
        return production;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param production новое значение для поля
     */
    public void setProduction(Production production) {
        this.production = production;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param author новое значение для поля
     */
    public void setAuthor(Author author) {
        this.author = author;
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
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getStatus() {
        return status;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param status новое значение для поля
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Typography getTypography() {
        return typography;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param typography новое значение для поля
     */
    public void setTypography(Typography typography) {
        this.typography = typography;
    }
}
