<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.Category" %>

<%
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<style>
    .categories-container {
        display: flex;
        justify-content: space-around;
        align-items: center;
        flex-wrap: wrap;
    }
    .category-card {
        text-align: center;
        margin: 20px;
    }
    .category-card img {
        width: 20%;
        height: 100px;
    }
    .category-card a {
        text-decoration: none;
        color: #000;
    }
</style>
</head>
<body>
<div class="categories-container">
    <%
        if (categories != null) {
            for (Category category : categories) {
    %>
                <div class="category-card">
                    <a href="items?categoryId=<%= category.getId() %>">
                        <img src="<%= category.getImage() %>" alt="<%= category.getName() %>">
                        <h3><%= category.getName() %></h3>
                        <p><%= category.getDescription() %></p>
                    </a>
                </div>
    <%
            }
        }
    %>
</div>
<div id="items-section">
    <%@include file="items.jsp" %>
    </div>
</body>
</html>
