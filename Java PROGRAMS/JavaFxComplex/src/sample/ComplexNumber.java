package sample;

import javafx.scene.control.Alert;

/**
 * Данный класс помогает работать с комплексными числами, у него есть 2 поля: re, im, а также методы, в которых реализуется логика сложения, вычитания, и умножения над комплексными числами.
 */
public class ComplexNumber {
    private double re;
    private double im;

    /**
     * Конструктор для заполнения полей объекта и его создания
     * @param re Число re, которое пользовать передает
     * @param im Число im, которое пользовать передает
     */
    public ComplexNumber(double re, double im){
        this.re = re;
        this.im = im;
    }
    /**
     * Этот метод реализует сложение комплексных чисел, этот метод является статическим для того, чтобы можно было не создавать объект, а просто запускать через ComplexNumber.plus
     * @param n1 первый объект ComplexNumber, в котором есть свои поля: re, im
     * @param n2 второй объект ComplexNumber, в котором есть свои поля: re, im
     * @return Объект класса с новыми полями, полученными в результате выполнения сложения комплексных чисел
     */
    public static ComplexNumber plus(ComplexNumber n1, ComplexNumber n2){
        try{
            return new ComplexNumber(n1.getRe() + n2.getRe(), n1.getIm() + n2.getIm());
        }
        catch (NullPointerException exception){
            System.out.println("Вы где-то ошиблись!");
            return null;
        }
    }

    /**
     * Этот метод реализует вычитание комплексных чисел, этот метод является статическим для того, чтобы можно было не создавать объект, а просто запускать через ComplexNumber.minus
     * @param n1 первый объект ComplexNumber, в котором есть свои поля: re, im
     * @param n2 второй объект ComplexNumber, в котором есть свои поля: re, im
     * @return Объект класса с новыми полями, полученными в результате выполенения вычитания комплексных чисел
     */
    public static ComplexNumber minus(ComplexNumber n1, ComplexNumber n2){
        try {
            return new ComplexNumber(n1.getRe() - n2.getRe(), n1.getIm() - n2.getIm());
        }
        catch (NullPointerException exception){
            System.out.println("Вы где-то ошиблись");
            return null;
        }
    }

    /**
     * Этот метод реализует умножение комплексных чисел, этот метод является статическим для того, чтобы можно было не создавать объект, а просто запускать через ComplexNumber.multiply
     * @param n1 первый объект ComplexNumber, в котором есть свои поля: re, im
     * @param n2 второй объект ComplexNumber, в котором есть свои поля: re, im
     * @return Объект класса с новыми полями, полученными в результате выполенения умножения комплексных чисел
     */
    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2){
        try {
            return new ComplexNumber((n1.getRe() * n2.getRe() - n1.getIm() * n2.getIm()), (n1.getRe() * n2.getIm() + n2.getRe() * n1.getIm()));
        }
        catch (NullPointerException exception){
            System.out.println("Вы где-то ошиблись");
            return null;
        }
    }

    /**
     * Геттер для получения поля
     * @return поле re
     */
    public double getRe() {
        return re;
    }

    /**
     * Сеттер для того, чтобы присвоить полю новое значение.
     * @param re новое значение для поля re
     */
    public void setRe(double re) {
        this.re = re;
    }

    /**
     * Геттер для получения поля
     * @return поле im
     */
    public double getIm() {
        return im;
    }

    /**
     * Сеттер для того, чтобы присвоить полю новое значение.
     * @param im новое значения для поля im
     */
    public void setIm(double im) {
        this.im = im;
    }
}
