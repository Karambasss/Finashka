package com.company;

public class Predmet {
    private String type; // Тип предмета
    private int hour; // скок часов
    private int kurs;  // для какого курса
    private String form_a; // форма аттестации
    private int semik; // сколько семинаров
    private int laba; // сколько лаб
    private int hometask; // Сколько домашки
    public Predmet(String type, int hour, int kurs, String form_a, int semik, int laba, int hometask){
        this.type = type;
        this.hour = hour;
        this.kurs = kurs;
        this.form_a = form_a;
        this.semik = semik;
        this.laba = laba;
        this.hometask = hometask;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public String getForm_a() {
        return form_a;
    }

    public void setForm_a(String form_a) {
        this.form_a = form_a;
    }

    public int getSemik() {
        return semik;
    }

    public void setSemik(int semik) {
        this.semik = semik;
    }

    public int getLaba() {
        return laba;
    }

    public void setLaba(int laba) {
        this.laba = laba;
    }

    public int getHometask() {
        return hometask;
    }

    public void setHometask(int hometask) {
        this.hometask = hometask;
    }

    public void out(){
        System.out.println("Тип предмета: " + this.type + "\n" + "Для какого курса : " + this.kurs + "\n" + "Форма аттестации: " + this.form_a + "\n" + "Сколько семинаров: " + this.semik + "\n" + "Сколько лабораторных: " + this.laba + "\n" + "Сколько часов: " + this.hour + "\n" + "Сколько домашки: " + this.hometask);
    }

}
