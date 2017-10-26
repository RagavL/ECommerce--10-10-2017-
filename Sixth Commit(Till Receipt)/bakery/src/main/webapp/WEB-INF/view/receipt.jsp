<%@ page language="java" import="com.model.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Payment Receipt</title>
</head>
<style>
table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	</style>
<script>
<script>
document.getElementById("date").innerHTML = Date();
</script>

	
	
<%@ include file='header.jsp' %>	
<body>

<br>
<h1>Receipt</h1>
<div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>${user.customername}</strong>
                        <br>
                        ${user.address}
                        <br>
                        <abbr title="Phone">P:</abbr> ${user.mobile}
                    </address>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em id="date"></em>
                    </p>
                    <p>
                        <em>Receipt #: 34522677W</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>#</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${cartitems}" var="cartitems">
                        <tr>
                            <td class="col-md-9"><em>${cartitems.prodname}</em></td>
                            <td class="col-md-1" style="text-align: center"></td>
                            <td class="col-md-1 text-center">${cartitems.price}</td>
                            <td class="col-md-1 text-center"></td>
                        </tr>
                      </c:forEach>
                        
                        <tr>
                            <td>   </td>
                            <td>   </td>
                                                    
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total: </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong>${grandtotal}</strong></h4></td>
                        </tr>
                        
                        <tr>
							
							<td><a href="home" class="btn btn-success btn-block">Home<i class="fa fa-angle-right"></i></a></td>
						</tr>
                    </tbody>
                </table>
             </div>
        </div>
    </div>
    </div>
<%@ include file='footer.jsp' %>
</body>
</html>