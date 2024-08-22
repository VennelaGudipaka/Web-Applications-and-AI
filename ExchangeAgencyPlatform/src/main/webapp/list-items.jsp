<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.assignment.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Items</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        img {
            max-width: 100px;
            height: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>My Items</h1>
        <c:choose>
            <c:when test="${empty items}">
                <p>You have no items.</p>
            </c:when>
            <c:otherwise>
                <table border="1">
                    <tr>
                        <th>ITEM ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Brand</th>
                        <th>RAM</th>
                        <th>Model</th>
                        <th>Size</th>
                        <th>Color</th>
                        <th>Type</th>
                        <th>Description</th>
                        <th>Condition</th>
                        <th>Photo</th>
                    </tr>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.category}</td>
                            <td>${item.brand}</td>
                            <td>${item.ram}</td>
                            <td>${item.model}</td>
                            <td>${item.size}</td>
                            <td>${item.color}</td>
                            <td>${item.type}</td>
                            <td>${item.description}</td>
                            <td>${item.condition}</td>
                            <td><img src="${item.photo}" alt="${item.name}"></td>
                            <td><a href="EditItemServlet?id=${item.id}" class="edit-button">Edit</a></td>
                            <td> <a href ="delete-item?id=${item.id}" class ="delete">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="index.jsp" class="back-link">Back to Home</a>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
