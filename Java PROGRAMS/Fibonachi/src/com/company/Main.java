package com.company;

import java.util.Scanner;

public class Main {


    public static int Fibbo(int n){

        if (n == 1){
            return 1;
        }

        if (n == 2){
            return 1;
        }

        return Fibbo(n - 1) + Fibbo(n - 2);

    }

    public static int Fact(int n){
        if (n > 15){
            System.out.println("НЕЛЬЗЯ ТАКОЕ БОЛЬШОЕ ЧИСЛО ДАВАТЬ");
            return -1;
        }
        if (n == 0){
            return 1;
        }
        int fact_Prem = Fact(n-1);

        int itog = n * fact_Prem;

        return itog;
    }

    public static int Fact_1(int n){
        int factorial = 1;

        if (n == 0){
            factorial = 1;
            return factorial;
        }

        for (int i = 1; i < n + 1; i++){
            factorial = factorial * i;
        }

        return factorial;
    }

    public static int Stepen(int chislo, int stepen){
        int itog = 1;

        if (chislo == 0 && stepen == 0){
            System.out.println("НЕОПРЕДЕЛЕННОСТЬ!" + " ОШИБКА 404");
            return -1;
        }

        if (stepen == 0){
            return itog;
        }

        for ( int i = 0; i < stepen; i++){
           itog *= chislo;
        }
        return itog;
    }

    public static int pow(int chislo, int stepen){
        if (stepen == 0){
            return 1;
        }
        int pow_Prem = pow(chislo,stepen - 1);

        int itog = chislo * pow_Prem;

        return itog;
    }

    public static void chisla(int a, int b){
        if (a == b){
            System.out.println(a);
            return;
        }
        else if (a < b){
            System.out.println(a);
            chisla(a + 1, b);
        }
        else if ( a > b){
            System.out.println(a);
            chisla(a - 1, b);
        }
    }

    public static int summa(int chislo){
        //123
         if (chislo < 10){
             return chislo;
         }

         else{
             int sum = chislo % 10 + summa(chislo / 10);
             return sum;
         }
    }



    public static void main(String[] args) {
	// write your code here
        Scanner Scan = new Scanner(System.in);

        System.out.println("Фибоначчи через рекурсию");

        System.out.println(Fibbo(Scan.nextInt()));

        System.out.println("Факториал через рекурсию");

        int itog = Fact(Scan.nextInt());

        System.out.println(itog);

        System.out.println("Факториал через цикл");

        int factorial = Fact_1(Scan.nextInt());

        System.out.println(factorial);

        System.out.println("Степень числа через цикл");

        System.out.println(Stepen(Scan.nextInt(),Scan.nextInt()));

        System.out.println("Степень числа через рекурсию");

        int pow = pow(Scan.nextInt(),Scan.nextInt());

        System.out.println(pow);

        System.out.println("Сравнение чисел a и б, рекурсивный вывод их координат ( все числа от начала до конца) ");

        chisla(Scan.nextInt(), Scan.nextInt());

        System.out.println("Сумма цифр числа");

        System.out.println(summa(Scan.nextInt()));
    }
}
