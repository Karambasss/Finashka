package com.example.michele.common;

import com.sun.istack.Nullable;

import javax.persistence.MappedSuperclass;
/**
 *<p>Данный класс необходим для того, чтобы уменьшить избыточность кода.</p>
 *<p>Все те классы, которые наследуются от Person, а именно: Author, Client, Employer имеют одинаковые поля: имя, фамилия, возраст, телефонный номер, почта и адрес.</p>
 *<p>Для того, чтобы не писать в каждом классе те же самые поля, было принято решение создать данный класс.</p>
 * @author Михаил Кузнецов
 *
 * */

@MappedSuperclass // при наследовании от Person его поля попадут в бд (PERSON не является Entity(то есть, не будет являться таблицей))
public abstract class Person {
    private String name;
    private String surname;
    @Nullable
    private Integer age;
    private String telephone_number;
    private String adress;
    private String email;

    /**
     * <p>Конструктор для заполнения полей класса Person</p>
     * @param name имя
     * @param surname фамилия
     * @param age возраст
     * @param telephone_number телефонный номер
     * @param adress адресс
     * @param email почта
     */
    public Person(String name, String surname, Integer age, String telephone_number, String adress, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.telephone_number = telephone_number;
        this.adress = adress;
        this.email = email;
    }
    public Person(){

    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     * */
    public String getName() {
        return name;
    }
    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param name новое значение для поля
     *
     * */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getSurname() {
        return surname;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param surname новое значение для поля
     *
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Integer getAge() {
        return age;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param age новое значение для поля
     * @throws NumberFormatException ошибка парсинга
     */
    public void setAge(Integer age) throws NumberFormatException {
        this.age = age;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getTelephone_number() {
        return telephone_number;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param telephone_number новое значение для поля
     */
    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getAdress() {
        return adress;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param adress новое значение для поля
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param email новое значение для поля
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
