package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner Scan = new Scanner(System.in);

        Human vasy = new Human(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt(),Scan.nextInt()); // Заполнили поля объекта

        vasy.CatOrDog(Scan.next()); // Делаем выбор

        boolean choice = vasy.getFav_animal(); //Получаем любимое животное : true - собака, false - кошка

        //double weight = vasy.getWeight(); //  у нас был метод public int getWeight(){return this.weight;} он возвращал тип инт но мы изменили его на дабл
        //System.out.println(weight);

        //Примеры вызова pubic String getFio(){}
        //String name = vasy.getFio();
        //System.out.println(name);

        //System.out.println(vasy.getSurname());

        if (choice == (false)){ // Хозяин кошки
            System.out.println("Ура, ты мой хозяин, приятно познакомиться, я кот");
            System.out.println("Инфа о владельце");
            vasy.get_info();
            System.out.println( "Моя информация: ");
            Cat cat = new Cat(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt(),Scan.nextInt(), Scan.next());
            cat.get_info();
            cat.info();
        }
        else{
            System.out.println("ТЫ мой хозяин, приятно познакомиться, я собака");
            System.out.println("Инфа о владельце");
            vasy.get_info();
            System.out.println("Моя информация: ");
            Dog dog = new Dog(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt(),Scan.nextInt(), Scan.next());
            dog.get_info();
            dog.info(); // к методу с void не нужно никаких соут, так как сам по себе void ничего не возвращает, все предусматривается в самом void , там ставятся размерности, печатаеся информация
        }

    }
}
