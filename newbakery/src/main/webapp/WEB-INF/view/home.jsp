<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<style>
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
#class1 button:hover {
    opacity: 0.8;
}

#class1 a:link, a:visited {
    background-color: #FF4500;
    color: white;
    padding: 10px 25px;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
    
}

#class1 a:hover {
    background-color: #FF4500;
}



</style>
<head>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%@ include file='header.jsp' %>
<body>
<c:if test="${sessionScope.username != null}">
<c:if test="${sessionScope.role == 'Role_User'}">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="https://www.supplybunny.com/uploads/product/main_image/3103/54d4c7ba-3ecc-454a-902d-75f214d99d25.jpg" alt="New York" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Bread</h3>
          
        </div>      
      </div>

      <div class="item">
        <img src="https://bizimages.withfloats.com/actual/57d7ee4b9ec66836ac6fb8c6.jpg" alt="Chicago" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Cakes</h3>
          
        </div>      
      </div>
    
      <div class="item">
        <img src="https://danielchocolates.com/wp-content/uploads/2016/05/pastries.jpg" alt="Los Angeles" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Pastries</h3>
          
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</c:if>
<c:if test="${sessionScope.role == 'Role_Admin'}">
<h1 align="center">ADMIN MANAGEMENT CONSOLE</h1>
<br>
<br>
<h2 align="center">PRODUCT OPERATIONS</h2>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="newproduct" id="class1">ADD A NEW PRODUCT</a>
<a href="adminproduct" id="class1">EDIT/DELETE BREAD</a>
<br>
<br>
<h2 align="center"> CATEGORY OPERATIONS</h2>
<br>
<br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="Category" id="class1">ADD A NEW CATEGORY</a>
<br>
<br>
</c:if>
</c:if>
<c:if test="${sessionScope.username == null}">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="https://www.supplybunny.com/uploads/product/main_image/3103/54d4c7ba-3ecc-454a-902d-75f214d99d25.jpg" alt="New York" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Bread</h3>
          
        </div>      
      </div>

      <div class="item">
        <img src="https://bizimages.withfloats.com/actual/57d7ee4b9ec66836ac6fb8c6.jpg" alt="Chicago" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Cakes</h3>
          
        </div>      
      </div>
    
      <div class="item">
        <img src="https://danielchocolates.com/wp-content/uploads/2016/05/pastries.jpg" alt="Los Angeles" width="2000" height="700">
        <div class="carousel-caption">
          <h3>Pastries</h3>
          
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>


</c:if>




<%@ include file='footer.jsp' %>


</body>
</html>
