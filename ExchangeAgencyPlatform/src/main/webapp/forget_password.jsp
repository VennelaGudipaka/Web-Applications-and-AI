<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
</head>
<body>
    <h2>Forgot Password</h2>
    <form action="forgot_password" method="post">
        <label for="email">Email Address:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <input type="submit" value="Submit">
    </form>
    <c:if test="${param.error != null}">
        <p style="color: red;">${param.error}</p>
    </c:if>
</body>
</html>
