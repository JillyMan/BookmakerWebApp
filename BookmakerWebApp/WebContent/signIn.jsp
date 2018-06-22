<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html> 
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/sign.css">

  <script src="js/bootstrap.min.js"></script>

  <title>Sigh In</title>
</head>

<%@ include file="navigation.jsp" %>

    <div class="col-md-12">
        <div id="logbox">
            <form id="signIn" method="post" action="signIn">
                <h1>Account login</h1>
                <input name="login" type="login" placeholder="enter your login" class="input login"/>
                <input name="password" type="password" placeholder="enter your password" required="required" class="input pass"/>
                <input type="submit" value="Sign me in!" class="inputButton"/>
                <div class="text-center">
                    <a href="?page=signUp" id="">create an account</a> - <a href="resetPass" id="">forgot password</a>
                </div>
            </form>
        </div>
    </div>
</html>