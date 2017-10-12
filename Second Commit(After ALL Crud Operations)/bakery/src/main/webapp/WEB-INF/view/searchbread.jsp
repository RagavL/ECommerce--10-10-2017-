<%@ page language="java" contentType="text/html" import="com.model.Bread"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
        

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">SEARCH BREAD</h1>
<form:form action="searchbyID" modelAttribute="bread">
<table align="center" cellspacing="2">
	
	<tr>
		<td>Bread ID</td>
		<td><form:input path="ID"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<center><input type="submit" value="SEARCH BY ID"/></center>
		</td>
	</tr>
	
</table>
</form:form>

</body>
</html>