package org.maney.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseInitializer {

    public static void connect(String configFilePath) {
        System.out.println("Connecting to database");

        try {
            FileInputStream propsInput = new FileInputStream(configFilePath);
            final Properties props = new Properties();
            props.load(propsInput);
            final String url = props.getProperty("db_url");

            Connection db = DriverManager.getConnection(url, props);

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM income");

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            if(e instanceof IOException) {
                System.err.println("Failed to load database config file " + configFilePath);
            }

            if(e instanceof SQLException) {
                System.err.println("Failed to connect to database");
                System.err.println(e.getMessage());
            }

            System.err.println(e.getMessage());
        }
    }
}
