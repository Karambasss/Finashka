package com.company;

public class Truba implements Instrument, Tovar{
    private int diametr;
    public Truba(int diametr){
        this.diametr = diametr;
    }

    public int getDiametr() {
        return diametr;
    }

    public void setDiametr(int diametr) {
        this.diametr = diametr;
    }
    @Override
    public void info(){
        System.out.println("Название: Труба " + "Характеристики: " +
                "Диаметр трубы: " + getDiametr());
    }

    @Override
    public void play() {
        System.out.println("Играет инструмент труба..... " + " Вау, какая красивая нота: "  + Key);
        info();
    }

    @Override
    public void buy() {
        System.out.println("Вы купили Трубу " + "Цена: " + cena + " Габарит товара: " + gabarit);

    }

    @Override
    public void test(int chislo) {
        if (chislo == 0){
            System.out.println("БРАКОВАННЫЙ ТОВАР");
        }
        else {
            System.out.println("Товар хороший");
        }

    }
    @Override
    public void INFO(){
        System.out.println("Информация о товаре! " + "Ваш товар - Труба!" +
                "Ее характеристики: " + "Габарит трубы: " + this.diametr);
    }
}
