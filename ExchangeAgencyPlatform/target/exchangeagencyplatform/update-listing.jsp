<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Item</title>
    <style>
        /* Add some basic styling for the form */
        .form-container {
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input, textarea, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            resize: vertical;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
        .submit-button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .submit-button:hover {
            background-color: #45a049;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group:last-child {
            margin-bottom: 0;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Edit Item</h1>

        <!-- Display an error message if present -->
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>

        <!-- Form to update item details -->
        <form action="update-listing" method="post">
            <!-- Hidden input to carry the item ID -->
            <input type="hidden" name="id" value="${item.id}">

            <!-- Input fields to edit item details -->
            <div class="form-group">
                <label for="name">Item Name:</label>
                <input type="text" id="name" name="name" value="${item.name}" required>
            </div>

            <div class="form-group">
                <label for="category">Category:</label>
                <select id="category" name="category" required>
                    <option value="" disabled>Select a category</option>
                    <option value="Furniture" <c:if test="${item.category == 'Furniture'}">selected</c:if>>Furniture</option>
                    <option value="Clothing" <c:if test="${item.category == 'Clothing'}">selected</c:if>>Clothing</option>
                    <option value="Electronics" <c:if test="${item.category == 'Electronics'}">selected</c:if>>Electronics</option>
                </select>
            </div>

            <div class="form-group">
                <label for="brand">Brand:</label>
                <input type="text" id="brand" name="brand" value="${item.brand}" required>
            </div>

            <div class="form-group">
                <label for="ram">RAM:</label>
                <input type="text" id="ram" name="ram" value="${item.ram}" required>
            </div>

            <div class="form-group">
                <label for="model">Model:</label>
                <input type="text" id="model" name="model" value="${item.model}" required>
            </div>

            <div class="form-group">
                <label for="size">Size:</label>
                <input type="text" id="size" name="size" value="${item.size}" required>
            </div>

            <div class="form-group">
                <label for="color">Color:</label>
                <input type="text" id="color" name="color" value="${item.color}" required>
            </div>

            <div class="form-group">
                <label for="type">Type:</label>
                <input type="text" id="type" name="type" value="${item.type}" required>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" required>${item.description}</textarea>
            </div>

            <div class="form-group">
                <label for="condition">Condition:</label>
                <input type="text" id="condition" name="condition" value="${item.condition}" required>
            </div>

            <div class="form-group">
                <label for="photo">Photo URL:</label>
                <input type="text" id="photo" name="photo" value="${item.photo}" required>
            </div>

            <input type="submit" value="Update Item" class="submit-button">
        </form>
    </div>
</body>
</html>
