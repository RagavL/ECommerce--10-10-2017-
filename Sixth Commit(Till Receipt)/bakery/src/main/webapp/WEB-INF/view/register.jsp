<!DOCTYPE html>

<html lang="en">
<head>
<title>Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/resources/css/Reg.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp"%>
<br>
<br>
<br>
	<div id="regContainer" class="container">
			<div class="row">
		  	<div class="col-md-6 col-md-offset-3">
			    <div class="panel panel-register">
				   	<div class="panel-heading">
					   	<div class="row">
						   	<div class="col-xs-6">
							   	<a href="#" class="active" id="register-form-link">Register</a>
							</div>
                         </div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="register-form" action="InsertUserRegister" method="post" role="form"
									style="display: block;">
									
									<div class="form-group">
										<label for="name">Name</label> <input type="text"
											name="customername" id="customername" tabindex="1"
											class="form-control" placeholder="Enter your Name" value="" pattern="[A-Z][A-za-z\s]{2,30}" minlength="2" maxlength="20" title="Should starts with Caps.Should not contain any special characters,minlenth is 2"required>
									</div>
									<div class="form-group">
										<label for="username">Username</label> <input type="text"
											name="username" id="username" tabindex="1"
											class="form-control" placeholder="Username" value=""  pattern="[a-z]{3,10}[1-9]{1-3}"
        title="It Should not contain any space.Should starts with small letter." required>
									</div>
									<div class="form-group">
										<label for="email">Email</label> <input type="email"
											name="email" id="email" tabindex="2" class="form-control"
											placeholder="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Eg:user@email.com>" required>
									</div>
									<div class="form-group">
										<label for="password">Password</label> <input type="password"
											name="password" id="password" tabindex="2"
											class="form-control" placeholder="Password" minlength="6" maxlength="16"  title="Six or more characters" required>
									</div>
									
									
									<div class="form-group">
										<label class="control-label col-sm-3">Gender <span
											class="text-danger">*</span></label> <label> <input
											name="gender" type="radio" value="Male" checked>Male
										</label>     <label> <input name="gender" type="radio"
											value="Female"> Female
										</label>
									</div>


									<div class="form-group">
										<label for="address">Address</label> <input type="address"
											name="address" id="Address" tabindex="2" class="form-control"
											placeholder="Address" required>
									</div>
									
									<div class="form-group">
										<label for="mobile">Contact No</label> 
										<input type="mobile" name="mobile" id="mobile"
											tabindex="2" class="form-control" placeholder="Contact No" pattern="[789][0-9]{9}" title="Should be 10 digits starting from 7,8 or 9" required>
									</div>
									<div class="form-group">
										<div class="col-xs-offset-3 col-md-8 col-sm-9">
											<span class="text-muted"><span
												class="label label-danger">Note:-</span> By clicking Sign
												Up, you agree to our <a href="#">Terms</a> and that you have
												read our <a href="#">Policy</a>, including our <a href="#">Cookie
													Use</a>.</span>
										</div>



									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<button class="btn btn-lg btn-primary btn-block"
													type="submit">Sign up</button>
											</div>
										</div>
									</div>
									
									</div>
									
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file='footer.jsp' %>	
</body>
</html>