<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Code</th>
			<th>Description</th>
			<th>Price</th>
			<th>Manifacturing Date</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.code}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td></td>
				<td><a href="ProductController?action=edit&id=${product.id}">Edit
				</a> <a href="ProductController?action=delete&id=${product.id}">
						Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>