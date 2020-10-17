package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Введите вектор и получите длину вектора!!");
        Vector vector1 = new Vector(Scan.nextInt(),Scan.nextInt(),Scan.nextInt());
        vector1.getKoren();

        System.out.println("Введите второй вектор и получите скалярное произведение векторов!!");
        Vector vector2 = new Vector(Scan.nextInt(),Scan.nextInt(),Scan.nextInt());
        int skalar = vector1.getScalar(vector2);
        System.out.println("Ответ на скалярное произведение равен " + skalar);

        System.out.println("Векторное произведение!!!");
        Vector vector3 = vector1.getVectornoe(vector2); // создается новый вектор и инициализируется не привычным нам способом( Vector vecto3 = new Vector()), а Vector vector3 = vector1.getVectornoe(vector2), тут на самом деле записано тоже самое, что и когда мы пишем Vector vector = vector1.getVectornoe(vector2) так как return возвращает консруктор класса вектор потому что в getVectornoe выдается вывод конструктора с указанными параметрами return new Vector(vect1,vect2,vect3)
        vector3.info();

        System.out.println("Угол между 2 векторами или косинус угла!!!");
        double ugol =  vector1.getUgol(vector2);
        System.out.println("Угол между 2 векторами или косинус угла равен " + ugol);

        System.out.println("Сложение векторов!!!");
        Vector vector4 = vector1.getPlus(vector2);
        vector4.info();

        System.out.println("Вычитание векторов!!!");
        Vector vector5 = vector1.getMinus(vector2);
        vector5.info();

    }
}
