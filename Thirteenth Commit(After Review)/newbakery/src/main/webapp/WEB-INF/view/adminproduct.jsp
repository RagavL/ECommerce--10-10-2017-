<%@ page language="java" import="com.model.Product" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
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
<body>
<%@ include file='header.jsp' %>

<h1>BREAD LIST</h1>
<div class="container">
	<table class="table table-bordered">
	<thead>
	<tr>
		<th width="80">Product ID</th>
		<th width="120">Product NAME</th>
		<th width="550">Product DESCRIPTION</th>
		<th width="120">QUANTITY</th>
		<th width="120">PRICE</th>
		
	</tr>
	</thead>

<c:forEach items="${prod}" var="PRODUCT">
		<tbody>
		<tr>
			<td>${PRODUCT.pid}</td>
			<td>${PRODUCT.pname}</td>
			<td>${PRODUCT.description}</td>
			<td>${PRODUCT.quantity}</td>
			<td>${PRODUCT.pprice}</td>
			<td><a href="editproductid/${PRODUCT.pid}">Edit</a></td>  
             <td><a href="deleteproduct/${PRODUCT.pid}">Delete</a></td>
			
		</tr>
	</tbody>
</c:forEach>

</table>
</div>

<%@ include file='footer.jsp' %>
</body>
</html>