/*
По данному числу N распечатайте все целые степени двойки, не превосходящие N, в порядке возрастания.

Операцией возведения в степень пользоваться нельзя!

Входные данные
Вводится натуральное число.

Выходные данные
Выведите ответ на задачу.

Примеры
входные данные
50
выходные данные
1 2 4 8 16 32 
*/

import java.util.Scanner;

class Main
{

  public static int mypow(int x, int y)
  { 
    int ans = 1; // ans = x, ans = x*x, ans = x*x*x ... ans = x*x*x...*x
    
    for (int i = 0; i < y; i++)//x = 2 y = 55 for(2 *1) =2 2 * 2=4  
    {
      ans = ans * x;
    }

    return ans;
  }  


  public static void main(String[] args)
  {
    Scanner SS = new Scanner(System.in);

    int t = SS.nextInt();
    
    int stepen = 0;

    while (true)
    { 
      int otvet = mypow(2, stepen);
           
      if (otvet <= t){
      
        //System.out.println(otvet);
        
        System.out.print(otvet + " ");
      }
      else{
        break;
      }
      stepen = stepen + 1;
    }
  
  }


}