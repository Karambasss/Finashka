/*
Определите средний балл всех учащихся по каждому предмету.

Входные данные
Заданы сначала количество учащихся n, затем n строк, каждая из которых содержит фамилию, имя и три числа (оценки по трем предметам: математике, физике, информатике). Данные в строке разделены одним пробелом. Оценки принимают значение от 1 до 5.

Выходные данные
Выведите три действительных числа: средний балл всех учащихся по математике, по физике, по информатике.

Примеры
входные данные
2
Markov Valeriy 4 5 2
Kozlov Georgiy 5 1 2
выходные данные
4.5 3 2 
*/

import java.util.Scanner;

class Main
{

  public static class Student{
    String name;
    String family_name;
    int grade1;
    int grade2;
    int grade3;
  }

  public static void main(String[] args)
  {
    Scanner ss = new Scanner(System.in);

    int n = ss.nextInt();
    
    Student[] SS = new Student[n]; // Сколько памяти для всех студентов нужно, new = выделение памяти


    for (int i = 0; i < n; i++){
      SS[i] = new Student();// выделение памяти для каждого студент
    }

    for(int i = 0; i < n; i++)
    {
      String NAME = ss.next();

      String Family_NAME = ss.next();

      int grade1 = ss.nextInt();

      int grade2 = ss.nextInt();

      int grade3 = ss.nextInt();

      SS[i].name = NAME;

      SS[i].family_name = Family_NAME;

      SS[i].grade1 = grade1;

      SS[i].grade2 = grade2;

      SS[i].grade3 = grade3;
      
    }
    
    double s1 = 0;

    double s2 = 0;
    
    double s3 = 0;

    for (int i = 0; i < n; i++){
      s1 = s1 + SS[i].grade1;
      
      s2 += SS[i].grade2;

      s3 += SS[i].grade3;
    }
    
    s1 = s1 / n;
    s2 = s2 / n;
    s3 = s3 / n;

    System.out.print(s1 + " " + s2 + " " + s3 + " ");
    
    
/*    
    for (int i = 0; i < n; i++){
      System.out.println(SS[i].name);

      System.out.println(SS[i].family_name);
  
      System.out.println(SS[i].grade1);
  
      System.out.println(SS[i].grade2);
  
      System.out.println(SS[i].grade3);
    }
  */  
  
  }
}