<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.admin.Category" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoppy | Admin | View Category</title>
</head>
<body>
<h2>Categories</h2>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Category> categories = (List<Category>) request.getAttribute("categories");
            if (categories != null) {
                for (Category category : categories) {
        %>
                    <tr>
                        <td><%= category.getId() %></td>
                        <td><%= category.getName() %></td>
                        <td><%= category.getDescription() %></td>
                        <td><img src="<%= category.getImage() %>" width=200 height=200></td>
                    </tr>
        <%
                }
            }
        %>
    </tbody>
</table>
</body>
</html>
