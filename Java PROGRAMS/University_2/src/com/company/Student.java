package com.company;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class Student extends Human{
    private int studak;
    private int[] ocenki;
    private Group my_group; // Поле класса GROUP в котором у нас лежат свои для него методы, которые могт вызываться в нашем классе студент
    public Student(String name, String surname, int age, int studak){ //  Суть конструктора в том, чтобы инициализировать поля класса
        super(name,surname,age); // Вызов отцовского конструктора, Обязательная последовательность.
        if (studak > 0) {
            this.studak = studak;
        }
    }
    Scanner Scan = new Scanner(System.in);

    public int getStudak() {
        return studak;
    }

    public void setStudak(int studak) {
        this.studak = studak;
    }

    public void setOcenki(int[] ocenki1){ //
        this.ocenki = new int[ocenki1.length]; // Массив оценок создается с указанной размерностью, то есть получает на вход другой массив и задает исходному полю в котором лежит массив размер
        for (int i = 0; i < this.ocenki.length; i++){ // тут идет цикл по размеру массива нашего поля в этом массиве создана размерность , сколько элементов оно может хранить
            this.ocenki[i] = ocenki1[i];// и каждый [i] элемент будет равен [i] из передаваемого массива
        }

    }
    public double getOcenka(){
        int sum = 0;
        for (int i = 0; i < this.ocenki.length;i++){
            sum = sum + this.ocenki[i];
        }
        double sr = (double) sum / this.ocenki.length; // Если оба операнда целочисленные, выполняется целочисленное деление, если хотя бы один дробный, выполняется дробное деление
        return sr;
    }
    public void setGroup(String group, int curs){
        // здесь делаем вызов к группе,
        my_group = new Group(group,curs); // КОгда мы делаем поле класса оно создается внутри класса ГРУП и обращается к его методам и полям
    }

    public Group getMy_group() {
        return my_group;
    }

    public void info(){
        System.out.println("Имя студента: " + getName() + "\n" + " Фамилия студента: " + getSurname()
                + "\n" + " Возраст: " + getAge() + "\n" + " Номер студенческого билета: " + getStudak()
                + "\n" + "БАЛЛЫ: "  + getOcenka());
        my_group.info();
    }
}
