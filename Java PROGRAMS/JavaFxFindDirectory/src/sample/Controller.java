package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.File;
import java.util.ArrayList;

/**
 * Данный класс создан для работы с javaFx
 * @author Кузнецов Михаил Пи19-4
 */
public class Controller {
    @FXML
    TextArea path_fld;
    @FXML
    TextArea result_fld;

    /**
     * Данный метод обрабатывает нажатие на кнопку, отдает во view пользователя список файлов, лежащих в указанной пользователем директории
     */
    @FXML
    public void clickBtn(){
        result_fld.clear();
        File file = new File(path_fld.getText()); // path_fld - текстареа, где пользователь задает путь
        if (file.isDirectory()){ // если файл является директорией
            ArrayList<String> arrayList = new ArrayList<>();
            for (String i : file.list()){
                //arrayList.add(file.getAbsolutePath() + File.separator + i + '\n');
                arrayList.add(file.getAbsolutePath() + File.separator + i + '\n');
            }
            if (arrayList.size() > 0){
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
