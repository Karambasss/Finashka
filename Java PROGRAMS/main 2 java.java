/*
По данному натуральному n вычислите значение n!.

Входные данные
Вводится единственное число n.

Выходные данные
Необходимо вывести  значение n!.

Примеры
входные данные
2
выходные данные
2
*/

import java.util.Scanner;

class Main{

  public static int Fac(int x){
    
    int factorial = 1;
    
    
    
    for (int i = 1; i <= x; i = i + 1)
    {
      
    factorial = factorial * i;

    }   
    
    return factorial;

  }

  public static void main(String[] args)
  {
    Scanner IO = new Scanner(System.in);
    
    int a = IO.nextInt();

    int otvet = Fac(a);

    System.out.println(otvet);
     
    return ;
  }
}

