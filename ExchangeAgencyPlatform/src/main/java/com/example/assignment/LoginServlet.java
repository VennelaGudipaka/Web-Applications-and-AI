package com.example.assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Raw password

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT user_id, password FROM users WHERE username = ?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String storedHashedPassword = rs.getString("password");
                
                boolean isPasswordCorrect = PasswordUtils.checkPassword(password, storedHashedPassword);

                if (isPasswordCorrect) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", userId);
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("errorMessage", "Invalid username or password.");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Invalid username or password.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error occurred. Please try again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
