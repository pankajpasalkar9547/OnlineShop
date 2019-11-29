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
			<th>Username</th>
			<th>Password</th>
			<th>Mobile</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customerId}</td>
				<td>${customer.username}</td>
				<td>${customer.password}</td>
				<td>${customer.mobileNo}</td>
				<td></td>
				<td>
					<a href="CustomerController?action=login&id=${product.id}">Login</a> 
					<a href="CustomerController?action=add&id=${product.id}">Add</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>