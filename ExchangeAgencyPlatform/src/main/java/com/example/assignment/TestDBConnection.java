package com.example.assignment;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Connection established successfully!");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
