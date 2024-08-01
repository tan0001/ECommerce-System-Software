<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="shop.User" %>

<%
    // Session checking logic
    HttpSession existingSession = request.getSession(false);
    String username = (existingSession != null) ? (String) existingSession.getAttribute("username") : null;
    User user = (existingSession != null) ? (User) existingSession.getAttribute("user") : null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY Shop</title>
<link rel="stylesheet" href="style.css" />
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<style>
    .navbar ul {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
    }
    .navbar ul li {
        position: relative;
    }
    .navbar ul li a {
        text-decoration: none;
        padding: 10px;
        display: block;
        color: #333;
    }
    .navbar ul li ul {
        display: none;
        position: absolute;
        top: 100%;
        left: 0;
        background: #fff;
        padding: 0;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }
    .navbar ul li:hover ul {
        display: block;
    }
    .navbar ul li ul li {
        width: 200px;
    }
    .navbar ul li ul li a {
        padding: 10px;
        color: #333;
    }
    .navbar ul li ul li a:hover {
        background: #f8f8f8;
    }
</style>
</head>
<body>
<div class="header">
     <div class="container">
          <div class="navbar">
          <div class="logo">
           <a href="index.jsp"> <img src="images/home-icon.jpg" alt="HOME" width="50px" height="50px" /></a>
          </div>
          <nav>
            <ul id="MenuItems">
              <li><a href="about.jsp">About</a></li>
              <li><a href="contact.jsp">Contact</a></li>
              <%
                  // Check if the user is logged in
                  if (username == null) {
              %>
                  <li><a href="login.jsp">Login</a></li>
                  <li><a href="register.jsp">Register</a></li>
              <%
                  } else {
              %>
                  <li>
                  	<a href="profile.jsp">
                  		<img src="<%= user.getImage() %>" alt="Profile Image" style="width: 32px; height: 32px; border-radius: 50%;">
                        <span><%= user.getFirst() %> <%= user.getLast() %></span>
                  	</a>
                  </li>
                  <li><a href="cart">Cart</a></li>
                  <li>
                  	<a href="logout">Log Out</a>
                  </li>
              <%
                  }
              %>
            </ul>
          </nav>
          <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
        <div class="row">
          <div class="col-2">
            <h1>
              Here shopping becomes <br/>simple!
            </h1>
            <p>
              "We trust something in a grocery store and assume it's good. We don't learn about the most precious thing in life—
              <br/>the food we put in our body. Educate yourself!"
            </p>
            <a href="" class="btn">Explore Now &#10140;</a>
          </div>
          <div class="col-2">
             <img src="images/image1.png" alt="" />
          </div>
        </div>
      </div>
    </div>
    <script>
    // Toggle function for mobile view if needed
    function menutoggle() {
        var MenuItems = document.getElementById("MenuItems");
        if (MenuItems.style.maxHeight == "0px") {
            MenuItems.style.maxHeight = "200px";
        } else {
            MenuItems.style.maxHeight = "0px";
        }
    }
</script>
</body>
</html>