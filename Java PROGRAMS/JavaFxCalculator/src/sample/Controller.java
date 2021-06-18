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
    TextField b_fld;
    @FXML
    TextField result_fld;

    /**
     * Данный метод обрабатывает нажатие на кнопку плюс.
     */
    @FXML
    public void plusBtn(){
        result_fld.clear();
        try {
            double a = Double.parseDouble(a_fld.getText());
            double b = Double.parseDouble(b_fld.getText());
            Calculator calculator = new Calculator(a,b);
            result_fld.setText("Ответ: " + calculator.plus());
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы где-то ошиблись!");
            alert.showAndWait();
        }
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку минус.
     */
    @FXML
    public void minusBtn(){
        result_fld.clear();
        try {
            double a = Double.parseDouble(a_fld.getText());
            double b = Double.parseDouble(b_fld.getText());
            Calculator calculator = new Calculator(a,b);
            result_fld.setText("Ответ: " + calculator.minus());
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы где-то ошиблись!");
            alert.showAndWait();
        }
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку умножить.
     */
    @FXML
    public void multipBtn(){
        result_fld.clear();
        try {
            double a = Double.parseDouble(a_fld.getText());
            double b = Double.parseDouble(b_fld.getText());
            Calculator calculator = new Calculator(a,b);
            result_fld.setText("Ответ: " + calculator.multiplication());
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы где-то ошиблись!");
            alert.showAndWait();
        }
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку делить.
     */
    @FXML
    public void divisionBtn(){
        result_fld.clear();
        try {
            double a = Double.parseDouble(a_fld.getText());
            double b = Double.parseDouble(b_fld.getText());
            Calculator calculator = new Calculator(a,b);
            result_fld.setText("Ответ: " + calculator.division());
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Вы где-то ошиблись!");
            alert.showAndWait();
        }
    }

}
