package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends Application {

    Stage mainWindow; // Наше главное окно
    Scene scene1, scene2;

    public static void print(){
        System.out.println("Ok!");
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        mainWindow = primaryStage;
        Label mylbl = new Label("Fisrt Stage!");
        Button btn1 = new Button("Scene 2");


        mylbl.setOnMouseClicked(mouseEvent -> mainWindow.setScene(scene2));

        btn1.setOnAction(event -> mainWindow.setScene(scene2)); // При нажатии на кнопку.
        Button btn2 = new Button("Back to scene 1");
        btn2.setOnAction(event -> mainWindow.setScene(scene1));

        //Первая сцена - вертикальный VBox
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(mylbl, btn1);
        scene1 = new Scene(vBox, 300, 500);

        //Вторая сцена - Stack pane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(btn2);
        scene2 = new Scene(stackPane, 300, 600);

        mainWindow.setScene(scene1);
        mainWindow.setTitle("My Title!");
        mainWindow.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}