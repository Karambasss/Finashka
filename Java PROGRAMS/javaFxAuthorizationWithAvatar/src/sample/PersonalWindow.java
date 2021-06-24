package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonalWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample1.fxml"));
        primaryStage.setTitle("Личный кабинет");
        primaryStage.setScene(new Scene(loader.load(),300,275));
        primaryStage.show();
    }
}
