package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner Scan = new Scanner(System.in);

        Human figure = new Human("Vasy", 45, "Male", 123000);

        System.out.println("Введите пароль: ");

        figure.insertPassToUse_getInformation(Scan.next());

        Employer empl = new Employer("misha", 78, "Male", "BEST", 4, 500);

        System.out.println("Введите пароль: ");

        empl.informationen(Scan.next());
    }
}
