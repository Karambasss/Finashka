import java.util.Scanner;

class Main
{

  public static void main(String[] args)
  {
    
    Scanner SS = new Scanner(System.in); // создание сканера
    
    int n = SS.nextInt();
    
    int i = 1;
    
    while (true)
    {
      if (i * i > n)
      {
        break; 
      }

      System.out.println(i*i);
      
      i = i + 1;
    }
    
    return ;
  }

}