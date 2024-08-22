<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Items and Express Interest</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 1200px;
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
        button {
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>View Items and Express Interest</h1>
    
    <table>
        <thead>
            <tr>
                <th>Item ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Brand</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.category}</td>
                    <td>${item.brand}</td>
                    <td>${item.description}</td>
                    <td>
                        <form action="expressInterest" method="post" style="display:inline;">
                            <input type="hidden" name="item_id" value="${item.id}" />
                            <input type="hidden" name="user_id" value="${userId}" />
                            <button type="submit">Express Interest</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href="index.jsp">Back to Home</a>
</div>

</body>
</html>
