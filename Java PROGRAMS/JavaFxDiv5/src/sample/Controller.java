package sample;

import java.awt.*;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField textField;
    @FXML
    TextField textField1;
    @FXML
    TextArea resultField;

    @FXML
    public void getDiv5(){
        resultField.setVisible(false);
        try {
            int firstNum = Integer.parseInt(textField.getText());
            int secondNum = Integer.parseInt(textField1.getText());

            //первая проверка - на отрицательные диапазоны
            if (firstNum < 0 && secondNum < 0){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Вы ввели два отрицательных диапазона!");
                alert.showAndWait();
                textField.clear();
                textField1.clear();
            }
            //вторая - на ввод диапазона в порядке возрастания, а не убывания
            else if (secondNum > firstNum){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Вы ввели диапазон в порядке возрастания!");
                alert.showAndWait();
                textField.clear();
                textField1.clear();
            }
            else if (firstNum >= secondNum && firstNum >= 10 && secondNum >= 10 && firstNum < 100 && secondNum < 100){
                resultField.clear();
                ArrayList<Integer> resultList = new ArrayList<>();
                for (int i = firstNum; i >= secondNum; i--){
                    if (i % 5 == 0){
                        resultList.add(i);
                    }
                }
                if (resultList.size() > 0){
                    resultField.setVisible(true);
                    resultField.setText("Ответ: " + resultList.toString());
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Не нашлись числа, которые делятся на 5 без остатка!");
                    alert.showAndWait();
                }
                textField.clear();
                textField1.clear();
            }
            //проверка на не однозначность числа и его положительность
            else if ((firstNum > 0 && firstNum < 10)  || (secondNum > 0 && secondNum < 10)){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Введите двузначное число!");
                alert.showAndWait();
                textField.clear();
                textField1.clear();
            }
            else if (secondNum < 0){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Введите положительное число!");
                alert.showAndWait();
                textField.clear();
                textField1.clear();
            }
            else if (secondNum == 0 || firstNum == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Введите не нулевое число!");
                alert.showAndWait();
                textField.clear();
                textField1.clear();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Вы ввели число/а > 100");
                alert.showAndWait();
                textField.clear();
                textField1.clear();
            }
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы допустили ошибку ввода данных!");
            alert.showAndWait();
            textField.clear();
            textField1.clear();
        }
    }
}
