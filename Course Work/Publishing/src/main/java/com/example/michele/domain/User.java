package com.example.michele.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД users</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) // позволяем отображать элементы коллекции ( Role.class - является эл-том коллекции (соответсвие)
    @CollectionTable(name= "users_role", joinColumns = @JoinColumn(name = "users_id")) // Будет создана таблица которая будет связана с user_id (из таблицы User)
    @Enumerated(EnumType.STRING)
    private Set<Role> role_of_user;
    private String password;
    private String username;

    /**
     * <p>Конструктор для заполнения полей</p>
     * @param username логин
     * @param password пароль
     */
    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    /**
     * <p>Конструктор</p>
     */
    public User(){

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
    public Set<Role> getRole_of_user() {
        return role_of_user;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param role_of_user новое значения для поля
     */
    public void setRole_of_user(Set<Role> role_of_user) {
        this.role_of_user = role_of_user;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole_of_user();
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getPassword() {
        return password;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    @Override
    public String getUsername() {
        return username;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param password новое значение для поля
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getLogin() {
        return username;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param login новое значение для поля
     */
    public void setLogin(String login) {
        this.username = login;
    }
}
