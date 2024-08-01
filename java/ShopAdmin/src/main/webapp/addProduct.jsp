<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Shoppy | Admin | Add Product </title>
</head>
<body>
<form action="product" method="post">
    <input type="hidden" name="action" value="addProduct">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required><br>
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" required><br>
    <label for="item">Item ID:</label>
    <input type="text" id="item" name="item" required><br>
    <button type="submit">Add Item</button>
</form>

</body>
</html>