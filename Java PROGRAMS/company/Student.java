package com.company;

public class Student {
    private String name;
    private String surname;
    private String familyname;
    private int Studak;
    private int age;
    private int [] marks;

    public Student(String name,String surname,String familyname, int Studak, int age){
        //делаем условия ввода для объектов одинакового типа
        if (name.length() <= 30 && name.length() != 0) {
            this.name = name;
        }
        if (surname.length() <= 25 && surname.length() != 0) {
            this.surname = surname;
        }
        if (familyname.length() <= 30 && familyname.length() != 0) {
            this.familyname = familyname;
        }
        if (Studak != 0){
            this.Studak = Studak;
        }
        if (age >= 17 && age <= 30){
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

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public int getStudak() {
        return Studak;
    }

    public void setStudak(int studak) {
        Studak = studak;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setMarks(int [] marks){
        this.marks = new int [marks.length]; // массив оценок имеет размер int[длина передаваемого массива]
        for (int i = 0; i < this.marks.length; i++) {
            this.marks[i] = marks[i];
        }
    }
    public void getMarks(){
        for (int i = 0; i < this.marks.length;i++){
            System.out.print(this.marks[i] + " ");
        }
        System.out.println();
    }
    public double getAverage(){
        int cnt = 0;
        int my_sum = 0;
        for (int i = 0; i < this.marks.length;i++){
            my_sum = my_sum + this.marks[i];
            cnt = cnt + 1;
        }
        double itog = my_sum/cnt;
        return itog;
    }
}
