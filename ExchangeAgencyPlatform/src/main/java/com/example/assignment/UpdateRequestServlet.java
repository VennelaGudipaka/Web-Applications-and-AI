package com.example.assignment;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String status = request.getParameter("status");
        if (idParam != null && !idParam.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                int exchangeRequest =     ExchangeRequestsDAO.updateRequestStatus(id, status);
             //   Exchange exchangeRequest = ExchangeRequestsDAO.getRequestsByUserId(id); // Ensure this method exists and returns an Exchange object
    
                if (exchangeRequest >0) {
                    request.setAttribute("request", exchangeRequest);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("update-request.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Request not found.");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request ID format.");
            } catch (SQLException e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Request ID is missing.");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String status = request.getParameter("status");

        if (idParam != null && !idParam.trim().isEmpty() && status != null && !status.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);

                if ("Pending".equals(status) || "Accepted".equals(status) || "Rejected".equals(status)) {
                    int rowsUpdated = ExchangeRequestsDAO.updateRequestStatus(id, status);
                    if (rowsUpdated > 0) {
                        request.setAttribute("request", rowsUpdated);
                        response.sendRedirect("view-request"); // Redirect to the view requests page
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Request not found.");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid status value.");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request ID format.");
            } catch (SQLException e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error while updating the request.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid input. ID and status are required.");
        }
    }
}
