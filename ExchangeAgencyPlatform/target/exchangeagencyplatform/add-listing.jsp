<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Listing</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-group input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        .form-group input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Listing</h2>
        <form action="add-listing" method="post">
            <div class="form-group">
                <label for="category">Category</label>
                <select name="category" id="category" required>
                    <option value="">Select Category</option>
                    <option value="Furniture">Furniture</option>
                    <option value="Clothing">Clothing</option>
                    <option value="Electronics">Electronics</option>
                </select>
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" name="itemName" id="name" placeholder="Name" required />
            </div>
            <div class="form-group">
                <label for="brand">Brand</label>
                <input type="text" name="brand" id="brand" placeholder="Brand" required />
            </div>
            <div class="form-group">
                <label for="ram">RAM</label>
                <input type="text" name="ram" id="ram" placeholder="RAM" />
            </div>
            <div class="form-group">
                <label for="model">Model</label>
                <input type="text" name="model" id="model" placeholder="Model" />
            </div>
            <div class="form-group">
                <label for="size">Size</label>
                <input type="text" name="size" id="size" placeholder="Size" />
            </div>
            <div class="form-group">
                <label for="color">Color</label>
                <input type="text" name="color" id="color" placeholder="Color" />
            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <input type="text" name="type" id="type" placeholder="Type" />
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="description" id="description" placeholder="Description" />
            </div>
            <div class="form-group">
                <label for="condition">Condition</label>
                <input type="text" name="condition" id="condition" placeholder="Condition" />
            </div>
            <div class="form-group">
                <label for="photo">Photo URL</label>
                <input type="text" name="photo" id="photo" placeholder="Photo URL" />
            </div>
            <div class="form-group">
                <input type="submit" value="Add Item" />
            </div>
        </form>
    </div>
</body>
</html>
