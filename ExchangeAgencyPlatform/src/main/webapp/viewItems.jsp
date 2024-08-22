<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        /* General body styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        /* Header styling */
        h1 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        /* Success message styling */
        .message {
            background-color: #d4edda;
            color: #155724;
            padding: 15px;
            border: 1px solid #c3e6cb;
            border-radius: 5px;
            margin: 20px auto;
            max-width: 600px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>HOO..!! YOU ARE INTERESTED </h1>
    
    <!-- Display success message if it exists -->
    <c:if test="${not empty sessionScope.message}">
        <div class="message">
            <p>${sessionScope.message}</p>
        </div>
        <!-- Remove message after displaying -->
        <c:remove var="message" scope="session"/>
        <!-- Redirect to view-items.jsp after a short delay -->
        <script type="text/javascript">
            // Set a timeout to redirect after 2 seconds
            setTimeout(function() {
                window.location.href = "view-items";
            }, 2000); // 2000 milliseconds = 2 seconds
        </script>
    </c:if>
    
    <!-- Other content here -->
</body>
</html>
