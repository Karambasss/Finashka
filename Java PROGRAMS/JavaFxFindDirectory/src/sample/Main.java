package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Главный класс, который запускает javaFx и задает FXML
 * @author Кузнецов Михаил Пи19-4
 */
public class Main extends Application {
    /***
     * Данный метод настраивает и запускает javaFx.
     * @param primaryStage Главное окно приложения
     * @throws Exception Ошибка старта программы
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    /**
     * Основной метод, который вызывается при запуске программы.
     * @param args массив аргументов с которыми может запускаться программа.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
