<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<%@ include file='header.jsp' %>
<body>
<!-- Category Form Started -->
<c:if test="${flag}">
<form action="UpdateCategory" method="post">
</c:if>
<c:if test="${!flag}">
<form action="AddCategory" method="post">
</c:if>

	<table align="center" cellspacing="2">
		<tr>
			<td colspan="2"><h3><b>Category Details</b></h3></td>
			<c:if test="${flag}">
			<input type="hidden" name="catid" value="${category.catid}" />
			</c:if>
		</tr>
		<tr>
			<td><h4><b>Category Name</b></h4></td>
			<c:if test="${flag}">
				<td><input type="text" name="catname" value="${category.catname}" /></td>
			</c:if>
			<c:if test="${!flag}">
				<td><input type="text" name="catname" required="true"/></td>
			</c:if>
		</tr>
		<tr>
			<td><h4><b>Category Description</b></h4></td>
			<c:if test="${flag}">
				<td><input type="text" name="catdescription" value="${category.catdescription}" required="true"/></td>
			</c:if>
			<c:if test="${!flag}">
			<td><input type="text" name="catdescription" /></td>
			</c:if>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="AddCategory" /></td>
		</tr>
	</table>
</form>

<!-- Category Form Completed -->

<!-- Displaying the Category data using Table -->
<table cellspacing="2" align="center" border="5" >

	<tr bgcolor="#ff66ff">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${catdetail}" var="category">
		<tr bgcolor="#00ff99">
			<td>${category.catid}</td>
			<td>${category.catname}</td>
			<td>${category.catdescription}</td>
			<td><a href="<c:url value="deleteCategory/${category.catid}"/>">Delete</a>
				<a href="<c:url value="updateCategory/${category.catid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- Completed Displaying Table -->
</body>
</html>