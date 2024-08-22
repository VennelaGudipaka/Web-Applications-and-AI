<!DOCTYPE html>
<html>
<head>
    <title>Create Exchange Request</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            width: 100%;
            margin: auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], select {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
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
    <h1>Create Exchange Request</h1>
    <form action="createExchangeRequest" method="post">
        <label for="item_id_from">Item ID From:</label>
        <input type="text" id="item_id_from" name="item_id_from" required><br>

        <label for="item_id_to">Item ID To:</label>
        <input type="text" id="item_id_to" name="item_id_to" required><br>

        <label for="user_id_from">User ID From:</label>
        <input type="text" id="user_id_from" name="user_id_from" required><br>

        <label for="user_id_to">User ID To:</label>
        <input type="text" id="user_id_to" name="user_id_to" required><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="Pending">Pending</option>
            <option value="Accepted">Accepted</option>
            <option value="Rejected">Rejected</option>
        </select><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
