<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.admin.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoppy | Admin | View Product</title>
</head>
<body>
<h2>Products</h2>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Item ID</th>
            <th>Image</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null) {
                for (Product product : products) {
        %>
                    <tr>
                        <td><%= product.getId() %></td>
                        <td><%= product.getName() %></td>
                        <td><%= product.getDescription() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getItem() %></td>
                        <td><img src="<%= product.getImage() %>" width=200 height=200></td>
                    </tr>
        <%
                }
            } 
        %>
    </tbody>
</table>
</body>
</html>
