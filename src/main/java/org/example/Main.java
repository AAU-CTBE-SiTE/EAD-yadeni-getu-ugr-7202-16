package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentsDB";
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the MySQL database
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Connected successfully!");

            // 3. Create a statement
            Statement statement = connection.createStatement();

            // 4. Execute a query
            ResultSet result = statement.executeQuery(
                    "SELECT * FROM students"
            );

            // 5. Display student records
            while (result.next()) {
                System.out.println(
                        result.getInt("id") + " | " +
                                result.getString("firstname") + " | " +
                                result.getString("lastname") + " | " +
                                result.getInt("grade")
                );
            }

            // 6. Close resources
            result.close();
            statement.close();
            connection.close();

            System.out.println("Connection closed successfully!");

        } catch (Exception e) {
            System.out.println("Connection failed!");
            System.out.println("Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }
}