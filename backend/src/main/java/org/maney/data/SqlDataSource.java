package org.maney.data;

import java.sql.*;
import java.util.Properties;

public abstract class SqlDataSource {
    private final String dataSourceUrl;
    private final Properties dataSourceProps;

    public SqlDataSource(String dataSourceUrl, Properties dataSourceProps) {
        this.dataSourceUrl = dataSourceUrl;
        this.dataSourceProps = dataSourceProps;
    }

    public void executeStatement(String statementString) throws SQLException {
        Connection db = null;

        try {
            db = DriverManager.getConnection(dataSourceUrl, dataSourceProps);

            PreparedStatement prepareStatement = db.prepareStatement(statementString);

            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs);
            }

            rs.close();
            prepareStatement.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        } finally {
            if(db != null) {
                try {
                    db.close();
                } catch (SQLException closeEx) {
                    System.err.println("Connection could not be closed");
                    System.err.println(closeEx.getMessage());
                }
            }
        }
    }
}
