package com.example.assignment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItemsServlet extends HttpServlet {

   // private ItemDAO itemDAO = new ItemDAO(); // Create an instance of ItemDAO

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> itemList = new ArrayList<Item>();
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        try {
            itemList = ItemDAO.getAllItems(userId); // Fetch items from the database
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Unable to fetch items from the database.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        if (itemList.isEmpty()) {
            request.setAttribute("message", "No items found.");
        }

        request.setAttribute("items", itemList);
        request.getRequestDispatcher("list-items.jsp").forward(request, response);
    }
}
