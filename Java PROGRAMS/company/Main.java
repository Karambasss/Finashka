package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //String a = "";
        //System.out.println(a.length());
        Scanner Scan =  new Scanner(System.in);

        Student Vasy = new Student("Вася", "Петров","Алексеевич",129213,22);
        System.out.println( Vasy.getName());
        System.out.println(Vasy.getSurname());
        System.out.println(Vasy.getFamilyname());
        System.out.println(Vasy.getStudak());
        System.out.println(Vasy.getAge());

        int [] lst = new int[Scan.nextInt()];
        for (int i = 0;i < lst.length;i++){
            lst[i] = Scan.nextInt();
        }
        Vasy.setMarks(lst);

        Vasy.getMarks();

        System.out.println(Vasy.getAverage());

    }
}
