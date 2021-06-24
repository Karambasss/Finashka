package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    TextField login_fld;
    @FXML
    PasswordField pass_fld;
    @FXML
    Button my_btn;
    @FXML
    ImageView view_im;
    @FXML
    Button avatar_btn;

    private final String login = "userMichele";
    private final String password = "adminMichele";

    @FXML
    public void clickToAuth(){
        String inputLogin = login_fld.getText(); // ваш логин
        String inputPassword = pass_fld.getText(); // ваш пароль
        PersonalWindow personalWindow = new PersonalWindow();
        Stage old_stage = (Stage) pass_fld.getScene().getWindow(); //получаем окно на которой сейчас находится пользователь
        if (inputLogin.equals(login) && inputPassword.equals(password)){ // если логин и пароль совпадают
            try {
                personalWindow.start(new Stage()); // открываем новое окно
                old_stage.close(); // закрываем старое
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
    @FXML
    public void upload(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(avatar_btn.getScene().getWindow());
        if (file != null){
            Image image = new Image(file.toURI().toString());
            view_im.setImage(image);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Не удалось загрузить аватар!");
            alert.showAndWait();
        }
    }
}
