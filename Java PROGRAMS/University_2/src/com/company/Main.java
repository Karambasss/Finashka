package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MENU menu = new MENU();

        menu.menu();

        Scanner Scan = new Scanner(System.in);

        int choice = menu.getChoice(Scan.nextInt());

        if (choice == 1){
            System.out.println("Введите параметры студента: ");
            Student student = new Student(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt());
            System.out.println("Введите количество оценок: ");
            int[] ocenki = new int[Scan.nextInt()];
            for (int i = 0; i < ocenki.length;i++){
                ocenki[i] = Scan.nextInt();
            }
            student.setOcenki(ocenki);
            System.out.println("Средний балл: " + student.getOcenka());
            System.out.println("Введите группу и курс студента: ");
            student.setGroup(Scan.next(),Scan.nextInt());
            student.info();
        }
        else if (choice == 2){
            System.out.println("Введите параметры преподавателя: ");
            Prepod prepod = new Prepod(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt(),Scan.nextInt()); // Создали препода
            System.out.println("Находим для препода количество заработной платы: ");
            prepod.setZp();
            System.out.println("Получаем Заработную плату: " + prepod.getZp());
            prepod.info();
        }
        else if (choice == 3){
            System.out.println("Введите количество студентов: ");
            Student[] students = new Student[Scan.nextInt()]; // Задали размерность массива объектов
            System.out.println("Введите параметры для каждого студента: ");
            for (int i = 0; i < students.length; i++){
                students[i] = new Student(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt()); // инициализируем каждый элемент массива, делаем из него обхект класса СТьюдент с методами и полями переданнымми в параметрах конструктора
            }
            for (int i = 0; i < students.length; i++){ // Цикл по каждому студенту
                System.out.println("Введите количество оценок у данного студента: ");
                int[] ocenki = new int[Scan.nextInt()]; // у каждого студента отдельно создается массив из оценок, который заполняется введенными из клавиатуры значениями
                for (int j = 0; j < ocenki.length; j++){
                    ocenki[j] = Scan.nextInt();
                }
                students[i].setOcenki(ocenki);
                System.out.println("Средний балл студента: " + students[i].getOcenka());
                System.out.println("Введите группу и курс студента: ");
                students[i].setGroup(Scan.next(), Scan.nextInt());
                students[i].info();
            }
        }
        else if (choice == 4){
            System.out.println("Введите количество преподавателей: ");
            Prepod[] prepods = new Prepod[Scan.nextInt()]; // Создается массив из объектов преподаватель и задается его размер
            System.out.println("Введите параметры для каждого преподавателя: ");
            for (int i = 0; i < prepods.length; i++){
                prepods[i] = new Prepod(Scan.next(),Scan.next(),Scan.nextInt(),Scan.nextInt(),Scan.nextInt()); // инициализируем каждого преподавателя, делаем его объектом класса Препод, который будет включать в себя все методы из Класса Препод и все поля будут инициализированы, потому что мы передаем параметры в констурктор
            } //prepods[i] - это уже объект класса преподаватель
            for (int i = 0; i < prepods.length; i++){ // Цикл уже по i элементам этого массива из объектов преподавателя, в каждой i элмементе уже хранятся параметры, которые инициализировали поля класса Препод, теперь мы можем спокойно вызывать методы из этого класса, так как инициализировали все требуемые поля класса Преподаватель
                System.out.println("Находим для препода количество заработной платы: ");
                prepods[i].setZp();
                System.out.println("Получаем Заработную плату: " + prepods[i].getZp());
                prepods[i].info();
            }
        }
    }
}
