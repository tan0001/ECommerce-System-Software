<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Shoppy | Admin | Remove Category </title>
</head>
<body>
<%-- Fetch and display categories here --%>
<form action="admin" method="post">
    <input type="hidden" name="action" value="removeCategory">
    <%-- Assume categories is a list of category objects with id and name --%>
    <c:forEach var="category" items="${categories}">
        <div>
            <span>${category.name}</span>
            <button type="submit" name="id" value="${category.id}">Remove</button>
        </div>
    </c:forEach>
</form>

</body>
</html>