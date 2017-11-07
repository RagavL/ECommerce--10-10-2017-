<%@ page language="java" import="com.model.Cakes"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
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
<title>Cakes</title>
</head>
<body bgcolor=#3B3738>
<%@ include file='header.jsp' %>

<h3>Cakes List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:form action="searchbyCakeName" align="right"  modelAttribute="cakes" method="post"><input type="text" name="NAME" placeholder="Search for Cakes"></form:form></h3>
<sec:authorize access="hasRole('Admin')">
 <a href="newcakes">ADD A NEW CAKE</a>
</sec:authorize>
<div class="container">
<div class="section group">
<c:forEach items="${allcakes}" var="CAKES">
<div class="col span_1_of_3">
		
			<h2 class="ex">${CAKES.NAME}</h2>
			
	<c:if test = "${CAKES.ID %5 == 1}">
   <img src ="https://static.wixstatic.com/media/b8325c_715e430c3329458a9fb118d0f564d6b1~mv2_d_2814_2814_s_4_2.jpg_256">
   </c:if>
   <c:if test = "${CAKES.ID % 5 == 2}">
   <img src ="https://www.giftforlovedone.com/uploads/341x0_276x0/blackforrestproduct.jpg">
   </c:if>
   <c:if test = "${CAKES.ID %5 == 3}">
   <img src ="https://www.blueprintsys.com/wp-content/themes/blueprint2017/images/no_image.jpg">
   </c:if>
   <c:if test = "${CAKES.ID %5 == 4}">
   <img src ="http://images.bigoven.com/image/upload/t_recipe-256/chocolate-molten-lava-cakes-low-car.jpg">
   </c:if>
   <c:if test = "${CAKES.ID %5 == 0}">
   <img src ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsND1ahWDKl7kKgIwvFGd8r4H-vFVUI9zcv-wwjjDcscNIHz7t">
   </c:if>
   <br>
   <br>
   <p class="ex">${CAKES.DESCRIPTION}</p>
   <p class="ex1"><i class="fa fa-inr" aria-hidden="true"></i>${CAKES.PRICE}</p>
			
			 <sec:authorize access="hasRole('Admin')">
			<a href="editproductid/${CAKES.ID}">Edit</a>  
            <a href="deleteproduct/${CAKES.ID}">Delete</a>
			</sec:authorize>
<a href="addcartproduct/${CAKES.NAME}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
</div>
</c:forEach>
</div>
</div> 		

<%@ include file='footer.jsp' %>
</body>
</html>