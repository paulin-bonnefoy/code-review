package fr.takima.codereview.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "takima";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(
                    DB_CONNECTION,
                    DB_USER,
                    DB_PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}