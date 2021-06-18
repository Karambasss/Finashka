package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Данный класс создан для работы с javaFx
 * @author Кузнецов Михаил Пи19-4
 */
public class Controller {
    @FXML
    TextField a_fld;
    @FXML
    TextField result_fld;

    /**
     * Данный метод находит факториал от переданного пользователем числа
     * @param n Переданное пользователем число
     * @return Факториал переданного пользователем числа
     */
    public int Fact(int n){
        if (n > 15){
            return -1;
        }
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return -404;
        }
        int factPrem = 1;
        for (int i = 1; i <= n; i++){
            factPrem = factPrem * i;
        }
        return factPrem;
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку и отображает результат пользователю
     */
    @FXML
    public void clickMe(){
        result_fld.clear();
        try {
            int a = Integer.parseInt(a_fld.getText());
            int res = Fact(a);
            if (res != -1 && res > 0){
                result_fld.setText("Ответ: " + res);
            }
            else if (res == -404){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Вы ввели число меньшее 0");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Нельзя вводить число больше 15");
                alert.showAndWait();
            }
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы допустили ошибку!");
            alert.showAndWait();
        }
        a_fld.clear();
    }
}
