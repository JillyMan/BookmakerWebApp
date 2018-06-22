<%@page import="com.domain.enums.Role"%>
<%@page import="com.domain.User"%>
<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <a href="load?page=home" class="navbar-brand">Bets</a>
        <div class="collapse navbar-collapse navHeaderCollapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="bets">Bets</a></li>            
                <%
                    Boolean userOnline = (Boolean)request.getAttribute("userOnline");                    
                    if(userOnline) {
        	            User user = (User)request.getSession().getAttribute("User");
					    if(user != null && user.getRole() == Role.BOOKMAKER.getInt()) {
		                	out.println(user.getFirstName() + " : " + user.getRole());
                %>
	                        <li><a href="load?page=createBet">Create bets</a></li>
	                	<% 
	    	             }
	                	%>
                        <li><a href="profile">Profile</a></li>
                        <li><a href="load?page=withdrawMoney">Withdraw money</a></li>
                        <li><a href="load?page=refill">Refill</a></li>
                        <li><a href="load?page=about">About</a></li>
                        <li><a href="load?page=signOut">Sign Out</a></li>
                <%
                    } else {                
                %>
                        <li><a href="load?page=signUp">SignUp</a></li>
                        <li><a href="load?page=signIn">SignIn</a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</div>
