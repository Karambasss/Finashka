package com.company;

public class Cat extends Human {
    private String type;

    public Cat(String name, String surname, int weight,int height, int age, String type){
        super(name,surname,weight,height,age);
        this.type = type;
    }
    //public Cat(String name, String surname, int weight,int height, int age, String type)
    /*
    public void LikeOrNot(){
        boolean choice = getFav_animal(); //getFav_animal();
        if (choice == (false)){
            System.out.println("Ура, ты мой хозяин!");
            get_info();
            System.out.print("Моя порода: " + this.type);
            //System.out.println("Моя информация!");
            //System.out.println();
        }

        else{
            System.out.println("УПС, возникла проблема, пользователь не любит кошек!!!");
        }
    }

     */
    public void info(){
        System.out.println("Моя порода: " + this.type);
    }
}
