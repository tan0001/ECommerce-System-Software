<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.admin.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoppy | Admin | View User</title>
</head>
<body>
<h2>Products</h2>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Shipping Address</th>
            <th>Image</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null) {
                for (User user : users) {
        %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getFirst() %></td>
                        <td><%= user.getLast() %></td>
                        <td><%= user.getAddress() %></td>
                        <td><%= user.getImage() %></td>
                    </tr>
        <%
                }
            } 
        %>
    </tbody>
</table>
</body>
</html>
