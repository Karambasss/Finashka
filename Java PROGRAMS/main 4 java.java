import java.util.Scanner;

class Main
{

  public static void main(String[] args)
  {
    
    Scanner SS = new Scanner(System.in); // создание сканера
    
    int n = SS.nextInt();
    
    
    //for(то, что исполняется 1 раз ;  ;  )
    
    //for(; условие продолжения цикла ;  )
    
    //for(; ; то, что происходит после каждого витка цикла  )
    

    for(int i = 1 ; i * i <= n ; i = i+1 ) // бесконечный цикл вместо int i = 1 for (int i = 1; ; ) цикл идет 
    {
      
      System.out.println(i*i);
    }
    
    return ;
  }

}