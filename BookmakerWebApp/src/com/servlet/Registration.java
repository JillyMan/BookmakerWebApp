package com.servlet;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.connector.*;
import com.dao.*;
import com.base_type.*;
import java.sql.Connection;
 
@SuppressWarnings("serial")
public class Registration extends HttpServlet {
 
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("reg.jsp").forward(request, response);
	}
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	System.out.println("doPost()");
    	String fname = request.getParameter("fname");
    	String lname = request.getParameter("lname");
    	String login = request.getParameter("login");
    	String password = request.getParameter("password");
    	User user = new User(fname, lname, 0, login, password, Role.USER);
    	Connection connection = null;

    	try {
    		connection = ConnectorToDB.getInstatnce().getConnection("artyomRoot", "toor");
    		UserDAO userDao = new UserDAO();
    		userDao.insert(user, connection);
    		
    		request.setAttribute("typeMessage", "alert alert-primary");
    		request.setAttribute("Message", "success");    		
    	} catch(Exception e) {
    		e.printStackTrace();    		
    		request.setAttribute("typeMessage", "alert alert-danger");
    		request.setAttribute("Message", "fail");
    	}finally {
    		try {
    			if(connection != null) {
    				connection.close();
    			}
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
			request.getRequestDispatcher("home.jsp").forward(request, response);
    	}    	
    }
}