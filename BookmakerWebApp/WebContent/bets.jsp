<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/sign.css" rel="stylesheet">
</head>
<body>

<%@ include file="navigation.jsp" %>

<div class="wrapper">
    <div class="col-md-10">
        <form method="post" action="bets">
           <div class="scrollable">
                 <c:forEach var="item" items="${listSport}">
                    <button id="button" name="buttonSport" value="${item.id}" onclick="clickAlert()"  type="button" class="btn btn-primary"><c:out value="${item.typeName}"/></button>
                </c:forEach>            
            </div>
        </form>         
    </div>
    <div class="matches-block">
        <div class="row">
            <div class="col-md-12">
                <div class="scrollable">
                     <table class="table">
                        <thead class="thead-bet">
                            <tr>
                                <td>Id</td>
                                <td>Date</td>
                                <td>Event-name</td>
                                <td>TM</td>
                                <td>TL</td>
                                <td>Win1</td>
                                <td>X</td>
                                <td>Win2</td>
                            </tr>
                        </thead>
                        <tbody class="tbody-bet">
                            <c:forEach var="item" items="${listBet}">
                                <tr>
                                    <td><c:out value = "${item.event.id}"/></td>
                                    <td><c:out value = "${item.event.timestamp}"/></td>
                                    <td><c:out value = "${item.event.nameEvent}"/></td>
                                    <td><a><c:out value = "${item.TL}"/></a></td>
                                    <td><a><c:out value = "${item.TM}"/></a></td>                               
                                    <td><a><c:out value = "${item.getStandOf()}"/></a></td>
                                    <td><a><c:out value = "${item.getWinOne()}"/></a></td>
                                    <td><a><c:out value = "${item.getWinTwo()}"/></a></td>     
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                
                </div>
            </div>          
        </div>
    </div>
    <%
        if(userOnline) {    
     %>
      <div class="col-md-12">
        <div id="logbox">
            <form method="post" action="makeBet">
                <div class="col-md-12">
                    <div class="${typeMessage}">
                        <p>${message}</p>
                    </div>
                </div>    
	            <input name="idEvent"   type="number" placeholder="id event" class="input" required="required" onkeypress="return isNumberKey(event)"/>
                <input name="nameBet"   type="name" placeholder="enter name bet" class="input" required="required"/>
                <input name="summa"     type="number" placeholder="summa" class="input" required="required"  onkeypress="return isNumberKey(event)" >
                <button type="button" class="btn btn-success">Make bet</button>        
            </form>
        </div>
     </div> 
     <% 
      }
     %>
</div>


<script type="text/javascript">
$("button").click(function() {
    var fired_button = $(this).val();
    alert(fired_button);
});

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode != 46 && charCode > 31  && (charCode < 48 || charCode > 57)){
        return false;
    }
    return true;
}  
</script>

</body>
</html>