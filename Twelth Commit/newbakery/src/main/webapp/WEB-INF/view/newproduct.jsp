<%@ page language="java" contentType="text/html" import="com.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
form {
  text-align: center;
}
</style>
<title>ADD A NEW BREAD</title>
</head>
<body>
<%@ include file='header.jsp' %>
<h2 align="center">ADD A NEW PRODUCT</h2>

<form:form action="insert" modelAttribute="product">
<table align="center" cellspacing="2">
	
	<tr>
		<td>Product ID</td>
		
		<td><form:input path="pid" value="${n}"/></td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td><form:input path="pname"/></td>
	</tr>
	
	<tr>
		<td>Product Description</td>
		<td><form:input path="description"/></td>
	</tr>
	<tr>
				<td><h4><b>Category</b></h4></td>
				<td><form:select path="catid" required="true">
						<form:option value="0" label="------Select----" />
						<form:options items="${catlist}" />
					</form:select>
				</td>
	</tr>		
	<tr>
	    <td>Product Quantity</td>
		<td><form:input path="quantity"/></td>
	</tr>
	<tr>
		<td>Product Price</td>
	    <td><form:input path="pprice"/></td>
	</tr>
	 
	<tr>
		<td colspan="2">
			<center><input type="submit" value="ADD A NEW PRODUCT"/></center>
		</td>
	</tr>
</table>
</form:form>

         
     
</body>
</html>