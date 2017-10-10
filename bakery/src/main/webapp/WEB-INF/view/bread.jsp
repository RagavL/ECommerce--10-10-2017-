<%@ page language="java"  import="com.model.Bread" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ include file='header.jsp' %>
 <h3>Bread List</h3>
<div class="container">
	<table class="table table-bordered">
	<thead>
	<tr>
		<th width="80">BREAD ID</th>
		<th width="120">BREAD NAME</th>
		<th width="120">BREAD TYPE</th>
		<th width="550">BREAD DESCRIPTION</th>
		<th width="120">QUANTITY</th>
		<th width="120">PRICE</th>
		
	</tr>
	</thead>

<c:forEach items="${allbread}" var="BREAD">
		<tbody>
		<tr>
			<td>${BREAD.ID}</td>
			<td>${BREAD.NAME}</td>
			<td>${BREAD.TYPE}</td>
			<td>${BREAD.DESCRIPTION}</td>
			<td>${BREAD.QUANTITY}</td>
			<td>${BREAD.PRICE}</td>
			
		</tr>
	</tbody>
</c:forEach>

</table>
</div>

<%@ include file='footer.jsp' %>
</body>
</html>