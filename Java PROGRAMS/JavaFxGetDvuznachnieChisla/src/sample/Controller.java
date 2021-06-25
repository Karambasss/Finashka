package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    @FXML
    TextField a_fld;
    @FXML
    TextField b_fld;
    @FXML
    TextArea result_fld;

    public ArrayList<Integer> getYourNumbers(int a, int b){
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (a > 0 && b > 0 && a <= b && a >= 10 && b >= 10 && a < 100){
            for (int i = a; i <= b; i++){
                if (i < 100){
                    arrayList.add(i);
                }
            }
            return arrayList;
        }
        else if (a > 0 && b > 0 && a >= b && b < 100 && a >= 10 && b >= 10){
            for (int i = a; i >= b; i--){
                if (i < 100){
                    arrayList.add(i);
                }
            }
            ArrayList<Integer> newList = new ArrayList<>();
            for (int i = arrayList.size()-1; i >= 0; i--){
                newList.add(arrayList.get(i));
            }
            return newList;
        }
        else if (a > 0 && b > 0 && a >= b && a >= 10 && b <= 10){
            for (int i = a; i >= 10; i--){
                if (i < 100){
                    arrayList.add(i);
                }
            }
            ArrayList<Integer> newList = new ArrayList<>();
            for (int i = arrayList.size()-1; i >= 0; i--){
                newList.add(arrayList.get(i));
            }
            return newList;
        }
        else if (a > 0 && b > 0 && a <= b && a <= 10 && b >= 10){
            for (int i = 10; i <= b; i++){
                if (i < 100){
                    arrayList.add(i);
                }
            }
            return arrayList;
        }
       return null;
    }

    @FXML
    public void clickMe(){
        result_fld.clear();
        try {
            int a = Integer.parseInt(a_fld.getText());
            int b = Integer.parseInt(b_fld.getText());
            ArrayList<Integer> arrayList = getYourNumbers(a,b);
            if (arrayList == null){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Ничего не выведено!");
                alert.showAndWait();
            }
            else {
                result_fld.setText("Ответ: " + arrayList.toString());
            }
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Что-то пошло не так!");
            alert.showAndWait();
        }
    }
}
