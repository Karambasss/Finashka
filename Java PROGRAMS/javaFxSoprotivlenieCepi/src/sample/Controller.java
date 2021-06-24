package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField r1_fld;
    @FXML
    TextField r2_fld;
    @FXML
    TextField result_fld;

    public int getResistance(int r1, int r2){
        return r1+r2;
    }

    @FXML
    public void clickMe(){
        result_fld.clear();
        try {
            int r1 = Integer.parseInt(r1_fld.getText());
            int r2 = Integer.parseInt(r2_fld.getText());
            result_fld.setText("Ответ: " + getResistance(r1,r2));
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Что-то пошло не так!");
            alert.showAndWait();
        }
        r1_fld.clear();
        r2_fld.clear();
    }
}
