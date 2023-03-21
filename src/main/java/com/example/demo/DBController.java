package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {
    private final static String url = "jdbc:mysql://localhost:3306/db_example";
    private final static String username = "root";
    private final static String password = "root";
    private static Connection CONNECTION = null;
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            CONNECTION = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to Store DB succesfull!");
        } catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

        try {
            Statement statement = CONNECTION.createStatement();
            statement.executeUpdate(
                    "create table names(id int primary key not null, " +
                                            "name varchar(32) default '' not null )"
            );

        }catch (SQLException e) {

        }
    }
}
