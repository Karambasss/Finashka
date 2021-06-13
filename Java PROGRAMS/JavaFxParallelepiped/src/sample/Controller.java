package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextField a_field;
    @FXML
    TextField b_field;
    @FXML
    TextField c_field;
    @FXML
    TextField res_field;

    public int getVolume(int a, int b, int c){
        return a*b*c;
    }

    public void clickMe(){
        try {
            int a = Integer.parseInt(a_field.getText());
            int b = Integer.parseInt(b_field.getText());
            int c = Integer.parseInt(c_field.getText());
            int res = getVolume(a,b,c);
            res_field.setText("Ответ: " + res);

        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Что-то пошло не так!");
            alert.showAndWait();
        }
        a_field.clear();
        b_field.clear();
        c_field.clear();
    }
}
