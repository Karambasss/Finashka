package com.company;

public class Employee {
    private String FIO = "Ivanov";
    private int ZPnumber;
    private int ZP;
    private String position;
    private String departament;

    public Employee(int ZPnumber, int ZP, String position, String departament) {
        
        this.ZPnumber = ZPnumber;
        this.ZP = ZP;
        this.position = position;
        this.departament = departament;
        System.out.println("Я из родителя!");
    }
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getZPnumber() {
        return ZPnumber;
    }

    public void setZPnumber(int ZPnumber) {
        this.ZPnumber = ZPnumber;
    }

    public int getZP() {
        return ZP;
    }

    public void setZP(int ZP) {
        this.ZP = ZP;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public void work(){
        System.out.println("Work hard!");
    }
    public void recieveZP(int zp){
        if (zp == this.ZP) System.out.println("Correct!");
        else System.out.println("Incorrect!");
    }
}
