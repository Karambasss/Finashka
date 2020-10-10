package com.company;

public class Human {
    private String name;
    private String surname;
    private int age;
    // Создаем конструктор, который заполняет все поля объекта значениями и строками
    public Human(String name, String surname, int age){
        if (name.length() <= 30 && name.length() > 0) {
            this.name = name;
        }
        if (surname.length() <= 30 && surname.length() > 0) {
            this.surname = surname;
        }
        if (age > 16) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
