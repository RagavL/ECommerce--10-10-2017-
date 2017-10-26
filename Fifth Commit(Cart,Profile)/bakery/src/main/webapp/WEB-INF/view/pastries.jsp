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
input[type=text] {
    width: 400px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 75px;
    font-size: 16px;
    height: 43px;
    background-color: white;
    background-image: url('searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 300px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file='header.jsp' %>
<h3>Pastries List <a href="newpastries">ADD A NEW PASTRIE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:form action="searchbyPastriesName" align="right"  modelAttribute="pastries" method="post"><input type="text" name="NAME" placeholder="Search for Pastries"></form:form></h3>
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
			<td><a href="editpastriesid/${PASTRIES.ID}">Edit</a></td>  
             <td><a href="deletepastries/${PASTRIES.ID}">Delete</a></td>
			
		</tr>
	</tbody>
</c:forEach>

</table>
</div>

<%@ include file='footer.jsp' %>
</body>
</html>