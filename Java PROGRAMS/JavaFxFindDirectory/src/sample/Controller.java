package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.File;
import java.util.ArrayList;


public class Controller {
    @FXML
    TextArea path_fld;
    @FXML
    TextArea result_fld;

    @FXML
    public void clickBtn(){
        result_fld.clear();
        File file = new File(path_fld.getText());
        if (file.isDirectory()){
            ArrayList<String> arrayList = new ArrayList<>();
            for (String i : file.list()){
                //arrayList.add(file.getAbsolutePath() + File.separator + i + '\n');
                arrayList.add(file.getAbsolutePath() + File.separator + i + '\n');
            }
            if (arrayList.size() != 0){
                result_fld.setText(arrayList.toString());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "что-то возникло не так!");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы допустили ошибку!");
            alert.showAndWait();
        }
        path_fld.clear();
    }
}
