package com.example.assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteItemServlet extends HttpServlet {
    private ItemDAO itemDAO;

    @Override
    public void init() {
        itemDAO = new ItemDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            try {
                itemDAO.deleteItem(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("list-items"); // Redirect to list-items page after deletion
    }
}
