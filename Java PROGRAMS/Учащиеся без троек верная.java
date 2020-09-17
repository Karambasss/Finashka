/*

Ввод и вывод данных производятся через стандартные потоки ввода-вывода.
Выведите фамилии и имена учащихся, не имеющих троек (а также двоек и колов).

Входные данные
Заданы сначала количество учащихся n, затем n строк, каждая из которых содержит фамилию, имя и три числа (оценки по трем предметам: математике, физике, информатике). Данные в строке разделены одним пробелом. Оценки принимают значение от 1 до 5.

Выходные данные
Необходимо вывести пары фамилия-имя по одной на строке, разделяя фамилию и имя одним пробелом. Выводить оценки не нужно. Порядок вывода должен быть таким же, как в исходных данных.

Примеры
входные данные
3
Babat Anna 5 4 3
Belova Galina 4 3 5
Moroz Yaroslav 3 5 4
выходные данные
*/

import java.util.Scanner; 

class Student{
    String name;

    String Family_name;

    int grade1;

    int grade2;

    int grade3; 

    //Student(String name1, String fam, int mark1, int mark2, int mark3){
      //name = name1;
      //Family_name = fam;
      //grade1 = mark1;
      //grade2 = mark2;
      //grade3 = mark3;
    }
  //}

class Main{
  public static void main (String[] args){
    //Teacher t = new Teacher();
    //System.out.println("Hello!");
  // Scan - переменная, которая обращается к классу сканнер
  Scanner Scan = new Scanner(System.in);

  int n = Scan.nextInt();

  Student [] lst = new Student[n]; // выделение памяти для [n] студентов, то есть выделение памяти для всех студентов


 for (int i = 0; i < n; i++){
  lst[i] = new Student();
  //lst[i] = new Student(Scan.nextLine(),Scan.nextLine(),
  //Scan.nextInt(), Scan.nextInt(), Scan.nextInt()); // выделение памяти для //[i] студента в целом в lst[i] будет выделена память, чтобы туда можно было ввести поля экземпляра класса
    }
    for (int i = 0; i < n; i++){
      String NAME = Scan.next();

      String Family_NAME = Scan.next();

      int GRADE1 = Scan.nextInt();

      int GRADE2 = Scan.nextInt();

      int GRADE3 = Scan.nextInt();

      lst[i].name = NAME;

      lst[i].Family_name = Family_NAME;
    
      lst[i].grade1 = GRADE1;

      lst[i].grade2 = GRADE2;

      lst[i].grade3 = GRADE3;

    }

  //for (int i = 0; i < n; i++){
  //   if ((lst[i].getmarks()[0] > 3) && (lst[i].getmarks()[1] > 3) && (lst[i].getmarks()[2] > 3)){
  //     System.out.print(lst[i].name + " " + lst[i].Family_name + "\n");
  //   }  
//}
//

  for (int i = 0; i < n; i++)
  {
    if ((lst[i].grade1 > 3) && (lst[i].grade3 > 3) && (lst[i].grade2 > 3))
    {
      System.out.print(lst[i].name + " " + lst[i].Family_name);
      System.out.println();
    } 
  }

  }
    
    }