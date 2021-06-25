package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField n_fld;
    @FXML
    TextField result_fld;

    public double sumOfTheRow(int n){
        if (n == 0 || n < 0){
            return -1;
        }
        if (n == 1){
            return 1;
        }
        else {
            double sum = 1;
            double re = 1;
            for (int i = 1; i < n; i++){
                sum += 1 / (re * 2);
                System.out.println(sum);
                re++;
            }
            return sum;
        }
    }

    @FXML
    public void clickMe(){
        result_fld.clear();
        try {
            int n = Integer.parseInt(n_fld.getText());
            double result = sumOfTheRow(n);
            if (result == -1){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Вы допустили ошибку!");
                alert.showAndWait();
            }
            else {
                result_fld.setText("Ответ: " + result);
            }
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Что-то пошло не так!");
            alert.showAndWait();
        }
    }
}
