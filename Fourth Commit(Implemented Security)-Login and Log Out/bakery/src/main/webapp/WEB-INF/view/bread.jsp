 <%@ page language="java" import="com.model.Bread" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<input type="text" name="NAME" placeholder="Search for Bread,Cakes and Pastries" ></form:form></h1>


<div class="container">
<div class="row">
<c:forEach items="${allbread}" var="BREAD">
    <div class="col-sm-3">
     <h2>${BREAD.NAME}</h2>
	 <p>${BREAD.DESCRIPTION}</p>
	 <p>${BREAD.QUANTITY}</p>
	 <p>${BREAD.PRICE}</p>
<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
</div>
</c:forEach>
</div>
</div> 

    





<%@ include file='footer.jsp' %>
</body>
</html>