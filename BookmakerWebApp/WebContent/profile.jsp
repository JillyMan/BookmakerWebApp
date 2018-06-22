<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<%@ include file="navigation.jsp" %>	
<div class="wrapper">
    <div class="col-md-10">
       <div class="scrollable">
   		<%
	  		User user = (User)request.getSession().getAttribute("user");
   		%>
          <a>Name: <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></a>
          <br>
          <a >Score <c:out value="${user.score}"/></a>
        </div>
    </div>

    <div class="matches-block">
        <div class="row">
            <div class="col-md-12">
                <div class="scrollable">
                     <table class="table">
                     <h1 style="color: #ffffff;">History bets</h1>
                        <thead class="thead-bet">
                            <tr>
								<td>Name event</td>
                                <td>Bets</td>
                                <td>Coefficient</td>
								<td>Result</td>
								<td>Summa</td>
                            </tr>
                        </thead>
                        <tbody class="tbody-bet">
                            <c:forEach var="item" items="${historyBet}">
        						<tr>
        							<td><c:out value = "${item.nameEvent}"/></td>
        							<td><c:out value = "${item.bets}"/></td>
        							<td><c:out value = "${item.coefficient}"/></td>
        							<td><c:out value = "${item.status}"/></td>
        							<td><c:out value = "${item.summa}"/></td>
        						</tr>
        					</c:forEach>
                        </tbody>
                    </table>                
                </div>
            </div>          
        </div>
    </div>
</div>
</body>
</html>
</body>
</html>