<%@ page language="java" import="com.model.Pastries"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file='header.jsp' %>
<h3>Cakes List</h3>
<div class="container">
	<table class="table table-bordered">
	<thead>
	<tr>
		<th width="80">PASTRIES ID</th>
		<th width="120">PASTRIES NAME</th>
		<th width="550">PASTRIES DESCRIPTION</th>
		<th width="120">PRICE</th>
		
	</tr>
	</thead>
<c:forEach items="${allpastries}" var="PASTRIES">
		<tbody>
		<tr>
			<td>${PASTRIES.ID}</td>
			<td>${PASTRIES.NAME}</td>
			<td>${PASTRIES.DESCRIPTION}</td>
			<td>${PASTRIES.PRICE}</td>
			
		</tr>
	</tbody>
</c:forEach>

</table>
</div>

<%@ include file='footer.jsp' %>
</body>
</html>