package com.example.michele.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * <p>Данный класс позволяет отобразить и работать с отдельной таблицей в БД productions</p>
 * @author Кузнецов Михаил
 */
@Entity
@Table(name = "productions")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "product_typ",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "typ_id")
    )
    private Set<Typography> typographies = new HashSet<>();

    /**
     * Метод для удаления отношения Продукции с Типографией
     * @param typography типографи
     */
    public void removeTyp(Typography typography){
        this.typographies.remove(typography);
        typography.getProductionSet().remove(this);
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
    public String getDescription() {
        return description;
    }

    /**
     * <p>Сеттер для установления нового значения для поля</p>
     * @param description новое значение для поля
     */
    public void setDescription(String description) {
        this.description = description;
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
    public Set<Typography> getTypographies() {
        return typographies;
    }
}
