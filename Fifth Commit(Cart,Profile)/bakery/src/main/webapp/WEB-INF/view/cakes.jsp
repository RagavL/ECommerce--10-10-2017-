<%@ page language="java" import="com.model.Cakes"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<body bgcolor=#3B3738>
<%@ include file='header.jsp' %>



<h3>Cakes List <a href="newcakes">ADD A NEW CAKE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:form action="searchbyCakeName" align="right"  modelAttribute="cakes" method="post"><input type="text" name="NAME" placeholder="Search for Cakes"></form:form></h3>
<div class="container">
	<table class="table table-bordered">
	<thead>
	<tr>
		<th width="80">CAKE ID</th>
		<th width="120">CAKE NAME</th>
		<th width="550">CAKE DESCRIPTION</th>
		
		<th width="120">PRICE</th>
		
	</tr>
	</thead>
<c:forEach items="${allcakes}" var="CAKES">
		<tbody>
		<tr>
			<td>${CAKES.ID}</td>
			<td>${CAKES.NAME}</td>
			<td>${CAKES.DESCRIPTION}</td>
			
			<td>${CAKES.PRICE}</td>
			<td><a href="editcakesid/${CAKES.ID}">Edit</a></td>  
             <td><a href="deletecakes/${CAKES.ID}">Delete</a></td>
			
		</tr>
	</tbody>
</c:forEach>

</table>
</div>

<%@ include file='footer.jsp' %>
</body>
</html>