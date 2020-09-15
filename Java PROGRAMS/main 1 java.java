import java.util.Scanner;


class Main
{

  public static int f(){
    return 0;
  }
  
  public static void main(String[] args)
  {
    
    Scanner TT = new Scanner(System.in);
    int n = TT.nextInt();
    // skanner для ручного ввода
    
    int sum = 0;
    int otv =0;    
    for (int i = 1; i <= n; i = i + 1)
    {
      int digit = i;

      sum = digit * digit;

      otv = otv + sum;
    }
    System.out.println(otv);
    return ;
  }

}