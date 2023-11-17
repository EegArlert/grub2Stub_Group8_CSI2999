package com.example.grub2stub;
import java.sql.Connection;  // <-- Manually add this line
import java.sql.DriverManager;  // <-- And this line

public class DBConnector {

    static {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found");
            e.printStackTrace();
        }
    }
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:data.db"; // Replace with your DB name
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
