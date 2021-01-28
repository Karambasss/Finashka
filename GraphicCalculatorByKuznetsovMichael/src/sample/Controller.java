package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.util.Scanner;

public class Controller {

    public Label lbl_control;
    //public CheckBox my_check;
    //public Button third_button;
    public int cnt;

    public Button plus;
    public Button minus;
    public Button umnozhit;
    public Button delenie;
    public TextField textField;
    public TextField textField2;

    public void plus_click(){
        Scanner Scan = new Scanner(System.in);

        System.out.println("Вы нажали на кнопку + , укажите, вы хотите работать с целыми или дробными числами?" + '\n' +
                "Введите 1, если хотите работать с целыми числами" + '\n' +
                "Введите 2, если хотите работать с дробными числами" + '\n' +
                "Введите любые другие числа, чтобы выйти и не складывать эти числа");

        int choicer = Scan.nextInt();

        if (choicer == 1) {

            if (textField.getText() != "" && textField2.getText() != "") {
                try {
                    int x = Integer.parseInt(textField.getText()); //Делаем из типа стринг инт

                    int y = Integer.parseInt(textField2.getText()); //Делаем из типа стринг инт

                    //lbl_control.setText(String.valueOf(x+y)); //Делаем из типа инт тип стринг

                    lbl_control.setText("Ответ: " + String.valueOf(x + y)); // Делаем из типа инт тип стринг

                    System.out.println("Ответ: " + (x + y));
                }
                catch (NumberFormatException e){
                    System.out.println("БУДЬТЕ ВНИМАТЕЛЬНЫ, ВЫ ВВЕЛИ НЕ ЦЕЛОЕ ЧИСЛО!");
                }

            }
            else {
                System.out.println("Вы ввели пуст(ую/ые) значени(я/е)." + "\n" + "Исправим следующим образом: введите не пустые значения");
            }
        }
        else if (choicer == 2){

            if (textField.getText() != "" && textField2.getText() != ""){

                try{
                    double x = Double.parseDouble(textField.getText());

                    double y = Double.parseDouble(textField2.getText());

                    //lbl_control.setText(String.valueOf(x+y)); //Делаем из типа инт тип стринг

                    lbl_control.setText("Ответ: " + String.valueOf(x+y));

                    System.out.println("Ответ: " + (x+y));
                }
                catch (NumberFormatException e){
                    System.out.println("БУДЬТЕ ВНИМАТЕЛЬНЫ, ВЫ ВВЕЛИ НЕ ДРОБНОЕ И НЕ ЦЕЛОЕ, А СТРОКОВОЕ ЧИСЛО");
                }
            }
            else {
                System.out.println("Вы ввели пуст(ую/ые) значени(я/е)." + "\n" + "Исправим следующим образом: введите не пустые значения");
            }

        }
        else {
            System.out.println("Пока-Пока");
            return;
        }
    }


    public void minus_click(){
        Scanner Scan = new Scanner(System.in);

        System.out.println("Вы нажали на кнопку - , укажите, вы хотите работать с целыми или дробными числами?" + '\n' +
                "Введите 1, если хотите работать с целыми числами" + '\n' +
                "Введите 2, если хотите работать с дробными числами" + '\n' +
                "Введите любые другие числа, чтобы выйти и не складывать эти числа");

        int choicer = Scan.nextInt(); // Выбор пользователем способ вычисления ( целое или дробное )

        //int hardChoicer; // Супервыбор пользователя как ему удобнее получить ответ (РЕШИЛ СОЗДАВАТЬ В КАЖДОМ БЛОКЕ ИФ ОТДЕЛЬНО, так как тогда логика будет правильнее

        if (choicer == 1) {

            if (textField.getText() != "" && textField2.getText() != "") {

                try {
                    int x = Integer.parseInt(textField.getText());

                    int y = Integer.parseInt(textField2.getText());

                    System.out.println("Как вы хотите выполнить вычитание?" + '\n' +
                            "Нажмите 1 для стандартного вычитания, пример: (x - y)" + '\n' +
                            "Нажмите 2 (или любое другое число) для нестандартного вычитания, пример: (y - x)");

                    int hardChoicer = Scan.nextInt(); // Супервыбор пользователя как ему удобнее получить ответ

                    if (hardChoicer == 1) {

                        lbl_control.setText("Ответ: " + String.valueOf(x - y));

                        System.out.println("Ответ: " + (x - y));
                    }
                    else {

                        lbl_control.setText("Ответ: " + (y - x));

                        System.out.println("Ответ: " + (y - x));

                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для целого числа либо строку, либо дробное число" + '\n' +
                            "Исправим следующим образом: " + "вводите целые числа");
                }
            }
            else{
                System.out.println("Вы ввели пуст(ую/ые) значени(я/е)." + "\n" + "Исправим следующим образом: введите не пустые значения");
            }
        }
        else if (choicer == 2) {

            if (textField.getText() != "" && textField2.getText() != "") {

                try {
                    double x = Double.parseDouble(textField.getText());

                    double y = Double.parseDouble(textField2.getText());

                    System.out.println("Как вы хотите выполнить вычитание?" + '\n' +
                            "Нажмите 1 для стандартного вычитания, пример: (x - y)" + '\n' +
                            "Нажмите 2 или (любое другое число) для нестандартного вычитания, пример: (y - x)");

                    int hardChoicer = Scan.nextInt();// Супервыбор пользователя как ему удобнее получить ответ

                    if (hardChoicer == 1) {

                        lbl_control.setText("Ответ: " + (x - y));

                        System.out.println("Ответ: " + (x - y));

                    }
                    else {

                        lbl_control.setText("Ответ: " + (y - x));

                        System.out.println("Ответ: " + (y - x));

                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для дробного числа строку" + '\n' +
                            "Исправим следующим образом: " + "вводите дробные числа");
                }
            }
            else {
                System.out.println("Вы ввели пуст(ую/ые) значени(я/е)." + "\n" + "Исправим следующим образом: введите не пустые значения");
            }
        }
        else {
            System.out.println("Пока-Пока");
            return;
        }
    }

    public void umnozhit_click(){

        Scanner Scan = new Scanner(System.in);

        System.out.println("Вы нажали на кнопку * , укажите, вы хотите работать с целыми или дробными числами?" + '\n' +
                "Введите 1, если хотите работать с целыми числами" + '\n' +
                "Введите 2, если хотите работать с дробными числами" + '\n' +
                "Введите любые другие числа, чтобы выйти и не складывать эти числа");

        int choser = Scan.nextInt();

        if (textField.getText() != "" && textField2.getText() != ""){

            if (choser == 1){

                try{
                    int x = Integer.parseInt(textField.getText());

                    int y = Integer.parseInt(textField2.getText());

                    lbl_control.setText("Ответ: " + ( x * y));

                    System.out.println("Ответ: " + (x * y));

                }

                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для целого числа либо строку, либо дробное число" + '\n' +
                            "Исправим следующим образом: " + "вводите целые числа");
                }

            }
            else if (choser == 2){

                try {
                    double x = Double.parseDouble(textField.getText());

                    double y = Double.parseDouble(textField2.getText());

                    lbl_control.setText("Ответ: " + (x * y));

                    System.out.println("Ответ: " + (x * y));
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для дробного числа строку" + '\n' +
                            "Исправим следующим образом: " + "вводите дробные числа");
                }
            }
            else {
                System.out.println("Пока-Пока");
                return;
            }
        }
        else{
            System.out.println("Вы ввели пуст(ую/ые) значени(я/е)." + "\n" + "Исправим следующим образом: введите не пустые значения");
        }
    }

    public void delenie_click(){
        Scanner Scan = new Scanner(System.in);

        if (textField.getText() != "" && textField2.getText() != ""){

            System.out.println("Вы нажали на кнопку / , укажите, вы хотите работать с целыми или дробными числами?" + '\n' +
                    "Введите 1, если хотите сделать деление целых чисел с округлением в меньшую сторону" + '\n' +
                    "Введите 2, если хотите сделать деление целых чисел с округлением в большую сторону" + '\n' +
                    "Введите 3, если хотите сделать деление дробных чисел с остатком без округления" + '\n' +
                    "Введите 4, если хотите сделать деление дробных чисел с округлением в большую сторону" + '\n' +
                    "Введите любые другие числа, чтобы выйти и не складывать эти числа");

            int choser = Scan.nextInt();

            if (choser == 1) {

                try {

                    int x = Integer.parseInt(textField.getText());

                    int y = Integer.parseInt(textField2.getText());

                    System.out.println("Как вы хотите выполнить целое деление с округлением в меньшую сторону?" + '\n' +
                            "Нажмите 1 для стандартного деления, пример: (x / y)" + '\n' +
                            "Нажмите 2 или (любое другое число) для нестандартного деления, пример: (y / x)");

                    int hardChoicer = Scan.nextInt();

                    if (hardChoicer == 1) {

                        lbl_control.setText("Ответ: " + (x / y));

                        System.out.println("Ответ: " + (x / y));
                    }
                    else {

                        lbl_control.setText("Ответ: " + (y / x));

                        System.out.println("Ответ: " + (y / x));
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для целого числа либо строку, либо дробное число" + '\n' +
                            "Исправим следующим образом: " + "вводите целые числа");
                }
                catch (ArithmeticException exception){
                    System.out.println("Вы ввели в поле для деления на целое число ноль" + '\n' +
                            "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                }
            }
            else if (choser == 2) {
                try {

                    int x = Integer.parseInt(textField.getText());

                    int y = Integer.parseInt(textField2.getText());

                    System.out.println("Как вы хотите выполнить целое деление с округлением в большую сторону?" + '\n' +
                            "Нажмите 1 для стандартного деления, пример: (x / y)" + '\n' +
                            "Нажмите 2 или (любое другое число) для нестандартного деления, пример: (y / x)");

                    int hardChoicer = Scan.nextInt();

                    if (hardChoicer == 1) {

                        if (y!= 0){

                            lbl_control.setText("Ответ: " + Math.round( (double)x / (double)y) );

                            System.out.println("Ответ: " + Math.round((double)x / (double)y) );
                        }
                        else {
                            System.out.println("Вы ввели в поле для деления на целое число ноль" + '\n' +
                                    "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                        }
                    }
                    else {

                        if (x!= 0){

                            lbl_control.setText("Ответ: " + Math.round((double)y / (double)x));

                            System.out.println("Ответ: " + Math.round((double)y / (double)x));
                        }
                        else {
                            System.out.println("Вы ввели в поле для деления на целое число ноль" + '\n' +
                                    "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                        }

                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для целого числа либо строку, либо дробное число" + '\n' +
                            "Исправим следующим образом: " + "вводите целые числа");
                }
            }
            else if (choser == 3) {

                try {

                    double x = Double.parseDouble(textField.getText());

                    double y = Double.parseDouble(textField2.getText());

                    System.out.println("Как вы хотите выполнить деление дробных чисел без округления?" + '\n' +
                            "Нажмите 1 для стандартного деления, пример: (x / y)" + '\n' +
                            "Нажмите 2 или (любое другое число) для нестандартного деления, пример: (y / x)");

                    int hardChoicer = Scan.nextInt();

                    if (hardChoicer == 1) {

                        if (y!= 0){

                            lbl_control.setText("Ответ: " + (x / y));

                            System.out.println("Ответ: " + (x / y));

                        }
                        else {
                            System.out.println("Вы ввели в поле для деления на дробное число ноль" + '\n' +
                                    "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                        }
                    }
                    else {

                        if (x != 0){

                            lbl_control.setText("Ответ: " + (y / x));

                            System.out.println("Ответ: " + (y / x));
                        }
                        else {
                            System.out.println("Вы ввели в поле для деления на дробное число ноль" + '\n' +
                                    "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                        }
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для дробного числа строку" + '\n' +
                            "Исправим следующим образом: " + "вводите дробные числа");
                }
            }
            else if (choser == 4) {
                try {

                    double x = Double.parseDouble(textField.getText());

                    double y = Double.parseDouble(textField2.getText());

                    System.out.println("Как вы хотите выполнить деление дробных чисел с округлением в большую сторону?" + '\n' +
                            "Нажмите 1 для стандартного деления, пример: (x / y)" + '\n' +
                            "Нажмите 2 или (любое другое число) для нестандартного деления, пример: (y / x)");

                    int hardChoicer = Scan.nextInt();

                    if (hardChoicer == 1) {

                        if (y != 0) {

                            lbl_control.setText("Ответ: " + (double) Math.round(x / y));

                            System.out.println("Ответ: " + (double) Math.round(x / y));
                        }
                        else{
                            System.out.println("Вы ввели в поле для деления на дробное число ноль" + '\n' +
                                    "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                        }
                    }
                    else {
                        if (x != 0){
                            lbl_control.setText("Ответ: " + (double) Math.round(y / x));

                            System.out.println("Ответ: " + (double) Math.round(y / x));
                        }
                        else {
                            System.out.println("Вы ввели в поле для деления на дробное число ноль" + '\n' +
                                    "Исправим следующим образом: " + "уберите ноль, так как на ноль делить нельзя");
                        }
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Вы ввели в поле для дробного числа строку" + '\n' +
                            "Исправим следующим образом: " + "вводите дробные числа");
                }
            }
            else {
                System.out.println("Пока-Пока");
                return;
            }
        }
        else {
            System.out.println("Вы ввели пуст(ую/ые) значени(я/е)." + "\n" + "Исправим следующим образом: введите не пустые значения");
        }
    }

    /*
    //OnAction - Нажатие кнопки - выполняется btn_click только тогда, когда кнопка нажата

    public void btn_click(){
        //Пишем название для кнопок и чекбоксов

        if (my_check.isSelected()){ // если поставлена галочка
            cnt+=1;
        }

        else{
            cnt-=1;
        }
        lbl_control.setText(String.valueOf(cnt)); // Метод, возвращающий тип инт в качестве стринга

    }
    */
}
