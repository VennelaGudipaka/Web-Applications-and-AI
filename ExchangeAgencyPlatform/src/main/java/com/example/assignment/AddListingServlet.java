package com.example.assignment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddListingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorMessage1", null);
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        
        String itemName = request.getParameter("itemName");
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String ram = request.getParameter("ram");
        String model = request.getParameter("model");
        String size = request.getParameter("size");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String condition = request.getParameter("condition");
        String photo = request.getParameter("photo");

        int itemId= ItemDAO.addItem(itemName,category,brand,ram,model,size,color,type,description,condition,photo);{
        UsersItemsDAO.addUserItem(itemId,userId);
        List<Item> itemList=null;
        try {
            itemList = ItemDAO.getAllItems(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("items", itemList);
        request.getRequestDispatcher("list-items.jsp").forward(request, response);
    }

    }
}

