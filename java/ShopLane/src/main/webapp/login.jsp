<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Log In </title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>Log In</h2>
	<form action="login" method="post">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username">
		<br><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password">
		<br><br>
		<input type="submit" value="Login">
	</form>
	
	<span style="color: red;">${errorMessage}</span>
<%@ include file="footer.html"%>
</body>
</html>