package com.example.assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditItemServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int itemId = Integer.parseInt(idParam);
                Item item = ItemDAO.getItemDetailsByItemId(itemId);
                if (item != null) {
                    request.setAttribute("item", item);
                    request.getRequestDispatcher("update-listing.jsp").forward(request, response);
                } else {
                    response.sendRedirect("list-items"); // Redirect if item not found
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("list-items"); // Redirect on error
            }
        } else {
            response.sendRedirect("list-items"); // Redirect if ID parameter is missing
        }
    }
}
