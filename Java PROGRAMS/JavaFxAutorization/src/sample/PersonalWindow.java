package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Данный класс является личным кабинетом для авторизованных пользователей.
 * @author Кузнецов Михаил Пи19-4
 */
public class PersonalWindow {
    /**
     * Конструктор, в котором присваивается новое окно для scene, в этом окне содержится личнный кабинет для авторизованных пользователей.
     * @throws IOException Ошибка ввода-вывода
     */
    public PersonalWindow() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample1.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Личный кабинет");
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
