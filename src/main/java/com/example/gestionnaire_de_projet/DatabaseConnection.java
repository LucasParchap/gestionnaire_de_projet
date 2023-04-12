package com.example.gestionnaire_de_projet;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseConnection {


    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "gestionnaire_de_projet";
        String databaseUser = "root"; //root
        String databasePassword = ""; //gestionnaire_de_projet2023!
        String url = "jdbc:mysql://localhost:3306/" + databaseName;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }

}
