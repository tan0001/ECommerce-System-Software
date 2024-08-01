<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
System.out.println("Products in JSP: " + products);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<style>
    .items-container {
        display: flex;
        justify-content: space-around;
        align-items: center;
        flex-wrap: wrap;
        margin-top: 20px;
    }
    .item-card {
        text-align: center;
        margin: 20px;
    }
    .item-card img {
        width: 100px;
        height: 100px;
    }
    .item-card h3 h2 {
        margin: 10px 0;
    }
</style>
</head>
<body>
<h2 class="title"> Products </h2>
<div id="items-container">
	<%
        if (products != null) {
            for (Product product : products) {
    %>
                <div class="item-card">
                    <img src="<%= product.getImage() %>" alt="<%= product.getName() %>">
                    <h3><%= product.getName() %></h3>
                    <p><%= product.getDescription() %></p>
                    <h2><%= product.getPrice() %></h2>
                    <form action="addToCart" method="post">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <label for="quantity">Enter quantity : </label>
                        <input type="number" name="quantity" value="1" min="1">
                        <button type="submit">Add to Cart</button>
                    </form>
                </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
