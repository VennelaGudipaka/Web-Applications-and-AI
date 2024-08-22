<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<%@ page import="com.example.assignment.ExchangeRequestsDAO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pending Exchange Requests</title>
</head>
<body>
    <h2>Pending Exchange Requests</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Request ID</th>
                <th>User ID</th>
                <th>Item ID</th>
                <th>Status</th>
                <th>Request Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                Connection connection = (Connection) application.getAttribute("dbConnection");
                ExchangeRequestsDAO dao = new ExchangeRequestsDAO(connection);
                ResultSet rs = dao.getPendingRequests();
                while (rs.next()) {
                    int requestId = rs.getInt("request_id");
                    int userId = rs.getInt("user_id");
                    int itemId = rs.getInt("item_id");
                    String status = rs.getString("status");
                    String requestDate = rs.getString("request_date");
            %>
            <tr>
                <td><%= requestId %></td>
                <td><%= userId %></td>
                <td><%= itemId %></td>
                <td><%= status %></td>
                <td><%= requestDate %></td>
                <td>
                    <form action="confirmExchange" method="post">
                        <input type="hidden" name="requestId" value="<%= requestId %>">
                        <input type="submit" value="Confirm">
                    </form>
                    <form action="rejectExchange" method="post">
                        <input type="hidden" name="requestId" value="<%= requestId %>">
                        <input type="submit" value="Reject">
                    </form>
                </td>
            </tr>
            <% 
                } 
                rs.close();
                connection.close();
            %>
        </tbody>
    </table>
</body>
</html>
