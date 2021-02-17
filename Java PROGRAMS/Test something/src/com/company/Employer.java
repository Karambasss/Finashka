package com.company;

import java.util.Scanner;


public class Employer extends Human{

    public static int getSalary(int stavka, int number_of_hours){
        if (stavka >= 0 && stavka <= 3){

            System.out.println("Ваша ставка " + stavka);

            if (number_of_hours >= 0 && number_of_hours <= 300){
                return (int) (1.5 * number_of_hours * stavka);
            }
            else if (number_of_hours > 300){
                return (int) (2 * number_of_hours *stavka);
            }
            else{
                return -1;
            }
        }
        else if (stavka > 3){

            System.out.println("Ваша ставка: " + stavka);

            if (number_of_hours >= 0 && number_of_hours <= 300){
                return (int) (2.5 * number_of_hours * stavka);
            }
            else if (number_of_hours > 300){
                return (int) (3.6 * number_of_hours *stavka);
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }

    String function;

    public Employer(String name, int age, String gender,String function, int stavka, int number_of_hours){
        //super(name,age,gender,stavka * number_of_hours + 10000); Первый способ - тупой!
        super(name, age, gender, getSalary(stavka,number_of_hours)); // Это уже крутая реализвация

        this.function = function;
    }


    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void informationen(String pass){
        insertPassToUse_getInformation(pass);
        System.out.println("Должность: " + this.function);
    }
}
