<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body { margin-top:20px; }
.panel-title {display: inline;font-weight: bold;}
.checkbox.pull-right { margin: 0; }
.pl-ziro { padding-left: 0px; }
</style>
<title>Check out</title>
</head>
<body>
 <%@ include file='header.jsp' %>
 
 <h1>CheckOut</h1>
 <hr>
  
   <div align="center" class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4" align="center">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                    <div class="checkbox pull-right">
                        <label>
                            <input type="checkbox" />
                            Remember
                        </label>
                    </div>
                </div>
                <div class="panel-body">
                    <form action="${sum}/receipt" role="form">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number" pattern="[0-9]{16}" title="Only 16 Numbers"
                                required autofocus/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" pattern="[0-12]{2}" title="Only Two Digits" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" pattern="[17-100]{2}" title="Only Two Digits" required /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CVV CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CVV" pattern="[0-9]{3}" title="Only 3 Numbers" required />
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-success btn-lg btn-block" value="Pay and Confirm Shipping Details">
                    </form>
                </div>
              </div>
            
            <br>
            
       <!--   <a href="${sum}/receipt" class="btn btn-success btn-lg btn-block" role="button">Pay and Confirm Shipping Details</a> -->
        </div>
        <div>
                                               <h3>Shipping Details</h3>
                                               
                                                <label class="col-sm-2 control-label" for="textinput">Name</label>
                                                <input type="text" size="50" value="${user.customername}" disabled>
                                                <br><br>
                                                <label class="col-sm-2 control-label" for="textinput">Phone Number</label>
                                                <input type="text" size="50" value="${user.mobile}" disabled>
                                                <br><br>
                                                <label class="col-sm-2 control-label" for="textinput">Address</label>
                                                <input type="text" size="50" height="30" value="${user.address}">
            
            
         
                 
      </div>
    </div>
</div>

<br>
  <%@ include file='footer.jsp' %>
</body>
</html>