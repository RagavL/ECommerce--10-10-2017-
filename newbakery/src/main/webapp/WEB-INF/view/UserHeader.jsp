<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {margin:0;}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #FF4500;
    position: fixed;
    top: 0;
    height: 45px;
    width: 100%;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
input[type=text] {
    width: 100px;
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
</head>
<title>eBakery</title>
<body>
<div>
<ul>
  <li><a href="home">Home</a></li>
  <li><a href="aboutus">About</a></li>
  <li><a href="bread">Bread</a></li>
  <li><a href="cakes">Cakes</a></li>
  <li><a href="pastries">Pastries</a></li>
  <li><form:form action="searchbyAll" modelAttribute="product" method="post">
<input type="text" name="pname" placeholder="Search for Bread,Cakes and Pastries" >
</form:form></li>

<c:if test="${username != null}">
<li><a>WELCOME ${username}</a></li>
<li><a href="mycart"><i class="fa fa-shopping-cart"></i>My Cart</a></li>
<li><a href="myprofile"><i class="fa fa-user-circle"></i>My Profile</a></li>
<li><a href="#">My Orders</a></li>
<li><a href="perform_logout"><i class="fa fa-sign-out"></i>Log Out</a></li>
</c:if>
<c:if test="${username == null}">
<li><a href="<c:url value = "/register"/>">Register</a></li>
<li><a href="<c:url value = "/login"/>"><i class="fa fa-sign-in"></i>Login</a></li>
</c:if>
  </ul>
</div>
<br>
<br>
</body>
</html>