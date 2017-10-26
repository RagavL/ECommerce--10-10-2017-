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
/*  SECTIONS  */
.section {
	clear: both;
	padding: 0px;
	margin: 0px;
}

h.ex {

 height: 80px;
 width: 120px;
}

p.ex {
    height: 75px;
    width: 350px;
    font-size:15px;
    color: #331adb;
    
}

p.ex1 {
    
    font-size:22px;
    color: #f44242;
    
}

/*  COLUMN SETUP  */
.col {
	display: block;
	float:left;
	margin: 1% 0 1% 1%;
}
.col:first-child { margin-left: 0; }

/*  GROUPING  */
.group:before,
.group:after { content:""; display:table; }
.group:after { clear:both;}
.group { zoom:1; /* For IE 6/7 */ }


/*  GRID OF THREE  */
.span_3_of_3 { width: 100%; }
.span_2_of_3 { width: 66.13%; }
.span_1_of_3 { width: 32.26%; }

/*  GO FULL WIDTH BELOW 480 PIXELS */
@media only screen and (max-width: 480px) {
	.col {  margin: 1% 0 1% 0%; }
	.span_3_of_3, .span_2_of_3, .span_1_of_3 { width: 100%; }
}

table, th, td {
    background-color: #3B3738;
    color: white;
    border: 1px solid black;
}

button {
    background-color: #FF4500;
    color: white;
    padding: 10px 25px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
    opacity: 0.8;
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
<div class="section group">
<c:forEach items="${allbread}" var="BREAD" varStatus="status" step="1" begin="0">
   <div class="col span_1_of_3">
   <h2 class="ex">${BREAD.NAME}</h2>
   <p class="ex">${BREAD.DESCRIPTION}</p>
   <p class="ex1">$${BREAD.PRICE}</p>
   
	<a href="editbreadid/${BREAD.ID}">Edit</a>  
    <a href="deletebread/${BREAD.ID}">Delete</a>
<a href="addcartbread/${BREAD.ID}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
</div>
</c:forEach>
</div>
</div> 


<%@ include file='footer.jsp' %>

</body>
</html>