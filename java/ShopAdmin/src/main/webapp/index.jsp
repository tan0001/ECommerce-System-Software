<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Shoppy | Admin | Log In </title>
</head>
<body>

	<h2>Login</h2>
	<form action="login.jsp" method="post">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username">
		<br><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password">
		<br><br>
		<input type="submit" value="Login">
	</form>
	
	Not registered yet? <a href="register.jsp">Register now!</a>
	
	<span style="color: red;">${errorMessage}</span>

</body>
</html>