package com.company;

import java.util.Scanner;

public interface Tovar {
    Scanner Scan = new Scanner(System.in);
    public int gabarit = Scan.nextInt();
    public int cena = Scan.nextInt();

    public void buy();

    public void test(int chislo);

    public void INFO();
}
