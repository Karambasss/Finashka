package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    @FXML
    Button click_btn;
    @FXML
    TextArea result_area;
    @FXML
    TextField first_fld;
    @FXML
    TextField sec_fld;

    public ArrayList<Integer> getRandomNumber(int first, int sec){
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            int resultNum = (int) (Math.random() * ((sec - first) + 1)  + first);
            resultList.add(resultNum);
        }
        return resultList;
    }



    public void clickAction(){
        int a = Integer.parseInt(first_fld.getText());
        int b = Integer.parseInt(sec_fld.getText());
        if (a < b){
            ArrayList<Integer> arr = getRandomNumber(a,b);
            result_area.setText("Ваш ответ: " + arr.toString());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Что-то пошло не так!");
            alert.showAndWait();
        }
        first_fld.clear();
        sec_fld.clear();
    }
}
