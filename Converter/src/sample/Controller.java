package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class Controller {

    public Label label;
    public Button celcia_btn;
    public Button far_btn;
    public Button calvin_btn;
    public TextField textfield;
    public TextField textfield2;
    Scanner Scan = new Scanner(System.in);

    public void celcia_click(){
        try{
            //Проверка на ввод не пустого слова

            int length = textfield.getLength(); // Вся длина введенного сообщения

            int index = textfield.getLength()-1; // Находим индекс последнего элемента

            char degrees = textfield.getText().charAt(index); // Получаем текст всего сообщения и засовываем только нужный кусок  (чтобы меньше писать) мы получаем в начале полную строку и засовываем в метод чар эт с индексом последнего символа

            if (degrees == 'F' || degrees == 'f') { // если этот символ - F или f получаем то он означает фаренгейты, то есть пользователь ввел 47F кликнул на кнопку цельсия, он хочет из фаренгейта в цельсию перевести

                // мы переводим в шкалу цельсии

                String str = textfield.getText(0, length-1); //Вырезаем последний символ

                try{
                    double temperature = Double.parseDouble(str); // теперь из типа стринг в тип double передаем

                    double otvet = (temperature - 32)/1.8;

                    textfield2.setVisible(true); // делаем его не скрытым

                    textfield2.setText(String.valueOf(otvet)); // заполянем (играюсь просто) с визибл

                    Alert alert = new Alert(Alert.AlertType.INFORMATION,String.valueOf(otvet)); // для красоты добавил информационный алерт - покажет вам красивую информацию

                    alert.showAndWait();

                    //label.setText(String.valueOf(temperature));

                    textfield2.clear(); // удаляем содержимое

                    textfield2.setVisible(false); // опять делаем скрытым
                }

                catch (NumberFormatException e){
                    e.printStackTrace();
                    System.out.println("Вы допустили ошибку, ввели много знаков, а надо число");
                }

            }

            else if (degrees == 'K' || degrees == 'k'){

                //Если мы переводим из кельвинов в цельсию

                String str = textfield.getText(0,textfield.getLength()-1); // Еще один способ, как перехватить и удалить последний символ ( от 0, до длина поля -1 получаем от 0 до предпоследнего символа)

                try {
                    double temperature = Double.parseDouble(str); // выполняется блок try catch, если ошибка не улавливается, то мы кладем все сообщение кроме последнего символа в переменную температуру

                    double otvet = temperature - 273.15;

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, String.valueOf(otvet));

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }

                catch (NumberFormatException e){ // Если последняя буква K а до этого были числа и строки типо 75gdfsF , тогда отрезается F, получается в str попадает 75gdfs - это не дабл, если приведем через parseDouble, то вылезет NumberFormatException, которую мы успешно обрабатываем
                    e.printStackTrace();
                    System.out.println("Вы допустили ошибку, надо только число вводить");
                }
            }

            else if (degrees == 'C' || degrees =='c'){

                String string = textfield.getText(0,length-1);

                try{
                    //еще один способ отрезать последний символ

                    // String str = textfield.getText(0,textfield.getLength()-1);

                    double otvet = Double.parseDouble(textfield.getText(0,textfield.getLength()-1));

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы переводите в ту же самую температуру, ответ:  " + otvet + "!");

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }
                catch (NumberFormatException exception){
                    exception.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");
                }
            }
            else {
                label.setText("Что-то пошло не так");
                return;
            }
        }
        catch (StringIndexOutOfBoundsException e){ // за границу вышли, то ловим или если пустое, то тоже ловим
            e.printStackTrace();
            System.out.println("Вы не ввели ничего");
        }
    }

    public void far_click(){

        try {

            int length = textfield.getLength();

            int index = length - 1;

            char degrees = textfield.getText().charAt(index); //Получаем полную длину слова, и вырезаем один символ, чтобы можно было узнатЬ, какую шкалу выбрал пользователь!

            if (degrees == 'C' || degrees == 'c'){

                String string = textfield.getText(0,index); // Не относится ко 2 трай ибо это тип стринг, он не вызовет ошибку, а вот когда мы запихиваем строковые данные в дабл, мы должн точно удалить все слова, буквы, а оставить только числа и все!

                try {
                    double temperature = Double.parseDouble(string);

                    double otvet = (temperature * 1.8) + 32;

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, String.valueOf(otvet));

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }
                catch (NumberFormatException exception){
                    exception.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");
                }
            }

            else if (degrees == 'K' || degrees =='k'){

                try {

                    double temperature = Double.parseDouble(textfield.getText(0,textfield.getLength()-1)); // БЕрем все от начала и до предпоследнего символа, если это все не строка, работаем

                    double otvet = (temperature * 1.8) - 459.67;

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, String.valueOf(otvet));

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");
                }
            }

            else if (degrees == 'F' || degrees == 'f'){

                try {
                    double otvet = Double.parseDouble(textfield.getText(0,textfield.getLength()-1));

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы переводите в ту же самую температуру, ответ:  " + otvet + "!");

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }

                catch (NumberFormatException ex){
                    ex.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");
                }

            }
            else{
                label.setText("Что-то пошло не так! Походу вы не ввели букву, обозначающую шкалу температуры");
                return;
            }
        }
        catch (StringIndexOutOfBoundsException exception){
            exception.printStackTrace();
            System.out.println("Вы ничего не ввели");
        }

    }

    public void calvin_click(){

        try{

            int length = textfield.getLength();

            int index = textfield.getLength()-1;

            char degrees = textfield.getText().charAt(index); // Получили последнюю букву (символ)

            if (degrees == 'C' || degrees == 'c') {

                try {

                    double temperature = Double.parseDouble(textfield.getText(0, textfield.getLength() - 1));

                    double otvet = temperature + 273.5;

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, String.valueOf(otvet));

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");
                }
            }

            else if (degrees == 'F' || degrees == 'f'){

                try{

                    double temperature = Double.parseDouble(textfield.getText(0,textfield.getLength()-1));

                    double otvet = (temperature + 459.67) / 1.8;

                    textfield2.setVisible(true);

                    textfield2.setText(String.valueOf(otvet));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, String.valueOf(otvet));

                    alert.showAndWait();

                    textfield2.clear();

                    textfield2.setVisible(false);
                }

                catch (NumberFormatException e){
                    e.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");

                }
            }

            else if (degrees == 'K' || degrees == 'K'){

                try{

                   double otvet = Double.parseDouble(textfield.getText(0,textfield.getLength()-1));

                   textfield2.setVisible(true);

                   textfield2.setText(String.valueOf(otvet));

                   Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вы переводите в ту же самую температуру, ответ: " + otvet + "!");

                   alert.showAndWait();

                   textfield2.clear();

                   textfield2.setVisible(false);
                }

                catch (NumberFormatException e){
                    e.printStackTrace();
                    System.out.println("Вы допустили ошибку, проверьте себя на ввод неправильных данных!");
                }

            }

            else {
                System.out.println("Что-то пошло не так! Походу вы не ввели букву, обозначающую шкалу температуры");
                return;
            }

        }
        catch (StringIndexOutOfBoundsException exception){
            exception.printStackTrace();
            System.out.println("Вы ничего не ввели");
        }
    }

}
