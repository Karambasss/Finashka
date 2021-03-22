package com.company.michele;

import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/my_db"; //Ссылка на таблицу

    private static final String  user_name = "michele"; //Имя пользователя

    private static final String user_password = "michele19"; // пароль от пользователя

    private static Connection connection; // Коннект к бд

    private static Statement statement; // Утверждение для запросов

    private static ResultSet resultSet; // Результат запросов

    private static ResultSetMetaData rsmd; //Содержит информацию о результирующей таблице - количество колонок, тип значений колонок и т.д.

    public static void main(String[] args) {
        //Селекты в джава
        //String query1 = "select count(*) from users_test";  // Первый запроc (Про кол-во строк в таблице)
        String query2 = "select * from users_test";
        //ИНСЕРТ В ДЖАВА
        //String insert_query = "Insert Into my_db.users_test VALUES(3,'Andrey','Andreev','Nemansky,Strogino')";
        //DELETE в ДЖАВА
        //String delete_query = "DELETE FROM users_test WHERE name = 'Alexei'";
        //UPDATE в ДЖАВА
        //String update_query = "Update users_test Set Name = 'VANYA' Where id_users_test = 3";
        try {
            connection = DriverManager.getConnection(url,user_name,user_password); // Коннект к бд ( DriverManager - ищет есть ли драйвер для подключения к бд)
            statement = connection.createStatement(); // Мы создали доступ к запросам
            //statement - объект, который умеет отправлять запросы к бд
            //statement.executeUpdate(insert_query); Инсерт для джавы (UPDATE - обновляем содержимое бд)
            //int ans = statement.executeUpdate(delete_query); // Delete для джавы - 0 в Update  - это когда ничего не удалось обновить и ни одна строка не поменялась, 1 - кол-во строк, которые поменялись
            //System.out.println(ans);
            //statement.executeUpdate(update_query); // Update для джавы
            //resultSet - только для селектов
            resultSet = statement.executeQuery(query2); // Создали доступ к полю вывода нашего запроса, который мы послали в executeQuery ( execute - не меняем содержимое данных в бд)
            rsmd = resultSet.getMetaData(); // Передаем метаданные из Таблицы результата в ResultSetMetaData
            int columns = rsmd.getColumnCount(); //Показываем сколько всего столбцов в таблице
            int rownum = 1;
            System.out.println(columns);
            while (resultSet.next()){
                System.out.println("Cтpокa : " + rownum++);

                for (int i = 1; i <= columns; i++) {
                    System.out.println("\tColumnLabel : '" + rsmd.getColumnLabel (i) + "', " +
                            "\tDisplaySize : " + rsmd.getColumnDisplaySize (i) + ", " +
                            "\tColumnType  : '" + rsmd.getColumnType (i) + "', " + // тип значения в указанном столбце
                            resultSet.getObject(i) + ", "); // само значение в столбце
                }
            }
            // Дальше мы показываем  то что дает нам запрос
            while (resultSet.next()){ // цикл идет по каждой строке таблицы, возвращаемой в результате запроса!!!
                int id  = resultSet.getInt(1); // покажи что находится в 1 столбце
                String name = resultSet.getString(2);
                String surname =resultSet.getString(3);
                String adress =resultSet.getString(4);
                System.out.println("ID = " + id + " Name = " + name + " Surname = " + surname + " Adress = " + adress);
                //int id = resultSet.getInt(1); // просто выдает вам результат выполнения select count(*) from ... ( там будет 1 запись и resultSet.getInt(1) пойдет в 1 столбец и присвоит это значение в 1 столбце в поле айди )
                //System.out.println("Количество записей в таблице: "  + id);
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //Выполняется всегда чтобы закрыть коннект утверждения и результаты запросов
        finally {
            //close connection ,stmt and resultset here
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
