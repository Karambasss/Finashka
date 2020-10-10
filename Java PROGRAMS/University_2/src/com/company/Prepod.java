package com.company;

import java.util.Scanner;

public class Prepod extends Human{
    private int qualify;
    private double zp;
    private int stavka = 1000;
    private Predmet[] predmets; // тут нам нужен массив из оценок потому что у преподавателя может быть много предметов, которые он ведет, и чтобы нам сделать так, что у него есть несколько предметов, лежащих в массиве, то мы делаем вызов к массиву объектов, в который мы кладем размерность массива - сколько нужно выделить места для создания отдельных ячеек в массиве для предметов, то есть, у нас будет 5 предметов и для каждого из этих 5 предметов мы делаем отдельный вызов к объекту класса предмет, в следствие чего у нас будет создан массив с разменрностью предметов, и в каждом i элементе будет лежать вся информация по этому предмету
    public Prepod(String name, String surname, int age, int qualify, int kol_pr){
        super(name,surname,age);
        if (qualify > 0 && qualify <= 3) {
            this.qualify = qualify;
        }
        Scanner Scan = new Scanner(System.in);
        predmets = new Predmet[kol_pr]; // выделяем сколько будет уроков вести препод
        // иНициадизация предметов
        for (int i = 0; i < predmets.length; i++){
            System.out.println("ВВедите предметы: ");
            predmets[i] = new Predmet(Scan.next(), Scan.nextInt(),Scan.nextInt(),Scan.next(),Scan.nextInt(),Scan.nextInt(), Scan.nextInt());
        // тут будет создан в массиве под каждым индексом массива новый предмет, в этой ячейке будет лежать вся информация об этом предмете
        }
    }

    public int getQualify() {
        return qualify;
    }
    public void setQualify(int qualify) {
        this.qualify = qualify;
    }

    public int getStavka() {
        return stavka;
    }

    public void setStavka(int stavka) {
        this.stavka = stavka;
    }

    public void setZp() {
        int hours = 0;
        for (int i = 0; i < this.predmets.length; i++){ // Считаем общее количество часов за все предметы в массиве из объектов оценка
            hours += predmets[i].getHour(); // Тут получается итоговое количество часов за все предметы
        }

        if (this.qualify == 1){
            if (hours > 0 && hours <= 150){
                this.zp =  1.5 * hours * stavka;
            }
            else if (hours > 150){
                this.zp = 1.6 * hours * stavka;
            }
        }

        else if (this.qualify == 2){
            if (hours > 0 && hours <= 150){
                this.zp =  1.3 * hours * stavka;
            }
            else if (hours > 150){
                this.zp = 1.4 * hours * stavka;
            }
        }

        else if (this.qualify == 3){
            if (hours > 0 && hours <= 150){
                this.zp = 1.2 * hours * stavka;
            }
            else if (hours > 150){
                this.zp = 1.3 * hours * stavka;
            }
        }
    }
    // После того, как нашли зп, возвращаем ее
    public double getZp() {
        return zp;
    }
    public void info(){
        System.out.println("Имя преподавателя: " + getName() + "\n" + " Фамилия преподавателя: " + getSurname()
                + "\n" + " Возраст преподавателя: " + getAge() + "\n" + " Квалификация преподавателя: " + getQualify()
                + "\n" + " Ставка преподавателя: " + getStavka() + "\n" + "Зарплата преподавателя: "  + getZp());
        System.out.println("Преподаваемые предметы этого преподавателя: ");
        for (int i = 0; i < this.predmets.length;i++){
            this.predmets[i].out();
        }
    }
}
