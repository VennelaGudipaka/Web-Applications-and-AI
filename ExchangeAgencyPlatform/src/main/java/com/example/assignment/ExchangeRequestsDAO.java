package com.example.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRequestsDAO {
	private static final String DB_URL = "jdbc:sqlite:C:\\db\\items.db";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    // Method to create an exchange request
    public int createExchangeRequest(int itemIdFrom, int itemIdTo, int userIdFrom, int userIdTo) throws SQLException {
        int rows=0;
        String query = "INSERT INTO exchange_requests (item_id_from, item_id_to, user_id_from, user_id_to, status) VALUES (?, ?, ?, ?, 'Pending')";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, itemIdFrom);
            statement.setInt(2, itemIdTo);
            statement.setInt(3, userIdFrom);
            statement.setInt(4, userIdTo);
           rows= statement.executeUpdate();

        }
        return rows;
    
    }

    // Method to get exchange requests by user ID
    public static List<Exchange> getRequestsByUserId(int userId) throws SQLException {
        List<Exchange> requests = new ArrayList<>();
        String query = "SELECT * FROM exchange_requests WHERE user_id_to = ? OR user_id_from = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Exchange request = new Exchange(
                        resultSet.getInt("id"),
                        resultSet.getInt("item_id_from"),
                        resultSet.getInt("item_id_to"),
                        resultSet.getInt("user_id_from"),
                        resultSet.getInt("user_id_to"),
                        resultSet.getString("status")
                    );
                    requests.add(request);
            }
        }
            
        System.out.println("REQUEST:ERDAO:"+requests);
        return requests;
    }
    }

    // Method to update the status of an exchange request
    public static int updateRequestStatus(int requestId, String status) throws SQLException {
        String query = "UPDATE exchange_requests SET status = ? WHERE id = ?";
        System.out.println("INSIDE UPDATE REQUEST");
        int rowsUpdated = 0;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

           
            
            statement.setString(1, status); // Set the status parameter
            statement.setInt(2, requestId); // Set the requestId parameter

            rowsUpdated = statement.executeUpdate();
            
           
            if (rowsUpdated > 0) {
                System.out.println("Update successful: " + query);
            } else {
                System.out.println("Update failed: " + query);
            }
        } catch (SQLException e) {
            // Print the SQL exception details
            e.printStackTrace();
        }

        return rowsUpdated;
    }


}