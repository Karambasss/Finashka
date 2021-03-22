package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.w3c.dom.Text;

import java.sql.*;

public class Controller {
    private static final String url = "jdbc:mysql://localhost:3306/kursach_db"; //Ссылка на таблицу

    private static final String  user_name = "michele"; //Имя пользователя

    private static final String user_password = "michele19"; // пароль от пользователя

    private static Connection connection;  // Коннект к бд

    private static Statement statement; //statement - объект, который умеет отправлять запросы к бд

    private static ResultSet resultSet; // Результат запросов

    private static ResultSetMetaData resultSetMetaData; //Содержит информацию о результирующей таблице - количество колонок, тип значений колонок и т.д.

    @FXML
    private TextField surname;
    @FXML
    private Button submit;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TableView tableView;
    @FXML
    private TextArea textBD;

    public void Submit_click(){
        try{
            name.getText();
            Integer.parseInt(age.getText());
            surname.getText();
        }
        catch (Exception ex ){
            System.out.println("error format");
            return;
        }
        String name1 = name.getText();
        int age1 = Integer.parseInt(age.getText());
        String surname1 = surname.getText();
        Users users = new Users(name1,age1,surname1);
        if (users.locker){
            String query1 = "Insert Into test_table(name,age,surname) Values(" + "'" + name1 + "'," + age1 +  ",'" + surname1 + "');";
            try {
                connection = DriverManager.getConnection(url,user_name,user_password);
                statement = connection.createStatement();
                statement.executeUpdate(query1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Все прошло успешно, ваши данные успешно занесены");
                alert.showAndWait();
                //resultSet = statement.executeQuery(query2);
                //resultSetMetaData = resultSet.getMetaData();

            /*
            if (!resultset.next()){
                alert никаких данных
            }
            else {
                while (resultset.next) {
                    textfield.settext(+ \n)
                }
            }
            */

            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void Select_click(){

        String Select_query = " Select * " +
                              "from test_table ";

        try {
            connection = DriverManager.getConnection(url,user_name,user_password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(Select_query);

            if ( !(resultSet.next()) ){ // Если резалтсет пустой, (то есть, если next не встретил ничего в бд
                Alert alert = new Alert(Alert.AlertType.ERROR, "Где данные, Лебовски?");
                return;
            }
            else {
                while (resultSet.next()){
                    //((((Получаем наши данные)))
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int age = resultSet.getInt(3);
                    String surname = resultSet.getString(4);

                    //Получаем содержимое текстареи и проводим дозапись туда

                     textBD.setText(textBD.getText() + "id: " +  id + ", name: " + name + ", age: " + age + ", surname: " + surname + '\n');

                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Готова БД по указанной таблице");
                alert.showAndWait();
            }


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
