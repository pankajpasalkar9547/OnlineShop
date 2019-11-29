<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CustomerController" method="get">
		Id 			: 		<input type="number" name="id"><br><br>
		Username 	: 		<input type="text" name="username" /><br><br>
		Password 	: 		<input type="password" name="password"/><br><br>
		Mobile 		: 		<input type="number" name="mobile"><br><br>
		
							<input type="submit" value="Add"/><br><br>
							<a href="login.jsp">Login</a> 
		
	</form>

</body>
</html>