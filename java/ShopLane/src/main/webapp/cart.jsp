<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.CartItem" %>

<%
    List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<style>
    .cart-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .cart-item {
        display: flex;
        justify-content: space-between;
        width: 80%;
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }
    .cart-item img {
        width: 100px;
        height: 100px;
    }
    .cart-item-details {
        flex-grow: 1;
        padding-left: 20px;
    }
</style>
</head>
<body>
<h2>Shopping Cart</h2>
<%@ include file="header.jsp"%>
<div class="cart-container">
    <%
        if (cartItems != null && !cartItems.isEmpty()) {
            for (CartItem cartItem : cartItems) {
    %>
                <div class="cart-item">
                    <img src="<%= cartItem.getImage() %>" alt="<%= cartItem.getProductName() %>">
                    <div class="cart-item-details">
                        <h1><%= cartItem.getProductName() %></h1>
                        <p><%= cartItem.getDescription() %></p>
                        <h3>Quantity: <%= cartItem.getQuantity() %></h3>
                        <h3>Price: <%= cartItem.getPrice() %></h3>
                        <h3>Total Amount: <%= cartItem.getTotal() %></h3>
                    </div>
                </div>
    <%
            }
        } else {
    %>
            <p>Your cart is empty.</p>
    <%
        }
    %>
</div>
<%@ include file="footer.html"%>
</body>
</html>
