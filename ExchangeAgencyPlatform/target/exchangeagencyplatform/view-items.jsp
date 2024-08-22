<!-- view-all-items.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Items for Exchange</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        /* Sample inline CSS to style the items */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            padding: 20px;
        }
        .item-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .item {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin: 20px;
            padding: 20px;
            width: 300px;
        }
        .item-details {
            margin-bottom: 15px;
        }
        .item img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
        }
        form {
            text-align: center;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 2px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>All Items for Exchange</h1>
    <div class="item-container">
        <c:forEach var="item" items="${items}">
            <div class="item">
                <h2>${item.category}</h2>
                <div class="item-details">
                    <p><strong>Item ID:</strong> ${item.id}</p>
                    <p><strong>Name:</strong> ${item.name}</p>
                    <p><strong>Brand:</strong> ${item.brand}</p>
                    <p><strong>Model:</strong> ${item.model}</p>
                    <p><strong>RAM:</strong> ${item.ram}</p>
                    <p><strong>Size:</strong> ${item.size}</p>
                    <p><strong>Color:</strong> ${item.color}</p>
                    <p><strong>Type:</strong> ${item.type}</p>
                    <p><strong>Description:</strong> ${item.description}</p>
                    <p><strong>Condition:</strong> ${item.condition}</p>
                    <img src="${item.photo}" alt="${item.name}">
                    <a href="index.jsp" class="back-link">Back to Home</a>
                </div>
                <form action="likeItem" method="post">
                    <input type="hidden" name="itemId" value="${item.id}">
                    <input type="submit" value="Like">
                </form>
            </div>
        </c:forEach>
    </div>
</body>
</html>
