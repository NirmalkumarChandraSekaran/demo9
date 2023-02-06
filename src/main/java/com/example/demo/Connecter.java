package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecter {

    public Connection getConnection()
    {
        Connection connection=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","12345");


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }


        return connection;
    }
}
