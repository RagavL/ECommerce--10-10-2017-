<%@ page language="java" import="com.model.Bread" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
    background-color: #3B3738;
    color: white;
    border: 1px solid black;
}

a:link, a:visited {
    background-color: #FF4500;
    color: white;
    
    padding: 10px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
    
}

a:hover {
    background-color: #FF4500;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bread List</title>
</head>
<body bgcolor="#3B3738">
<%@ include file='header.jsp' %>

<h1>BREAD LIST<a href="newbread">ADD A NEW BREAD</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:form action="searchbyName" modelAttribute="bread" method="post">
<input type="text" name="NAME" placeholder="Search for Bread,Cakes and Pastries" >
</form:form></h1>
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
			<td><a href="editbreadid/${BREAD.ID}">Edit</a></td>  
             <td><a href="deletebread/${BREAD.ID}">Delete</a></td>
			
		</tr>
	</tbody>
</c:forEach>

</table>
</div>

<%@ include file='footer.jsp' %>
</body>
</html>