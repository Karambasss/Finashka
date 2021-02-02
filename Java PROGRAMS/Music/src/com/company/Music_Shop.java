package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Music_Shop {
    private String name;
    private int kol_em;
    public ArrayList<Tovar> tovars;

    public Music_Shop(String name, int kol_em){
        this.name = name;
        this.kol_em = kol_em;
        tovars = new ArrayList<>();
    }
    public void add(Tovar tovar){
        tovars.add(tovar);
        System.out.println("Вы добавили товар! ");
        tovar.INFO();
    }
    public void INFO_ALL(){
        for (int i = 0; i < tovars.size(); i++){
            tovars.get(i).INFO();
        }
    }
    public void DEL_OBJ(Tovar Tovar){
        Scanner Scan = new Scanner(System.in);

        System.out.println("Вы собираетесь удалить товар!");

        System.out.println("Нажмите 1 если вы хотите удалить товар");

        System.out.println("Нажмите 2 если вы передумали удалять товар или ошиблись");

        int choice = Scan.nextInt();

        if (choice == 1){
            System.out.println("Пока товар!");

            tovars.remove(Tovar);
        }
        else{
            System.out.println("Ура вы не удалили этот товар!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKol_em() {
        return kol_em;
    }

    public void setKol_em(int kol_em) {
        this.kol_em = kol_em;
    }
}
