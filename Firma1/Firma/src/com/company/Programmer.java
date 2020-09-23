package com.company;

public class Programmer extends Employee  {

    public String language;

    public Programmer(int ZPnumber, int ZP, String position, String departament,String language) {
        super(ZPnumber, ZP, position, departament);

        this.language = language;
        System.out.println("OK!");

    }
    public void programming(){

    }


}
