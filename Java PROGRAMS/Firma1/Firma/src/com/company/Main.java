package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Programmer programmerDima = new Programmer(10,100000,"middle","office1","C++");
        programmerDima.setFIO("Dima");
        System.out.println(programmerDima.getFIO());
        System.out.println(programmerDima.programming());
        programmerDima.recieveZP(5000);
    }
}
