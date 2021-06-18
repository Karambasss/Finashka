package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Данный класс создан для работы с javaFx
 * @author Кузнецов Михаил Пи19-4
 */
public class Controller {
    @FXML
    TextField login_fld;
    @FXML
    PasswordField pass_fld;

    private final String login = "userMichele";
    private final String password = "adminMichele";

    /**
     * Данный метод обрабатывает нажатие на кнопку, проверяет авторизацию пользователя, и, в случае успеха, загружает пользователю его личный кабинет.
     */
    @FXML
    public void clickToAuth(){
        String inputLogin = login_fld.getText();
        String inputPassword = pass_fld.getText();
        PersonalWindow personalWindow = new PersonalWindow();
        Stage old_stage = (Stage) pass_fld.getScene().getWindow();
        if (inputLogin.equals(login) && inputPassword.equals(password)){
            try {
                personalWindow.start(new Stage());
                old_stage.close();
            }
            catch (IOException exception){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Возникла ошибка!");
                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ошибка входа!");
            alert.showAndWait();
        }
        login_fld.clear();
        pass_fld.clear();
    }
}
