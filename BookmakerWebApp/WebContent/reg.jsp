<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Registrations</title>
</head>
<body>
	<div class="container">		
		<div class="row">
			<div class="col-md-12">
				<dir class="page-header">
					<h1>Registration</h1>
				</dir>		
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="${typeMessage}">
					<p>${Message}</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<form action="reg" method="post">
					<div class="form-group">
						<label for="idfName">First name</label>
						<input type="text" id="idfName" name="fname" class="form-control">
					</div>
					<div class="form-group">
						<label for="idName">Last name</label>
						<input type="text" id="idlName" name="lname" class="form-control">
					</div>
					<div class="form-group">
						<label for="idLogin">Login</label>
						<input type="text" id="idLogin" name="login" class="form-control">
					</div>
					<div class="form-group">
						<label for="idPassword">Password</label>
						<input type="password" id="idPassword" name="password" class="form-control">
					</div>	
					<div class="form-group">
						<input type="submit" value="Sumbit" class="btn btn-primary">
						<input type="reset"  value="Reset"  class="btn btn-danger">
					</div>
				</form>
<!--				<a href="reg" class="btn btn-success">List</a>-->	
			</div>
		</div>
	</div>
</body>
</html>