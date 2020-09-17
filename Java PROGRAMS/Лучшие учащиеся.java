/*
Определите учащихся с наилучшей успеваемостью, то есть с максимальным средним баллом по трем предметам. Выведите всех учащихся, имеющих максимальный средний балл.

Входные данные
Заданы сначала количество учащихся n, затем n строк, каждая из которых содержит фамилию, имя и три числа (оценки по трем предметам: математике, физике, информатике). Данные в строке разделены одним пробелом. Оценки принимают значение от 1 до 5.

Выходные данные
Необходимо вывести пары фамилия-имя по одной на строке, разделяя фамилию и имя одним пробелом. Выводить оценки не нужно. Порядок вывода должен быть таким же, как в исходных данных.

Примеры
входные данные
2
Markov Valeriy 1 1 1
Sergey Petrov 5 5 5
выходные данные
Sergey Petrov
*/

import java.util.Scanner;

public class Main{

  public static class Student{

    String name;

    String family_name;

    int grade1;

    int grade2;
    
    int grade3;
  }

  public static void main(String[] args){

    Scanner Scan = new Scanner(System.in);

    int n = Scan.nextInt();

    Student [] lst = new Student[n];

    for (int i = 0; i < n;i++){

      lst[i] = new Student();
    
    }
    for (int i = 0;i < n; i++){
      String name = Scan.next();

      String fam = Scan.next();

      int mark1 = Scan.nextInt();

      int mark2 = Scan.nextInt();

      int mark3 = Scan.nextInt();

      lst[i].name = name;

      lst[i].family_name = fam;

      lst[i].grade1 = mark1;

      lst[i].grade2 = mark2;

      lst[i].grade3 = mark3;
    }
    int best = 0;
    String name_fam = "";

    for (int i = 0; i < n; i++){
      int cnt = lst[i].grade1 + lst[i].grade2 + lst[i].grade3;
      if (cnt > best){
        best = cnt;
      }
    }
    for (int i = 0; i < n; i++){
      int cnt = lst[i].grade1 + lst[i].grade2 + lst[i].grade3;
      if (cnt == best){
        System.out.print(lst[i].name + " " + lst[i].family_name);
        System.out.println();
      }
    }  
    }
}