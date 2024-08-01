<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="shop.Item" %>

<%
    List<Item> items = (List<Item>) request.getAttribute("items");
System.out.println("Items in JSP: " + items);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items</title>
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
    .item-card h3 {
        margin: 10px 0;
    }
</style>
</head>
<body>
<h2 class="title"> Items </h2>
<div id="items-container">
	<%
        if (items != null) {
            for (Item item : items) {
    %>
                <div class="item-card">
                	<a href="products?itemId=<%= item.getId() %>">
	                    <img src="<%= item.getImage() %>" alt="<%= item.getName() %>">
	                    <h3><%= item.getName() %></h3>
	                    <p><%= item.getDescription() %></p>
					</a>
                </div>
    <%
            }
        }
    %>
</div>
<div id="products-section">
    <%@include file="products.jsp" %>
    </div>

</body>
</html>
