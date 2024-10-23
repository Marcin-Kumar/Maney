package org.maney.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseInitializer {

    public static void connect() {
        System.out.println("Hello world!");

        final String url = "jdbc:postgresql://localhost:5432/testdb";
        final Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");
        props.setProperty("ssl", "true");
        try {
            Connection db = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.out.println("Failed to connect to " + url);
            System.out.println(e.getMessage());
        }
    }
}
