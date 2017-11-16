 <%@ page language="java" import="com.model.Product" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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

input[type=text] {
    width: 400px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 75px;
    font-size: 16px;
    height: 43px;
    background-color: white;
    
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
<title>Bread</title>
</head>
<body bgcolor="#3B3738">
<%@ include file='header.jsp' %>
<h3>PRODUCT LIST&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:form action="searchbyName" align="right" modelAttribute="bread" method="post">
<input type="text" name="NAME" placeholder="Search for Bread" ></form:form></h3>


<sec:authorize access="hasRole('Admin')">
 <a href="newproduct">ADD A NEW PRODUCT</a>
</sec:authorize>

<div class="container">
<div class="section group">
<c:forEach items="${prod}" var="PRODUCT" varStatus="status" step="1" begin="0">
<!-- <c:url value="C:/Users/Prasad/Desktop/Full Project/newbakery/src/main/webapp/resources/${pro.id}.jpg" var="imageurl"></c:url> -->
   <div class="col span_1_of_3">
   <h2 class="ex">${PRODUCT.pname}</h2>
   
    <c:if test = "${PRODUCT.pid %5 == 1}">
   <img src ="https://images-na.ssl-images-amazon.com/images/I/71Dfcwd+unL._SL256_.jpg">
   </c:if>
   <c:if test = "${PRODUCT.pid % 5 == 2}">
   <img src ="https://dtgxwmigmg3gc.cloudfront.net/files/53eedc4cc566d758850143dc-thumb-256x256.jpeg">
   </c:if>
   <c:if test = "${PRODUCT.pid %5 == 3}">
   <img src ="http://images.bigoven.com/image/upload/t_recipe-256/dads-banana-bread-38b2a5.jpg">
   </c:if>
   <c:if test = "${PRODUCT.pid %5 == 4}">
   <img src ="https://dtgxwmigmg3gc.cloudfront.net/files/52e1f420c566d7053c01db14-icon-256x256.png">
   </c:if>
   <c:if test = "${PRODUCT.pid %5 == 0}">
   <img src ="https://www.blueprintsys.com/wp-content/themes/blueprint2017/images/no_image.jpg">
   </c:if>
  
   
   
   <br>
   <br>
   <p class="ex">${PRODUCT.description}</p>
   <p class="ex1">${PRODUCT.pprice}</p>
   
   
<sec:authorize access="hasRole('Role_Admin')">
 <a href="editproductid/${PRODUCT.pid}">Edit</a>  
    <a href="deleteproduct/${PRODUCT.pid}">Delete</a> 
 <tt>GrantedAuthority</tt>s.
</sec:authorize>
<c:if test="${username != null}">	
<a href="addcartproduct/${PRODUCT.pname}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
</c:if>
<c:if test="${username == null}">	
<a href="login" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
</c:if>
</div>
</c:forEach>
</div>
</div> 


<%@ include file='footer.jsp' %>

</body>
</html>