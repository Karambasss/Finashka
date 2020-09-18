/*
Напишите программу, которая вычисляет сумму элементов матрицы.

Входные данные
В первой строке записаны через пробел размеры матрицы: количество строк N и количество столбцов M ( 1 ≤ N , M ≤ 100 ). В следующих N строках записаны строки матрицы, в каждой – по M натуральных чисел, разделённых пробелами.

Выходные данные
Программа должна вывести одно число – сумму элементов матрицы.

Примеры
входные данные
4 5
1 2 3 4 5
6 12 8 9 10
11 12 12 14 15
16 17 18 12 20
выходные данные
207
*/

import java.util.Scanner;

public class Main{

  public static class Matrix{

    // задаем поля класса, когда мы создали поле класса, мы можем к ним обращаться в методах класса с помощью this.поле класса или просто поле класса = другое название

    int[][] matrix;// int - тип; [][] - класс; matrix - имя переменной

    int rows; // поля строк

    int columns; // поля столбцов

    public Matrix(int n, int m){ // создаем конструктор, чтобы можно было задать матрице ее размер

      this.rows = n;

      this.columns = m;

      this.matrix = new int[n][m]; 
      // задали матрицу ( то есть задали количество памяти для ее создания)
    }

    public void set_matrix(){ //создаем метод для ввода в массив целых чисел

      Scanner Scan = new Scanner(System.in);

      for (int i = 0; i < this.rows; i++){
        for (int j = 0;j < this.columns;j++){
          this.matrix[i][j] = Scan.nextInt();// заполняем поле класса с указанными строками и столбцами целыми значениями      
        }
      }
      System.out.println("Матрица создана и заполнена числами, которые вы ввели!");

    }

    public int summa(){

      int my_sum = 0;

      for (int i = 0; i < this.rows; i++){
        for (int j = 0; j < this.columns; j++){
          my_sum = my_sum + this.matrix[i][j];
        }
      }

      return my_sum;

    }

    public void output(){
      for (int i = 0; i < this.rows; i++){
        for (int j = 0; j < this.columns; j++){
          System.out.print(this.matrix[i][j] + " "); // печатает все на одной строке ( то есть тут он печатает через пробел числа, которые находятсяв 0 строке и во всех столбцах 0 строки  )
        }
        System.out.println(); // потом делает перевод на новую строку, как только все числа из столбцов в строке 0 исполнятся и будут выведены
      }
    }    
  }

  public static void main(String[] args){

    Scanner Scan = new Scanner(System.in);
    
    int x = Scan.nextInt();// можно их сразу в поле ввода через пробел вводить

    int y = Scan.nextInt();

    Matrix matrica = new Matrix(x,y); // Создали матрицу с конструктором Matrix(x,y)

    matrica.set_matrix(); // создаем метод для того, чтобы наша матрица была заполнена числами

    matrica.output();

    int otvet = matrica.summa();

    System.out.println(otvet);
  }

}