<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Register </title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>Register User</h2>
	<form action="register" method="post">
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required>
		<br><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required>
		<br><br>
		<label for="first">First name:</label>
		<input type="text" id="first" name="first">
		<br><br>
		<label for="last">Last Name:</label>
		<input type="text" id="last" name="last">
		<br><br>
		<label for="address">Shipping Address:</label>
		<input type="text" id="address" name="address">
		<br><br>
		<label for="image">Profile Image URL:</label>
		<input type="text" id="image" name="image">
		<br><br>
		<input type="submit" value="Register New User">
	</form>
	
	<span style="color: red;">${errorMessage}</span>
<%@ include file="footer.html"%>
</body>
</html>