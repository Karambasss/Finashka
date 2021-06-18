package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Данный класс является личным кабинетом для авторизованных пользователей.
 * @author Кузнецов Михаил Пи19-4
 */
public class PersonalWindow extends Application {
    /**
     * Данный метод настраивает и запускает javaFx.
     * @param primaryStage Главное окно приложения
     * @throws Exception Ошибка старта программы
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample1.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Личный кабинет");
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }
}
