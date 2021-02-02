package com.company;

public class Guitar implements Instrument,Tovar{
    private int num_strun;
    public Guitar(int num_strun){
        this.num_strun = num_strun;
    }

    public int getNum_strun() {
        return num_strun;
    }

    public void setNum_strun(int num_strun) {
        this.num_strun = num_strun;
    }

    @Override
    public void info(){
        System.out.println("Название: Гитара " + "Характеристики: " +
        "Количество струн: " + getNum_strun());
    }

    @Override
    public void play() {
        System.out.println("Играет инструмент гитара....... " + " Вау, какая красивая нота: "  + Key);
        info();
    }

    @Override
    public void buy() {
        System.out.println("Вы купили Гитару " + "Его цена: " + cena + " Габарит товара: " + gabarit);

    }

    @Override
    public void test(int chislo) {
        if (chislo == 0){
            System.out.println("Товар бракованный");
        }
        else {
            System.out.println("Товар хороший");
        }

    }

    @Override
    public void INFO() {
        System.out.println("Информация о товаре: " +
                "Ваш товар - Гитара! " + " Кол-во струн " + this.num_strun );
    }
}
