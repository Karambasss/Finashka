package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        double a = Scan.nextDouble();

        double b = Scan.nextDouble();

        char znak = Scan.next().charAt(0); // next вернет строку, charAt(0) вернет 0 символ строки; то есть, если мы ввели строку 'abde' то charAt(0) выведет 0 жлемент, то есть 'a'

        Calculator Calc = new Calculator(a, b, znak);

        System.out.println(Calc.getOper());
    }
}
