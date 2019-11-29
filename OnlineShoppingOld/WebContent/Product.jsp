<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ProductController" method="post">
<c:if test="${ param.action eq 'edit'}">
<input type="hidden" name="action" value="update">
</c:if>
<c:if test="${ param.action eq null}">
<input type="hidden" name="action" value="save">
</c:if>
<table border="2">
<tr>
<th> ID</th>
<td><input type="text" name="id" id="id" value="${product.id}"/></td>
<th>Code</th>
<td><input type="text" name="code" id="code" value="${product.code}"/></td>
<th>Description</th>
<td><input type="text" name="description" id="description" value="${product.description}"/></td>
<th>Price</th>
<td><input type="text" name="price" id="price" value="${product.price}"/></td>
<th>Maniufacturing Date</th>
<td>
<fmt:formatDate value="${ product.manifacturefDate}" pattern="dd/mm/yyyy" var="manfDate"/>

<input type="text" name="manifactureDate" id="manifactureDate" value="${manfDate}"/></td>
</tr>
<tr>
<td><input type="submit"></td>
<td><input type="reset"></td>

</tr>
</table>

</form>
</body>
</html>








