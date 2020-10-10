package com.company;

import java.util.Scanner;

public class MENU {

    private int choice;

    public void menu(){
        System.out.println("Вы включили меню ");
        System.out.println("Добро пожаловать ");
        System.out.println("Мои возможности: ");
        System.out.println("Введите 1 для создания студента ");
        System.out.println("Введите 2 для создания преподавателя ");
        System.out.println("Введите 3 для создания группы студентов ");
        System.out.println("Введите 4 для создания группы преподавателей ");
    }
    public int getChoice(int choice){
        //Scanner Scan = new Scanner(System.in);
        //Scan.nextInt();
        this.choice = choice;
        return this.choice;
    }
}
