<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Shoppy | Admin | Add Item </title>
</head>
<body>
<form action="item" method="post">
    <input type="hidden" name="action" value="addItem">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required><br>
    <label for="category">Category ID:</label>
    <input type="text" id="category" name="category" required><br>
    <button type="submit">Add Item</button>
</form>

</body>
</html>