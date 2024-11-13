package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bus_management_data_temp";
    private static final String USER = "bus@admin";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}