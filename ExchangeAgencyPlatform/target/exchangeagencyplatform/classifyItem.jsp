<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Item Classification Input</title>
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
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box; /* Ensures padding is included in total width/height */
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Enter Item Details</h1>
    <form action="classifyItem" method="post">
        <div class="form-group">
            <label for="category">Category:</label>
            <select name="category" id="category">
                <option value="Electronics">Electronics</option>
                <option value="Clothing">Clothing</option>
                <option value="Furniture">Furniture</option>
            </select>
        </div>

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="brand">Brand:</label>
            <input type="text" id="brand" name="brand">
        </div>

        <div class="form-group">
            <label for="ram">RAM:</label>
            <input type="text" id="ram" name="ram">
        </div>

        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" id="model" name="model">
        </div>

        <div class="form-group">
            <label for="size">Size:</label>
            <input type="text" id="size" name="size">
        </div>

        <div class="form-group">
            <label for="color">Color:</label>
            <input type="text" id="color" name="color">
        </div>

        <div class="form-group">
            <label for="type">Type:</label>
            <input type="text" id="type" name="type">
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" id="description" name="description">
        </div>

        <div class="form-group">
            <label for="condition">Condition:</label>
            <input type="text" id="condition" name="condition">
        </div>

        <input type="submit" value="Classify">
    </form>
</div>

</body>
</html>
