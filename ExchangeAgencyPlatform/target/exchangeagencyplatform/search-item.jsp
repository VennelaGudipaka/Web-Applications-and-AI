<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Item</title>
</head>
<body>
    <h1>Search Item by ID</h1>
    <form action="update-listing" method="get">
        <label for="id">Item ID:</label>
        <input type="text" id="id" name="id"/>
        <input type="submit" value="Search"/>
    </form>
    <p><%= request.getAttribute("message") %></p>
</body>
</html>
