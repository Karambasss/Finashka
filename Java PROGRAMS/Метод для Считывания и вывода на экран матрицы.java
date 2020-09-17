import java.util.Scanner;

public class Main
{
  public static class Matrix 
  {
		int matrix[][]; // двумерный массив
		int rows; // количество строк
    int columns; // количество столбцов

    public Matrix(int x, int y)
    {
      this.rows = x; // строки
      this.columns = y; // столбцы
      this.matrix = new int[x][y]; // создали размерность // 272 строка всегда должна исполниться раньше , чем 279 строка, так как в 272 задается размерность исходного поля матрицы, а в 279 уже заполняет исходную матрицу числами     
    }

    public void set_elements()// или public void set_elements(Scanner Scan){}
    {
      Scanner Scan = new Scanner(System.in);
      for (int i = 0; i < this.rows; i++){
        for (int j = 0; j < this.columns;j++){
          this.matrix[i][j] = Scan.nextInt();
        }
      }
    }
    public void output()
    {
      for (int i = 0; i < this.rows; i++){
        for (int j = 0; j < this.columns; j++){
          System.out.print(this.matrix[i][j] + " "); 
        }
        System.out.println();
      }
    }
  }
  
  public static void main (String[] args)  
  {
    Scanner Scan = new Scanner(System.in);

    int x = Scan.nextInt();

    int y = Scan.nextInt();

    Matrix a = new Matrix(x,y);
//a.set_element(Scan); // Вызываем функцию от матрицы
    a.set_elements();

    a.output();

    x = Scan.nextInt();

    y = Scan.nextInt();

    Matrix b = new Matrix(x,y);

    b.set_elements();

    b.output();
	}
}