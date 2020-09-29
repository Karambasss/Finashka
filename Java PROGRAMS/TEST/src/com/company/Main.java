package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        TEST[] st_list = new TEST[Scan.nextInt()]; // TEST[] st_list = new TEST[5] в объекте массива будет выделена память на 5 элементов

        for (int i = 0; i < st_list.length;i ++){
            st_list[i] = new TEST(Scan.next(),Scan.next());
        }

        // Задаются оценки данных студентов

        for (int i = 0; i < st_list.length; i++){
            int[] massiv = new int[Scan.nextInt()]; // создаем в цикле массив с указанным количеством элементов массива ([i] элементов, когда мы делаем int[] massiv = new int[5] мы сделали так, что теперь в массиве massiv будет i = 0 i = 1 i = 2 i = 3 i = 4 элементов
            for (int j = 0; j < massiv.length;j++){
                massiv[j] = Scan.nextInt();
            }
            st_list[i].setMassiv(massiv);
            }

        int cnt = 0;
        for (int i = 0; i < st_list.length; i++ ){
            cnt+=1; // как только i ( это у нас новый студент ставновится по циклу равна 0, 1,2,3, < st_list.length, тогда мы просто прибавляем 1 к кнт
            System.out.println("Мы создали" + " " + cnt + " " + "студента!!");
            System.out.println(st_list[i].getName() + " " + st_list[i].getSurname());
            System.out.println("ОЦЕНКИ: ");
            st_list[i].output();
            System.out.println("Сумма оценок: ");
            System.out.println(st_list[i].sumMassiv());
        }
        }
    }

