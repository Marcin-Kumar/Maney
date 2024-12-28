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

            _insertDummyValues(db);

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT name FROM income_categories");

            while (rs.next()) {
                System.out.println(rs.getArray(1));
            }

            rs.close();
            st.close();

            db.close();

        } catch (Exception e) {
            if (e instanceof IOException) {
                System.err.println("Failed to load database config file " + configFilePath);
            }

            System.err.println(e.getMessage());
        }
    }

    private static void _insertDummyValues(Connection db) throws SQLException {
        String insertCategorySqlString = "INSERT INTO income_categories (\n" +
                "    income_category_id,\n" +
                "    name\n" +
                ") VALUES( ?, ?)";
        PreparedStatement insertCategory = db.prepareStatement(insertCategorySqlString);

        insertCategory.setString(1, "71c96b9d-f788-4941-923a-aeb6b0a6bee2");
        insertCategory.setString(2, "category A");

        ResultSet rs = insertCategory.executeQuery();
        while (rs.next()) {
            System.out.println(rs);
        }

        rs.close();
        insertCategory.close();
    }
}
