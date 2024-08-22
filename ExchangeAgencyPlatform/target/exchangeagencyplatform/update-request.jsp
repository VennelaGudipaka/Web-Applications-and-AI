<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Exchange Request Status</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
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
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .back-link {
            display: block;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Update Exchange Request Status</h1>

    <form action="updateRequest" method="post">
        <input type="hidden" name="id" value="${param.id}">

        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Pending" ${requestScope.request.status == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="Accepted" ${requestScope.request.status == 'Accepted' ? 'selected' : ''}>Accepted</option>
                <option value="Rejected" ${requestScope.request.status == 'Rejected' ? 'selected' : ''}>Rejected</option>
            </select>
        </div>

        <button type="submit">Update Status</button>
    </form>

    <a href="view-request" class="back-link">Back to View Requests</a>
</div>

</body>
</html>
