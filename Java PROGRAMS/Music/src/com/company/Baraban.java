package com.company;

public class Baraban implements Instrument, Tovar {
    private int size;
    public Baraban(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public void info(){
        System.out.println("Название Барабан: " + "Характеристики: " +
                "Размер барабана: " + getSize() );
    }

    @Override
    public void play() {
        System.out.println("Играет инструмент барабан..... " + " Вау, какая красивая нота: "  + Key);
        info();
    }

    @Override
    public void buy() {
        System.out.println("Вы купили товар Барабан " + "Цена: " + cena + " Его габарит: " + gabarit);
    }

    @Override
    public void test(int chislo) {
        if (chislo == 0){
            System.out.println("Товар бракованный !!!!!");
        }
        else {
            System.out.println("Товар хороший");
        }
    }

    @Override
    public void INFO() {
        System.out.println("Информация о товаре: " +
        " Ваш инструмент - " + " Барабан!" + " Его размер: " + this.size);
    }
}
