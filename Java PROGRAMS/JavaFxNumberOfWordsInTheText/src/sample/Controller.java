package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    @FXML
    TextArea text_fld;
    @FXML
    TextArea result_fld;

    public Map<String, Integer> getYourNumber(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            Integer n = map.get(w);
            System.out.println("word " + w + " " + n);
            if (n == null){
                n = 1;
            }
            else {
                ++n;
            }
            map.put(w, n);
        }
        System.out.println(map);
        return map;
    }

    @FXML
    public void clickMe() {
        result_fld.clear();
        String text = text_fld.getText();
        String[] words = text.split(" ");
        Map<String, Integer> myMap = getYourNumber(words);
        if (myMap == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Не нашлись слова");
            alert.showAndWait();
        }
        else {
            result_fld.setText("Ответ: " + myMap);
        }
    }
}
