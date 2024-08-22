package com.example.assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewRequestsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Integer userId = (Integer) session.getAttribute("userId");
            if (userId != null) {
                List<Exchange> exchangeRequests = getExchangeRequestById(userId);
                request.setAttribute("exchangeRequests", exchangeRequests);
                request.getRequestDispatcher("view-request.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp?error=You must log in first.");
            }
        } else {
            response.sendRedirect("login.jsp?error=Session expired.");
        }
    }
    
    private List<Exchange> getExchangeRequestById(int userId) {
        List<Exchange> requests = new ArrayList<>();
        String sql = "SELECT * FROM exchange_requests WHERE user_id_from = ? OR user_id_to = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            ResultSet resultSet = stmt.executeQuery();
    
            while (resultSet.next()) {
                Exchange request = new Exchange(
                    resultSet.getInt("id"),
                    resultSet.getInt("item_id_from"),
                    resultSet.getInt("item_id_to"),
                    resultSet.getInt("user_id_from"),
                    resultSet.getInt("user_id_to"),
                    resultSet.getString("status")
                  //  resultSet.getTimestamp("request_date")
                );
                requests.add(request);
            }
        } catch (SQLException e) {
          //  e.printStackTrace(); // Check for SQL errors
        e.getMessage();
        }
        System.out.println("Retrieved requests: " + requests.size()); // Debugging line
        return requests;
    }
    
    
}
