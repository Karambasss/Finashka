package com.company;

import java.util.Scanner;

/*
       Выведите фамилии и имена учащихся в порядке убывания их среднего балла.

               Входные данные
       Заданы сначала количество учащихся n, затем n строк, каждая из которых содержит фамилию, имя и три числа (оценки по трем предметам: математике, физике, информатике). Данные в строке разделены одним пробелом. Оценки принимают значение от 1 до 5.

       Общее число учащихся не превосходит 100001.
       Выходные данные
       Необходимо вывести пары фамилия-имя по одной на строке, разделяя фамилию и имя одним пробелом. Выводить оценки не нужно. Если несколько учащихся имеют одинаковые средние баллы, то их нужно выводить в порядке, заданном во входных данных.

               Примеры
       входные данные
       2
       Markov Valeriy 1 1 1
       Ivanov Ivan 2 2 2
       выходные данные
       Ivanov Ivan
       Markov Valeriy
       входные данные
       3
       Markov Valeriy 5 5 5
       Sergey Petrov 1 1 1
       Petrov Petr 3 3 3
       выходные данные
       Markov Valeriy
       Petrov Petr
       Sergey Petrov

        */
public class Main {

    public static void main(String[] args) {

        Scanner Scan = new Scanner(System.in);

        int n = Scan.nextInt();

        Student[] students = new Student[n]; // указали количество массивов объекта

        for (int i = 0; i < n; i++){
            students[i] = new Student(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt(),Scan.nextInt()); // создаем любое кол-во пользователей ( у них есть имя фамилия и баллы)

        }
        double max = -999999;
        double sum = 0;
        for (int i = 0; i < n; i++){
            sum = students[i].getOcenka();
            if (sum > max){
                max = sum;
            }
        }
        //System.out.println(max);
        for (int i = 0; i < n; i++){
            sum = students[i].getOcenka();
            if (sum == max){
                System.out.print(students[i].name + " " + students[i].surname);
                System.out.println();
            }
        }
        double sr = 0;
        for (int i = 0; i < n; i++){
            sum = students[i].getOcenka();
            if (sum > 0 && sum < max){
                sr = sum;
            }
        }
        for(int i = 0;i < n; i++){
           sum = students[i].getOcenka();
           if (sum == sr){
               System.out.print(students[i].name + " " + students[i].surname);
               System.out.println();
               }
           }
        double min = 999;
        for (int i = 0; i < n; i++){
            sum = students[i].getOcenka();// сюда попадают все баллы именно этого струдента [i] и выыводится его ср арифметическое
            if (sum > 0 && sum < sr ){
                min = sum;
            }
        }
        for (int i = 0; i < n; i++){
            sum = students[i].getOcenka();
            if (sum == min){
                System.out.print(students[i].name + " " + students[i].surname);
                System.out.println();
            }
        }
        }

    }

