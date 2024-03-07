package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

//        String url = jdbc:mysql:student;
        String url = "jdbc:mysql://localhost:3306/student";
        String userName = "root";
        String password = "root";
        String sql = "SELECT * from student.student";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        System.out.println("ID: " + resultSet.getInt(1));
        System.out.println("Name: " + resultSet.getString(2));
        System.out.println("Age: " + resultSet.getInt(3));

        String sql2 = "insert into student.student values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Kiran");
        preparedStatement.setInt(3, 25);
        preparedStatement.execute();

        connection.close();

    }
}