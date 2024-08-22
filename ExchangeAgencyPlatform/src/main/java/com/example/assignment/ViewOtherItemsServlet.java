package com.example.assignment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewOtherItemsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session ==null||session.getAttribute("userId")==null){
            response.sendRedirect("login.jsp");
        }
        int userId = (Integer) session.getAttribute("userId");
        ItemDAO itemDAO=new ItemDAO();

        List<Item> items = itemDAO.getAllItemsExcludingUser(userId);
        request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view-items.jsp");
        dispatcher.forward(request, response);
    }
}
