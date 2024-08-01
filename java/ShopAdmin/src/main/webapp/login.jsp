<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    if (username != null && password != null) {
        request.getRequestDispatcher("dashboard").forward(request, response);
    } else {
    	request.setAttribute("errorMessage", "Invalid credentials");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
