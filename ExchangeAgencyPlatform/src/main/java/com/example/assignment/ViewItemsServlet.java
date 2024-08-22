package com.example.assignment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewItemsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // ItemDAO itemDAO = new ItemDAO();
        try {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            List<Item> items = ItemDAO.getAllItems(userId);
            request.setAttribute("items", items);
            request.getRequestDispatcher("/WEB-INF/jsp/viewItems.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error occurred.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
