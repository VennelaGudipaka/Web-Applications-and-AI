package com.example.assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;


public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String errorMessage = null;
        String successMessage = null;

        try {
            boolean registered = registerUser(username, password, email);
            if (registered) {
                successMessage = "Registration successful. You can now log in.";
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                errorMessage = "Registration failed. Please try again.";
            }
        } catch (SQLException e) {
            String sqlState = e.getSQLState();
            if (sqlState != null && sqlState.equals("23505")) { // Example SQL State for unique violation
                request.setAttribute("errorMessage", "Username already exists.");
            } else {
                request.setAttribute("errorMessage", "Database error occurred. Please try again."+e.getMessage());
            }
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "An unexpected error occurred. Please try again.";
        }

        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("successMessage", successMessage);

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
    
    private boolean registerUser(String username, String password, String email) throws SQLException {
        boolean success = false;
        String hashedPassword = hashPassword(password);

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");


            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, email);

            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0;
        }finally{
            System.out.println("Hello");
        }
        return success;
    }
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

}
