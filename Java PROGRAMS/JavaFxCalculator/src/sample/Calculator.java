package sample;

/**
 * Данный класс необходим для вычисления любой математической операции (+,-,*,/) и получения результата
 * @author Кузнецов Михаил Пи19-4
 */
public class Calculator {
    private double a;
    private double b;

    /**
     * Конструктор, который заполняет поля объекта
     * @param a Параметр для присваивания полю a
     * @param b Параметр для присваивания полю b
     */
    public Calculator(double a, double b){
        this.a = a;
        this.b = b;
    }

    /**
     * Данный метод производит вычисление сложения чисел.
     * @return Результат сложения чисел
     */
    public double plus(){
        return a + b;
    }

    /**
     * Данный метод производит вычисление вычитания чисел.
     * @return Результат вычитания чисел
     */
    public double minus(){
        return a - b;
    }

    /**
     * Данный метод производит вычисление умножения чисел.
     * @return Результат умножения чисел
     */
    public double multiplication(){
        return a * b;
    }

    /**
     * Данный метод производит вычисление деления чисел.
     * @return Результат деления чисел
     */
    public double division(){
        return a / b;
    }

    /**
     * Геттер для получения значения поля
     * @return Значение поля a
     */
    public double getA() {
        return a;
    }

    /**
     * Сеттер для того, чтобы присвоить полю новое значение.
     * @param a Новое значение для поля a
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Геттер для получения значения поля
     * @return Значение поля b
     */
    public double getB() {
        return b;
    }

    /**
     * Сеттер для того, чтобы присвоить полю новое значение.
     * @param b Новое значение для поля b
     */
    public void setB(double b) {
        this.b = b;
    }
}
