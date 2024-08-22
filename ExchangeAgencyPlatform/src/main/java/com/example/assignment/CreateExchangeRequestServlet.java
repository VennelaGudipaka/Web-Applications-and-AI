package com.example.assignment;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateExchangeRequestServlet extends HttpServlet {

    // Database connection details (replace with your actual details)
    private static final String DB_URL = "jdbc:sqlite:C:\\db\\items.db";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from request
            String itemIdFromStr = request.getParameter("item_id_from");
            String itemIdToStr = request.getParameter("item_id_to");
            String userIdFromStr = request.getParameter("user_id_from");
            String userIdToStr = request.getParameter("user_id_to");
            String status = request.getParameter("status");

            // Validate and parse parameters
            int itemIdFrom = parseParameter(itemIdFromStr);
            int itemIdTo = parseParameter(itemIdToStr);
            int userIdFrom = parseParameter(userIdFromStr);
            int userIdTo = parseParameter(userIdToStr);

            // Ensure status is valid
            if (status == null || !status.matches("Pending|Accepted|Rejected")) {
                throw new IllegalArgumentException("Invalid status");
            }

            // Save exchange request to the database
            saveExchangeRequest(itemIdFrom, itemIdTo, userIdFrom, userIdTo, status);

            // Redirect to the view requests page
            response.sendRedirect("index.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the error for debugging
            response.sendRedirect("error.jsp?error=Invalid input");
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); // Log the error for debugging
            response.sendRedirect("error.jsp?error=" + e.getMessage());
        }
    }

    private int parseParameter(String parameter) throws NumberFormatException {
        if (parameter == null || parameter.trim().isEmpty()) {
            throw new NumberFormatException("Parameter is empty or null");
        }
        return Integer.parseInt(parameter);
    }

    private void saveExchangeRequest(int itemIdFrom, int itemIdTo, int userIdFrom, int userIdTo, String status) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish a database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a SQL insert statement
            String sql = "INSERT INTO exchange_requests (item_id_from, item_id_to, user_id_from, user_id_to, status) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Set parameters for the prepared statement
            statement.setInt(1, itemIdFrom);
            statement.setInt(2, itemIdTo);
            statement.setInt(3, userIdFrom);
            statement.setInt(4, userIdTo);
            statement.setString(5, status);

            // Execute the insert statement
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Log the error for debugging
            // Handle the exception (e.g., log it, send an error response)
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log the error for debugging
            }
        }
    }
}

