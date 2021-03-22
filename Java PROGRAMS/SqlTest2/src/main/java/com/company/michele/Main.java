package com.company.michele;

import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/kursach_db"; //Ссылка на таблицу

    private static final String  user_name = "michele"; //Имя пользователя

    private static final String user_password = "michele19"; // пароль от пользователя

    private static Connection connection;  // Коннект к бд

    private static Statement statement; //statement - объект, который умеет отправлять запросы к бд

    private static ResultSet resultSet; // Результат запросов

    private static ResultSetMetaData resultSetMetaData; //Содержит информацию о результирующей таблице - количество колонок, тип значений колонок и т.д.

    public static void main(String[] args) {
        String query1 = "Select * from authors";
        //String insert = "Insert Into authors(id_author,surname,name,last_name, telephone_number) VALUES(2,'Иванов', 'Михаил', 'Алексеевич',79034560987)";
        try {
            connection = DriverManager.getConnection(url,user_name,user_password); // Коннект к бд ( DriverManager - ищет есть ли драйвер для подключения к бд)
            statement = connection.createStatement(); // Мы создали доступ к запросам
            //statement.executeUpdate(insert);
            resultSet = statement.executeQuery(query1);// Создали доступ к полю вывода нашего запроса, который мы послали в executeQuery ( execute - не меняем содержимое данных в бд)
            resultSetMetaData = resultSet.getMetaData(); // Передаем метаданные из Таблицы результата в ResultSetMetaData
            int columns = resultSetMetaData.getColumnCount(); //Показываем сколько всего столбцов в таблице
            int rownum = 1;
            //System.out.println(columns);
            while (resultSet.next()){
                System.out.println("Cтpокa : " + rownum++);

                for (int i = 1; i <= columns; i++) {
                    System.out.println("\tColumnLabel : '" + resultSetMetaData.getColumnLabel (i) + "', " +
                            "\tDisplaySize : " + resultSetMetaData.getColumnDisplaySize (i) + ", " +
                            "\tColumnType  : '" + resultSetMetaData.getColumnType (i) + "', " + // тип значения в указанном столбце
                            resultSet.getObject(i) + ", "); // само значение в столбце
                }
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //close connection ,stmt and resultset here ЗАкрываем процессы - потоки
            try {
                connection.close();
            }
            catch(SQLException se) {
            }

            try {
                statement.close();

            }
            catch(SQLException se) {
            }
            try {
                resultSet.close();
            }
            catch(SQLException se) {

            }
        }
    }
}
