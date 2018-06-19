<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List user</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="page-header"><h1>List users</h1></div>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<td>UserID</td>
						<td>Score</td>
						<td>First name</td>
						<td>Last Name</td>
						<td>Login</td>
						<td>Password</td>
						<td>Role</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
							<td><c:out value = "${item.id}"></c:out></td>
							<td><c:out value = "${item.score}"></c:out></td>
							<td><c:out value = "${item.firstName}"></c:out></td>
							<td><c:out value = "${item.lastName}"></c:out></td>
							<td><c:out value = "${item.login}"></c:out></td>
							<td><c:out value = "${item.password}"></c:out></td>
							<td><c:out value = "${item.role}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>