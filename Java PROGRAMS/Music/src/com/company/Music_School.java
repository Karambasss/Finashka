package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Music_School {
    private String name;
    private int kol_st;
    public ArrayList<Instrument> instruments;  // коллекция принимающая тип объектов Интерфейс и все другие объекты которые реализуют интерфейс( все связанные с интерфейсом объекты)
    public Music_School(String name, int kol_st){
        this.name = name;
        this.kol_st = kol_st;
        instruments = new ArrayList<>();
    }
    public void add(Instrument instrument){
        instruments.add(instrument);
        System.out.println("Добавлен инструмент!");
        instrument.info();
    }
    public void itog(){
        for (int i = 0; i < instruments.size(); i++){
            instruments.get(i).info();
        }
    }

    public void delInstrument(Instrument instrument){

        System.out.println("ВЫ СОБИРАЕТЕСЬ УДАЛИТЬ ТОВАР! ");

        instrument.info();

        System.out.println("Нажмите 1, если вы точно уверены удалить этот инструмент! ");

        System.out.println("Нажмите 2, если вы передумали или ошиблись ");

        Scanner Scan = new Scanner(System.in);

        int a = Scan.nextInt();

        if (a == 1){
            instruments.remove(instrument);
        }

        else {
            System.out.println("Фух, слава богу вы не удалили этот инструмент! ");
        }
    }

}
