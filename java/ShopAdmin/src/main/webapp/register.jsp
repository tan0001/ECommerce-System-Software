<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Shoppy | Admin | Register </title>
</head>
<body>

	<h2>Register Admin User</h2>
	<form action="register" method="post">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username">
		<br><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password">
		<br><br>
		<input type="submit" value="Login">
	</form>
	
	<span style="color: red;">${errorMessage}</span>

</body>
</html>