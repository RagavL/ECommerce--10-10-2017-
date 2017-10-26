<%@ page language="java" import="com.model.User" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>User profile form requirement</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
<!--     <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }

    .othertop{margin-top:10px;}
    
    .button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
       
    </style>
</head>

<body>
 <%@include file="header.jsp" %>
   <div class="container">
<div class="row">
<div class="col-md-10 ">
<form:form action="${pageContext.request.contextPath}/editsaveuser" modelAttribute="user" class="form-horizontal" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Welcome ${user.username}</legend>

<!-- Text input-->




<div class="form-group">
  <label class="col-md-4 control-label" for="Name (Full name)">Name</label>  
  <div class="col-md-4">
 <div class="input-group">
       <div class="input-group-addon">
        <i class="fa fa-user">
        </i>
       </div>
       <form:input path="customername" type="text" placeholder="Name (Full name)" class="form-control input-md"/>
      </div>
    
  </div>

  
</div>



<!-- Multiple Radios (inline) 
<div class="form-group">
  <label class="col-md-4 control-label" for="Gender">Gender</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="Gender-0">
      <input type="radio" name="Gender" id="Gender-0" value="1" checked="checked">
      Male
    </label> 
    <label class="radio-inline" for="Gender-1">
      <input type="radio" name="Gender" id="Gender-1" value="2">
      Female
    </label> 
    
  </div>
</div>-->

<div class="form-group">
  <label class="col-md-4 control-label col-xs-12" for="Permanent Address">Password</label>  
  <div class="col-md-2  col-xs-4">
  <form:input path="password" type="password" placeholder="District" class="form-control input-md "/>
  </div>
  
</div>


<div class="form-group">
  <label class="col-md-4 control-label col-xs-12" for="Permanent Address">Permanent Address</label>  
  <div class="col-md-2  col-xs-4">
  <form:input path="address" type="text" placeholder="District" class="form-control input-md "/>
  </div>
</div>



<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Phone number ">Phone number </label>  
  <div class="col-md-4">
  <div class="input-group">
       <div class="input-group-addon">
     <i class="fa fa-phone"></i>
        
       </div>
    <form:input path="mobile" type="text" placeholder="Primary Phone number " class="form-control input-md"/>
    
      </div>
      
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email Address">Email Address</label>  
  <div class="col-md-4">
  <div class="input-group">
       <div class="input-group-addon">
     <i class="fa fa-envelope-o"></i>
        
       </div>
    <form:input path="email" type="text" placeholder="Email Address" class="form-control input-md"/>
    
      </div>
  
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" ></label>  
  <div class="col-md-4">
  <input type="submit" class="button" value="SAVE">
  
    
  </div>
</div>

</fieldset>
</form:form>
</div>
<div class="col-md-2 hidden-xs">
<img src="http://websamplenow.com/30/userprofile/images/avatar.jpg" class="img-responsive img-thumbnail ">
  </div>


</div>
   </div>
    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
<%@include file="footer.jsp" %>
</html>
