package com.company;

public class Human {
    private String FIO;
    private String surname;
    private int weight;
    private int height;
    private int age;
    boolean Fav_animal;

    public Human(String name,String surname,int weight,int height,int age){
        if (name.length() > 0 && name.length() < 30) {
            this.FIO = name;
        }
        else{
            System.out.println("Слишком большое имя! ");
        }
        if (surname.length() > 0 && surname.length() < 30){
            this.surname = surname;
        }
        else{
            System.out.println("Слишком большая фамилия! ");
        }
        this.weight = weight;

        this.height = height;

        this.age = age;

    }

    public String getFio(){
        return this.FIO;
    }
    public void setFIO(String name){
        this.FIO = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    public boolean getFav_animal(int pass) {
        int password = 12345;

        if (pass == password) {
            return Fav_animal;
        }
        else {
            System.out.println("ТЫ НЕ ПРОЙДЕШЬ!");
        }
        return ;
    }
    */

    public void CatOrDog(String name){
         if (name.equals("Dog")){
             this.Fav_animal = (true);
         }
         if (name.equals("Cat")){
             this.Fav_animal = (false);
         }
        }

    public boolean getFav_animal(){
        return this.Fav_animal;
    }

    public void get_info(){
        System.out.println("Привет, я : " + this.FIO + " " + this.surname + "\n" + "Вот Моя карточка со всей информацией: " + this.age + " " + this.height + " " + this.weight);
    }
    }

