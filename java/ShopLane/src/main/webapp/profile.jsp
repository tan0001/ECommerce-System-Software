<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="shop.User" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User Profile</title>
<style>
/* Add styles for profile page */
.container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f4f4f4;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    margin-bottom: 20px;
}

.profile-details {
    font-size: 16px;
}

.profile-details p {
    margin: 10px 0;
}

</style>
</head>
<body>

<%@include file="header.jsp" %>
    <div class="container">
        <h1>User Profile</h1>
        <div class="profile-details">
        	<img src="<%= user.getImage() %>">
            <p><strong>Id:</strong> <%= user.getId() %></p>
            <p><strong>Email:</strong> <%= user.getEmail() %></p>
            <p><strong>Password:</strong> <%= user.getPassword() %></p>
            <p><strong>First Name:</strong> <%= user.getFirst() %></p>
            <p><strong>Last Name:</strong> <%= user.getLast() %></p>
            <p><strong>Shipping Address:</strong> <%= user.getAddress() %></p>
            
        </div>
    </div>
    <%@include file="footer.html" %>
</body>
</html>