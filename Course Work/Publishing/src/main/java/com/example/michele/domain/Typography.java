package com.example.michele.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД typographies</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name = "typographies")
public class Typography {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String requisites;
    private String telephone_number;
    private String typography_address;
    @ManyToMany(mappedBy = "typographies")
    private Set<Production> productionSet = new HashSet<>();

    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Set<Production> getProductionSet() {
        return productionSet;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param productionSet новое значения для поля
     */
    public void setProductionSet(Set<Production> productionSet) {
        this.productionSet = productionSet;
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public Long getId() {
        return id;
    }

    /**
     * Метод необходимый для удаления отношения с Типографии с Продукцией
     * @param production Продукция
     */
    public void removeProd(Production production){
        this.productionSet.remove(production); // убираем из множества (из отношения продукцию у типографии)
        production.getTypographies().remove(this); // убираем из множества (из отношения типографию у продукции)
    }
    /**
     * <p>Геттер для получения поля</p>
     * @return поле
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param name новое значение для поля
     */
    public void setName(String name) {
        this.name = name;
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
    public String getTypography_address() {
        return typography_address;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param typography_address новое значение для поля
     */
    public void setTypography_address(String typography_address) {
        this.typography_address = typography_address;
    }
}
