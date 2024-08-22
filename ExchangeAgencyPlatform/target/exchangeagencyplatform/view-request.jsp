<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Exchange Requests</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1000px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .actions {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Exchange Requests</h1>
    
    <table>
        <thead>
            <tr>
                <th>Request ID</th>
                <th>Item From</th>
                <th>Item To</th>
                <th>User From</th>
                <th>User To</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="request" items="${exchangeRequests}">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.itemIdFrom}</td>
                    <td>${request.itemIdTo}</td>
                    <td>${request.userIdFrom}</td>
                    <td>${request.userIdTo}</td>
                    <td>${request.status}</td>
                    <td class="actions">
                        <a href="update-request.jsp?id=${request.id}" class="update-button">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="index.jsp" class="back-link">Back to Home</a>
</div>

</body>
</html>
