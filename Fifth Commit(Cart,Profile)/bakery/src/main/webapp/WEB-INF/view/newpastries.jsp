<%@ page language="java" contentType="text/html" import="com.model.Pastries"%>
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
<h2 align="center">ADD A NEW PASTRIES</h2>

<form:form action="insertpastries" modelAttribute="pastries">
<table align="center" cellspacing="2">
	
	<tr>
		<td>Pastries ID</td>
		
		<td><form:input path="ID"/></td>
	</tr>
	<tr>
		<td>Pastries Name</td>
		<td><form:input path="NAME"/></td>
	</tr>
	
	<tr>
		<td>Pastries Description</td>
		<td><form:input path="DESCRIPTION"/></td>
	</tr>
	
	<tr>
		<td>Pastries Price</td>
	
		<td><form:input path="PRICE"/></td>
	</tr>
	 
	<tr>
		<td colspan="2">
			<center><input type="submit" value="ADD A NEW  Pastrie"/></center>
		</td>
	</tr>
</table>
</form:form>


         
     
</body>
</html>