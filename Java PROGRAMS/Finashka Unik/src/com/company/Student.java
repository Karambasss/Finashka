package com.company;

import java.util.Scanner;

class Student{
    String name;
    String surname;
    int grade1;
    int grade2;
    int grade3;

    public Student(String name, String surname,int grade1,int grade2,int grade3){
        this.name = name;
        this.surname = surname;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public double getOcenka(){
        double sum = this.grade1 + this.grade2 + this.grade3;
        double itog = (sum/3);
        return itog;
        }

    }

