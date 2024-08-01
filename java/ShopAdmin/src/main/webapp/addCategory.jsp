<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Shoppy | Admin | Add Category </title>
</head>
<body>
<form action="category" method="post">
    <input type="hidden" name="action" value="addCategory">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required><br>
    <button type="submit">Add Category</button>
</form>

</body>
</html>