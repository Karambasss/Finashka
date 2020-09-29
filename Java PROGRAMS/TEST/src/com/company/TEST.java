package com.company;

public class TEST {
    private String name;
    private String surname;
    private int [] massiv;
    public TEST(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public void setMassiv(int[] massiv){
        this.massiv = new int[massiv.length]; // int[] massiv = new int[5]
        for (int i = 0; i < this.massiv.length;i++){
            this.massiv[i] = massiv[i]; // передали в поле класса массив все элементы массива который указан в параметрах метода
        }
    }
    public void output(){
        for (int i = 0; i < this.massiv.length; i++ ){
            System.out.print(this.massiv[i] + " ");
        }
        System.out.println();
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int[] getMassiv(){
        return this.massiv;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public int sumMassiv(){
        int summa = 0;
        for (int i = 0; i < this.massiv.length;i++){
            summa = summa + this.massiv[i];
        }
        return summa;
    }
}
