package com.company;

public class Dog extends Human{
    private String type;

    public Dog(String name, String surname, int weight,int height, int age, String type){
        super(name, surname, weight, height, age);
        this.type = type;
    }
    public void info(){
        System.out.println("Моя порода: " + this.type);
    }
}
