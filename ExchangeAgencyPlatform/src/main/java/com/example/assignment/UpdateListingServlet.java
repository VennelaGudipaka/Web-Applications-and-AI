package com.example.assignment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateListingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
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

        if (idStr == null || idStr.isEmpty()) {
            request.setAttribute("errorMessage", "Invalid item ID. Please try again.");
            request.getRequestDispatcher("update-listing.jsp").forward(request, response);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid item ID format. Please try again.");
            request.getRequestDispatcher("update-listing.jsp").forward(request, response);
            return;
        }

        // Create an Item object with the updated values
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setCategory(category);
        item.setBrand(brand);
        item.setRam(ram);
        item.setModel(model);
        item.setSize(size);
        item.setColor(color);
        item.setType(type);
        item.setDescription(description);
        item.setCondition(condition);
        item.setPhoto(photo);

        // Call the DAO method to update the item in the database
        boolean updateSuccessful = ItemDAO.updateItem(item);

        if (updateSuccessful) {
            response.sendRedirect("list-items");
        } else {
            request.setAttribute("item", item);
            request.setAttribute("errorMessage", "Update failed. Please try again.");
            request.getRequestDispatcher("update-listing.jsp").forward(request, response);
        }
    }
}
