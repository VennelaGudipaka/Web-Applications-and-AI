<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mary's Exchange Agency</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f8ff;
        }
        header {
            background-color: #4a90e2;
            color: #ffffff;
            padding: 15px 0;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        nav ul {
            padding: 0;
            list-style: none;
            background-color: #2c3e50;
            margin: 0;
            text-align: center;
        }
        nav ul li {
            display: inline;
            margin: 0;
        }
        nav ul li a {
            display: inline-block;
            color: #ffffff;
            text-decoration: none;
            padding: 15px 20px;
            font-weight: bold;
        }
        nav ul li a:hover {
            background-color: #34495e;
            border-radius: 5px;
        }
        .container {
            width: 85%;
            margin: auto;
            overflow: hidden;
        }
        .main-content {
            padding: 30px;
            background-color: #ffffff;
            margin: 20px 0;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .footer {
            text-align: center;
            padding: 15px;
            background-color: #4a90e2;
            color: #ffffff;
            margin-top: 20px;
            box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
        }
        .footer a {
            color: #ffffff;
            text-decoration: none;
            font-weight: bold;
        }
        .footer {
    background-color: #4a4a4a;
    padding: 20px;
    position: relative; /* This allows absolute positioning inside the footer */
    text-align: center; /* Center text in the footer */
}

.footer .logout-button {
    position: absolute;
    top: 10px; /* Distance from the top */
    right: 10px; /* Distance from the right */
    background-color: #007bff;
    color: white;
    border: none;
    padding: 10px 15px;
    border-radius: 4px;
    text-decoration: none;
    font-size: 16px;
}

.footer .logout-button:hover {
    background-color: #0056b3;
}

        .about-section {
            background-color: #eaf1f8;
            border-radius: 8px;
            padding: 20px;
            margin-top: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .about-section h2 {
            color: #2c3e50;
        }
        .about-section p {
            color: #555555;
            line-height: 1.6;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Mary's Exchange Agency</h1>
    </header>

    <div class="container">
        <nav>
            <ul>
                <li><a href="add-listing.jsp">Add Listing</a></li>
                <li><a href="list-items">List Items</a></li>
                <li><a href="view-request">View Exchange Requests</a></li>
                <li><a href="create-exchange-request.jsp">Create Exchange</a></li>
                <li><a href="view-items">Interest</a></li>
                <li><a href="classifyItem.jsp">Classify Item</a></li>
            </ul>
        </nav>

        <div class="main-content">
            <h2>Explore Our Services</h2>
            <p>Use the links above to navigate to the respective services.</p>

            <div class="about-section">
                <h2>About Mary's Exchange Agency</h2>
                <p>Mary's Exchange Agency is dedicated to providing a seamless platform for individuals to exchange items they no longer need for items they find valuable. Founded on the principles of sustainability and community, our agency aims to make item exchanges simple and efficient.</p>
                <p>Whether you're looking to swap electronics, clothing, or even offer services, our platform connects you with other users to facilitate mutually beneficial exchanges. Our user-friendly interface and secure transaction system ensure a smooth experience for all parties involved.</p>
                <p>Thank you for being a part of our community and helping us make the world a little greener, one exchange at a time.</p>
            </div>
        </div>
    </div>

    <footer class="footer">
        <p>© 2024 Mary's Exchange Agency. All rights reserved.<a href="#">Privacy policy</a></p>
        <a href="logout.jsp" class="logout-button">Logout</a>
    </footer>
    
</body>
</html>
