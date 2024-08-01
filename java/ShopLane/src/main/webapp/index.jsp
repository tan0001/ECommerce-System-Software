<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MY Shop</title>
<link rel="stylesheet" href="style.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<!-- ---------featured categories--------   -->
	<div class="small-container">
		<h2 class="title">
			<a href="categories"> Categories </a>
		</h2>
		<%@ include file="categories.jsp"%>

	</div>
	
	<%@ include file="footer.html"%>
</body>
</html>