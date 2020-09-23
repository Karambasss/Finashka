package com.company;

public class Calculator {
    // должно быть 2 аргумента дробных; поле знак; char - 1 символ ( ровно один символ как и пробел так и одна буква или цифра;
    double a;
    double b;
    char znak; //

    public Calculator(double a, double b, char znak) { // создали конструктор для инициализвации
        this.a = a;
        this.b = b;
        this.znak = znak;
    }
    // операции + - * /

    public double getOper(){
        double result = 0;

        if (this.znak == '+'){
            // ' ' кавычки - это для одного символа, " " для двух и более символов( для строки)
            result = this.a + this.b;
        }
        if (this.znak == '-'){
            result = this.a - this.b;
        }
        if (this.znak == '*'){
            result = this.a * this.b;
        }
        if (this.znak == '/'){
            result = this.a / this.b;
        }
        return result;
        }
    }
