<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
	HttpSession existingSession = request.getSession(false);
	String username = (existingSession != null) ? (String) existingSession.getAttribute("username") : null;

    if (username == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Shoppy | Admin | Dashboard </title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="header">
        <div class="welcome">
            Welcome, <%= username %>!
        </div>
        <form action="logout" method="post" class="logout">
            <input type="submit" value="Logout">
        </form>
    </div>
    <h2>This is your dashboard.</h2>
    
    <nav>
        <ul>
            <li><a href="category?action=addCategory">Add Category</a></li>
            <!-- <li><a href="category?action=removeCategory">Remove Category</a></li> -->
            <li><a href="category?action=displayCategory">Display Category</a></li>
            <li><a href="product?action=addProduct">Add Product</a></li>
            <li><a href="product?action=displayProduct">Display Product</a></li>
            <li><a href="item?action=addItem">Add Item</a></li>
            <li><a href="item?action=displayItem">Display Item</a></li>
            <li><a href="user?action=displayUser">Display Users</a></li>
        </ul>
    </nav>
    <main>
        <div class="menu">
            <% 
			    String action = request.getParameter("action");
			    if (action == null) {
			        action = "displayCategory"; // default action
			    }
			    if ("addCategory".equals(action)) {
			        %><%@ include file="addCategory.jsp" %><%
			    } else if ("removeCategory".equals(action)) {
			        %> @ include file="removeCategory.jsp" %><%
			    } else if ("displayCategory".equals(action)) { 
                    %><%@ include file="viewCategory.jsp" %><%
			    } else if ("addItem".equals(action)) {
			        %><%@ include file="addItem.jsp" %><%
			    } else if ("displayItem".equals(action)) { 
                    %><%@ include file="viewItem.jsp" %><%
			    } else if ("addProduct".equals(action)) {
			        %><%@ include file="addProduct.jsp" %><%
			    } else if ("displayProduct".equals(action)) { 
                    %><%@ include file="viewProduct.jsp" %><%
			    } else if ("displayUser".equals(action)) { 
                    %><%@ include file="viewUser.jsp" %><%
			    }
			%>
        </div>
    </main>
    <footer>
        <p>&copy; 2024 Admin Page</p>
    </footer>
</body>
</html>
