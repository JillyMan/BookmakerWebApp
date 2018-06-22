<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/sign.css">

	<title>Sigh Up</title>
</head>
<body>
<%@ include file="navigation.jsp" %>

  	<div class="container">
    	<div class="col-md-12">
	    	<div id="logbox">
		      	<form id="signUp" method="post" action="signUp">
			        <h1>Create an account</h1>

					<div class="row">
						<div class="col-md-12">
							<div class="${typeMessage}">
								<p>${message}</p>
							</div>
						</div>
					</div>

			        <input name="fname" class="input name" type="text" placeholder="First name" pattern="^[\w]{3,16}$" autofocus="autofocus" required="required"/>
			        <input name="lname" class="input name type="text" placeholder="Last name" pattern="^[\w]{3,16}$" autofocus="autofocus" required="required" "/>	
			        <input name="login" class="input login" type="login" placeholder="Login"/>
			        <input name="password" class="input pass" type="password" placeholder="Choose a password" required="required"/>			        
			        <input class="inputButton" type="submit" value="Sign me up!"/>
			        
			        <div class="text-center">
			            already have an account? <a href="?page=signIn" id="login_id">sign in</a>
			        </div>
		      	</form>
	    	</div>
   		</div>   
  </div>
</body>
</html>