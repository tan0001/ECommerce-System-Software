<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.admin.Item" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoppy | Admin | View Item</title>
</head>
<body>
<h2>Categories</h2>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Category ID</th>
            <th>Image</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Item> items = (List<Item>) request.getAttribute("items");
            if (items != null) {
                for (Item item : items) {
        %>
                    <tr>
                        <td><%= item.getId() %></td>
                        <td><%= item.getName() %></td>
                        <td><%= item.getDescription() %></td>
                        <td><%= item.getCategory() %></td>
                        <td><img src="<%= item.getImage() %>" width=200 height=200></td>
                    </tr>
        <%
                }
            } 
        %>
    </tbody>
</table>
</body>
</html>
