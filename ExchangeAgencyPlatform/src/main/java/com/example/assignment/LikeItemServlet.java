package com.example.assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LikeItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId"); // Assuming userId is stored in session
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        UsersItemsDAO userItemsDAO = new UsersItemsDAO();
        userItemsDAO.addLikedItem(userId, itemId);
        request.getSession().setAttribute("message", "You have expressed interest successfully.");

        // Redirect to index.jsp
        //response.sendRedirect("index.jsp");
        response.sendRedirect("viewItems.jsp"); // Redirect back to the list of items
    }
}
