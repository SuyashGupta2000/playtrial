package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    private Connection connection;

    public SqlConnection() throws SQLException {
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle_details", "root", "password");
    }

    public Connection getConnection() {
        return connection;
    }
}